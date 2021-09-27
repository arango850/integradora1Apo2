package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.UserLoginWindow;
import model.UserRegisterWindow;

public class Main extends Application {

	UserLoginWindow userLoginWindow;
	UserRegisterWindow userRegisterWindow;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		userLoginWindow= new UserLoginWindow();
		userLoginWindow.show();
	}

}
