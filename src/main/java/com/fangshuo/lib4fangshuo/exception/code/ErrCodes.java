package com.fangshuo.lib4fangshuo.exception.code;

public class ErrCodes 
{
	public static final String ECODE_SUCCESS = "000000";			// 成功的返回代码
	public static final String ECODE_FILE_NOTFOUND = "FILE01";	// 文件不存在
	
	public static final ErrorCode0 JNDI_LOOKUP_ERROR 		= new ErrorCode0("100001", "取JNDI的上下文时错误");
	public static final ErrorCode2 TXN_LOAD_PARAM_ERROR 	= new ErrorCode2("100003", "从{0}的方法{1}生成参数时错误");
	public static final ErrorCode1 TASK_UNKNOW_CMD 			= new ErrorCode1("100006", "未知的流程处理命令:{0}");
	public static final ErrorCode2 TXN_EXEC_ERROR 			= new ErrorCode2("100010", "执行命令{0}时错误:{1}");
	public static final ErrorCode1 TXN_EXEC_ERROR1 			= new ErrorCode1("100010", "执行命令{0}时错误");
	public static final ErrorCode1 TXN_USERNAME_ERROR		= new ErrorCode1("100011", "错误的用户名,{0}");
	public static final ErrorCode0 TXN_USERNAME_ERROR1		= new ErrorCode0("100011", "错误的用户名,可能没有签到");
	public static final ErrorCode0 TXN_INPUT_ERROR		= new ErrorCode0("100012", "输入参数错误");
	
