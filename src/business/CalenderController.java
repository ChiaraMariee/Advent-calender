package business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

/**
 * 
 * @author Chiara-Marie Zok
 *
 */
public class CalenderController {
	final int MAXDATE = 24;
	Door[] doors = new Door[MAXDATE];

	/**
	 * fills each door with the information found in the source File
	 * 
	 * @param sourceFile
	 */
	public void init(String sourceFile) {
		Door currentDoor = null;
		int number;
		String movie, director;
		BufferedReader reader = null;
		String line;

		try {
			reader = new BufferedReader(new FileReader(sourceFile));
			for (int i = 0; i < MAXDATE; i++) {
				line = reader.readLine();
				number = Integer.parseInt(line.split(";")[0]);
				movie = line.split(";")[1];
				director = line.split(";")[2];

				if (movie!= null && director != null && number <= MAXDATE && number > 0) {
					currentDoor = new Door(movie, director, number, false);
				}

				doors[i] = currentDoor;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * checks if the user can open the door he has clicked on
	 * 
	 * @param toOpen door that has been clicked on 
	 * @return boolean if opening is possible
	 */
	public boolean open(Door toOpen) {
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
	
		if (toOpen.getOpen() == false) {
			if (toOpen.getNumber() <= day) {
				toOpen.setOpen(true);
				return true;
			}
		} else {
			return true;
		}
		return false;
	}

	public Door[] getDoors() {
		return doors;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}
}
