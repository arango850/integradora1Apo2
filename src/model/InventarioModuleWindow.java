package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InventarioModuleWindow extends Stage {

	Button addBtn;
	Button chBtn;
	Button sprBtn;
	Button back;
	MenuWindow menuWindow;
	
	public InventarioModuleWindow() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("InventarioModuleWindow.fxml"));
		Parent root= loader.load();
		Scene scene= new Scene(root, 800,700);
		setScene(scene);
		
		addBtn= (Button) loader.getNamespace().get("addBtn");
		chBtn= (Button) loader.getNamespace().get("chBtn");
		sprBtn = (Button) loader.getNamespace().get("sprBtn");
		back= (Button) loader.getNamespace().get("back");
		
		init();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void init() {
		// TODO Auto-generated method stub
		addBtn.setOnAction(event->{
			
		});
		chBtn.setOnAction(event->{
			
		});
		sprBtn.setOnAction(event->{
			
		});
		back.setOnAction(event->{
			menuWindow = new MenuWindow();
			menuWindow.show();
		});
	}
	
}
