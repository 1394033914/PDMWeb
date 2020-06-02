package com.pdmweb.pdm.controller;

import com.pdmweb.common.entity.FebsResponse;
import com.pdmweb.pdm.service.impl.PdmwebServiceImpl;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pdm")
public class PdmwebController {

    @Autowired
    private PdmwebServiceImpl pdmwebService;

    @Autowired
    private DSLContext dsl;

    @GetMapping("pdmList")
    @ResponseBody
    public FebsResponse pdmList() {
        List<Map<String, Object>> pdmList = dsl.fetch("select * from pdm_list where pdm_status = 1 order by create_time asc").intoMaps();

        Map<String, Object> map = new HashMap<>();
        map.put("rows", pdmList);
        return new FebsResponse().success().data(map);
    }

























}

