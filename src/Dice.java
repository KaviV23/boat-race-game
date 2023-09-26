import java.util.Random;
import java.util.Scanner;

public class Dice {
	private int faces;

	public Dice() {
		this(6);
	}

	public Dice(int faces) {
		this.faces = faces;
	}

	public int roll() {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		// Roll the dice on user request
		System.out.print("Press ENTER to roll the dice\n");
		input.nextLine();
		int draw = rand.nextInt((faces + 1) - 1) + 1;
		System.out.printf("You got a %d\n", draw);
		return draw;
	}
}
