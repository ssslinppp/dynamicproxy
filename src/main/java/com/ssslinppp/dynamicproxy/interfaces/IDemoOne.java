package com.ssslinppp.dynamicproxy.interfaces;

import com.ssslinppp.dynamicproxy.annotation.ClassAnnotation;
import com.ssslinppp.dynamicproxy.annotation.MethodAnnotation;
import com.ssslinppp.dynamicproxy.annotation.ParamAnnotation;

import java.util.HashMap;

/**
 * Description：<br/>
 * User: liulin <br/>
 * Date: 2017/9/22 <br/>
 * Time: 9:37 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@ClassAnnotation(classAlias = "DemoInterfaceOne")
public interface IDemoOne {
    @MethodAnnotation(methodAlias = "methodOne")
    public String getOne(@ParamAnnotation(value = "map") HashMap map);

    @MethodAnnotation(methodAlias = "methodMulti")
    public String getMulti(@ParamAnnotation(value = "name") String name, @ParamAnnotation(value = "age") int age);
}
