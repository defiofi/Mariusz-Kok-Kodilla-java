package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("David Weber", "Kwestia honoru",2006,"17625" );
        Book book2 = new Book("David Weber", "Honor na wygnaniu",2009,"19635" );
        Book book3 = new Book("David Weber", "W rękach wroga",2010,"11417" );
        Book book4 = new Book("David Weber", "Misja Honor",2012,"26938" );
        Book book5 = new Book("David Weber", "Cień wolności",2014,"35273" );
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals( 2010, publicationYearMedian,  0);
    }
}