	public static final ErrorCode1 FILE_NOTEXIST 			= new ErrorCode1("FILE01", "文件[{0}]不存在");
	public static final ErrorCode1 FILE_OPEN_ERROR 			= new ErrorCode1("FILE02", "打开文件[{0}]时错误");
	public static final ErrorCode1 FILE_OPEN_ERROR1 		= new ErrorCode1("FILE02", "打开文件错误:{0}");
	public static final ErrorCode1 FILE_READERROR 			= new ErrorCode1("FILE03", "读取文件[{0}]错误");
	public static final ErrorCode0 FILE_READERROR2 			= new ErrorCode0("FILE03", "读取文件时错误");
	public static final ErrorCode1 FILE_WRITEERROR 			= new ErrorCode1("FILE04", "写文件[{0}]错误");
	public static final ErrorCode2 FILE_WRITEERROR1 		= new ErrorCode2("FILE04", "写文件[{0}]错误,编码集{1}错误");
	public static final ErrorCode0 FILE_WRITEERROR2 		= new ErrorCode0("FILE04", "写文件时错误");
	public static final ErrorCode1 FILE_WRITEERROR3 		= new ErrorCode1("FILE04", "写文件时错误:{0}");
	public static final ErrorCode0 FILE_ISNULL 				= new ErrorCode0("FILE05", "文件名称是空");
	public static final ErrorCode0 FILE_NAME_ISNULL			= new ErrorCode0("FILE05", "文件名称为空");
	public static final ErrorCode1 FILE_DOWNLOAD_ERROR 		= new ErrorCode1("FILE06", "下载文件[{0}]错误");	
	public static final ErrorCode1 FILE_DOWNLOAD_ERROR1 	= new ErrorCode1("FILE06", "下载文件错误:{0}");
	public static final ErrorCode0 FILE_DOWNLOAD_ERROR2 	= new ErrorCode0("FILE06", "下载文件错误");
	public static final ErrorCode0 FILE_UPLOAD_ERROR 		= new ErrorCode0("FILE07", "取上传文件错误");
	public static final ErrorCode1 FILE_DELETE_ERROR 		= new ErrorCode1("FILE08", "删除文件[{0}]时错误");
	public static final ErrorCode1 FILE_CREATE_ERROR 		= new ErrorCode1("FILE09", "创建文件[{0}]时错误");
	public static final ErrorCode1 FILE_CLOSE_ERROR 		= new ErrorCode1("FILE10", "关闭文件[{0}]错误");
	public static final ErrorCode1 FILE_ALREADY_EXIST 		= new ErrorCode1("FILE11", "文件[{0}]已经存在");
	public static final ErrorCode1 FILE_CREATEPATH_ERROR 	= new ErrorCode1("FILE12", "创建目录[{0}]时错误");
	public static final ErrorCode1 FILE_PATH_NOTFOUND		= new ErrorCode1("FILE13", "目录[{0}]不存在");
	public static final ErrorCode2 FILE_RENAME_ERROR 		= new ErrorCode2("FILE14", "修改文件{0}->{1}名称时错误");
	public static final ErrorCode0 FILE_CREATE_EXCEL_ERROR 	= new ErrorCode0("FILE15", "生成EXCEL文档时错误");
	public static final ErrorCode1 FILE_CALC_CRC32_ERROR 	= new ErrorCode1("FILE16", "计算文件{0}的CRC时错误");
	public static final ErrorCode1 FILE_CREATE_ZIP_ERROR 	= new ErrorCode1("FILE18", "创建压缩文件[{0}]时错误");
	public static final ErrorCode0 FILE_UPLOAD_READERROR	= new ErrorCode0("FILE19", "读取上传文件时错误");
	public static final ErrorCode1 FILE_ENGINE_NOTFOUND		= new ErrorCode1("FILE66", "没有找到文件{0}的生成方式");
	public static final ErrorCode1 FILE_DOWNLOAD_LIMIT 		= new ErrorCode1("FILE20", "没有下载文件[{0}]的权限");
	public static final ErrorCode0 FILE_ZIP_READERROR		= new ErrorCode0("FILE21", "读取压缩文件时错误");
	
	
	public static final ErrorCode1 LOAD_CONFIGERROR 		= new ErrorCode1("100050", "加载系统配置参数{0}时错误");
	public static final ErrorCode1 LOAD_DBCONF_ERROR 		= new ErrorCode1("100051", "加载数据表配置文件时错误:{0}");
	public static final ErrorCode2 ACTION_DUPLICATE 		= new ErrorCode2("100055", "交易码{0}在类{1}已经存在");
	public static final ErrorCode1 TXN_CONFIG_NOTFOUND		= new ErrorCode1("100056", "交易{0}的配置信息不存在");
	public static final ErrorCode2 ACTION_DISABLED			= new ErrorCode2("100058", "交易{0}已经被禁止:{1}");
	public static final ErrorCode2 ACTION_FORWARD_ERROR 	= new ErrorCode2("100059", "交易{0}的导航页面{1}不存在");
	public static final ErrorCode0 DAO_CONFIG_DUPLICATE 	= new ErrorCode0("100061", "DAO配置信息重复");
	public static final ErrorCode1 DAO_CONFIG_NOTFOUND		= new ErrorCode1("100062", "数据表{0}的配置信息不存在");
	public static final ErrorCode1 DAO_SEQUENCE_ERROR		= new ErrorCode1("100063", "获取Sequence[{0}]时错误");
	public static final ErrorCode1 DAO_AUTO_COLUMN_ERROR	= new ErrorCode1("100064", "服务端生成的变量[{0}]没有定义转换函数");

	public static final ErrorCode0 SCANNER_BRACKET_MISS = new ErrorCode0("SCN001", "括号不匹配");
	public static final ErrorCode0 SCANNER_FROM_MISS 	= new ErrorCode0("SCN002", "没有找到[FROM]关键字");
	public static final ErrorCode0 SCANNER_ORDER_BY_MISS= new ErrorCode0("SCN003", "[ORDER]关键字后没有找到[BY]关键字");
	public static final ErrorCode1 SCANNER_VARIABLE_MISS= new ErrorCode1("SCN004", "变量[{0}]定义错误");
	public static final ErrorCode0 EMPTY_VALUE_ERROR	= new ErrorCode0("SCN005", "生成SQL语句时空值错误");
	public static final ErrorCode0 NO_SELECT_ERROR		= new ErrorCode0("SCN006", "SQL语句没有找到SELECT关键字");
	public static final ErrorCode0 SQL_PARSER_ERROR		= new ErrorCode0("SCN007", "解析SQL语句错误");

