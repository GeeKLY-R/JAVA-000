package com.example.demo;

import java.util.List;
@Data
@Configuration
@AutoConfigureBefore(School.class)
public class Klass {

    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }

}
