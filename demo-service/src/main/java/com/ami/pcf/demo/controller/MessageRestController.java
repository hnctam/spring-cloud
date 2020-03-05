package com.ami.pcf.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ami.pcf.demo.domain.User;
import com.ami.pcf.demo.error.AppException;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/message")
@Api(value = "User Management System")
@Slf4j
public class MessageRestController {
    @RequestMapping("/hello/{lang}")
    String getMessage(@RequestParam(value = "name") String name, @PathVariable String lang) {
        log.info("Get message for {}", name);
        String rsp;
        if ("en".equals(lang)) {
            rsp = "Hi " + name + " : responded on - " + new Date();
        } else {
            rsp = "Bonjour " + name + " : a repondu le - " + new Date();
        }
        return rsp;
    }

    @RequestMapping(path = "/create/{mode}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestBody final User user, @PathVariable String mode) {
        log.info("Create new user={} with mode = {}", user, mode);
        if (null == user || null != user.getId()) {
            throw new AppException("Create new user ID must be NULL");
        }
        return user;
    }
}
