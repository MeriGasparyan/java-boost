package com.merigasparyan.jmp.task2;

import junit.framework.TestCase;

public class StringComparatorTest extends TestCase {
    private final StringComparator comparator = new StringComparator();

    public void testCompare_ValidStrings_ReturnsComparisonBasedOnSecondChar() {

        String str1 = "Apple";
        String str2 = "Banana";
        String str3 = "Cherry";

        assertTrue("a < p should return negative", comparator.compare(str1, str2) < 0);
        assertTrue("h > a should return positive", comparator.compare(str2, str3) > 0);
        assertTrue("h < p should return negative", comparator.compare(str1, str3) < 0);
        assertEquals("Both have 'e' as second char", 0, comparator.compare("Hello", "Jelly"));
    }

    public void testCompare_IdenticalSecondCharacter_ReturnsZero() {
        assertEquals(0, comparator.compare("Hello", "Nelly"));
        assertEquals(0, comparator.compare("Test", "Best"));
    }

    public void testCompare_NullFirstString_ThrowsException() {
        try {
            comparator.compare(null, "something");
            fail("Should have thrown NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Cannot compare null strings", e.getMessage());
        }
    }

    public void testCompare_NullSecondString_ThrowsException() {
        try {
            comparator.compare("something", null);
            fail("Should have thrown NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Cannot compare null strings", e.getMessage());
        }
    }


}