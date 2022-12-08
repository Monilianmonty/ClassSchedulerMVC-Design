package final_project_MVC;


import java.awt.Frame;
import javax.swing.*;

/*
 * In Models:
 * 	- Student
 * 	- Course
 * 	- loginPage
 * 	- UserReg
 * 	- CoursePage
 * 
 * In View:
 * 	- create all JFrame elements
 * 	- getters/setters to each element
 * 	- add elements to frame
 * 
 * Controller 
 * 	- contains references to (instances of) model and view 
 * 	- initController method to add actionListeners to GUI components
 * 	- use .addActionListener(e -> *actionFunction*) and put actionFunction(){<code>} later
 */

public class Main {
	public static void main(String args[]) {
		Login_View logView = new Login_View();
		UserReg_View regView = new UserReg_View();
		ClassPage_View classView = new ClassPage_View();
		
		controller control = new controller(logView, regView, classView);
		
		control.initController();

	}
}
