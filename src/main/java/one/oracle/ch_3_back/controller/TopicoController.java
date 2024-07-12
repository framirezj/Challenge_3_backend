package one.oracle.ch_3_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping
    public void hello(){
        System.out.println("Hello World");
    }

}
