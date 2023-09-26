import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Collections;
import java.lang.Integer;

public class ScoreBoard {
	private ArrayList<String> boatScores = new ArrayList<>();
	
	public ScoreBoard() {
		// create new save file
		File saveFile = new File("ScoreBoard.txt");
		try {
			if (saveFile.createNewFile()) {
				
			}
			else {
				Scanner readSaveFile = new Scanner(new File("ScoreBoard.txt"));
				while (readSaveFile.hasNext()) {
					boatScores.add(new Boat(readSaveFile.nextInt(), readSaveFile.next()).toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addBoatScore(Boat boat) {
		if (boatScores.size() == 5) {
			for (String x: boatScores) {
				String[] ScoreSplt = x.split("\\s+");
				String[] BoatSplt = boat.toString().split("\\s+");
				int s = Integer.parseInt(ScoreSplt[0]);
				int b = Integer.parseInt(BoatSplt[0]);
				if (b <= s) {
					boatScores.add(boat.toString());
					System.out.println("You are on the leaderboard!\n");
					break;
				}
			}
		} 
		else {
			boatScores.add(boat.toString());
			System.out.println("You are on the leaderboard!\n");
		}
		Collections.sort(boatScores);
		if (boatScores.size() > 5) {
			boatScores.remove(5);
		}
	}
	
	public void displayBoatScores() {
		System.out.println("Top Five Scores:");
		if (boatScores.size() == 0) {
			System.out.println("No records");
		}
		else {
			for (String x: boatScores) {
				System.out.println(x);
				}
			}
		System.out.println();
		}
	
	public void saveToFile() throws IOException {
		FileWriter writeFile = new FileWriter("Scoreboard.txt");
		for (String x: boatScores) {
			writeFile.write(x.toString()+"\n");
		}
		writeFile.close();
	}
}