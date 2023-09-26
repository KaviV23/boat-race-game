import java.util.Random;

public class RiverTrack {
	private Boat p1;
	private Boat p2;
	private EventPoint[] track;
	private int length;

	// constructor
	public RiverTrack(Boat p1, Boat p2) {
		this(p1, p2, 100);
	}

	public RiverTrack(Boat p1, Boat p2, int length) {
		this.p1 = p1;
		this.p2 = p2;
		this.length = length;
		this.track = new EventPoint[length];
		// place 25 trap & current objects
		for (int i = 0; i < 15; i++) {
			placeEventPoints(new Trap());
			placeEventPoints(new Current());
		}
	}

	// setter/getter
	public int getLength() {
		return length;
	}

	public EventPoint getTrackItem(int i) {
		return track[i];
	}

	// methods
	public void placeEventPoints(EventPoint event) {
		// pick random spot on track that is not first/last
		Random rand = new Random();
		int point = rand.nextInt((length - 1) - 1) + 1;

		// prevent overwriting existing events
		while (track[point] != null) {
			point = rand.nextInt((length - 1) - 1) + 1;
		}
		track[point] = event; // place event once empty spot found on track
	}

	public void displayRiver() {
		int p1Pos = p1.getPosition();
		int p2Pos = p2.getPosition();

		for (int i = 0; i < length; i++) {
			if (i == p1Pos && i == p2Pos) {
				System.out.print("|1/2");
			} else if (i == p1Pos) {
				System.out.print("| 1 ");
				if (i == (length - 1)) { // last cell right border
					System.out.println("|\n");
				}
			} else if (i == p2Pos) {
				System.out.print("| 2 ");
				if (i == (length - 1)) {
					System.out.println("|\n"); // last cell right border
				}
			} else {
				EventPoint item = track[i];
				System.out.print("| ");
				if (item == null) {
					if (i != (length - 1)) {
						System.out.print("  ");
					}
				} else {
					String str = item.toString();
					String[] splt = str.split("\\s+");
					System.out.print(splt[0] + " ");
				}
				if (i == (length - 1)) {
					System.out.println("  |\n"); // last cell right border
				}
			}
		}
	}
}
