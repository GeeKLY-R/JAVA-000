import javax.annotation.Resource;
@Data
@Configuration
public class School implements ISchool {

    @Autowired(required = true)
    Klass class1;

    @Resource(name = "student")
    Student student;

    @Override
    public void ding(){

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student);

    }

}
