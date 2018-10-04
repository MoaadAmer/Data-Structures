package datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by MoaadA on 9/3/2018.
 */
public class StackAsArray<T> {

    private final static int INITIAL_SIZE = 2;
    private T[] data;
    private int count = -1;

    public StackAsArray() {
        data = (T[]) new Object[INITIAL_SIZE];
    }

    public void push(T value) {
        if (data.length == count + 1)
            expandArray();
        count++;
        data[count] = value;

    }

    private void expandArray() {
        data = Arrays.copyOf(data, data.length * INITIAL_SIZE);
    }

    public T pop() {
        T value = peek();
        if (value != null) {
            data[count] = null;
            count--;
        }
        return value;

    }

    public T peek() {
        if (count != -1)
            return data[count];
        throw new EmptyStackException();
    }


    public void clear() {
        count = -1;
    }

    public int getSize() {
        return count + 1;
    }
}
