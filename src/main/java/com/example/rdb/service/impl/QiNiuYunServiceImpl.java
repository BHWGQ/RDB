package com.example.rdb.service.impl;

import com.example.rdb.service.QiNiuYunService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class QiNiuYunServiceImpl implements QiNiuYunService {

    @Autowired
    private ObjectMapper objectMapper;


    public String upload(MultipartFile file) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huadongZheJiang2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "ErABU8Xnu4tHdUN2-Pw8MMGOaY-FtXBxIKurQwjt";
        String secretKey = "Ay_Z7B6Uqqg1nUPv-YEsliOf93zEhVcnVXPZjtb-";
        String bucket = "trade-server";
        String fileName = file.getOriginalFilename().replace(" ", "");
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String format = LocalDate.now().toString();
        String key = fileName + UUID.randomUUID().toString() + ".zip";
        try {
            byte[] uploadBytes = file.getBytes();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = objectMapper.readValue(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "http://www.lyggwsp.work/" + key;
    }
}
