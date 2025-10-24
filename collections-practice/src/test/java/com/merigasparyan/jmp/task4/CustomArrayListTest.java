package com.merigasparyan.jmp.task4;


import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomArrayListTest extends TestCase {

    private CustomArrayList<String> list;
    private CustomArrayList<Integer> intList;

    @BeforeEach
    public void setUp() {
        list = new CustomArrayList<>();
        intList = new CustomArrayList<>();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    public void testCustomCapacityConstructor() {
        CustomArrayList<String> customList = new CustomArrayList<>(10);
        assertEquals(0, customList.size());
        assertTrue(customList.isEmpty());
    }

    public void testInvalidCapacityConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new CustomArrayList<>(-1));
    }

    public void testAddAndSize() {
        assertTrue(list.add("A"));
        assertEquals(1, list.size());

        assertTrue(list.add("B"));
        assertEquals(2, list.size());

        assertFalse(list.isEmpty());
    }

    public void testAddWithIndex() {
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B"); // Insert at position 1

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    public void testAddWithIndexAtEnd() {
        list.add("A");
        list.add(1, "B"); // Add at the end

        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    public void testAddWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "A"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "A"));
    }

    public void testGet() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    public void testGetInvalidIndex() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    public void testSet() {
        list.add("A");
        list.add("B");

        assertEquals("A", list.set(0, "X"));
        assertEquals("X", list.get(0));
        assertEquals("B", list.set(1, "Y"));
        assertEquals("Y", list.get(1));
    }

    public void testSetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "A"));
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "B"));
    }

    public void testRemoveByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));

        assertEquals("A", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("C", list.get(0));
    }

    public void testRemoveByObject() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
        assertFalse(list.contains("B"));

        assertFalse(list.remove("X")); // Non-existent element
        assertEquals(2, list.size());
    }

    public void testRemoveInvalidIndex() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    public void testContains() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains("A"));
        assertTrue(list.contains("B"));
        assertTrue(list.contains("C"));
        assertFalse(list.contains("X"));
        assertFalse(list.contains(null));
    }

    public void testContainsWithNull() {
        list.add("A");
        list.add(null);
        list.add("C");

        assertTrue(list.contains(null));
    }

    public void testContainsAll() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertTrue(list.containsAll(Arrays.asList("A", "C")));
        assertTrue(list.containsAll(Arrays.asList("B", "D")));
        assertFalse(list.containsAll(Arrays.asList("A", "X")));
        assertTrue(list.containsAll(Collections.emptyList()));
    }

    public void testAddAll() {
        List<String> toAdd = Arrays.asList("A", "B", "C");
        assertTrue(list.addAll(toAdd));

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    public void testAddAllWithIndex() {
        list.add("X");
        list.add("Z");

        List<String> toAdd = Arrays.asList("A", "B");
        assertTrue(list.addAll(1, toAdd));

        assertEquals(4, list.size());
        assertEquals("X", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
        assertEquals("Z", list.get(3));
    }

    public void testRemoveAll() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertTrue(list.removeAll(Arrays.asList("B", "D")));
        assertEquals(2, list.size());
        assertTrue(list.contains("A"));
        assertTrue(list.contains("C"));
        assertFalse(list.contains("B"));
        assertFalse(list.contains("D"));

        assertFalse(list.removeAll(Arrays.asList("X", "Y"))); // No elements removed
    }

    public void testRetainAll() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        assertTrue(list.retainAll(Arrays.asList("B", "D")));
        assertEquals(2, list.size());
        assertTrue(list.contains("B"));
        assertTrue(list.contains("D"));
        assertFalse(list.contains("A"));
        assertFalse(list.contains("C"));
    }

    public void testClear() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Should be able to add after clear
        list.add("X");
        assertEquals(1, list.size());
    }

    public void testIterator() {
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    public void testIteratorRemove() {
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        iterator.next(); // Move to "A"
        iterator.remove(); // Remove "A"

        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
    }

    public void testListIterator() {
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> listIterator = list.listIterator();
        assertTrue(listIterator.hasNext());
        assertFalse(listIterator.hasPrevious());

        assertEquals("A", listIterator.next());
        assertTrue(listIterator.hasPrevious());

        assertEquals("B", listIterator.next());
        assertEquals("C", listIterator.next());
        assertFalse(listIterator.hasNext());
    }

    public void testIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A"); // Duplicate
        list.add("C");

        assertEquals(0, list.indexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(3, list.indexOf("C"));
        assertEquals(-1, list.indexOf("X"));
    }

    public void testLastIndexOf() {
        list.add("A");
        list.add("B");
        list.add("A"); // Duplicate
        list.add("C");

        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(1, list.lastIndexOf("B"));
        assertEquals(3, list.lastIndexOf("C"));
        assertEquals(-1, list.lastIndexOf("X"));
    }

    public void testSubList() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        List<String> subList = list.subList(1, 4);
        assertEquals(3, subList.size());
        assertEquals("B", subList.get(0));
        assertEquals("C", subList.get(1));
        assertEquals("D", subList.get(2));

        subList.set(1, "X");
        assertEquals("X", list.get(2));
    }

    public void testSubListInvalidRange() {
        list.add("A");
        list.add("B");

        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(1, 3));
        assertThrows(IllegalArgumentException.class, () -> list.subList(2, 1));
    }

    public void testToArray() {
        list.add("A");
        list.add("B");
        list.add("C");

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    public void testToArrayWithType() {
        list.add("A");
        list.add("B");
        list.add("C");

        String[] array = list.toArray(new String[0]);
        assertEquals(3, array.length);
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    public void testDynamicResizing() {
        CustomArrayList<Integer> smallList = new CustomArrayList<>(2);

        for (int i = 0; i < 10; i++) {
            smallList.add(i);
        }

        assertEquals(10, smallList.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), smallList.get(i));
        }
    }

    public void testCollectionsSort() {
        list.add("Z");
        list.add("A");
        list.add("M");
        list.add("B");

        Collections.sort(list);
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("M", list.get(2));
        assertEquals("Z", list.get(3));
    }

    public void testCollectionsReverse() {
        list.add("A");
        list.add("B");
        list.add("C");

        Collections.reverse(list);
        assertEquals("C", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("A", list.get(2));
    }

    public void testCollectionsBinarySearch() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        Collections.sort(list); // Ensure sorted
        int index = Collections.binarySearch(list, "C");
        assertEquals(2, index);

        index = Collections.binarySearch(list, "X");
        assertTrue(index < 0); // Not found
    }

    public void testStreamOperations() {
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);


        List<Integer> squared = intList.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 4, 9, 16, 25), squared);

        List<Integer> evens = intList.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(2, 4), evens);


        int sum = intList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(15, sum);
    }

    public void testNullElements() {
        list.add("A");
        list.add(null);
        list.add("C");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertNull(list.get(1));
        assertEquals("C", list.get(2));

        assertTrue(list.contains(null));
        assertEquals(1, list.indexOf(null));
    }

    public void testEqualsAndHashCode() {
        list.add("A");
        list.add("B");
        list.add("C");

        CustomArrayList<String> otherList = new CustomArrayList<>();
        otherList.add("A");
        otherList.add("B");
        otherList.add("C");

        assertEquals(list, otherList);
        assertEquals(list.hashCode(), otherList.hashCode());

        otherList.set(1, "X");
        assertNotEquals(list, otherList);
    }

    public void testToString() {
        list.add("A");
        list.add("B");
        list.add("C");

        String str = list.toString();
        assertTrue(str.contains("A"));
        assertTrue(str.contains("B"));
        assertTrue(str.contains("C"));
    }

    public void testRandomAccessPerformance() {

        for (int i = 0; i < 1000; i++) {
            intList.add(i);
        }

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            intList.get(i);
        }
        long endTime = System.nanoTime();


        long duration = endTime - startTime;
        assertTrue(duration < 100_000_000);
    }
}