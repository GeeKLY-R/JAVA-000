import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author linyunrui
 */
public class ServiceLoader {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类
        applicationContext.register(PeopleServiceLoaderFactoryBean.class);
        //启动应用上下文
        applicationContext.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<DefaultPeopleFactory> bean = autowireCapableBeanFactory.getBean(ServiceLoader.class);

        Iterator<DefaultPeopleFactory> iterator = bean.iterator();
        while (iterator.hasNext()) {
            DefaultPeopleFactory next = iterator.next();
            System.out.println(next.createPeople().toString());
        }

    }
}