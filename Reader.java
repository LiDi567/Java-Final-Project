package FinalProject3;

import java.util.ArrayList;
import java.util.List;

class Reader {
    int id;
    String name;
    List<String> booksRead;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
        booksRead = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

}
