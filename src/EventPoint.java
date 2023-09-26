
public class EventPoint {
	private char symbol;
	private int power;
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d", getSymbol(), getPower());
	}
}
