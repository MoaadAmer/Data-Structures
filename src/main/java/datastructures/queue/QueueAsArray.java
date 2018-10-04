package datastructures.queue;

public class QueueAsArray<T> {
    private final static int INITIAL_SIZE = 2;
    private T[] data;
    private int head;
    private int tail = -1;
    private int elementsNumber;


    public QueueAsArray() {
        data = (T[]) new Object[INITIAL_SIZE];
    }


    public int getSize() {
        return elementsNumber;
    }

    public void add(T value) {
        if (elementsNumber == data.length)
            grow();
        if (tail + 1 == data.length) {
            tail = -1;
        }
        data[++tail] = value;
        elementsNumber++;
    }

    private void grow() {

        T[] temp = (T[]) new Object[data.length * INITIAL_SIZE];

        int i = 0;
        for (int j = head; j < data.length; j++, i++)
            temp[i] = data[j];
        //tail is not in the end of the array
        if (tail < head) {
            for (int j = 0; j < head; j++, i++) {
                temp[i] = data[j];
            }

        }

        data = temp;
        head = 0;
        tail = i - 1;
    }

    public T poll() {
        T value = peek();
        head++;
        if (head == data.length)
            head = 0;
        elementsNumber--;
        return value;
    }


    public T peek() {
        if (elementsNumber == 0)
            throw new QueueEmptyException();
        return data[head];
    }

    public void clear() {
        head = elementsNumber = 0;
        tail = -1;

    }
}
