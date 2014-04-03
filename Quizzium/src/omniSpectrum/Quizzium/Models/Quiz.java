package omniSpectrum.Quizzium.Models;

public class Quiz {
	
	private String name;
	private Object questions;
	
	public Quiz (String name){
		this.name = name;
		this.questions = null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
