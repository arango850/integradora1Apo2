package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonalModuleWindow extends Stage {

	private Button workerList;
	private Button changePass;
	private Button back;
	
	MenuWindow menuWindow;
	
	public PersonalModuleWindow() {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("PersonalModuleWindow.fxml"));
		Parent root = loader.load();
		Scene scene= new Scene(root, 800,700);
		setScene(scene);
		
		workerList= (Button) loader.getNamespace().get("workerList");
		changePass=(Button) loader.getNamespace().get("changePass");
		back=(Button) loader.getNamespace().get("back");
		init();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		// TODO Auto-generated method stub
		workerList.setOnAction(event->{
			
		});
		changePass.setOnAction(event->{
			
		});
		back.setOnAction(event->{
		menuWindow= new MenuWindow();
		menuWindow.show();
		});
	}
}
