package LibraryProject;

import java.util.ArrayList;

public class Teacher extends Reader {
    public Teacher(int id, String name, String login, String password) {
        super(id, name, login, password);
    }

    @Override
    public void AddissueBook(Books books) {
        issuedBooks = new ArrayList<>();
        issuedBooks.add(books);
    }
}
