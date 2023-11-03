package com.itgenius.openfeign.controller;

import org.springframework.web.bind.annotation.RestController;
import com.itgenius.openfeign.common.internal.InternalServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OpenFeignController {
    
    private final InternalServiceClient internalServiceClient;

    @GetMapping("/internal")
    public String internalCall() {
        return "this is internal OpenFeign call: " + internalServiceClient.getInternalResource();
    }

}