	public static final ErrorCode1 LIST_LOADFILE_ERROR		= new ErrorCode1("100070", "加载代码文件{0}时错误");
	public static final ErrorCode0 LIST_LOADMODULE_ERROR	= new ErrorCode0("100071", "从模块文件加载代码时错误");
	
	public static final ErrorCode1 CHARSET_ERROR 		= new ErrorCode1("100201", "不支持编码集:{0}");
	public static final ErrorCode0 KEY_DATA_ERROR 		= new ErrorCode0("100211", "密钥数据错误");
	public static final ErrorCode0 KEY_FILE_ERROR 		= new ErrorCode0("100211", "密钥文件错误");
	public static final ErrorCode0 KEY_PADDING_ERROR 	= new ErrorCode0("100212", "数据块长度或填充信息错误");
	public static final ErrorCode0 NO_DES_ALGORITHM 	= new ErrorCode0("100213", "不支持DES算法");
	public static final ErrorCode0 NO_MD5_ALGORITHM 	= new ErrorCode0("100214", "不支持MD5算法");
	public static final ErrorCode0 ENCRYPT_KEY_ERROR 	= new ErrorCode0("100216", "加密错误:获取密钥错误");
	public static final ErrorCode0 ENCRYPT_DATA_ERROR 	= new ErrorCode0("100216", "加密错误:加密数据错误");
	public static final ErrorCode0 DECRYPT_KEY_ERROR 	= new ErrorCode0("100217", "解密错误:获取密钥错误");
	public static final ErrorCode0 DECRYPT_DATA_ERROR 	= new ErrorCode0("100217", "解密错误:解密数据错误");
	public static final ErrorCode0 GET_SIGN_ERROR 		= new ErrorCode0("100218", "生成签名时错误");
	public static final ErrorCode0 CHECK_SIGN_ERROR 	= new ErrorCode0("100219", "检查签名数据错误:数据不一致");
	public static final ErrorCode0 GET_MD5_ERROR 		= new ErrorCode0("100220", "计算消息摘要时错误");
	public static final ErrorCode0 KEY_GEN_ERROR 		= new ErrorCode0("100221", "生成密钥错误");
	public static final ErrorCode0 KEY_LOAD_ERROR 		= new ErrorCode0("100222", "获取密钥数据错误");
	public static final ErrorCode0 RANDOM_CODE_ERROR 	= new ErrorCode0("100223", "验证码错误");
	public static final ErrorCode0 LISCENE_CODE_ERROR 	= new ErrorCode0("100224", "注册码错误");
	public static final ErrorCode0 LISCENE_EXPIRATION 	= new ErrorCode0("100225", "注册码已经过期");
	
	public static final ErrorCode1 VALID_VALUE_ISNULL 	= new ErrorCode1("100401", "数据项{0}为空");
	public static final ErrorCode3 VALID_VALUE_TOLONG 	= new ErrorCode3("100402", "数据项{0}的长度{1}超过最大长度{2}");
	public static final ErrorCode3 VALID_VALUE_LENGTH 	= new ErrorCode3("100402", "数据项{0}的长度{1}必须是{2}");
	public static final ErrorCode1 VALID_FORMAT_ERROR 	= new ErrorCode1("100403", "数据项{0}格式错误");
	public static final ErrorCode0 DATE_MONTH_ERROR		= new ErrorCode0("100404", "日期的格式错误，月只能是[1~12]" );
	public static final ErrorCode0 DATE_DAY_ERROR		= new ErrorCode0("100404", "日期的格式错误，日只能是[1~31]" );
	public static final ErrorCode0 DATE_YEAR_ERROR 		= new ErrorCode0("100405", "日期的格式错误，年错误");
	public static final ErrorCode0 DATE_FORMAT_ERROR 	= new ErrorCode0("100406", "日期的格式错误");
	public static final ErrorCode0 FORMAT_MONEY_ERROR	= new ErrorCode0("100409", "金额的格式错误，只能精确到仟亿，小数点只能两位" );
	public static final ErrorCode1 FORMAT_CODE_ERROR	= new ErrorCode1("10040a", "数据字典[{0}]的格式错误" );
	
