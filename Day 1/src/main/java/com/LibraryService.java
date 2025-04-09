package com;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    // هو هنا لسه في مشكلة بتاعة ال dependancy invertion بس انا مش عارف هحلها ازاي يعني المفروض افصلها في كلاس واخد منه object  واستقبله في الكونستركتور هنا

    LibraryService(){
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title,User user) {
        Book book = findBook(title);
        if(book==null){
            System.out.println(title+" is not found in the library.");
        } else if (!book.isAvailable()) {
            System.out.println(title+" is not available.");
        }else if (book instanceof BorrowInterface) {
            ((BorrowInterface) book).borrowBook(user);
        } else {
            System.out.println(title + " cannot be borrowed.");
        }

    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            if (book instanceof BorrowInterface) {
                ((BorrowInterface) book).returnBook();
            }
        } else {
            System.out.println(title+" is not found in the library.");
        }
    }
}
