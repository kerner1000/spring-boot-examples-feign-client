package kerner1000;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello-client", url="localhost:8080", configuration = FeignClientConfig.class)
public interface HelloClient {

    @RequestMapping("/hello/{greeting}")
    ResponseEntity<Object> hello(@PathVariable String greeting);
}
