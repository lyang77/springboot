package com.umxwe.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/miya")
    public String miya(){
        return name+":"+age;
    }

    @RequestMapping("/lucy")
    public String lucy(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }
}
