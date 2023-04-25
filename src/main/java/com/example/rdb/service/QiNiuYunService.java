package com.example.rdb.service;

import org.springframework.web.multipart.MultipartFile;

public interface QiNiuYunService {
    public String upload(MultipartFile file);
}
