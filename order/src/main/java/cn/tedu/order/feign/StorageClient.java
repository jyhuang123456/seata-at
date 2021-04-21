package cn.tedu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storage")
public interface StorageClient {
    @GetMapping(value = "/decrease",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = "application/json;charset=UTF-8")
    String decrease(@RequestParam Long productId, @RequestParam Integer count);
}
