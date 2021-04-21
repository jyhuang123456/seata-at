package cn.tedu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "EASY-ID-GENERATOR")
public interface EasyIdGeneratorClient {
    @GetMapping(value = "/segment/ids/next_id",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = "application/json;charset=UTF-8")
    Long nextId(@RequestParam String businessType);
}
