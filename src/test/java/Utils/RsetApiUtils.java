package Utils;

import java.util.Random;

public class RsetApiUtils {

	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
	
}
