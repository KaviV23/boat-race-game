import java.io.IOException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// initialize/create class instances
		ScoreBoard scoreBoard = new ScoreBoard(); // ScoreBoard creates file or opens existing one
		Dice dice = new Dice(); // Dice is created with the default 6 faces
		RiverTrack river; // initialize RiverTrack
		Boat p1; // initialize player
		Boat p2; // initialize player
		Boat winner = null;
		String recentTurn = "p2";

		// initialize scanner
		Scanner input = new Scanner(System.in);

		// display score board
		scoreBoard.displayBoatScores();

		// ask player 1 & 2 to assign name
		System.out.println("Player 1 will make the first move");
		System.out.println("Player 1, Name your boat: ");
		p1 = new Boat(input.nextLine());
		System.out.println("Player 2, Name your boat: ");
		p2 = new Boat(input.nextLine());
		System.out.println();

		// construct river, place boats into river
		river = new RiverTrack(p1, p2);
		// display river
		river.displayRiver();

		// game start
		while (winner == null) {
			if (recentTurn == "p2") {
				// player1's turn
				System.out.printf("%s's(P1) Turn\n", p1.getName());
				p1.move(river, dice.roll()); // player 1 rolls the dice and moves
				// display river after p1 move
				river.displayRiver();
				recentTurn = "p1"; // set recent turn to p1
				// check for win
				if (p1.getPosition() == (river.getLength() - 1)) {
					winner = p1; // set winner to p1
				}
			} else if (recentTurn == "p1") {
				// player2's turn
				System.out.printf("%s's(P2) Turn\n", p2.getName());
				p2.move(river, dice.roll()); // player 1 rolls the dice and moves
				// display river after p1 move
				river.displayRiver();
				recentTurn = "p2"; // set recent turn to p1
				// check for win
				if (p2.getPosition() == (river.getLength() - 1)) {
					winner = p2; // set winner to p1
				}
			}
		}
		System.out.printf("Congratulations! %s is the Winner!\n\n", winner.getName());
		scoreBoard.addBoatScore(winner);
		scoreBoard.displayBoatScores();
		try { // save file
			scoreBoard.saveToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}