package med.voll.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String helloWorld(){
        return "Hello World";

    }

    public int contarHasta100(){
        return 0;
    }
}
