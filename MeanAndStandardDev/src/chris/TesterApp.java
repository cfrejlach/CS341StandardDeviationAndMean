package chris;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class TesterApp.
 * @author Chris
 * 
 */
public class TesterApp {
	
	/**
	 * Not num.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	public static boolean notNum(String value) {
		//Check if there is anything other than a real number and if so return false
		boolean test = true;
		for (int i = 0; i <= value.length() - 1; i++) {
			char check = value.charAt(i);
			if (Character.isDigit(check))
				test = false;
			else {
				test = true;
				break;
			}

		}
		return test;
	}
	
	
	/**
	 * Checks if is empty.
	 *
	 * @param listNums the list nums
	 * @return true, if is empty
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean isEmpty(File listNums) throws IOException {
		//check if the file is empty
		BufferedReader br = new BufferedReader(new FileReader(listNums));
		if (br.readLine() == null) {
			br.close();
			return true;
		} else {
			br.close();
			return false;
		}
	}
}
