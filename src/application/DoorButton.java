package application;

import business.Door;
import javafx.scene.control.Button;
/**
 * 
 * @author Chiara-Marie Zok
 *
 */
public class DoorButton extends Button {
	//door would be a better name but I saw the chance and took it 
	
	public final Door hodor;
	
	public DoorButton(Door door) {
		hodor = door;
	}

	
}
