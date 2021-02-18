package LibraryProject;

import LibraryProject.Books;
import LibraryProject.Lidrary;

import java.io.Serializable;
import java.util.List;

public abstract class Reader implements Serializable {
    private int id;
    private String name;
    private String login;
    private String Password;
    protected List <Books> issuedBooks;

    public Reader(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Books> getIssuedBooks() {
        return issuedBooks;
    }

    public abstract void AddissueBook(Books books);

}
