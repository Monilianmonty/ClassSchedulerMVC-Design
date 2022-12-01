import java.io.*;
public class Class implements Serializable{
    String name;
    String title;
    String start;
    String end;

    public Class(String n, String t, String s, String e) {
        name = n;
        title = t;
        start = s;
        end = e;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    @Override
    public String toString() {
        return name;
    }
}
