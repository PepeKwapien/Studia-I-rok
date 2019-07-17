package lollies;

public class Solution {

	public static String solve(Day[] month) {
		
		int best = 0;
		
		for(int i = 0; i<month.length; i++) {
			int howManyLolliesCollected = month[i].getMaxLollies();
			if(best<month[i].getMaxLollies())
				best = month[i].getMaxLollies();
			for(int j = i+month[i].getDelay() ;j<month.length; j++) {
				if(howManyLolliesCollected+month[j].getLollies()>month[j].getMaxLollies())
					month[j].setMaxLollies(howManyLolliesCollected+month[j].getLollies());
			}
		}
		
		return String.format("You can collect %d lollies at best", best);
	}
	
	public static void main(String[] args) {
		Day[] month1 = new Day[5];
		month1[0] = new Day(1,2);
		month1[1] = new Day(4,2);
		month1[2] = new Day(7,5);
		month1[3] = new Day(3,1);
	    month1[4] = new Day(13,7);
		System.out.println(solve(month1));
		
		Day[] month2 = new Day[8];
		month2[0] = new Day(1,7);
		month2[1] = new Day(2,6);
		month2[2] = new Day(3,5);
		month2[3] = new Day(4,4);
		month2[4] = new Day(5,3);
		month2[5] = new Day(6,2);
		month2[6] = new Day(20,1);
		month2[7] = new Day(1,7);
		System.out.println(solve(month2));
	}
}
