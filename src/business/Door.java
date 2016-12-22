
package business;

/**
 * 
 * @author Chiara-Marie Zok
 * 
 */
public class Door {
	private String movie, director; 
	private int number; 
	private boolean open; 
	
	public Door(String movie, String director, int number, boolean open){
		this.movie = movie; 
		this.director = director; 
		this.number = number;  
		this.open = open; 
	}
	
	public String getMovie(){
		return movie; 
	}
	
	public String getDirector(){
		return this.director; 
	}
	public int getNumber(){
		return this.number; 
	}
	public boolean getOpen(){
		return this.open;
	}
	
	public void setOpen(boolean open){
		this.open = open; 
	}
	
}
