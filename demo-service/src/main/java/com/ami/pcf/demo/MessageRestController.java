package com.ami.pcf.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/message")
public class MessageRestController {
    @RequestMapping("/hello")
    String getMessage(@RequestParam(value = "name") String name) {
        String rsp = "Hi " + name + " : responded on - " + new Date();
        return rsp;
    }
}
