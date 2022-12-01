import java.io.Serializable;

public class Teacher implements Serializable {

    String email;
    String name;
    String password;
    String subjectTaught;
    String ID;

    public Teacher(String email, String name, String password, String subjectTaught, String ID){
        this.email = email;
        this.name = name;
        this.password = password;
        this.subjectTaught = subjectTaught;
        this.ID = ID;
    }

    public Teacher(){

    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setSubjectTaught(String subjectTaught){
        this.subjectTaught = subjectTaught;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getSubjectTaught(){
        return subjectTaught;
    }

    public String getID(){
        return ID;
    }

    public void Display(){
        System.out.println(getEmail() + " " + getName() + " " + getPassword() + " " + getSubjectTaught() + " " + getID());
    }


}
