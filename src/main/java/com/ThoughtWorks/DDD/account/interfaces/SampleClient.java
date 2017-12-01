package com.ThoughtWorks.DDD.account.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account")
public interface SampleClient {

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    String choose();
}
