package kerner1000;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/{greeting}")
    ResponseEntity<MyJsonResponse> sayHello(@PathVariable String greeting){
        return ResponseEntity.ok(new MyJsonResponse(greeting));
    }
}
