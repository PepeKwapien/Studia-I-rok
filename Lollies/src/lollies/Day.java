package lollies;

public class Day {

	private int lollies;
	private int delay;
	
	private int maxLollies;
	
	public Day(int _lollies, int _delay) {
		lollies = _lollies;
		delay = _delay;
		maxLollies = _lollies;
	}

	public int getLollies() {
		return lollies;
	}

	public void setLollies(int lollies) {
		this.lollies = lollies;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getMaxLollies() {
		return maxLollies;
	}

	public void setMaxLollies(int maxLollies) {
		this.maxLollies = maxLollies;
	}
	
}
