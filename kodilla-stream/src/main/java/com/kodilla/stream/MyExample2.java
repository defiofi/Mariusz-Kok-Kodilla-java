package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.person.People;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyExample2 {
    public static void main(String[] args) {
        People.getList().stream()
                .map(s -> s.toUpperCase())      // Transformowanie
              //.map(String::toUpperCase) - drugi sposób
                .filter(s -> s.length() > 11)       //Filtrowanie
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")     //Transformowanie
                .filter(s -> s.substring(0, 1).equals("M"))         //Filtrowanie
                .forEach(System.out::println);  // pierwszy sposób zakończenia
              //.forEach(s -> System.out.println(s)); - drugi sposób zakończenia

            BookDirectory theBookDirectory = new BookDirectory();
            theBookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .forEach(System.out::println);
        System.out.println();

        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());      // Kolektor wstawia do theResultListOfBooks rezultat stream
        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
        System.out.println();
        Map<String, Book> theResultMapOfBooks1 = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks1.size());
        theResultMapOfBooks1.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println();
        String theResultStringOfBooks2 = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks2);
    }
}
