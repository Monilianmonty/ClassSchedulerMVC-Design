import javax.swing.*;
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

    public static void main(String[] args) {

    }

    public static void drawClass() {
        ClassPageInterface cpi = new ClassPageInterface();
        JFrame window = new JFrame("Class Selection Screen");
        Container contentPane = window.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        //select class label
        JLabel selectClass = new JLabel("Select a class to add: ");
        contentPane.add(selectClass);
        layout.putConstraint(SpringLayout.WEST, selectClass, 5, SpringLayout.WEST, contentPane);

        //JComboBox for adding classes
        JComboBox addClassOptions = new JComboBox();
        //temporary classes (courses) for now
        addClassOptions.addItem("SWENG311");
        addClassOptions.addItem("CMPSC360");
        addClassOptions.addItem("CMPSC121");
        contentPane.add(addClassOptions);
        layout.putConstraint(SpringLayout.WEST, addClassOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, addClassOptions, 20, SpringLayout.NORTH, selectClass);

        //JButton to add classes
        JButton addButton = new JButton("Add Class");
        contentPane.add(addButton);
        layout.putConstraint(SpringLayout.WEST, addButton, 110, SpringLayout.WEST, addClassOptions);
        layout.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, selectClass);

        //selected classes label
        JLabel selectedClasses = new JLabel("Current schedule: ");
        contentPane.add(selectedClasses);
        layout.putConstraint(SpringLayout.WEST, selectedClasses, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, selectedClasses, 25, SpringLayout.SOUTH, addClassOptions);

        //JLabel for remove classes section
        JLabel removeClasses = new JLabel("Select classes to remove: ");
        contentPane.add(removeClasses);
        layout.putConstraint(SpringLayout.WEST,removeClasses, 5,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, removeClasses, 200, SpringLayout.NORTH, selectedClasses);

        //JComboBox for remove classes section
        JComboBox removeClassOptions = new JComboBox();
        contentPane.add(removeClassOptions);
        layout.putConstraint(SpringLayout.WEST, removeClassOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, removeClassOptions, 20, SpringLayout.NORTH, removeClasses);

        //JButton for remove classes section
        JButton removeButton = new JButton("Remove Class");
        contentPane.add(removeButton);

        //allows "Add Class" button to do stuff
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove course visibility from dropdown
                JLabel newCourse = new JLabel((String) addClassOptions.getSelectedItem());
                contentPane.add(newCourse);
                layout.putConstraint(SpringLayout.WEST, newCourse, 5, SpringLayout.WEST, contentPane);
                layout.putConstraint(SpringLayout.NORTH, newCourse, cpi.geti(), SpringLayout.NORTH, selectedClasses);
                if (addClassOptions.getSelectedIndex() == -1) {
                    cpi.dispJOP("You can't add any more classes!");
                }
                else {
                    removeClassOptions.addItem(addClassOptions.getSelectedItem());
                    addClassOptions.removeItemAt(addClassOptions.getSelectedIndex());
                }
                cpi.incrementi();
            }
        });

        //need to make a "Remove Class" button and give it functionality

        window.setVisible(true);
        window.setBounds(400,150,1280,720);
    }


}