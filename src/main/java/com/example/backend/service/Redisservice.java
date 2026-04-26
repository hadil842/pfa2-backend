package com.example.backend.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Redisservice {
    @Autowired
    public StringRedisTemplate redisTemplate;

    public Redisservice(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveVirement(int clientId, String data) {
        redisTemplate.opsForValue().set("virement:" + clientId,
                data,
                5,
                TimeUnit.MINUTES);
    }

    public String getVirement(int clientId) {
        return redisTemplate.opsForValue().get("virement:" + clientId);
    }

    public void deleteVirement(int clientId) {
        redisTemplate.delete("virement:" + clientId);
    }

}
