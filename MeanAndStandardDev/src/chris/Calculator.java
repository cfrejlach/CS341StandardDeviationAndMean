package chris;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class Calculator.
 * 
 * @author Chris
 */
public class Calculator {
	
	/** The mean. */
	private static double mean;
	
	/** The stand D. */
	private static double standD;
	
	/** The list num. */
	private static String listNum;
	
	/** The num. */
	private static String[] num;
	
	/** The current. */
	private static Node current;
	
	/**
	 * Calc.
	 *
	 * @param listNums the list nums
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static void calc(File listNums) throws IOException {
		//put out error if file is empty
		assert TesterApp.isEmpty(listNums) == false : "Error: The file is empty";
		listNum = new String(Files.readAllBytes(Paths.get(listNums.toString())));

		//takes out white space so nums are separated by spaces
		//takes away blank line error
		listNum = listNum.replaceAll("\\s+", " ");
		num = listNum.split(" ");

		// CRASH IF ONE NUMBER IN FILE IS NOT A REAL NUMBER
		for (int i = 0; i <= num.length - 1; i++) {
			assert TesterApp.notNum(num[i]) == false : "Error: " + num[i] + " is not a real number";
		}

		// add value to LinkedList
		for (int i = 0; i <= num.length - 1; i++) {
			LinkedList.addNode(Integer.valueOf(num[i]));
		}
		mean = calcMean();
		standD = calcSD(mean);

	}
	
	/**
	 * Calc SD.
	 *
	 * @param mean the mean
	 * @return the double
	 */
	private static double calcSD(double mean) {
		standD = Math.sqrt(variance(LinkedList.getSize(), mean));
		return standD;
	}
	
	/**
	 * Variance.
	 *
	 * @param length the length
	 * @param mean the mean
	 * @return the double
	 */
	private static double variance(double length, double mean) {
		// Compute sum squared differences with the mean 
		double sqDiff = 0;
		current = LinkedList.getHead();
		sqDiff += (LinkedList.getHead().data - mean) * (LinkedList.getHead().data - mean);
		while (current.next != null) {
			current = current.next;
			sqDiff += (current.data - mean) * (current.data - mean);
		}
		System.out.println(length);
		return sqDiff / length;
	}

	/**
	 * Calc mean.
	 *
	 * @return the double
	 */
	private static double calcMean() {
		double sum = 0;
		current = LinkedList.getHead();
		;
		sum += current.data;
		while (current.next != null) {
			current = current.next;
			sum += current.data;
		}
		// Get the length of the array
		double length = num.length;
		// Return the average / mean.
		mean = (sum / length);
		return mean;
	}
	
	/**
	 * Gets the mean.
	 *
	 * @return the mean
	 */
	public static double getMean() {
		return mean;
	}
	
	/**
	 * Gets the sd.
	 *
	 * @return the sd
	 */
	public static double getSD() {
		return standD;
	}

}
