package vts;

import lecture.EmptyStackException;
import sink.SinkingStack;

public class VTS<T> extends SinkingStack<T> {

	private int size;
	private int cursor;
	private int capacity;
	
	public VTS(int capacity) {
		super(capacity);
		cursor = -1;
		size = 0;
		this.capacity = capacity;
	}
	
	public VTS(){
		super();
		cursor = -1;
		size = 0;
		capacity = super.return_default_size();
	}
	
	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		
		if(size == 0) {
			throw new EmptyStackException();
		}
		else {
			--size;
			cursor = size - 1;
		}
		return super.pop();
	}
	
	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		
		if(size != capacity) {
			++size;
			cursor = size - 1;
		}
		else {
			cursor = size - 1;
		}
		
		super.push(t);
	}
	
	public T peek() {
		return super.getElement(cursor);
	}
	
	public void cursorDown() throws VTSException, EmptyStackException {
		if(cursor == 0) {
			throw new VTSException();
		}
		else if(cursor == -1) {
			throw new EmptyStackException();
		}
		else {
			--cursor;
		}
	}
	
	public void cursorToTop() {
		cursor = size - 1;
	}
	
}
