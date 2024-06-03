package pro.sky.Homework_2.__algorithms_1.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringList stringListTest;
    private static final String ZERO = "zero";
    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final String FOUR = "four";
    private static final String FIVE = "five";
    @BeforeEach
    void setUp() {
        stringListTest = new StringListImpl(10);
        stringListTest.add(ZERO);
        stringListTest.add(ONE);
        stringListTest.add(TWO);
        stringListTest.add(THREE);
        stringListTest.add(FOUR);
    }

    @Test
    void testAdd() {
        int size = stringListTest.size();
        String expected = stringListTest.add(FIVE);
        String actual = stringListTest.get(size);
        assertEquals(expected, actual);
    }

    @Test
    void testAddIndex() {
        String actualPrev = stringListTest.get(1);
        String expected = stringListTest.add(1, ONE);
        String actual = stringListTest.get(1);
        assertEquals(expected, actual);
        assertEquals(stringListTest.get(2), actualPrev);
    }
    @Test
    void testSet() {
        String actualPrev = stringListTest.get(2);
        String expected = stringListTest.set(1, ONE);
        String actual = stringListTest.get(1);
        assertEquals(expected, actual);
        assertEquals(stringListTest.get(2), actualPrev);
    }

    @Test
    void removeByString() {
        int size = stringListTest.size();
        String actual = stringListTest.get(size - 1);
        String expected = stringListTest.remove(actual);
        assertEquals(actual, expected);
        assertEquals(stringListTest.size(), size - 1);
    }

    @Test
    void removeByIndex() {
        int size = stringListTest.size();
        String actual = stringListTest.get(size - 1);
        String expected = stringListTest.remove(size - 1);
        assertEquals(actual, expected);
        assertEquals(stringListTest.size(), size - 1);
    }

    @Test
    void containsTrue() {
        for (int i = 0; i < stringListTest.size(); i++) {
            assertTrue(stringListTest.contains(stringListTest.get(i)));
        }
    }

    @Test
    void indexOf() {
        for (int i = 0; i < stringListTest.size(); i++) {
            assertEquals(i, stringListTest.indexOf(stringListTest.get(i)));
        }
        assertEquals(-1, stringListTest.indexOf(FIVE));
    }

    @Test
    void lastIndexOf() {
        StringListImpl stringList = new StringListImpl(5);
        String onlyThis = "only this";
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        assertEquals(stringList.size()-1, stringList.lastIndexOf(onlyThis));
        assertEquals(-1, stringList.lastIndexOf("not only this"));
    }

    @Test
    void get() {
        String expected = stringListTest.add(FIVE);
        String actual = stringListTest.get(stringListTest.size()-1);
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        StringListImpl stringList = new StringListImpl(10);
        stringList.add(ZERO);
        stringList.add(ONE);
        stringList.add(TWO);
        stringList.add(THREE);
        stringList.add(FOUR);
        assertTrue(stringListTest.equals(stringList));
        stringList.add(FIVE);
        assertFalse(stringListTest.equals(stringList));
    }

    @Test
    void size() {
        StringListImpl stringList = new StringListImpl(10);
        assertEquals(0, stringList.size());
        stringList.add(ONE);
        assertEquals(1, stringList.size());
        stringList.add(TWO);
        assertEquals(2, stringList.size());
    }

    @Test
    void isEmpty() {
        StringListImpl stringList = new StringListImpl(10);
        assertTrue(stringList.isEmpty());
        stringList.add(ONE);
        assertFalse(stringList.isEmpty());
        stringList.remove(ONE);
        assertTrue(stringList.isEmpty());
    }

    @Test
    void clear() {
        assertFalse(stringListTest.isEmpty());
        stringListTest.clear();
        assertTrue(stringListTest.isEmpty());
    }

    @Test
    void toArray() {
        StringListImpl stringList = new StringListImpl(3);
        String [] actual = {ONE, TWO, THREE};
        for (String s : actual) {
            stringList.add(s);
        }
        String [] expected = stringList.toArray();
        assertArrayEquals(expected, actual);
    }
}