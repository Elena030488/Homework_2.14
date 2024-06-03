package pro.sky.Homework_2.__algorithms_1.list;

import pro.sky.Homework_2.__algorithms_1.exception.ElementNotFoundException;
import pro.sky.Homework_2.__algorithms_1.exception.IncorrectDataException;
import pro.sky.Homework_2.__algorithms_1.exception.IndexOutOfBoundsException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] data;
    private int size;
    private int currentLength;
    private static final int DEFAULT_SIZE = 10;

    public IntegerListImpl() {
        data = new Integer[DEFAULT_SIZE];
        size = 0;
        this.currentLength = DEFAULT_SIZE;
    }

    public IntegerListImpl(int startLength) {
        data = new Integer[startLength];
        size = 0;
        this.currentLength = startLength;
    }
    private void grow() {
        if (size == currentLength) {
            currentLength = currentLength + currentLength / 2;
            data = Arrays.copyOf(data, currentLength);
        }
    }
    @Override
    public Integer add(Integer item) {
        grow();
        data[size] = item;
        size++;
        return data[size - 1];
    }

    private void checkIndex(int index) {
        if ((index < 0) || (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index" + index + "out of bound exception");
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);
        grow();
        for (int i = size; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        size++;
        data[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                Integer s = data[i];
                for (int j = i; j < size; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                return s;
            }
        }
        throw new ElementNotFoundException("Item" + item + "not found");
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer s = data[index];
        for (int j = index; j < size; j++) {
            data[j] = data[j + 1];
        }
        size--;
        return s;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IncorrectDataException("Incorrect input data");
        }
        if (this == otherList)
            return true;
        return size == otherList.size() && Arrays.equals(toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new Integer[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
    @Override
    public Integer[] sort() {
        Integer[] arr = toArray();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
    @Override
    public boolean contains(Integer element) {
        Integer[] dataSort = sort();
        int min = 0;
        int max = dataSort.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(element, dataSort[mid])) {
                return true;
            }
            if (element < dataSort[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
