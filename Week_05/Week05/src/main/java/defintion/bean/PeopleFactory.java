public class PeopleFactory {

    @Bean
    public static People createBean(){
        People people = new People();
        people.setId(3L);
        people.setName("name3");
        return people;
    }
}