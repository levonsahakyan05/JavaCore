package homework.books.model;

public class Book {
    private String title;
    private Author authorName;
    private double price;
    private int count;
    private String genre;
    private User registerUser;

    public Book(String title, Author authorName, double price, int count, String genre,User registerUser) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.count = count;
        this.genre = genre;
        this.registerUser = registerUser;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public User getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(User registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName.getName() + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", registerUser=" + registerUser +
                ", genre='" + genre + '\'' +
                '}';
    }
}
