package com.example.rdb.controller;

import com.example.rdb.service.QiNiuYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
    @Autowired
    private QiNiuYunService qiNiuYunService;

    @PostMapping("/upload")
    public Map<String, Object> fileupload(MultipartFile file, HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        String originName = file.getOriginalFilename();
        if (!originName.endsWith(".zip")) {
            result.put("status", "error");
            result.put("msg", "文件类型不对");
            return result;
        }
        String url = qiNiuYunService.upload(file);
        result.put("url", url);
//        String newName = UUID.randomUUID().toString()+".zip";
//        try {
//            file.transferTo(new File(folder,newName));
//            String url = req.getScheme() + "//" + req.getServerName() + ":" + req.getServerPort() +format + newName;
//            result.put("status","success");
//            result.put("url",url);
//        } catch (IOException e) {
//            result.put("status","error");
//            result.put("msg",e.getMessage());
//        }
        return result;
    }

    @PostMapping("/upload1")
    public Map<String, Object> fileupload1(MultipartFile file, HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();
        String originName = file.getOriginalFilename();
        if (!originName.endsWith(".zip")) {
            result.put("status", "error");
            result.put("msg", "文件类型不对");
            return result;
        }
        String url = qiNiuYunService.upload(file);
        result.put("url", url);
//        String newName = UUID.randomUUID().toString()+".zip";
//        try {
//            file.transferTo(new File(folder,newName));
//            String url = req.getScheme() + "//" + req.getServerName() + ":" + req.getServerPort() +format + newName;
//            result.put("status","success");
//            result.put("url",url);
//        } catch (IOException e) {
//            result.put("status","error");
//            result.put("msg",e.getMessage());
//        }
        return result;
    }
}
