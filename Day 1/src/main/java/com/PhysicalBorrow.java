package com;

public class PhysicalBorrow extends Book implements BorrowInterface {

    public PhysicalBorrow(String title) {
        super(title);
    }

    public void borrowBook(User user) {
        if (super.isAvailable()) {
            super.setAvailable(false);
            System.out.printf(user.getName() + " successfully borrowed " + super.getTitle());
        } else {
            System.out.println(super.getTitle() + " is not available.");
        }
    }

    public void returnBook() {
        super.setAvailable(true);
        System.out.println("\n"+super.getTitle() + " has been returned.");
    }
}
