package com.ssslinppp.dynamicproxy.interfaces;

import com.google.common.collect.Maps;
import com.ssslinppp.dynamicproxy.DynamicproxyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Description：<br/>
 * User: liulin <br/>
 * Date: 2017/9/22 <br/>
 * Time: 12:37 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DynamicproxyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IDemoOneTest {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private IDemoOne demoOne;

    @Test
    public void getOne() throws Exception {
        HashMap map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(demoOne.getOne(map));
    }

    @Test
    public void getMulti() throws Exception {
        System.out.println(demoOne.getMulti("zhangSan", 18));
    }
}