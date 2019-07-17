package onp;

public class ZlaNotacjaException extends Exception {

	public ZlaNotacjaException(String s) {
		super("Expression was incorrect! - "+s);
	}
}
