package kopiec;

public class Kopiec {
	Wêze³ head;
	
	public Kopiec() {
		head = null;
	}
	
	public Kopiec(Wêze³ w) {
		if(w.getRodzic()!=null)
			throw new IllegalArgumentException();
		else {
			head = w;
		}
	}
	
	private void Merge(Kopiec k1, Kopiec k2) {
		Wêze³ drzewo1 = k1.getHead();
		Wêze³ drzewo2 = k2.getHead();
		
		if(drzewo1 == null) {
			head = drzewo2;
		}
		if(drzewo2 == null) {
			head = drzewo1;
		}
		else if(drzewo2 != null && drzewo1 != null) {
			if(drzewo1.getWysokoœæ()<=drzewo2.getWysokoœæ()) {
				head = drzewo1;
				drzewo1 = drzewo1.getPrawyBrat();
			}
			else {
				head = drzewo2;
				drzewo2 = drzewo2.getPrawyBrat();
			}
			Wêze³ nastepny = head;
			while(drzewo2 !=null && drzewo1 != null) {
				if(drzewo1.getWysokoœæ()<=drzewo2.getWysokoœæ()) {
					nastepny.setPrawyBrat(drzewo1);
					drzewo1 = drzewo1.getPrawyBrat();
					nastepny = nastepny.getPrawyBrat();
				}
				else {
					nastepny.setPrawyBrat(drzewo2);
					drzewo2 = drzewo2.getPrawyBrat();
					nastepny = nastepny.getPrawyBrat();
				}
			}
			if(drzewo2 == null) {
				nastepny.setPrawyBrat(drzewo1);
			}
			else {
				nastepny.setPrawyBrat(drzewo2);
			}
		}
		
	}
	
	public Kopiec Union(Kopiec k1, Kopiec k2) {
		Merge(k1,k2);
		if(head == null) {
			return this;
		}
		Wêze³ poprzedni = null;
		Wêze³ x = head;
		Wêze³ nastepny = x.getPrawyBrat();
		while(nastepny != null) {
			if(x.getWysokoœæ()!=nastepny.getWysokoœæ() || (nastepny.getPrawyBrat()!=null && nastepny.getPrawyBrat().getWysokoœæ()==x.getWysokoœæ())) {
				poprzedni = x;
				x = nastepny;
			}
			else {
				if(x.getKlucz()<=nastepny.getKlucz()) {
					x.setPrawyBrat(nastepny.getPrawyBrat());
					x = x.Merge(nastepny);
				}
				else {
					if(poprzedni == null) {
						head = nastepny;
					}
					else {
						poprzedni.setPrawyBrat(nastepny);
					}
					nastepny = nastepny.Merge(x);
					x = nastepny;
				}
			}
			nastepny = x.getPrawyBrat();
		}
		Wêze³ naChwile = this.head;
		k1.Destroy();
		k2.Destroy();
		this.setHead(naChwile);
		return this;
	}

	public Wêze³ getHead() {
		return head;
	}

	public void setHead(Wêze³ head) {
		this.head = head;
	}
	
	private void Destroy() {
		head = null;
	}
	
	public void Insert(int key) {
		Kopiec help = new Kopiec(new Wêze³(key));
		this.Union(this, help);
	}
	
	public int Minimum() throws PustyKopiecException {
		if(head == null) {
			throw new PustyKopiecException();
		}
		int minimum = head.getKlucz();
		Wêze³ analizowany = head.getPrawyBrat();
		while(analizowany != null) {
			minimum = analizowany.getKlucz() < minimum ? analizowany.getKlucz() : minimum;
			analizowany = analizowany.getPrawyBrat();
		}
		return minimum;
	}
	
	private void InsertWêze³(Wêze³ w) {
		Kopiec help = new Kopiec(w);
		this.Union(this, help);
	}
	
	public void ExtractMinimum() throws PustyKopiecException {
		int minimum = this.Minimum();
		Wêze³ poprzedni = null;
		Wêze³ x = head;
		
		while(x.getKlucz()!=minimum) {
			poprzedni = x;
			x = x.getPrawyBrat();
		}
		
		if(poprzedni == null) {
			head = x.getPrawyBrat();
		}
		else {
			poprzedni.setPrawyBrat(x.getPrawyBrat());
		}
		
		Wêze³ noweDrzewo = x.getLeweDziecko();
		Kopiec help = new Kopiec();
		while(noweDrzewo!=null) {
			Wêze³ analizowany = noweDrzewo;
			noweDrzewo = analizowany.getPrawyBrat();
			analizowany.setRodzic(null);
			analizowany.setPrawyBrat(null);
			help.InsertWêze³(analizowany);
		}
		
		this.Union(this, help);
	}
	
	private Wêze³ ZnajdzWezel(int x) {
		return head.ZnajdzWezel(x);
	}
	
	public void DecreaseKey(int x, int fresh) {
		if(fresh > x) {
			throw new IllegalArgumentException("Nowa wartoœæ klucza jest wieksza!");
		}
		Wêze³ znaleziony = this.ZnajdzWezel(x);
		znaleziony.setKlucz(fresh);
		Wêze³ y = znaleziony;
		Wêze³ z = znaleziony.getRodzic();
		while(z!=null && y.getKlucz()<z.getKlucz()) {
			int temp = z.getKlucz();
			z.setKlucz(y.getKlucz());
			y.setKlucz(temp);
			
			y = z;
			z = y.getRodzic();
		}
	}
	
	public void Delete(int x) throws PustyKopiecException {
		this.DecreaseKey(x, Integer.MIN_VALUE);
		this.ExtractMinimum();
	}
	
}
