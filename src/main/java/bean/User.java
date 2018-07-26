package bean;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private int age;
    private Date regTime;

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id:"+id+
                "age:"+age+
                "name:"+name+
                "date:"+regTime.toString();
    }
}
