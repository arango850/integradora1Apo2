package control;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IngredientData implements Serializable {
	private static final long serialVersionUID= 1L;
	
	private ObservableList<Ingredient> ingredients;
	
	public IngredientData() {
		ingredients=FXCollections.observableArrayList();
	}

	public ObservableList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ObservableList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
