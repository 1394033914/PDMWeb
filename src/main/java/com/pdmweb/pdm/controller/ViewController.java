package com.pdmweb.pdm.controller;

import com.pdmweb.common.utils.FebsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping
    public Object login() {
        return FebsUtil.view("login");
    }

    @GetMapping("home")
    public String home() {
        return FebsUtil.view("home");
    }

    @GetMapping("loginlog")
    public String loginLog() {
        return FebsUtil.view("user/loginLog");
    }

    @GetMapping("httptrace")
    public String httptrace() {
        return FebsUtil.view("user/httpTrace");
    }

}
