import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;

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
        boolean[] MW = {true, false, true, false, false};
        boolean[] MWF = {true, false, true, false, true};


        Class class1 = new Class("SWENG311", "Object Oriented Programming", "10:00", "11:00", MW);
        Class class2 = new Class("CMPSC360", "Discrete Mathematics", "11:00", "12:00", MWF);
        Class class3 = new Class("CMPSC121", "Intermediate Programming", "12:00", "13:00", MWF);
        Class class4 = new Class("CMPSC200", "Matlab", "12:00", "13:00", MWF);
        Class[] classes = new Class[]{class1,class2,class3,class4};
        //JComboBox for adding classes
        JComboBox addClassOptions = new JComboBox(classes);
        contentPane.add(addClassOptions);
        layout.putConstraint(SpringLayout.WEST, addClassOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, addClassOptions, 20, SpringLayout.NORTH, addClass);

        //JButton to add classes
        JButton addButton = new JButton("Add Class");
        contentPane.add(addButton);
        layout.putConstraint(SpringLayout.WEST, addButton, 110, SpringLayout.WEST, addClassOptions);
        layout.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, addClass);

        //selected classes label
        JLabel selectedClasses = new JLabel("Current schedule: ");
        contentPane.add(selectedClasses);
        layout.putConstraint(SpringLayout.WEST, selectedClasses, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, selectedClasses, 25, SpringLayout.SOUTH, addClassOptions);

        //makes table for selected classes
        String[] columnNames = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Object[][] data = new Object[14][6];
        for(int i = 0; i < 4; i++) {
            data[0][i] = columnNames[i];
        }
        for (int i = 0; i < 13; i++) {
            data[i+1][0] = (i+8)+":00";
        }
        JTable selectedClassesTable = new JTable(data, columnNames);
        contentPane.add(selectedClassesTable);
        layout.putConstraint(SpringLayout.WEST, selectedClassesTable, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, selectedClassesTable, 20, SpringLayout.NORTH, selectedClasses);
        selectedClassesTable.setCellSelectionEnabled(false);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        selectedClassesTable.setModel(tableModel);

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
        layout.putConstraint(SpringLayout.WEST, removeButton, 5, SpringLayout.EAST, removeClassOptions);
        layout.putConstraint(SpringLayout.NORTH, removeButton, 20, SpringLayout.NORTH, removeClass);

        //allows "Add Class" button to do stuff
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addClassOptions.getSelectedIndex() == -1) {
                    cpi.dispJOP("You can't add any more classes!");
                }
                else {
                    Class pickedClass = (Class) addClassOptions.getSelectedItem();
                    for (int i = 0; i < 13; i++) {
                        if (data[i][0].equals(pickedClass.getStart()) && data[i][1] == null) {
                            selectedClassesTable.setValueAt(pickedClass.getEnd(), i, 1);
                            selectedClassesTable.setValueAt(pickedClass.getName(), i, 2);
                            selectedClassesTable.setValueAt(pickedClass.getTitle(), i, 3);
                            removeClassOptions.addItem(pickedClass);
                            addClassOptions.removeItemAt(addClassOptions.getSelectedIndex());
                        }
                        else if (data[i][1] != null && data[i][0].equals(pickedClass.getStart())){
                            cpi.dispJOP("That time slot is reserved for another class. Remove the class in this slot to add your current selected one.");
                        }
                    }
                }
                cpi.incrementi();
            }
        });
        //allows "Remove Class" button to do stuff
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //adds course back to the "Add Class" dropdown
                Class pickedClass = (Class) removeClassOptions.getSelectedItem();
                for (int i = 0; i < 13; i++) {
                    if (data[i][0].equals(pickedClass.getStart())) {
                        selectedClassesTable.setValueAt(null, i, 1);
                        selectedClassesTable.setValueAt(null, i, 2);
                        selectedClassesTable.setValueAt(null,i,3);
                        addClassOptions.addItem(removeClassOptions.getSelectedItem());
                        removeClassOptions.removeItemAt(removeClassOptions.getSelectedIndex());
                    }
                }
            }
        });

        //log out button
        JButton logout = new JButton("Log Out");
        contentPane.add(logout);
        layout.putConstraint(SpringLayout.SOUTH, logout,-5, SpringLayout.SOUTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, logout, -5, SpringLayout.EAST, contentPane);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //window.dispose();
                window.dispose();
                LogInPageInterface.drawLog();

            }
        });

        window.setVisible(true);
        window.setBounds(400,150,1280,720);
    }


}
