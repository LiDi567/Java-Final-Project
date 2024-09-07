package FinalProject3;

import java.util.ArrayList;
import java.util.List;

class Library {
    List<Shelf> shelves;
    List<Reader> readers;

    public Library() {
        shelves = new ArrayList<>();
        readers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Shelf shelf = new Shelf();
            shelf.addBook(new Book("Author " + (i + 1), "Title " + (i * 2 + 1), 100));
            shelf.addBook(new Book("Author " + (i + 1), "Title " + (i * 2 + 2), 200));
            shelves.add(shelf);
        }
    }

    public boolean isTherePlaceForNewBook() {
        for (Shelf shelf : shelves) {
            if (shelf.isShelfFull()) {
                return true;
            }
        }
        return false;
    }

    public void addNewBook(Book book) {
        for (Shelf shelf : shelves) {
            if (shelf.isShelfFull()) {
                shelf.addBook(book);
                return;
            }
        }
        System.out.println("No available shelf space for the new book.");
    }

    public void deleteBook(String title) {
        for (Shelf shelf : shelves) {
            if (shelf.removeBook(title)) {
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void registerReader(int id, String name) {
        readers.add(new Reader(id, name));
    }

    public void removeReader(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equals(name)) {
                readers.remove(reader);
                System.out.println("Reader removed successfully.");
                return;
            }
        }
        System.out.println("Reader not found.");
    }

    public List<String> searchByAuthor(String author) {
        List<String> titles = new ArrayList<>();
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getAuthor().equals(author)) {
                    titles.add(book.getTitle());
                }
            }
        }
        return titles;
    }
}
