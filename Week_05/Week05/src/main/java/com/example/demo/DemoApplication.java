package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

        public static void main(String[] args) {
            ConfigurableApplicationContext context = SpringApplication.run(BootApplication.class, args);
            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                System.out.println("beanDefinitionName ==>" + beanDefinitionName);
            }
            Klass klassBean = context.getBean(Klass.class);
            School schoolBean = context.getBean(School.class);
            Student studentBean = context.getBean(Student.class);
            System.out.println("klassBean ==>" + klassBean);
            System.out.println("schoolBean ==>" + schoolBean);
            System.out.println("studentBean ==>" + studentBean.getName());
        }
    }
