public class BeanDefinitionRegister {

    @Autowired
    private People people;


    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        //设置属性值
        beanDefinitionBuilder.addPropertyValue("id",6)
                .addPropertyValue("name","name6");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //设置bean类型
        beanDefinition.setBeanClass(People.class);

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类
        applicationContext.registerBeanDefinition("people",beanDefinition);
        applicationContext.register(BeanDefinitionRegister.class);
        //启动应用上下文
        applicationContext.refresh();

        BeanDefinitionRegister bean = applicationContext.getBean(BeanDefinitionRegister.class);
        System.out.println(bean.people);

    }

}