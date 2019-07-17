package sink;

import lecture.EmptyStackException;
import lecture.IStack;

import java.lang.IndexOutOfBoundsException;

public class SinkingStack<T> implements IStack<T> {
	
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int index;
	
	@SuppressWarnings("unchecked")
	public SinkingStack(int capacity){
		array = (T[])(new Object[capacity+1]);
		index = 0;
	}
	
	public SinkingStack() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return index==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return index == array.length -1;
	}

	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return array[--index];
		}
		
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		if(isFull()) {
			array[index] = t;
			sink();
		}
		else {
			array[index++] = t;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public T top() throws EmptyStackException {
		// TODO Auto-generated method stub

		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return array[index-1];
		}
		
	}

	@SuppressWarnings("unchecked")
	private void sink() {
		T[] help = (T[])(new Object[array.length]);
		
		for(int i = 0; i<(array.length-1);i++) {
			help[i] = array[i+1];
		}
		
		array = help;
		
	}
	
	//-------------------------------------------------------------------
	
	protected T getElement(int cursor) throws IndexOutOfBoundsException {
		
		if(cursor<0 || cursor>=index) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return array[cursor];
		}
	}
	
	protected int return_default_size() {
		return DEFAULT_CAPACITY;
	}
	
}
