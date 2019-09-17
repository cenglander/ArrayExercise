package arrayexercisev3;

/**
 *
 * @author Charlotte Englander
 */
public class Book {

    static int idCounter = 1;

    private String title;
    private String author;
    private int id;
    private double price;
    private String dateOfRelease;

    public Book(String title, String author, double price, String dateOfRelease) {
        this.title = title;
        this.author = author;
        this.id = idCounter;
        this.price = price;
        this.dateOfRelease = dateOfRelease;
        idCounter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    @Override
    public String toString() {
        return fix(title, 25) + fix(author, 20) + fix(String.valueOf(id), 9) + fix(String.valueOf(price), 10) + dateOfRelease;
    }

    String fix(String s, int x) {
        String s2;
        if (s.length() > x) {
            return s.substring(0, x + 1);
        } else {
            s2 = s;
            for (int i = s.length() + 1; i < x + 1; i++) {
                s2 = s2 + " ";
            }
        }
        return s2;
    }
}
