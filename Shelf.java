package FinalProject3;

import java.util.ArrayList;
import java.util.List;

class Shelf {
    List<Book> books;
    private boolean isShelfFull;

    public Shelf() {
        books = new ArrayList<>();
        isShelfFull = false;
    }

    public boolean isShelfFull() {
        return !isShelfFull;
    }

    public void addBook(Book book) {
        if (isShelfFull) {
            System.out.println("Shelf is full. Cannot add more books.");
            return;
        }

        if (books.size() < 5) {
            books.add(book);
            if (books.size() == 5) {
                isShelfFull = true;
            }
        } else {
            System.out.println("Shelf is already full.");
        }
    }

    public boolean removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                isShelfFull = false;
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}

