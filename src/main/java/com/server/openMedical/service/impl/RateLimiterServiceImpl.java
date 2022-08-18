package com.server.openMedical.service.impl;

import com.server.openMedical.service.RateLimiterService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {
    //Cache for API key and token bucket ( we can use any other caching method as well )
    Map<String, Bucket> bucketCache = new ConcurrentHashMap<>();

    @Override
    public Bucket resolveBucket(String apiKey) {
        bucketCache.put("/api/service/main",newBucket(apiKey));
        bucketCache.put("/api/service/second",newBucketSecondService(apiKey));
        bucketCache.put("/api/service/third",newBucketThirdService(apiKey));
        return bucketCache.get(apiKey);
    }
    private Bucket newBucket(String s) {
        return Bucket4j.builder()
                .addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofSeconds(1)))).build();
    }
    private Bucket newBucketSecondService(String s){
        return Bucket4j.builder()
                .addLimit(Bandwidth.classic(5, Refill.intervally(5, Duration.ofSeconds(1)))).build();
    }
    private Bucket newBucketThirdService(String s){
        return Bucket4j.builder()
                .addLimit(Bandwidth.classic(2, Refill.intervally(2, Duration.ofSeconds(1)))).build();
    }


}
