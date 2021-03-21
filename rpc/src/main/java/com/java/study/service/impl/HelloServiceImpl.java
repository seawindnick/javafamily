package java.com.java.study.service.impl;

import java.com.java.study.service.HelloService;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-12-12 23:22
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return "Hello, " + name;
    }
}
