package final_project_MVC;


import java.io.*;

public class StudentClassData {
    public static void main(String args[]) {
        Student student1 = new Student("111111111", "student 1", "email1@psu.edu", "password1");
        Student student2 = new Student("222222222", "student 2", "email2@psu.edu", "password2");
        Student student3 = new Student("333333333", "student 3", "email3@psu.edu", "password3");
        Student student4 = new Student("444444444", "student 4", "email4@psu.edu", "password4");

        boolean[] MWF = new boolean[]{true, false, true, false, true};
        boolean[] MWTF = new boolean[]{true, false, true, true, false};
        boolean[] TR = new boolean[]{false, true, false, true, false};
        
        Class class1 = new Class("SWENG311", "Object Oriented Programming", 10, 11, MWTF);
        Class class2 = new Class("CMPSC360", "Discrete Mathematics", 11, 12, MWF);
        Class class3 = new Class("CMPSC121", "Intermediate Programming", 12, 13, MWTF);
        Class class4 = new Class("CMPSC200", "Matlab", 12, 13, MWF);

        try {
            FileOutputStream out = new FileOutputStream(new File("StudentData.txt"));
            ObjectOutputStream obOut = new ObjectOutputStream(out);


            obOut.writeObject(student1);
            obOut.writeObject(student2);
            obOut.writeObject(student3);
            obOut.writeObject(student4);

            obOut.close();
            out.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found 1");
        }catch(IOException e) {
            System.out.println("Error Initializing Stream 1");
        }
        try {
            FileOutputStream out2 = new FileOutputStream(new File("ClassData.txt"));
            ObjectOutputStream obOut2 = new ObjectOutputStream(out2);
            obOut2.writeObject(class1);
            obOut2.writeObject(class2);
            obOut2.writeObject(class3);
            obOut2.writeObject(class4);

            obOut2.close();
            out2.close();

        }
        catch(FileNotFoundException e){
            System.out.println("File not Found 2");
        }catch(IOException e) {
            System.out.println("Error Initializing Stream 2");
        }
    }
}