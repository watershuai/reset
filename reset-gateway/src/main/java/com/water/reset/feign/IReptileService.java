package com.water.reset.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "reset-reptile")
@Component
public interface IReptileService {

    @PostMapping(value = "/reptile/task")
    String task(@RequestParam("id") String id);
    //String task( String id);
}
