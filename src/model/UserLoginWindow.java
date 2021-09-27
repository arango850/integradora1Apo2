package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import control.Worker;
import control.WorkerData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserLoginWindow extends Stage {
	WorkerData workerConeection;
	TextField idTF;
	PasswordField passTF;
	Button logTF;
	Button adTF;
	UserRegisterWindow userRegisterWindow;
	MenuWindow menuWindow;
	
	public UserLoginWindow() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLoginWindow.fxml"));
		Parent root= loader.load();
		Scene scene = new Scene(root, 761,504);
		setScene(scene);
		
		idTF= (TextField) loader.getNamespace().get("idTF");
		passTF= (PasswordField) loader.getNamespace().get("passTF");
		logTF= (Button) loader.getNamespace().get("logTF");
		adTF= (Button) loader.getNamespace().get("adTF");
		
		init();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public void init() {
		// TODO Auto-generated method stub
		logTF.setOnAction(event ->{
			login();
			
		});
		adTF.setOnAction(event ->{
			userRegisterWindow = new UserRegisterWindow();
			userRegisterWindow.show();
			this.close();
		});
	}

	public void login() {
		// TODO Auto-generated method stub
		try {
		File file = new File("workers.txt");
		FileInputStream fis= new FileInputStream(file);
		ObjectInputStream ois= new ObjectInputStream(fis);
		ArrayList<Worker> workers= (ArrayList<Worker>) ois.readObject();
		
		if(verification(workers)) {
			MenuWindow menuWindow= new MenuWindow();
			menuWindow.show();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de Incio de sesión");
			alert.setHeaderText("Error de Inicio de sesión");
			alert.setContentText("Vueleve a intentar");

			alert.showAndWait();
		}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public boolean verification(ArrayList<Worker> workers) {
		boolean ver= false;
		for(int i =0; i<workers.size();i++) {
			if(workers.get(i).getName().equals(idTF.getText())) {
				if(workers.get(i).getPassword().equals(passTF.getText())) {
					ver= true;
				}
			}
			
		}
		return ver;
	}
}
	

