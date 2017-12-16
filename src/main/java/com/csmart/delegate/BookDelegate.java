package com.csmart.delegate;

import java.util.HashMap;

/**
 * @author Shubhank Mittal (Shubhank.mittal@cdk.com)
 * @since 1.0 12/16/17.
 */
public class BookDelegate {

    HashMap<String, Integer> books = new HashMap<>();

    public BookDelegate() {
        books.put("A55767", 10);
        books.put("34234B", 10);
        books.put("342342B", 10);
        books.put("N55767", 10);
        books.put("342V34B", 10);
        books.put("942342B", 10);
    }

    public boolean isAvailable(String isbn) {
        if (books.get(isbn) != null) {
            return true;
        }
        return false;
    }
// Assuming book will not be issued to other
    public void updateBookAvailability(String isbn){
        int value=books.get(isbn).intValue();
        books.put(isbn,value--);
    }
}
