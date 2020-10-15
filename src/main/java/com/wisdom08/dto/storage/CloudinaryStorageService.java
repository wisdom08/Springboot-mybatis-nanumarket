package com.wisdom08.dto.storage;

import com.cloudinary.Cloudinary;
import com.wisdom08.NanumarketException;
import com.wisdom08.service.storage.IStorageService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryStorageService implements IStorageService {

    @Value("${storage.cloudinary.name}") String repoName;
    @Value("${storage.cloudinary.apikey}") String apiKey;
    @Value("${storage.cloudinary.secret}") String apiSecret;

    Cloudinary c;

    @PostConstruct
    public void init() {
        Map<String, Object> props = new HashMap<>();
        props.put("cloud_name", repoName);
        props.put("api_key", apiKey);
        props.put("api_secret", apiSecret);

        c = new Cloudinary(props);

        // File testFile = new File();

    }
    @Override
    public void upload(IUpfile file) {

        File f = null;
        try {
            byte [] fileData = file.getData();
            Map<String, Object> uploadConfig = new HashMap<>();
            uploadConfig.put("public_id", file.getGeneratedFileName());
            c.uploader().upload(fileData, uploadConfig);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NanumarketException(500, "UPLOAD_ERROR");
        }

    }
}
