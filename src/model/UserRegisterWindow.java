package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import control.Worker;
import control.WorkerData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserRegisterWindow extends Stage {

	TextField adminTF;
	TextField adminIDTF;
	PasswordField adminPassTF;
	DatePicker adminDate;
	Button adminDone;
	Button back;
	
	
	private WorkerData workerData;
	private UserLoginWindow userLoginWindow;
	
	public UserRegisterWindow() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserRegisterWindow.fxml"));
		Parent root= loader.load();
		Scene scene= new Scene (root, 800,700);
		setScene(scene);
		
		adminTF= (TextField) loader.getNamespace().get("adminTF");
		adminIDTF= (TextField) loader.getNamespace().get("adminIDTF");
		adminPassTF= (PasswordField) loader.getNamespace().get("adminPassTF");
		adminDate= (DatePicker) loader.getNamespace().get("adminDate");
		adminDone= (Button) loader.getNamespace().get("adminDone");
		back= (Button) loader.getNamespace().get("back");
		
		workerData= new WorkerData();
		
		
		init();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		// TODO Auto-generated method stub
		adminDone.setOnAction(e ->{
			login();
			
		});
		back.setOnAction(event->{
			userLoginWindow= new UserLoginWindow();
			userLoginWindow.show();
		});
	}

	public void login() {
		// TODO Auto-generated method stub
		String name= adminTF.getText();
		String id= adminIDTF.getText();
		String date= adminDate.getValue().toString();
		String password= adminPassTF.getText();
		
		
		Worker work= new Worker(name,id,date,password);
		
		workerData.setWorker(getDataWorker());
		workerData.getWorker().add(work);
		
		guardarWorker(work);
		
		this.close();
		
	}

	private void guardarWorker(Worker work) {
		// TODO Auto-generated method stub
		try {
		File file= new File("workers.txt");
		FileOutputStream out= new FileOutputStream(file);
		ObjectOutputStream oos= new ObjectOutputStream(out);
		oos.writeObject(new ArrayList<Worker>(workerData.getWorker()));
		oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ObservableList<Worker> getDataWorker() {
		// TODO Auto-generated method stub
		
		try {
		File file= new File("students.txt");
		FileInputStream fis= new FileInputStream(file);
		ObjectInputStream ois= new ObjectInputStream(fis);
		List<Worker> list= (List<Worker>) ois.readObject();
		ObservableList<Worker> dataWorker = FXCollections.observableList(list);
		return dataWorker;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
