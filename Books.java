package LibraryProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Books implements Serializable {
    private int id;
    private String name;
    private boolean inStock;
    private String author;
    private String zhanyr;
    private Reader user;
    private ArrayList <String> coment;
    private int like;
    private int dontLike;

    public ArrayList<String> getComent() {
        return coment;

    }

    public void setComent(ArrayList <String> coment) {
        this.coment = coment;
    }

    public int getDontLike() {
        return dontLike;
    }

    public void setDontLike(int dontLike) {
        this.dontLike += dontLike;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like += like;
    }

    public Books(int id, String name, boolean inStock, String author, String zhanyr) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.author = author;
        this.zhanyr = zhanyr;
    }

    public String getAuthor() {
        return author;
    }

    public String getZhanyr() {
        return zhanyr;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Reader getUser() {
        return user;
    }

    public void setUser(Reader user) {
        this.user = user;
    }


}
