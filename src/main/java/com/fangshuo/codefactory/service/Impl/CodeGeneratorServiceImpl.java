package com.fangshuo.codefactory.service.Impl;

import org.springframework.stereotype.Service;

import com.fangshuo.codefactory.model.ProjectInfo;
import com.fangshuo.codefactory.model.ResObj4CR;
import com.fangshuo.codefactory.service.CodeGeneratorService;

@Service
public class CodeGeneratorServiceImpl implements CodeGeneratorService {
	@Override
	public ResObj4CR generateCode4You(ProjectInfo projectInfo) {
		// TODO Auto-generated method stub

		ResObj4CR resObj4CR = new ResObj4CR();// 响应信息;
		resObj4CR.setgResult(true);
		return resObj4CR;
	}

}
