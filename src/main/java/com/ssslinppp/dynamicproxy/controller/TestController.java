package com.ssslinppp.dynamicproxy.controller;

import com.google.common.collect.Maps;
import com.ssslinppp.dynamicproxy.interfaces.IDemoOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/proxy")
public class TestController {
    @Autowired
    @Lazy
    private IDemoOne demoOne;

    @RequestMapping("/one")
    public String getOne() throws Exception {
        HashMap map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return demoOne.getOne(map).toString();
    }

    @RequestMapping("multi")
    public String getMulti() throws Exception {
        return demoOne.getMulti("zhangSan", 18).toString();
    }
}
