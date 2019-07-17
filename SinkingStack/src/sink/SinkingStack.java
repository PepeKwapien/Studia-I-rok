package sink;

import lecture.EmptyStackException;
import lecture.IStack;

public class SinkingStack<T> implements IStack<T> {
	
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int cursor;
	
	@SuppressWarnings("unchecked")
	public SinkingStack(int capacity){
		array = (T[])(new Object[capacity+1]);
		cursor = 0;
	}
	
	public SinkingStack() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cursor==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return cursor == array.length -1;
	}

	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return array[--cursor];
		}
		
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		if(isFull()) {
			array[cursor] = t;
			sink();
		}
		else {
			array[cursor++] = t;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return cursor;
	}

	@Override
	public T top() throws EmptyStackException {
		// TODO Auto-generated method stub

		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return array[cursor-1];
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
	
	
}
