package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PedidosModuleWindow extends Stage {

	Button registroBtn;
	Button listaBtn;
	Button cambiarBtn;
	Button back;

	MenuWindow menuWindow;
	
	public PedidosModuleWindow() {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("PedidosModuleWindow.fxml"));
		Parent root= loader.load();
		Scene scene = new Scene(root, 800,500);
		setScene(scene);
		
		registroBtn= (Button) loader.getNamespace().get("registroBtn");
		listaBtn= (Button) loader.getNamespace().get("listaBtn");
		cambiarBtn= (Button) loader.getNamespace().get("cambiarBtn");
		back= (Button) loader.getNamespace().get("back");
		
		init();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void init() {
		// TODO Auto-generated method stub
		registroBtn.setOnAction(event->{
			
		});
		listaBtn.setOnAction(event ->{
			
		});
		cambiarBtn.setOnAction(event->{
			
		});
		back.setOnAction(event->{
			menuWindow= new MenuWindow();
			menuWindow.show();
		});
	}
}
