import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassPageInterface extends JFrame{
    //serves as an incrementer for the position of a course
    //every time a class gets added or deleted, this number will change corresponding to the pixel distance from the "Current schedule: " JLabel
    //i.e., the first item is a distance of 20 pixels away, the second is 40, and so on.


    private int i = 20;
    public int geti() {
        return this.i;
    }
    //displays a warning message with a specified message
    public void dispJOP(String message) {
        JFrame f = new JFrame("Warning");
        JOptionPane.showMessageDialog(f, message);
    }
    //does the incrementation for our i variable
    public void incrementi() {
        i = i+20;
    }

    public static void drawClass() {
        ClassPageInterface cpi = new ClassPageInterface();
        JFrame window = new JFrame("Class Selection Screen");
        Container contentPane = window.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        //JLabel for adding classes
        JLabel addClass = new JLabel("Select a class to add: ");
        contentPane.add(addClass);
        layout.putConstraint(SpringLayout.WEST, addClass, 5, SpringLayout.WEST, contentPane);

        //temporary classes (courses) for now
        boolean[] MWF = new boolean[]{true, false, true, false, true};
        boolean[] MWTF = new boolean[]{true, false, true, true, false};
        boolean[] TR = new boolean[]{false, true, false, true, false};
        Class class1 = new Class("SWENG311", "Object Oriented Programming", 10, 11, MWTF);
        Class class2 = new Class("CMPSC360", "Discrete Mathematics", 11, 12, MWF);
        Class class3 = new Class("CMPSC121", "Intermediate Programming", 12, 13, MWTF);
        Class class4 = new Class("CMPSC200", "Matlab", 12, 13, MWF);
        Class[] classes = new Class[]{class1,class2,class3,class4};
        //JComboBox for adding classes
        JComboBox addClassOptions = new JComboBox(classes);
        contentPane.add(addClassOptions);
        layout.putConstraint(SpringLayout.WEST, addClassOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, addClassOptions, 20, SpringLayout.NORTH, addClass);

        //JButton to add classes
        JButton addButton = new JButton("Add Class");
        contentPane.add(addButton);
        layout.putConstraint(SpringLayout.WEST, addButton, 200, SpringLayout.WEST, addClassOptions);
        layout.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, addClass);

        //selected classes label
        JLabel selectedClasses = new JLabel("Current schedule: ");
        contentPane.add(selectedClasses);
        layout.putConstraint(SpringLayout.WEST, selectedClasses, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, selectedClasses, 25, SpringLayout.SOUTH, addClassOptions);

        //makes table for selected classes
        String[] columnNames = {"Time Slot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Object[][] data = new Object[28][6];
        for (int i = 0; i < 27; i+=2) {
            data[i+1][0] = (i+8-(i/2))+":00 - "+(i+9-(i/2))+":00";
            if (i < 26) {
                data[i+2][0] = " ";
            }
        }
        for (int i = 0; i < 6; i++) {
            data[0][i] = columnNames[i];
        }
        JTable selectedClassesTable = new JTable(data, columnNames);
        contentPane.add(selectedClassesTable);
        layout.putConstraint(SpringLayout.NORTH, selectedClassesTable, 20, SpringLayout.NORTH, selectedClasses);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, selectedClassesTable, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);

        //JLabel for remove classes section
        JLabel removeClass = new JLabel("Select classes to remove: ");
        contentPane.add(removeClass);
        layout.putConstraint(SpringLayout.WEST, removeClass, 5,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, removeClass, 40, SpringLayout.SOUTH, selectedClassesTable);

        //JComboBox for remove classes section
        JComboBox removeClassOptions = new JComboBox();
        contentPane.add(removeClassOptions);
        layout.putConstraint(SpringLayout.WEST, removeClassOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, removeClassOptions, 20, SpringLayout.NORTH, removeClass);

        //JButton for remove classes section
        JButton removeButton = new JButton("Remove Class");
        contentPane.add(removeButton);
        layout.putConstraint(SpringLayout.WEST, removeButton, 200, SpringLayout.WEST, removeClassOptions);
        layout.putConstraint(SpringLayout.NORTH, removeButton, 20, SpringLayout.NORTH, removeClass);

        //allows "Add Class" button to do stuff
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addClassOptions.getSelectedIndex() == -1) {
                    cpi.dispJOP("You can't add any more classes!");
                }
                else {
                    Class pickedClass = (Class) addClassOptions.getSelectedItem();
                    for (int i = 1; i < 27; i++) {
                        if (data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(), pickedClass.getEnd())) && data[i][1] == null) {
                            for (int j = 0; j < 5; j++) {
                                if (pickedClass.getDays()[j]) {
                                    selectedClassesTable.setValueAt(pickedClass.getName(), i, j+1);
                                    selectedClassesTable.setValueAt(pickedClass.getTitle(), i+1, j+1);
                                }
                            }
                            removeClassOptions.addItem(pickedClass);
                            addClassOptions.removeItemAt(addClassOptions.getSelectedIndex());
                        }
                        else if (data[i][1] != null && data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(), pickedClass.getEnd()))){
                            cpi.dispJOP("That time slot is reserved for another class. Remove the class in this slot to add your current selected one.");
                        }
                    }
                }
                cpi.incrementi();
            }
        });
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment( JLabel.CENTER );
        selectedClassesTable.getColumnModel().getColumn(0).setCellRenderer( renderer );
        for (int i = 1; i < 6; i++) {
            selectedClassesTable.getColumnModel().getColumn(i).setPreferredWidth(200);
            selectedClassesTable.getColumnModel().getColumn(i).setCellRenderer( renderer );
        }
        //allows "Remove Class" button to do stuff
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adds course back to the "Add Class" dropdown
                Class pickedClass = (Class) removeClassOptions.getSelectedItem();
                for (int i = 1; i < 27; i++) {
                    if (data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(), pickedClass.getEnd())) && data[i][1] != null) {
                        for (int j = 0; j < 5; j++) {
                            if(pickedClass.getDays()[j]) {
                                selectedClassesTable.setValueAt(null, i, j+1);
                                selectedClassesTable.setValueAt(null, i+1, j+1);
                            }
                        }
                    }
                }
                addClassOptions.addItem(removeClassOptions.getSelectedItem());
                removeClassOptions.removeItemAt(removeClassOptions.getSelectedIndex());
            }
        });
        window.setVisible(true);
        window.setBounds(400,150,1280,720);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
    }


}