	public static final ErrorCode0 CONF_NOT_FOUND 		= new ErrorCode0("100501", "配置信息没有找到");
	public static final ErrorCode0 MENU_NOT_INIT 		= new ErrorCode0("100502", "菜单文件没有初始化");
	public static final ErrorCode1 MENU_NODE_NOT_FOUND 	= new ErrorCode1("100503", "菜单代码{0}没有找到");
	public static final ErrorCode0 MENU_CONF_ERROR		= new ErrorCode0("100504", "菜单节点没有配置名称或ID");
	public static final ErrorCode1 MENU_INCLUDE_ERROR	= new ErrorCode1("100505", "菜单节点{0}的部分include中没有file-name属性");
	
	public static final ErrorCode1 TXN_LOAD_PROXY_ERROR = new ErrorCode1("101000", "加载交易代理类{0}时错误");
	public static final ErrorCode0 EJB_NOTFOUND 		= new ErrorCode0("101001", "找不到EJB容器");
	public static final ErrorCode1 EJB_CONNECT_ERROR 	= new ErrorCode1("101002", "连接EJB容器{0}时错误");
	public static final ErrorCode2 EJB_CALL_ERROR 		= new ErrorCode2("101003", "调用EJB服务{0}:{1}时错误");
	public static final ErrorCode0 EJB_REGISTER_ERROR 	= new ErrorCode0("101004", "注册EJB服务时错误");
	public static final ErrorCode1 BEAN_NOTFOUND 		= new ErrorCode1("101011", "业务组件{0}不存在");
	public static final ErrorCode0 BEAN_CALL_ERROR 		= new ErrorCode0("101013", "调用业务组件时错误");
	public static final ErrorCode1 BEAN_LOAD_ERROR 		= new ErrorCode1("101014", "加载业务组件{0}时错误");
	public static final ErrorCode1 BEAN_TYPE_ERROR 		= new ErrorCode1("101015", "业务组件类型{0}错误");
	public static final ErrorCode1 CLASS_TYPE_ERROR 	= new ErrorCode1("101016", "服务类{0}的类型错误");
	public static final ErrorCode1 DAO_CLASS_TYPE_ERROR = new ErrorCode1("101016", "DAO类{0}的类型错误");
	public static final ErrorCode0 LOG_MONITOR_ERROR 	= new ErrorCode0("101017", "注册监控信息时错误");
	public static final ErrorCode0 LOG_MONITOR_IS_OVER	= new ErrorCode0("101018", "监控队列最多支持8个并发用户");
	
