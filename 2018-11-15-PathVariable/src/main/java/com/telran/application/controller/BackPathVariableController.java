package com.telran.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackPathVariableController {
    @GetMapping(value = "/aaa/{something}/bbb")
    public String getPathValue(@PathVariable(value = "something") String str){
        return str;
    }

}
