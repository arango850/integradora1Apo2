package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuWindow extends Stage {

	Button personalBtn;
	Button inventarioBtn;
	Button cartaBtn;
	Button pedidosBtn;
	PersonalModuleWindow personalModuleWindow;
	InventarioModuleWindow inventarModuleWindow;
	CartaModuleWindow cartaModuleWindow;
	PedidosModuleWindow pedidosModuleWindow;
	public MenuWindow() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuWindow.fxml"));
		Parent root= loader.load();
		Scene scene = new Scene(root, 800,700);
		setScene(scene);
		
		personalBtn= (Button) loader.getNamespace().get("personalBtn");
		inventarioBtn = (Button) loader.getNamespace().get("inventarioBtn");
		cartaBtn=(Button)loader.getNamespace().get("cartaBtn");
		pedidosBtn= (Button) loader.getNamespace().get("pedidosBtn");
		
		init();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void init() {
		// TODO Auto-generated method stub
		personalBtn.setOnAction(event->{
			personalModuleWindow= new PersonalModuleWindow();
			personalModuleWindow.show();
		});
		inventarioBtn.setOnAction(event ->{
			inventarModuleWindow= new InventarioModuleWindow();
			inventarModuleWindow.show();
		});
		cartaBtn.setOnAction(event->{
			cartaModuleWindow= new CartaModuleWindow();
			cartaModuleWindow.show();
		});
		pedidosBtn.setOnAction(event->{
			pedidosModuleWindow= new PedidosModuleWindow();
			pedidosModuleWindow.show();
		});
		
		
	}
}
