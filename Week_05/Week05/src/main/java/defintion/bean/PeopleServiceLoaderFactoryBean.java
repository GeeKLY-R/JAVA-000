@Configuration
public class PeopleServiceLoaderFactoryBean extends ServiceLoaderFactoryBean {

    @PostConstruct
    public void setServiceType() {
        super.setServiceType(DefaultPeopleFactory.class);
    }
}