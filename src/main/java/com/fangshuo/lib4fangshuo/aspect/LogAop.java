package com.fangshuo.lib4fangshuo.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.fangshuo.codefactory.utils.StringUtils;
import com.fangshuo.lib4fangshuo.Enum.AccessLogStatus;
import com.fangshuo.lib4fangshuo.annotation.AccessLog;
import com.fangshuo.lib4fangshuo.log.LogManager;
import com.fangshuo.lib4fangshuo.model.OperationLog;
import com.fangshuo.lib4fangshuo.timertask.jdktask.LogInsertTask;
import com.fangshuo.lib4fangshuo.utils.HttpUtils;
import com.fangshuo.lib4fangshuo.utils.UUID;
import com.google.gson.Gson;

/**
 * 
 * Copyright: Copyright (c) 2018 Jun_Zhou
 * 
 * @ClassName: LogAop.java
 * @Description: 操作日志的AOP切面;
 * 
 * @version: v1.0.0
 * @author: JunZhou
 * @Email: 1769676159@qq.com
 * @Site: CERNO
 * @date: 2018年10月6日 下午8:26:48
 */
@Aspect
@Component
@EnableAsync
public class LogAop {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut(value = "@annotation(com.fangshuo.lib4fangshuo.annotation.AccessLog)")
	public void logPointCut() {
	}

	/**
	 * 后置置通知 用于拦截操作 
	 * 后置通知：在目标方法执行后（无论是否发生异常），执行的通知；
	 *  后置通知中：程序可通过rvt形参来访问目标方法的返回值。
	 * 
	 * @param joinPoint 切点
	 */
	@AfterReturning(pointcut = "logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 拦截异常操作
	 *
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		handleLog(joinPoint, e);
	}

	@Async
	protected void handleLog(final JoinPoint joinPoint, final Exception e) {
		try {
			// 获得注解
			AccessLog controllerLog = getAnnotationLog(joinPoint);
			if (controllerLog == null) {
				return;
			}
			// 从session中获取当前的用户

			// 当前操作状态设置;
			OperationLog operLog = new OperationLog();
			operLog.setStatus(AccessLogStatus.SUCCESS.getStatusCode());
			operLog.setMessage("操作成功");
			if (e != null) {// 操作失败;
				operLog.setStatus(AccessLogStatus.FALL.getStatusCode());
				operLog.setMessage(StringUtils.substring(e.getMessage(), 0, 2000));
			}
			// 操作时间;
			operLog.setCreatetime(new Date());
			HttpServletRequest request = HttpUtils.getRequest();
			// 请求的地址
			operLog.setOperUrl(request.getRequestURI());
			// 请求的网络地址;
			operLog.setAccessIp(HttpUtils.getIp(request));
			operLog.setAccessMac(HttpUtils.getMacByIP(operLog.getAccessIp()));

			// 设置方法名称
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			operLog.setMethod(className + "." + methodName + "()");
			// 处理设置注解上的参数
			getControllerMethodDescription(controllerLog, operLog);
			// 设置uuid;
			operLog.setUuid(UUID.getUUID());
			// 异步保存数据库，避免重要操作堵塞;
			LogManager.getLoggerManager()
					.taskExecutor(new LogInsertTask().setOPERATE_DELAY_TIME(20).setParameter(operLog));
		} catch (Exception exp) {
			// 记录本地异常日志
			log.error("异常信息:{}", exp.getMessage());
			exp.printStackTrace();
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 *
	 * @param log
	 * @param operLog
	 * @throws Exception
	 */
	public void getControllerMethodDescription(AccessLog log, OperationLog operLog) throws Exception {
		// 设置日志类型
		operLog.setLogtype(log.type());
		// 设置日志名字
		operLog.setLogname(log.value());
		// 获取参数的信息，传入到数据库中。
		setRequestValue(operLog);
	}

	/**
	 * 获取请求的参数，放到log中
	 *
	 * @param operLog
	 */
	private void setRequestValue(OperationLog operLog) {
		Map<String, String[]> map = HttpUtils.getRequest().getParameterMap();
		Gson gson = new Gson();
		String params = gson.toJson(map);
		operLog.setOperParams(params);
	}

	/**
	 * 是否存在注解，如果存在就获取
	 *
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private AccessLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(AccessLog.class);
		}
		return null;
	}
}
