package final_project_MVC;


import java.awt.Frame;
import javax.swing.*;

/*
 * In Models:
 * 	- Student
 * 	- Course
 * In Views:
 *	- Login Page, user Registration View, Main Page View 
 * 	- create all JFrame elements
 * 	- add elements to frame
 * 	- getters/setters to each element
 * Controller 
 * 	- contains references to (instances of) model and view 
 * 	- initController method to add actionListeners to GUI components
 * 	- add functionality to GUI elements
 */

public class Main {
	public static void main(String args[]) {
		Login_View logView = new Login_View();
		UserReg_View regView = new UserReg_View();
		controller control = new controller(logView, regView);
		
		control.initController();

	}
}
