package com.exo1.exo1.controller;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheController {
    private final CacheManager cacheManager;

    @GetMapping
    public Map<String, Object> getAllCaches() {
        Map<String, Object> caches = new HashMap<>();
        for (String cacheName : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(cacheName);
            if (cache != null) {
                caches.put(cacheName, cache.getNativeCache());
            }
        }
        return caches;
    }
}