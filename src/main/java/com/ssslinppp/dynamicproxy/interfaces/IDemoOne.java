package com.ssslinppp.dynamicproxy.interfaces;

import com.ssslinppp.dynamicproxy.annotation.ClassAnnotation;
import com.ssslinppp.dynamicproxy.annotation.MethodAnnotation;
import com.ssslinppp.dynamicproxy.annotation.ParamAnnotation;

import java.util.HashMap;


@ClassAnnotation(classAlias = "DemoInterfaceOne")
public interface IDemoOne {
    @MethodAnnotation(methodAlias = "methodOne")
    public String getOne(@ParamAnnotation(value = "map") HashMap map);

    @MethodAnnotation(methodAlias = "methodMulti")
    public String getMulti(@ParamAnnotation(value = "name") String name, @ParamAnnotation(value = "age") int age);
}