	public static final ErrorCode2 BEAN_METHOD_NOTFOUND 	= new ErrorCode2("101021", "业务组件{0}的方法{1}不存在");
	public static final ErrorCode1 BEAN_LOADMODULE_ERROR 	= new ErrorCode1("101048", "加载服务模块{0}时错误");
	public static final ErrorCode1 BEAN_LOADCLASS_ERROR 	= new ErrorCode1("101049", "加载类{0}时错误");
	public static final ErrorCode0 BEAN_LOADCLASS_ERROR1 	= new ErrorCode0("101049", "加载模块中的类时错误");
	public static final ErrorCode1 TXN_GEN_METHOD_ERROR 	= new ErrorCode1("101050", "生成交易的接口类{0}时错误");
	public static final ErrorCode0 TXN_NO_STEP 				= new ErrorCode0("101051", "交易没有处理流程");
	public static final ErrorCode2 TXN_ENTRY_NOTFOUND		= new ErrorCode2("101052", "没有找到交易[{0}:{1}]的处理函数" );
	
	
	public static final ErrorCode2 JAVA_METHOD_NOTFOUND 	= new ErrorCode2("103101", "类{0}中没有找到方法{1}");
	public static final ErrorCode1 JAVA_CLASS_NOTFOUND 		= new ErrorCode1("103102", "类{0}没有定义");
	public static final ErrorCode1 JAVA_CLASS_NOTINSTANCE 	= new ErrorCode1("103103", "类{0}不能被实例化");
	public static final ErrorCode1 JAVA_ACCESS_LIMIT 		= new ErrorCode1("103104", "类{0}没有存取权限");
	public static final ErrorCode2 JAVA_METHOD_LIMIT 		= new ErrorCode2("103104", "没有权限访问类{0}的方法{1}");
	public static final ErrorCode2 JAVA_INVOCATE_EXCEPTION 	= new ErrorCode2("103105", "调用{0}的方法{1}异常");
	public static final ErrorCode0 JAVA_THREAD_INTERRUPTED 	= new ErrorCode0("103110", "JAVA线程被中断");
	public static final ErrorCode1 JAVA_OTHER_ERROR 		= new ErrorCode1("103111", "调用JAVA服务时异常错误:{0}");
	public static final ErrorCode0 JAVA_COMPILE_EXCEPTION 	= new ErrorCode0("103201", "编译组件时错误");
	public static final ErrorCode1 JAVA_COMPILE_ERROR		= new ErrorCode1("103201", "编译文件{0}时错误");
	public static final ErrorCode0 JAVA_PARSER_ERROR 		= new ErrorCode0("103202", "解析JAVA源文件时错误");
	public static final ErrorCode0 JAVA_OUT_MEMORY 			= new ErrorCode0("103203", "内存溢出");
	public static final ErrorCode2 JAVA_OUT_MEMORY1 		= new ErrorCode2("103203", "执行{0}方法{1}时内存溢出");
	public static final ErrorCode2 JAVA_PARAMETER_ERROR 	= new ErrorCode2("103204", "生成{0}方法{1}的输入参数时错误");
	public static final ErrorCode0 JAVA_FORMAT_ERROR		= new ErrorCode0("103205", "格式化类文件时错误");
	
	public static final ErrorCode1 SERIAL_BEAN_NOTFOUND 	= new ErrorCode1("104101", "没有找到序列号{0}的函数");
	public static final ErrorCode0 SERIAL_KEYCOLUMN_ISNULL 	= new ErrorCode0("104102", "没有指定分类字段名称");
	public static final ErrorCode0 ECODE_CONFIG_ERROR		= new ErrorCode0("104111", "错误代码格式错误");
	
	public static final ErrorCode1 XML_PARSER_ERROR 		= new ErrorCode1("105001", "解析XML文档{0}时错误");
	public static final ErrorCode1 XML_PARSER_ERROR2 	= new ErrorCode1("105001", "解析XML文档时错误,{0}");
	public static final ErrorCode1 XML_CREATE_ERROR 	= new ErrorCode1("105002", "生成XML文档{0}时错误");
	public static final ErrorCode1 XML_CREATE_ERROR2 	= new ErrorCode1("105002", "生成XML文档时错误:{0}");
	public static final ErrorCode1 DTD_PARSER_ERROR 	= new ErrorCode1("105003", "解析DTD文档{0}时错误");
	public static final ErrorCode1 XML_ELEMENT_NOFOUND 	= new ErrorCode1("105101", "XML文件中节点{0}不存在");
	public static final ErrorCode1 XML_KEYNAME_NOFOUND 	= new ErrorCode1("105102", "查找节点记录时，没有指定{0}的关键字字段");
	public static final ErrorCode0 XML_OUTPUT_NOFOUND 	= new ErrorCode0("105103", "没有指定输出数据的节点");
	public static final ErrorCode0 XML_ADD_PROPERTY_ERROR = new ErrorCode0("105103", "不在节点内，不能增加属性" );
	public static final ErrorCode0 HTML_PARSER_ERROR1 	= new ErrorCode0("105201", "解析HTML内容时错误");

