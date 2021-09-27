package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import control.Worker;
import control.WorkerData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class cambiarContrasena extends Stage {

	TextField name;
	PasswordField newpass;
	Button done;
	Button back;
	private WorkerData workerdata;
	PersonalModuleWindow personalModuleWindow;
	public cambiarContrasena() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("cambiarContrasena.fxml"));
			Parent root= loader.load();
			Scene scene= new Scene (root, 800,700);
			setScene(scene);
			
			name= (TextField) loader.getNamespace().get("name");
			
			newpass= (PasswordField) loader.getNamespace().get("newpass");
			
			done= (Button) loader.getNamespace().get("done");
			back= (Button) loader.getNamespace().get("back");
			
			workerdata= new WorkerData();
			
			
			init();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public void init() {
		// TODO Auto-generated method stub
		back.setOnAction(event->{
			personalModuleWindow= new PersonalModuleWindow();
			personalModuleWindow.show();
		});
		done.setOnAction(event->{
			try {
				File file = new File("workers.txt");
				FileInputStream fis= new FileInputStream(file);
				ObjectInputStream ois= new ObjectInputStream(fis);
				ArrayList<Worker> workers= (ArrayList<Worker>) ois.readObject();
				
				if(verification(workers)) {
					String newpass1= newpass.getText();
					
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error de Usuario");
					alert.setHeaderText("Usuario No encontrado");
					alert.setContentText("Vueleve a intentar");

					alert.showAndWait();
				}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			
		});}
		public boolean verification(ArrayList<Worker> workers) {
			boolean ver= false;
			for(int i =0; i<workers.size();i++) {
				if(workers.get(i).getName().equals(name.getText())) {
					ver= true;
					
				}
				
			}
			return ver;
		}
	}
 
