package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks(){
        //Given
        LocalDate localDate1 = LocalDate.of(1970, 11, 20);
        LocalDate localDate2 = LocalDate.of(1990, 10, 15);
        LocalDate localDate3 = LocalDate.of(2000, 06, 11);

        Book book1 = new Book("Zrob to sam", "Adam Slodowy",localDate1 );
        Library library = new Library("Zestaw ksiazek");
        library.getBooks().add(book1);
        Book book2 = new Book("Nie rob tego w domu", "Bartosz Goszki",localDate2 );
        library.getBooks().add(book2);
        Book book3 = new Book("W ogole tego nie rob", "Cezary Burak",localDate3 );
        library.getBooks().add(book3);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Zestaw ksiazek numer 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Zestaw ksiazek numer 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        clonedLibrary.getBooks().remove(book1);
        deepClonedLibrary.getBooks().add(new Book("Ksiazka dodana", "Dariusz Plus", LocalDate.of(2010, 05, 03) ));
        //Then
        System.out.println(library);
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(4, deepClonedLibrary.getBooks().size());
    }
}
