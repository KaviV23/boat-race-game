import java.lang.Integer;

public class Boat {
	private String name;
	private int position;
	private int moveCount;

	public Boat(String name) {
		this(0, name);
	}

	public Boat(int moveCount, String name) {
		setName(name);
		setMoveCount(moveCount);
	}

	// setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	// methods
	public void move(RiverTrack track, int diceRoll) {
		// check for event
		if (checkEvent(track, checkOutOfBounds(track, getPosition() + diceRoll))) { // if there's event
			setPosition(checkOutOfBounds(track, hitEvent(track, getPosition() + diceRoll)));

		} else { // if there is no event
			setPosition(checkOutOfBounds(track, getPosition() + diceRoll));
		}
		moveCount ++;
	}

	public boolean checkEvent(RiverTrack track, int pos) {
		if (track.getTrackItem(pos) == null) {
			return false;
		} else {
			return true;
		}
	}

	public int checkOutOfBounds(RiverTrack track, int pos) {
		if (pos > track.getLength() - 1) {
			return 99;
		} else if (pos < 0) {
			return 0;
		} else {
			return pos;
		}
	}

	public int hitEvent(RiverTrack track, int pos) {
		String str = track.getTrackItem(pos).toString();
		String[] splt = str.split("\\s+");
		int pushOrPull = Integer.parseInt(splt[1]);
		return pos + pushOrPull;
	}

	@Override
	public String toString() {
		return String.format("%d %s", getMoveCount(), getName());
	}
}
