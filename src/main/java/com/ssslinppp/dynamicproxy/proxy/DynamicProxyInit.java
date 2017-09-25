package com.ssslinppp.dynamicproxy.proxy;

import com.ssslinppp.dynamicproxy.annotation.ClassAnnotation;
import com.ssslinppp.dynamicproxy.annotation.ParamAnnotation;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Description：<br/>
 * User: liulin <br/>
 * Date: 2017/9/22 <br/>
 * Time: 11:36 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DynamicProxyInit {

    @Autowired
    private ApplicationContext ctx;

    /**
     * 将对象注入到Spring应用上下文
     *
     * @param name
     * @param obj
     */
    public void registerBean(String name, Object obj) {
        // 获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) ctx
                .getAutowireCapableBeanFactory();

        // 动态注册bean.
        defaultListableBeanFactory.registerSingleton(name, obj);
    }

    @PostConstruct
    public void initDynamicProxy() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LinkedHashMap<String, String> params = new LinkedHashMap<>();

                // 解析方法参数
                Parameter[] parameters = method.getParameters();  // 获取所有方法参数
                for (int i = 0; i < parameters.length; i++) {
                    // 获取方法参数注解，并取得参数注解中的原数据信息
                    ParamAnnotation param = parameters[i].getAnnotation(ParamAnnotation.class);
                    if (param != null) {
                        params.put(param.value(), String.valueOf(args[i]));
                    }
                }

                return params.toString();
            }
        };

        // 获取所有声明了 ClassAnnotation 注解的接口和类
        Set<Class<?>> clszzsWithClassAnnotataion = new Reflections("com.ssslinppp.*").getTypesAnnotatedWith(ClassAnnotation.class);
        for (Class<?> cls : clszzsWithClassAnnotataion) {
            if (cls.isInterface()) { // Proxy动态代理仅适用于Interface，如果不是接口，需要使用CGLib实现动态代理
                // 创建动态代理类
                Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{cls}, handler);

                // 将代理类注入到Spring上下文
                System.out.println("注入spring上下文：" + cls.getName() + ", " + proxy.getClass().getName());
                registerBean(cls.getName(), proxy);
            }
        }
    }
}
