package lecture;

public interface IStack<T> {

	boolean isEmpty();
	boolean isFull();
	T pop() throws EmptyStackException;
	void push(T t) throws FullStackException;
	int size();
	T top() throws EmptyStackException;
	
}
