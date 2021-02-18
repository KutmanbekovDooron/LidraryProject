package LibraryProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Lidrary{

    private List<Reader> readerList;
    private List<Books> bookList;

    public Lidrary(List<Reader> readerList,List<Books> bookList) {
        this.readerList = readerList;
        this.bookList = bookList;
    }

    public List<Reader> getReaderList() {
        return readerList;
    }

    public void setReaderList(List<Reader> readerList) {
        this.readerList = readerList;
    }

    public List<Books> getBookList() {
        return bookList;
    }
    public void addBook(Books books){
        this.bookList.add(books);
    }
}
