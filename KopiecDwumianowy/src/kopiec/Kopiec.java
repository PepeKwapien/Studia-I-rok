package kopiec;

public class Kopiec {
	W�ze� head;
	
	public Kopiec() {
		head = null;
	}
	
	public Kopiec(W�ze� w) {
		if(w.getRodzic()!=null)
			throw new IllegalArgumentException();
		else {
			head = w;
		}
	}
	
	private void Merge(Kopiec k1, Kopiec k2) {
		W�ze� drzewo1 = k1.getHead();
		W�ze� drzewo2 = k2.getHead();
		
		if(drzewo1 == null) {
			head = drzewo2;
		}
		if(drzewo2 == null) {
			head = drzewo1;
		}
		else if(drzewo2 != null && drzewo1 != null) {
			if(drzewo1.getWysoko��()<=drzewo2.getWysoko��()) {
				head = drzewo1;
				drzewo1 = drzewo1.getPrawyBrat();
			}
			else {
				head = drzewo2;
				drzewo2 = drzewo2.getPrawyBrat();
			}
			W�ze� nastepny = head;
			while(drzewo2 !=null && drzewo1 != null) {
				if(drzewo1.getWysoko��()<=drzewo2.getWysoko��()) {
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
		W�ze� poprzedni = null;
		W�ze� x = head;
		W�ze� nastepny = x.getPrawyBrat();
		while(nastepny != null) {
			if(x.getWysoko��()!=nastepny.getWysoko��() || (nastepny.getPrawyBrat()!=null && nastepny.getPrawyBrat().getWysoko��()==x.getWysoko��())) {
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
		W�ze� naChwile = this.head;
		k1.Destroy();
		k2.Destroy();
		this.setHead(naChwile);
		return this;
	}

	public W�ze� getHead() {
		return head;
	}

	public void setHead(W�ze� head) {
		this.head = head;
	}
	
	private void Destroy() {
		head = null;
	}
	
	public void Insert(int key) {
		Kopiec help = new Kopiec(new W�ze�(key));
		this.Union(this, help);
	}
	
	public int Minimum() throws PustyKopiecException {
		if(head == null) {
			throw new PustyKopiecException();
		}
		int minimum = head.getKlucz();
		W�ze� analizowany = head.getPrawyBrat();
		while(analizowany != null) {
			minimum = analizowany.getKlucz() < minimum ? analizowany.getKlucz() : minimum;
			analizowany = analizowany.getPrawyBrat();
		}
		return minimum;
	}
	
	private void InsertW�ze�(W�ze� w) {
		Kopiec help = new Kopiec(w);
		this.Union(this, help);
	}
	
	public void ExtractMinimum() throws PustyKopiecException {
		int minimum = this.Minimum();
		W�ze� poprzedni = null;
		W�ze� x = head;
		
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
		
		W�ze� noweDrzewo = x.getLeweDziecko();
		Kopiec help = new Kopiec();
		while(noweDrzewo!=null) {
			W�ze� analizowany = noweDrzewo;
			noweDrzewo = analizowany.getPrawyBrat();
			analizowany.setRodzic(null);
			analizowany.setPrawyBrat(null);
			help.InsertW�ze�(analizowany);
		}
		
		this.Union(this, help);
	}
	
	private W�ze� ZnajdzWezel(int x) {
		return head.ZnajdzWezel(x);
	}
	
	public void DecreaseKey(int x, int fresh) {
		if(fresh > x) {
			throw new IllegalArgumentException("Nowa warto�� klucza jest wieksza!");
		}
		W�ze� znaleziony = this.ZnajdzWezel(x);
		znaleziony.setKlucz(fresh);
		W�ze� y = znaleziony;
		W�ze� z = znaleziony.getRodzic();
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
