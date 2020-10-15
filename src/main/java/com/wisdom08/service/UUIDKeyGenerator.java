package com.wisdom08.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDKeyGenerator implements IKeyGenerator {

    @Override
    public String getKey() {
        return UUID.randomUUID().toString() ;
    }
}
