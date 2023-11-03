package com.itgenius.openfeign.common.internal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
    name = "InternalServiceClient", 
    url = "http://localhost:8081/employees"
)
public interface InternalServiceClient {
    @GetMapping("/test")
    String getInternalResource();
}
