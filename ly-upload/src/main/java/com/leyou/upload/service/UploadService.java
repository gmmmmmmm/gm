package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadImage(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();//a.jpg
        String ext=  StringUtils.substringAfterLast(originalFilename,".");//jpg

        try {
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);
            return "http://image.leyou.com/"+ storePath.getFullPath();//group1/M00/00/00/wKjkoF1nRZGAL1slAAB-nAZZa_4410.jpg

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
