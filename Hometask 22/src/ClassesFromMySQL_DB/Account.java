package ClassesFromMySQL_DB;

import java.util.List;

/**
 * Created by vig on 2/8/17.
 */
public class Account {
    private Long id;
    private String name;
    private Byte age;
    private Class1 class1;
    private School school;
    private List<Subject> subjects;

    public Account(Long id, String name, Byte age, Class1 class1, School school, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.class1 = class1;
        this.school = school;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Class1 getClass1() {
        return class1;
    }

    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + this.class1.toString() + " "
                + this.school.toString() + " " + this.subjects.toString();
    }
}
