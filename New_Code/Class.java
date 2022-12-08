

import java.io.*;

public class Class implements Serializable{
    String name;
    String title;
    int start;
    int end;
    boolean[] days;

    public Class(String n, String t, int s, int e, boolean[] d) {
        name = n;
        title = t;
        start = s;
        end = e;
        days = d;
    }
    public int getStart() {
        return start;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public int getEnd() {
        return end;
    }
    public boolean[] getDays() {
        return days;
    }
    @Override
    public String toString() {
        return name+" ("+start+":00 - "+end+":00)";
    }
    public String intToTimeSlot(int startTime, int endTime) {
        return startTime+":00 - "+endTime+":00";
    }
}