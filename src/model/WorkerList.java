package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import control.Worker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class WorkerList extends Stage {

	 private TableView<Worker> table;
	Button back;
	
	PersonalModuleWindow personalModuleWindow;
	
	
	public WorkerList() {
		try {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("WorkerList.fxml"));
		
			Parent root= loader.load();
			Scene scene= new Scene(root,700,600);
			setScene(scene);
			
			table= (TableView) loader.getNamespace().get("table");
			back= (Button) loader.getNamespace().get("back");
			
			TableColumn<Worker, String> nameColum= new TableColumn<>("name");
			TableColumn<Worker,String> idColum= new TableColumn<>("cedula");
			TableColumn<Worker, String> passColum= new TableColumn<>("contraseña");
			TableColumn<Worker, String> dateColum= new TableColumn<>("fecha de nacimiento");
			
			nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
			idColum.setCellValueFactory(new PropertyValueFactory<>("id"));
			passColum.setCellValueFactory(new PropertyValueFactory<>("password"));
			dateColum.setCellValueFactory(new PropertyValueFactory<>("date"));
			
			table.getColumns().addAll(nameColum, idColum,passColum,dateColum);
			table.setItems(getData());
			
			init();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private ObservableList<Worker> getData() {
		// TODO Auto-generated method stub
		try {
		File file= new File("worker.txt");
		
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			List<Worker> list= (List<Worker>) ois.readObject();
			ObservableList<Worker> worker= FXCollections.observableArrayList(list);
			
			return worker;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	public void init() {
		// TODO Auto-generated method stub
		back.setOnAction(event->{
			personalModuleWindow= new PersonalModuleWindow();
			personalModuleWindow.show();
		});
	}
	
}
