package com.example.demo;
@Import(User.class)
public class AnnotationBeanDefinition {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        applicationContext.register(AnnotationBeanDefinition.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.toString());
    }
}
@Component
class User{
    public Long id = 1L;
    public String name = "user";


}