package listInGeneral;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.lang.IndexOutOfBoundsException;

public class MyOwnList<T> implements Iterable<T> {

	/*-*********************************************************///Fields
	
	private final static int DEFAULT_CAPACITY = 2;
	private Object tab[] = {};
	private int amountOfElements = 0;
	
	/*-*********************************************************///Constructor
	
	public MyOwnList(){
		tab = new Object[DEFAULT_CAPACITY];
	}
	
	/*-*********************************************************///Anonymous Iterator
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private int currentIndex = -1;
			private boolean enableRemove = false;
			
			
			@Override
			public boolean hasNext() {
			
				if((1+currentIndex)<amountOfElements) {
					return true;
				}
				return false;
			}
			
			@Override
			public T next() throws NoSuchElementException {
				
				if((++currentIndex)<amountOfElements) {
					
					enableRemove = true;
					
					@SuppressWarnings("unchecked")
					T returned = (T)tab[currentIndex];
					
					return returned;
				}
				else
					throw new NoSuchElementException();
			}
			
			
			@Override
			public void remove() throws IllegalStateException {
				
				if(enableRemove) {
					excludeElement(currentIndex);
					--currentIndex;
					--amountOfElements;
					
					enableRemove = false;
				}
				else
					throw new IllegalStateException();
			}
			
		};
	}
	
	/*-*********************************************************///Helpful private methods
	
	private void increaseCapacity() {
		Object[] help = new Object[2*tab.length];
		for(int i = 0; i<tab.length;i++) {
			help[i] = tab[i];
		}
		tab = help;
	}
	
	private void excludeElement(int cI) {
		Object help[] = new Object[tab.length];
		int i;
		for(i = 0; i<cI; i++) {
			help[i] = tab[i];
		}
		int anotherhelp = amountOfElements-1;
		for(int j = ++cI; i<(anotherhelp); j++, i++) {
			help[i] = tab[j];
		}
		tab = help;
	}
	
	private void includeElement(int cI, Object o) {
		Object help[] = new Object[tab.length];
		int i;
		for(i = 0; i<cI; i++) {
			help[i] = tab[i];
		}
		help[i] = o;
		++i;
		for(int j = cI; j<amountOfElements; j++, i++) {
			help[i] = tab[j];
		}
		
		tab = help;
	}
	
	/*-*********************************************************///Standard list methods
	
	public boolean add(T t) {
		
		
		if(amountOfElements == tab.length) {
			increaseCapacity();
		}
		tab[amountOfElements] = t;
		amountOfElements++;
		
		return true;
	}
	
	public void add(int index, T t) throws IndexOutOfBoundsException {
		
		if(index<0 || index> amountOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		if(amountOfElements == tab.length) {
			increaseCapacity();
		}
		includeElement(index, t);
		amountOfElements++;
	}
	
	public boolean contains(T t) {
		Iterator<T> itt = this.iterator();
		
		if(t == null) {
			while(itt.hasNext()) {
				if(itt.next()==null) {
					return true;
				}
			}
		}
		else {
			while(itt.hasNext()) {
				
				T help = itt.next();
				
				if(help == null) {
					continue;
				}
				else {
					if(help.equals(t)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		
		if(index<0 || index>=amountOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		@SuppressWarnings("unchecked")
		T returned = (T)tab[index];
		
		return returned;
		
	}
	
	public int indexOf(T t) {
	
		Iterator<T> itt = this.iterator();
		int i = -1;
		
		if(t == null) {
			while(itt.hasNext()) {
				i++;
				if(itt.next()==null) {
					return i;
				}
			}
		}
		
		else {
			while(itt.hasNext()) {
				
				i++;
				T help = itt.next();
				
				if(help == null) {
					continue;
				}
				else {
					if(help.equals(t)) {
						return i;
					}
				}
			}
		}
		
		return -1;
		
	}
	
	public T set(int index, T t) throws IndexOutOfBoundsException {
		
		if(index<0 || index>=amountOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		@SuppressWarnings("unchecked")
		T previous = (T)tab[index];
		
		tab[index] = t;
		
		return previous;
	}
	
	public T remove(int index) throws IndexOutOfBoundsException {
		
		if(index<0 || index>=amountOfElements) {
			throw new IndexOutOfBoundsException();
		}
		
		Iterator<T> itt = this.iterator();
		
		T help = null;
		
		for(int i = 0; i<=index; i++) {
			help = itt.next();
		}
		
		itt.remove();
		
		return help;
		
	}
	
	public void clear() {
		tab = new Object[DEFAULT_CAPACITY];
		amountOfElements = 0;
	}
	
	public int size() {
		return amountOfElements;
	}
	

}
