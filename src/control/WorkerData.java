package control;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkerData implements Serializable {
	private static final long serialVersionUID  = 1L;
	
	
	
	private ObservableList<Worker> worker;
	
	public WorkerData() {
		worker= FXCollections.observableArrayList();
	}

	public WorkerData(ObservableList<Worker> worker) {
		
		this.worker = worker;
	}

	public ObservableList<Worker> getWorker() {
		return worker;
	}

	public void setWorker(ObservableList<Worker> worker) {
		this.worker = worker;
	}
	
	
	

}
