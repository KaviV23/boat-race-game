import java.util.Random;

public class Current extends EventPoint {

	public Current() {
		// Current symbol
		setSymbol('C');
		// Random Current Power
		Random rand = new Random();
		setPower(rand.nextInt(6 - 1) + 1); // power will be random value range 1 - 5
	}
}
