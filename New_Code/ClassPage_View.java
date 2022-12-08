import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ClassPage_View extends JPanel {
    protected JFrame classFrame;
    private Container class_contentPane;
    private SpringLayout class_layout;
    private JLabel class_addClassLabel;
    private Class[] classes;
    private JComboBox class_addClassOptions;
    private JButton class_addClassButton;
    private JLabel class_selectedClasses;
    private JTable class_selectedClassesTable;
    private String[] class_selectedClassesTableColumns;
    private Object[][] class_selectedClassesTableData;
    private JLabel class_removeClassLabel;
    private JComboBox class_removeClassOptions;
    private JButton class_removeClassButton;
    private DefaultTableCellRenderer class_renderer;
    private Dimension class_dim;

    public ClassPage_View() {
        //creating temporary classes
        boolean[] MWF = new boolean[]{true, false, true, false, true};
        boolean[] MWTF = new boolean[]{true, false, true, true, false};
        boolean[] TR = new boolean[]{false, true, false, true, false};
        Class class1 = new Class("SWENG311", "Object Oriented Programming", 10, 11, MWTF);
        Class class2 = new Class("CMPSC360", "Discrete Mathematics", 11, 12, MWF);
        Class class3 = new Class("CMPSC121", "Intermediate Programming", 12, 13, MWTF);
        Class class4 = new Class("CMPSC200", "Matlab", 12, 13, MWF);
        classes = new Class[]{class1,class2,class3,class4};

        //JFrame for the class page window
        classFrame = new JFrame("Class Selection Screen");
        class_contentPane = classFrame.getContentPane();
        class_layout = new SpringLayout();
        class_contentPane.setLayout(class_layout);

        //JLabel for adding classes
        class_addClassLabel = new JLabel("Select classes to add:");
        class_contentPane.add(class_addClassLabel);
        class_layout.putConstraint(SpringLayout.WEST, class_addClassLabel, 5, SpringLayout.WEST, class_contentPane);

        //JComboBox for adding classes
        class_addClassOptions = new JComboBox(classes);
        class_contentPane.add(class_addClassOptions);
        class_layout.putConstraint(SpringLayout.WEST, class_addClassOptions, 5, SpringLayout.WEST, class_contentPane);
        class_layout.putConstraint(SpringLayout.NORTH, class_addClassOptions, 20, SpringLayout.NORTH, class_addClassLabel);

        //JButton to add classes
        class_addClassButton = new JButton("Add Class");
        class_contentPane.add(class_addClassButton);
        class_layout.putConstraint(SpringLayout.WEST, class_addClassButton, 200, SpringLayout.WEST, class_addClassOptions);
        class_layout.putConstraint(SpringLayout.NORTH, class_addClassButton, 20, SpringLayout.NORTH, class_addClassLabel);

        //JLabel for the selected classes
        class_selectedClasses = new JLabel("Current schedule:");
        class_contentPane.add(class_selectedClasses);
        class_layout.putConstraint(SpringLayout.WEST, class_selectedClasses, 5, SpringLayout.WEST, class_contentPane);
        class_layout.putConstraint(SpringLayout.NORTH, class_selectedClasses, 25, SpringLayout.SOUTH, class_addClassOptions);

        //JTable for selected classes
        class_selectedClassesTableColumns = new String[]{"Time Slot","Monday","Tuesday","Wednesday","Thursday","Friday"};
        class_selectedClassesTableData = new Object[28][6];
        for (int i = 0; i < 27; i+=2) {
            class_selectedClassesTableData[i+1][0] = (i+8-(i/2))+":00 - "+(i+9-(i/2))+":00";
            if (i < 26) {
                class_selectedClassesTableData[i+2][0] = " ";
            }
        }
        for (int i = 0; i < 6; i++) {
            class_selectedClassesTableData[0][i] = class_selectedClassesTableColumns[i];
        }
        class_selectedClassesTable = new JTable(class_selectedClassesTableData, class_selectedClassesTableColumns);
        class_contentPane.add(class_selectedClassesTable);
        class_layout.putConstraint(SpringLayout.NORTH, class_selectedClassesTable, 20, SpringLayout.NORTH, class_selectedClasses);
        class_layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, class_selectedClassesTable, 0, SpringLayout.HORIZONTAL_CENTER, class_contentPane);

        //JLabel for remove classes section
        class_removeClassLabel = new JLabel("Select classes to remove:");
        class_contentPane.add(class_removeClassLabel);
        class_layout.putConstraint(SpringLayout.WEST, class_removeClassLabel, 5,SpringLayout.WEST, class_contentPane);
        class_layout.putConstraint(SpringLayout.SOUTH, class_removeClassLabel, 40, SpringLayout.SOUTH, class_selectedClassesTable);

        //JComboBox for remove classes section
        class_removeClassOptions = new JComboBox();
        class_contentPane.add(class_removeClassOptions);
        class_layout.putConstraint(SpringLayout.WEST, class_removeClassOptions, 5, SpringLayout.WEST, class_contentPane);
        class_layout.putConstraint(SpringLayout.NORTH, class_removeClassOptions, 20, SpringLayout.NORTH, class_removeClassLabel);

        //JButton for remove classes section
        class_removeClassButton = new JButton("Remove Class");
        class_contentPane.add(class_removeClassButton);
        class_layout.putConstraint(SpringLayout.WEST, class_removeClassButton, 200, SpringLayout.WEST, class_removeClassOptions);
        class_layout.putConstraint(SpringLayout.NORTH, class_removeClassButton, 20, SpringLayout.NORTH, class_removeClassLabel);

        //sets renderer for the table
        class_renderer = new DefaultTableCellRenderer();
        class_renderer.setHorizontalAlignment(JLabel.CENTER);
        class_selectedClassesTable.getColumnModel().getColumn(0).setCellRenderer(class_renderer);
        for (int i = 1; i < 6; i++) {
            class_selectedClassesTable.getColumnModel().getColumn(i).setPreferredWidth(200);
            class_selectedClassesTable.getColumnModel().getColumn(i).setCellRenderer(class_renderer);
        }
        classFrame.setBounds(400,150,1280,720);
        class_dim = Toolkit.getDefaultToolkit().getScreenSize();
        classFrame.setLocation(class_dim.width/2-classFrame.getSize().width/2, class_dim.height/2-classFrame.getSize().height/2);
    }
    public JButton getClass_addClassButton() {
        return class_addClassButton;
    }
    public JButton getClass_removeClassButton() {
        return class_removeClassButton;
    }
    public JComboBox getClass_addClassOptions() {
        return class_addClassOptions;
    }
    public JComboBox getClass_removeClassOptions() {
        return class_removeClassOptions;
    }
    public Object[][] getClass_selectedClassesTableData() {
        return class_selectedClassesTableData;
    }
    public JTable getClass_selectedClassesTable() {
        return class_selectedClassesTable;
    }
}