	public static final ErrorCode1 JSON_PARSER_ERROR 	= new ErrorCode1("105051", "解析JSON文档{0}时错误");
	public static final ErrorCode1 JSON_PARSER_ERROR2 	= new ErrorCode1("105051", "解析JSON文档时错误,{0}");
	public static final ErrorCode0 JSON_PARSER_ERROR3 	= new ErrorCode0("105051", "解析JSON数据时错误");
	
	public static final ErrorCode0 JTA_CONTEXT_ERROR 	= new ErrorCode0("102111", "生成JTA的上下文时错误");
	public static final ErrorCode1 JTA_JNDI_NOTFOUND 	= new ErrorCode1("102112", "取JTA事务的JNDI{0}时错误");
	public static final ErrorCode0 JTA_BEGIN_ERROR		= new ErrorCode0("102113", "启动JTA事务时错误");
	public static final ErrorCode0 JTA_COMMIT_ERROR		= new ErrorCode0("102114", "处理JTA事务时错误");
	
	public static final ErrorCode1 EBD_OPEN_ERROR		= new ErrorCode1("103114", "打开内嵌数据库{0}时错误");
	
	public static final ErrorCode1 INST_ADD_ERROR		= new ErrorCode1("TASK81", "增加指令时错误:{0}");
	public static final ErrorCode0 INST_ADD_INTERRUPT	= new ErrorCode0("TASK81", "增加指令时发生了中断");
	public static final ErrorCode1 INST_SAVE_ERROR		= new ErrorCode1("TASK82", "保存指令到文件{0}时错误");
	public static final ErrorCode1 INST_RESTORE_ERROR	= new ErrorCode1("TASK82", "从文件{0}恢复指令时错误");
	
	public static final ErrorCode1 CACHE_FILE_NOTFOUND	= new ErrorCode1("CACH01", "缓存文件{0}不存在");
	public static final ErrorCode1 CACHE_SAVE_ERROR		= new ErrorCode1("CACH02", "保存缓存数据{0}错误");
	public static final ErrorCode1 CACHE_READ_ERROR		= new ErrorCode1("CACH03", "读取缓存数据{0}错误");
	
	public static final ErrorCode1 JMS_JNDI_ERROR 		= new ErrorCode1("JMS001", "查找JMS的JNDI[{0}]时错误");
	public static final ErrorCode1 JMS_INIT_ERROR 		= new ErrorCode1("JMS002", "初始化JMS[{0}]时错误");
	public static final ErrorCode1 JMS_SEND_ERROR 		= new ErrorCode1("JMS003", "发送消息[{0}]时错误");
	public static final ErrorCode1 JMS_RECV_ERROR 		= new ErrorCode1("JMS004", "接收消息[{0}]时错误");
	public static final ErrorCode1 JMS_NO_CONFIG 		= new ErrorCode1("JMS005", "没有配置JMS[{0}]");
	public static final ErrorCode0 JMS_START_ERROR 		= new ErrorCode0("JMS006", "启动JMS服务线程时错误");
	public static final ErrorCode0 JMS_PROCESS_ERR 		= new ErrorCode0("JMS007", "处理异步消息时异常错误");
	

