import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml配置
 * @author linyunrui
 */
public class XmlBeanDefinition {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-definitions-context.xml");
        //启动上下文
        applicationContext.refresh();
        //依赖查找
        People bean = applicationContext.getBean(People.class);
        System.out.println(bean.toString());
        // 关闭Spring上下文
        applicationContext.close();
    }
}