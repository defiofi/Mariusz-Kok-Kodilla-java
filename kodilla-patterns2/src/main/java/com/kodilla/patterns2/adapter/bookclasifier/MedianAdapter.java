package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    public int publicationYearMedian(Set<Book> bookSet){
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> libraryMap= new HashMap<>();
        List<Book> oldBooks = bookSet.stream().collect(Collectors.toList());
        for(int i = 0; i<bookSet.size(); i++) {
            com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book newBook =
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.
                            Book(oldBooks.get(i).getAuthor(), oldBooks.get(i).getTitle(), oldBooks.get(i).getPublicationYear());
            BookSignature bookSignature = new BookSignature(oldBooks.get(i).getSignature());
            libraryMap.put(bookSignature, newBook);
        }
        return medianPublicationYear(libraryMap);
    }
}
