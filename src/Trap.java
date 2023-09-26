import java.util.Random;

public class Trap extends EventPoint {

	public Trap() {
		// Trap symbol
		setSymbol('#');
		// Random Trap Power
		Random rand = new Random();
		setPower(-(rand.nextInt(6 - 1) + 1)); // power will be random value range (-1) - (-5)
	}
}
