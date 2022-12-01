import java.io.*;
public class Class implements Serializable{
    String name;
    String title;
    String start;
    String end;
    boolean[] days = new boolean[5];

    public Class(String n, String t, String s, String e, boolean[] d) {
        name = n;
        title = t;
        start = s;
        end = e;
        days = d;
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
