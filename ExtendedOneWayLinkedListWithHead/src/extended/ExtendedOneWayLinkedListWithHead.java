package extended;

import lecture.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.lang.IndexOutOfBoundsException;
import java.util.function.*;
import java.util.ConcurrentModificationException;
import java.util.ArrayList;


public class ExtendedOneWayLinkedListWithHead<E> extends AbstractList<E> implements Iterable<E> {
	
	private OneWayLinkedListWithHead<E> innerList;
	
	public ExtendedOneWayLinkedListWithHead(){
		innerList = new OneWayLinkedListWithHead<E>();
	}
	
	@Override
	public ListIterator<E> listIterator(){
		
		ListIterator<E> returned =
		
		new ListIterator<E>() {
			
			int cursor = -1;
			Boolean hasNext = !(innerList.isEmpty());
			Boolean hasPrevious = false;
			boolean canBeRemovedOrSet = false;
			
			boolean wasNextUsed;
			
			@Override
			public boolean hasNext() {
				return hasNext;
			}
			
			@Override
			public boolean hasPrevious() {
				return hasPrevious;
			}
			
			@Override
			public E next() throws NoSuchElementException {
				
				if(!hasNext)
					throw new NoSuchElementException();
				
				hasPrevious = true;
				E returned = innerList.get(++cursor);
				canBeRemovedOrSet = true;
				wasNextUsed = true;
				
				try {
					innerList.get(cursor+1);
					hasNext = true;
				}
				catch(IndexOutOfBoundsException e) {
					hasNext = false;
				}
				
				return returned;
				
			}
			
			@Override
			public E previous() throws NoSuchElementException {

				if(!hasPrevious)
					throw new NoSuchElementException();
				
				hasNext = true;
				E returned = innerList.get(cursor);
				--cursor;
				canBeRemovedOrSet = true;
				wasNextUsed = false;
				try {
					innerList.get(cursor);
					hasPrevious = true;
				}
				catch(IndexOutOfBoundsException e) {
					hasPrevious = false;
				}
				
				return returned;
			}
			
			@Override
			public int previousIndex() {
				return cursor;
			}
			
			@Override
			public int nextIndex() {
				return cursor+1;
			}
			
			@Override
			public void set(E e) throws IllegalStateException {

				if(!canBeRemovedOrSet)
					throw new IllegalStateException();
				else if(wasNextUsed) {
					innerList.set(cursor, e);
				}
				else
					innerList.set(cursor+1, e);
				canBeRemovedOrSet = false;
			}
			
			@Override
			public void remove() throws IllegalStateException {

				if(!canBeRemovedOrSet)
					throw new IllegalStateException();
				else if(wasNextUsed) {
					innerList.remove(cursor);
					cursor--;
				}
				else {
					innerList.remove(cursor+1);
					
				}
				
				canBeRemovedOrSet = false;
			}
			
			@Override
			public void add(E e) {
				innerList.add(++cursor, e);
			}
			
			@Override
			public void forEachRemaining(Consumer<? super E> action) {
				 throw new UnsupportedOperationException(); 
			}
			
			
		};
		
		return returned;
	}
	
	@Override
	public boolean add(int index, E data) {
		return innerList.add(index, data);
	}
	
	@Override
	public boolean add(E value) {
		return innerList.add(value);
	}
	
	@Override
	public int indexOf(E data) {
		return innerList.indexOf(data);
	}
	
	@Override
	public boolean contains(E data) {
		return innerList.contains(data);
	}
	
	@Override
	public E get(int index) {
		return innerList.get(index);
	}
	
	@Override
	public E set(int index, E data) {
		return innerList.set(index, data);
	}
	
	@Override
	public E remove(int index) {
		return innerList.remove(index);
	}
	
	@Override
	public boolean remove(E value) {
		return innerList.remove(value);
	}
	
	@Override
	public Iterator<E> iterator() {
		return innerList.iterator();
	}
	
	@Override
	public int size() {
		return innerList.size();
	}
	
	@Override
	public void clear() {
		innerList.clear();
	}
	
	@Override
	public boolean isEmpty() {
		return innerList.isEmpty();
	}
	
	
}
