package kopiec;

import java.util.NoSuchElementException;

public class W�ze� {
	private int wysoko��;
	private W�ze� leweDziecko;
	private W�ze� prawyBrat;
	private W�ze� rodzic;
	private int klucz;
	
	public W�ze�(int klucz) {
		if(klucz == Integer.MIN_VALUE)
			throw new IllegalArgumentException();
		this.wysoko�� = 0;
		this.rodzic = null;
		this.prawyBrat = null;
		this.leweDziecko = null;
		
		this.klucz = klucz;
	}
	
	public W�ze� Merge(W�ze� x) {
		if(x.getWysoko��()!=this.getWysoko��())
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
	
	private void MergeHelp(W�ze� x, W�ze� y) {
		x.setRodzic(y);
		x.setPrawyBrat(y.getLeweDziecko());
		y.setLeweDziecko(x);
	}

	
	private void ZwiekszWysokosc() {
		this.wysoko��++;
	}
	
	public int getWysoko��() {
		return wysoko��;
	}

	public void setWysoko��(int wysoko��) {
		this.wysoko�� = wysoko��;
	}

	public W�ze� getLeweDziecko() {
		return leweDziecko;
	}

	public void setLeweDziecko(W�ze� leweDziecko) {
		this.leweDziecko = leweDziecko;
	}

	public W�ze� getPrawyBrat() {
		return prawyBrat;
	}

	public void setPrawyBrat(W�ze� prawyBrat) {
		this.prawyBrat = prawyBrat;
	}

	public W�ze� getRodzic() {
		return rodzic;
	}

	public void setRodzic(W�ze� rodzic) {
		this.rodzic = rodzic;
	}

	public int getKlucz() {
		return klucz;
	}

	public void setKlucz(int klucz) {
		this.klucz = klucz;
	}
	
	public W�ze� ZnajdzWezel(int x) {
		W�ze� znaleziony = ZnajdzWezel(this, x);
		
		if(znaleziony == null)
			throw new NoSuchElementException("Warto�� "+x+" nie istnieje ani tym drzewie ani w jego braciach");
		
		return znaleziony;
	}
	
	private W�ze� ZnajdzWezel(W�ze� w, int x) {
		W�ze� znaleziony = null;
		
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