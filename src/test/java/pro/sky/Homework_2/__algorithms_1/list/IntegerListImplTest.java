package pro.sky.Homework_2.__algorithms_1.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerList integerList;
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    @BeforeEach
    void setUp() {
        integerList = new IntegerListImpl(10);
        integerList.add(ZERO);
        integerList.add(ONE);
        integerList.add(TWO);
        integerList.add(THREE);
        integerList.add(FOUR);
    }

    @Test
    void add() {
        int size = integerList.size();
        Integer expected = integerList.add(FIVE);
        Integer actual = integerList.get(size);
        assertEquals(expected, actual);
    }

    @Test
    void testAddIndex() {
        Integer actualPrev = integerList.get(1);
        Integer expected = integerList.add(1, ONE);
        Integer actual = integerList.get(1);
        assertEquals(expected, actual);
        assertEquals(integerList.get(2), actualPrev);
    }

    @Test
    void set() {
        Integer actualPrev = integerList.get(2);
        Integer expected = integerList.set(1, ONE);
        Integer actual = integerList.get(1);
        assertEquals(expected, actual);
        assertEquals(integerList.get(2), actualPrev);
    }

    @Test
    void removeByString() {
        int size = integerList.size();
        Integer actual = integerList.get(size - 1);
        Integer expected = integerList.remove(actual);
        assertEquals(actual, expected);
        assertEquals(integerList.size(), size - 1);
    }

    @Test
    void removeByIndex() {
        int size = integerList.size();
        Integer actual = integerList.get(size - 1);
        Integer expected = integerList.remove(size - 1);
        assertEquals(actual, expected);
        assertEquals(integerList.size(), size - 1);
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
        for (int i = 0; i < integerList.size(); i++) {
            assertEquals(i, integerList.indexOf(integerList.get(i)));
        }
        assertEquals(-1, integerList.indexOf(FIVE));
    }

    @Test
    void lastIndexOf() {
        IntegerListImpl list = new IntegerListImpl(5);
        Integer onlyThis = 99;
        list.add(onlyThis);
        list.add(onlyThis);
        list.add(onlyThis);
        list.add(onlyThis);
        list.add(onlyThis);
        assertEquals(list.size()-1, list.lastIndexOf(onlyThis));
        assertEquals(-1, list.lastIndexOf(9));
    }

    @Test
    void get() {
        Integer expected = integerList.add(FIVE);
        Integer actual = integerList.get(integerList.size()-1);
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        IntegerListImpl list = new IntegerListImpl(10);
        list.add(ZERO);
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
        list.add(FOUR);
        assertTrue(integerList.equals(list));
        list.add(FIVE);
        assertFalse(integerList.equals(list));
    }

    @Test
    void size() {
        IntegerListImpl list = new IntegerListImpl(10);
        assertEquals(0, list.size());
        list.add(ONE);
        assertEquals(1, list.size());
        list.add(TWO);
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty() {
        IntegerListImpl list = new IntegerListImpl(10);
        assertTrue(list.isEmpty());
        list.add(ONE);
        assertFalse(list.isEmpty());
        list.remove(ONE);
        assertTrue(list.isEmpty());
    }

    @Test
    void clear() {
        assertFalse(integerList.isEmpty());
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    void toArray() {
        IntegerListImpl list = new IntegerListImpl(3);
        Integer [] actual = {ONE, TWO, THREE};
        for (Integer s : actual) {
            list.add(s);
        }
        Integer [] expected = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void sort() {
        Integer[] expected = {ZERO, ONE, TWO, THREE, FOUR};
        assertArrayEquals(expected, integerList.sort());
        assertArrayEquals(expected, integerList.quickSort());
    }

    @Test
    void containsFalse() {
        assertFalse(integerList.contains(FIVE));
    }
}