package com.fangshuo.codefactory.service;

import com.fangshuo.codefactory.model.ProjectInfo;
import com.fangshuo.codefactory.model.ResObj4CR;

public interface CodeGeneratorService {

	ResObj4CR generateCode4You(ProjectInfo projectInfo);

}