	// SMTP
	public static final ErrorCode0 MAIL_SEND_ADDR_ERROR = new ErrorCode0( "MAIL01", "发件人地址格式错误" );
	public static final ErrorCode0 MAIL_TO_ADDR_ERROR 	= new ErrorCode0( "MAIL02", "TO[收件人]邮件地址错误" );
	public static final ErrorCode0 MAIL_CC_ADDR_ERROR 	= new ErrorCode0( "MAIL03", "CC[抄送人]人邮件地址错误" );
	public static final ErrorCode0 MAIL_BCC_ADDR_ERROR 	= new ErrorCode0( "MAIL04", "BCC[暗送人]人邮件地址错误" );
	public static final ErrorCode0 SET_SENDTIME_ERROR 	= new ErrorCode0( "MAIL05", "设置发送时间时错误" );
	public static final ErrorCode0 SET_SUBJECT_ERROR 	= new ErrorCode0( "MAIL06", "设置邮件的主题错误" );
	public static final ErrorCode0 SET_MAILBODY_ERROR 	= new ErrorCode0( "MAIL07", "设置邮件内容时错误" );
	public static final ErrorCode0 SET_ATTACH_ERROR 	= new ErrorCode0( "MAIL08", "设置邮件的附件时错误" );
	public static final ErrorCode0 SEND_MAIL_ERROR 		= new ErrorCode0( "MAIL09", "发送邮件时错误" );
	public static final ErrorCode0 MAIL_NO_LISTENER 		= new ErrorCode0( "MAIL10", "没有定义接收邮件的动作" );
	
	// POP3
	public static final ErrorCode1 OPEN_POP3_ERROR 		= new ErrorCode1( "MAIL11", "连接邮件服务器[{0}]错误" );
	public static final ErrorCode0 RECV_MAIL_ERROR 		= new ErrorCode0( "MAIL12", "接收邮件时错误" );
	public static final ErrorCode0 DEL_MAIL_ERROR 		= new ErrorCode0( "MAIL13", "删除邮件时错误" );
	public static final ErrorCode0 GET_SUBJECT_ERROR	= new ErrorCode0( "MAIL14", "取邮件的标题错误" );
	public static final ErrorCode0 GET_MAILBODY_ERROR	= new ErrorCode0( "MAIL15", "取邮件的正文时错误" );
	public static final ErrorCode0 MAIL_FORMAT_ERROR 	= new ErrorCode0( "MAIL16", "未知的邮件正文格式" );
	public static final ErrorCode1 MAIL_FORMAT_ERROR1 	= new ErrorCode1( "MAIL16", "未知的邮件正文格式:{0}" );
	
	// 邮件内容
	public static final ErrorCode0 CREATE_MAILBODY_ERROR 	= new ErrorCode0( "MAIL30", "生成邮件的主体时错误" );
	public static final ErrorCode0 PARSER_MAILBODY_ERROR 	= new ErrorCode0( "MAIL31", "解析邮件的主体时错误" );
	public static final ErrorCode1 ATTACHMENT_NOEXIST_ERROR = new ErrorCode1( "MAIL32", "邮件的的附件[{0}]不存在" );
	
	// 身份证
	public static final ErrorCode0 CHK_IDCARD_LENGTH 	= new ErrorCode0("card01", "身份证长度错误");
	public static final ErrorCode0 CHK_IDCARD_YEAR 		= new ErrorCode0("card02", "身份证年份错误");
	public static final ErrorCode0 CHK_IDCARD_MONTH 	= new ErrorCode0("card03", "身份证月份错误");
	public static final ErrorCode0 CHK_IDCARD_DAY 		= new ErrorCode0("card04", "身份证日错误");
	public static final ErrorCode0 CHK_IDCARD_CHECK 	= new ErrorCode0("card05", "身份证校验码错误");
	public static final ErrorCode0 CHK_IDCARD_NUMBER18 	= new ErrorCode0("card06", "身份证前17位必须是数字");
	public static final ErrorCode0 CHK_IDCARD_NUMBER15 	= new ErrorCode0("card07", "身份证必须全是数字");
	
	// 加密/解密
	public static final ErrorCode0 ENCODE_ERROR 	= new ErrorCode0("crypt1", "加密错误");
	public static final ErrorCode0 DECODE_ERROR 	= new ErrorCode0("crypt2", "解密错误");

