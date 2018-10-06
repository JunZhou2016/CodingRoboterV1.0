package com.fangshuo.tempTest;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface  QiNiu {
	 /**
     * 上传文件到七牛云存储
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String uploadImgQiniu(@RequestParam("file") MultipartFile multipartFile) throws IOException;
}
