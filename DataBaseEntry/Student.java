

import java.io.*;

public class Student implements Serializable{
    String id;
    String name;
    String email;
    String password;

    public Student(String i, String n, String e, String p) {
        id = i;
        name = n;
        email = e;
        password = p;
    }

    public Student(){

    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public void Display(){
        System.out.println(getId() + " " + getEmail() + " " + getPassword() +" "+ getName());
    }

}
