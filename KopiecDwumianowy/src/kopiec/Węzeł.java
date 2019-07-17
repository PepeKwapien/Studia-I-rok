package kopiec;

import java.util.NoSuchElementException;

public class Wêze³ {
	private int wysokoœæ;
	private Wêze³ leweDziecko;
	private Wêze³ prawyBrat;
	private Wêze³ rodzic;
	private int klucz;
	
	public Wêze³(int klucz) {
		if(klucz == Integer.MIN_VALUE)
			throw new IllegalArgumentException();
		this.wysokoœæ = 0;
		this.rodzic = null;
		this.prawyBrat = null;
		this.leweDziecko = null;
		
		this.klucz = klucz;
	}
	
	public Wêze³ Merge(Wêze³ x) {
		if(x.getWysokoœæ()!=this.getWysokoœæ())
			throw new IllegalArgumentException();
		else {
			if(x.getKlucz()>this.klucz) {
				this.ZwiekszWysokosc();
				MergeHelp(x,this);
				return this;
			}
			else {
				x.ZwiekszWysokosc();
				MergeHelp(this,x);
				return x;
			}
		}
	}
	
	private void MergeHelp(Wêze³ x, Wêze³ y) {
		x.setRodzic(y);
		x.setPrawyBrat(y.getLeweDziecko());
		y.setLeweDziecko(x);
	}

	
	private void ZwiekszWysokosc() {
		this.wysokoœæ++;
	}
	
	public int getWysokoœæ() {
		return wysokoœæ;
	}

	public void setWysokoœæ(int wysokoœæ) {
		this.wysokoœæ = wysokoœæ;
	}

	public Wêze³ getLeweDziecko() {
		return leweDziecko;
	}

	public void setLeweDziecko(Wêze³ leweDziecko) {
		this.leweDziecko = leweDziecko;
	}

	public Wêze³ getPrawyBrat() {
		return prawyBrat;
	}

	public void setPrawyBrat(Wêze³ prawyBrat) {
		this.prawyBrat = prawyBrat;
	}

	public Wêze³ getRodzic() {
		return rodzic;
	}

	public void setRodzic(Wêze³ rodzic) {
		this.rodzic = rodzic;
	}

	public int getKlucz() {
		return klucz;
	}

	public void setKlucz(int klucz) {
		this.klucz = klucz;
	}
	
	public Wêze³ ZnajdzWezel(int x) {
		Wêze³ znaleziony = ZnajdzWezel(this, x);
		
		if(znaleziony == null)
			throw new NoSuchElementException("Wartoœæ "+x+" nie istnieje ani tym drzewie ani w jego braciach");
		
		return znaleziony;
	}
	
	private Wêze³ ZnajdzWezel(Wêze³ w, int x) {
		Wêze³ znaleziony = null;
		
		if(w.getKlucz()==x) {
			znaleziony = w;
		}
		if((w.getLeweDziecko()!=null && znaleziony == null)&&w.getKlucz()<x) {
			znaleziony = ZnajdzWezel(w.getLeweDziecko(),x);
		}
		if(w.getPrawyBrat()!=null && znaleziony == null) {
			znaleziony = ZnajdzWezel(w.getPrawyBrat(), x);
		}
		
		return znaleziony;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.getKlucz();
	}
	
	
	
	
}