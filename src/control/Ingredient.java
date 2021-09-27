package control;

import java.io.Serializable;

public class Ingredient implements Serializable {
	private static final long serialVersionUID= 1L;
	private String ingredientName;
	private double amount;
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Ingredient() {
		
		// TODO Auto-generated constructor stub
	}
	public Ingredient(String ingredientName, double amount) {
		
		this.ingredientName = ingredientName;
		this.amount = amount;
	}

	
		
}
