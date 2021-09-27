package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CartaModuleWindow extends Stage  {

	Button create;
	Button back;
	MenuWindow menuWindow;
	
	public CartaModuleWindow () {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("CartaModuleWindow.fxml"));
		
			Parent root= loader.load();
			Scene scene = new Scene(root, 600,500);
			setScene(scene);
			
			create= (Button) loader.getNamespace().get("create");
			back=(Button) loader.getNamespace().get("back");
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void init() {
		// TODO Auto-generated method stub
		create.setOnAction(event->{
			
		});
		back.setOnAction(event->{
			menuWindow= new MenuWindow();
			menuWindow.show();
		});
	}
}
