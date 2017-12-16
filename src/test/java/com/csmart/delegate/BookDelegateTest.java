package com.csmart.delegate;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public class BookDelegateTest {

    private BookDelegate bookDelegate;

    @Test
    public void testIsAvailable() throws Exception {
        assertFalse(bookDelegate.isAvailable("34342343324"));
        assertTrue(bookDelegate.isAvailable("942342B"));
    }
}