	// 其他错误
	public static final ErrorCode0 ONLY_DEVELOPMENT		= new ErrorCode0("999901", "只有开发环境才能执行");
	public static final ErrorCode0 ONLY_RUNTIME			= new ErrorCode0("999902", "只有运行环境才能执行");
	public static final ErrorCode1 CALL_SERVICE_ERROR	= new ErrorCode1("999903", "调用服务{0}时产生未知错误");
	public static final ErrorCode2 CALL_METHOD_ERROR	= new ErrorCode2("999904", "调用{0}的方法{1}时产生未知错误");
	public static final ErrorCode0 EXEC_OTHER_ERROR		= new ErrorCode0("999905", "执行程序时产生未知错误");
	public static final ErrorCode0 TXN_OTHER_ERROR		= new ErrorCode0("999999", "未知的错误");

	public static final ErrorCode0 REDIS_SERIALIZE_ERR = new ErrorCode0("JDS001", "对象序列化错误");
	public static final ErrorCode0 REDIS_DESERIALIZE_ERR = new ErrorCode0("JDS002", "对象反序列化错误");
	
	public static final ErrorCode1 FILTER_IS_EMPTY 	= new ErrorCode1("VLD001", "输入条件[{0}]不能空");
	public static final ErrorCode2 DATASET_TOO_LARGE 	= new ErrorCode2("VLD002", "数据[{0}/{1}]过大，请分页");

	// 数据服务
	public static final ErrorCode0 DSE_CORP_NULL 		= new ErrorCode0("ds0001", "公司编号不能空");
	public static final ErrorCode0 DSE_MSGID_NULL 	= new ErrorCode0("ds0002", "接口编号不能空");
	public static final ErrorCode0 KEY_FILE_NULL		= new ErrorCode0("ds0003", "密钥文件不存在");
	public static final ErrorCode1 KEY_FILE_NOT_EXIST	= new ErrorCode1("ds0004", "密钥文件[{0}]不存在");
	public static final ErrorCode1 OBJECT_NOT_EXIST	= new ErrorCode1("ds0005", "实体对象[{0}]没有配置");
	public static final ErrorCode0 INIT_OBJECT_ERROR 	= new ErrorCode0( "ds0078", "初始化对象错误" );

	// EXCEL导入服务
	public static final ErrorCode0 IMPORT_FILE_ERROR 		    = new ErrorCode0("FILE70", "不能导入空文件！");
	public static final ErrorCode1 IMPORT_FILEHEADERCOUNT_ERROR = new ErrorCode1("FILE71", "文件工作表{0}列头数量不一致！");
	public static final ErrorCode2 IMPORT_FILEHEADER_ERROR 		= new ErrorCode2("FILE72", "文件工作表{0}第{1}列名称不一致！");
	public static final ErrorCode0 LOAD_XLS_DATA_ERROR 		   	= new ErrorCode0( "FILE73", "map转化时出现异常" );
	public static final ErrorCode2 XLS_DATA_EMPTY 			= new ErrorCode2("FILE74", "第[{0}]行的[{1}]为空");
	public static final ErrorCode2 XLS_DATA_ERROR 			= new ErrorCode2("FILE75", "第[{0}]行的[{1}]格式不对");

	// DAO
	public static final ErrorCode0 DAO_UUID_EMPTY	 			= new ErrorCode0("DAO003", "UUID不能空");
	public static final ErrorCode0 DAO_INSERT_DUPLICATE 		= new ErrorCode0("DAO005", "增加记录时重复");
	public static final ErrorCode0 DAO_INSERT_ERROR	 		= new ErrorCode0("DAO006", "增加记录错误");
	
	//Elastic
	public static final ErrorCode0 ELASTIC_CREATE_ERROR 		= new ErrorCode0("Elas1", "添加失败");
	public static final ErrorCode0 ELASTIC_UPDATE_ERROR 		= new ErrorCode0("Elas2", "修改失败");
	public static final ErrorCode0 ELASTIC_DELETE_ERROR 		= new ErrorCode0("Elas3", "删除失败");

	public static final ErrorCode1 NOT_JAR_FILE		 		= new ErrorCode1("SCAN08", "不是JAR文件[{0}]");
}
