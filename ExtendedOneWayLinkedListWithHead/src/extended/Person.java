package extended;

public class Person {

	String nazwisko;
	int pesel;
	
	public Person(String n, int p) {
		nazwisko = n;
		pesel = p;
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		
		if(p.nazwisko.equals(this.nazwisko)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nazwisko+" "+pesel;
	}
	
	
}
