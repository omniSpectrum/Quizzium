package omniSpectrum.Quizzium.Models;

public class Quiz {
	
	private String name;
	private Question[] questions;
	
	public Quiz (String name, Question[] questions){
		this.name = name;
		this.questions = questions;
	}
	public Quiz (String name){
		this(name, null);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
