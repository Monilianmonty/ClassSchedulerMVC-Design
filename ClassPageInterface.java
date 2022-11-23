import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClassPageInterface {
    public static void main(String[] args) {
        JFrame window = new JFrame("Class Selection Screen");
        Container contentPane = window.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        //select class label
        JLabel selectClass = new JLabel("Select a class to add: ");
        contentPane.add(selectClass);
        layout.putConstraint(SpringLayout.WEST, selectClass, 5, SpringLayout.WEST, contentPane);

        //dropdown box for various class options
        JComboBox classOptions = new JComboBox();
        //temporary classes for now
        classOptions.addItem("SWENG311");
        classOptions.addItem("CMPSC360");
        classOptions.addItem("CMPSC121");
        contentPane.add(classOptions);
        layout.putConstraint(SpringLayout.WEST, classOptions, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, classOptions, 20, SpringLayout.NORTH, selectClass);

        //add an "Add Class" button
        JButton addButton = new JButton("Add Class");
        contentPane.add(addButton);
        layout.putConstraint(SpringLayout.WEST, addButton, 110, SpringLayout.WEST, classOptions);
        layout.putConstraint(SpringLayout.NORTH, addButton, 20, SpringLayout.NORTH, selectClass);

        //selected classes label
        JLabel selectedClasses = new JLabel("Current schedule: ");
        contentPane.add(selectedClasses);
        layout.putConstraint(SpringLayout.WEST, selectedClasses, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, selectedClasses, 25, SpringLayout.SOUTH, classOptions);

        //allows "Add Class" method to do stuff
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove course visibility from dropdown
                //JLabel newCourse = new JLabel(classOptions.get);
                classOptions.removeItemAt(classOptions.getSelectedIndex());
                //add to section below
            }
        });
        window.setVisible(true);
        window.setBounds(400,150,1280,720);
    }
}
