package com.stackroute.MuzixAppMysql.confiiguration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration annotation is used to identify the class as configuration class
@Configuration
public class WebConfig {

 //creating bean using bean annotation
    @Bean
 //using servlet registration bean which is inbuilt for bean creation
    public ServletRegistrationBean servletRegistrationBean() {
     //creating object for bean
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
}
