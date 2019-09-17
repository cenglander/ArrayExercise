package arrayexercisev3;

/**
 *
 * @author Charlotte Englander
 */
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class BookManagement {

    static int nextFreePosition = 0;
    static Book[] books = new Book[10];

    static void fillArray() {
        books[nextFreePosition++] = new Book("Java", "Kalle Karlsson", 123, "1995-03-01");
        books[nextFreePosition++] = new Book("Python", "Lisa Larsson", 234, "2010-03-01");
        books[nextFreePosition++] = new Book("Java 2", "Johan Jansson", 98, "1990-03-01");
        books[nextFreePosition++] = new Book("Python 2", "Peter Persson", 324, "1988-03-01");
        books[nextFreePosition++] = new Book("Java Fundamentals", "Max Månsson", 323, "1994-03-01");
        books[nextFreePosition++] = new Book("Java 34", "Ola Ålund", 456, "1993-03-01");
        books[nextFreePosition++] = new Book("Python Fundamentals", "Ellinor Engström", 79, "1970-03-01");
        books[nextFreePosition++] = new Book("Java 678", "Inga Petersson", 200, "1965-03-01");
        books[nextFreePosition++] = new Book("Python 43", "Hanna Haag", 427, "1974-03-01");
        books[nextFreePosition++] = new Book("Python 324", "Pelle Paff", 156, "1967-03-01");
    }

    static void addBook() {
        if (nextFreePosition >= books.length) {
            Book[] books2 = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                books2[i] = books[i];
            }
            books = books2;
        }
        System.out.print("Title: ");
        String title = ArrayExerciseV3.sc.nextLine();
        System.out.print("Name of author: ");
        String author = ArrayExerciseV3.sc.nextLine();
        System.out.print("Price: ");
        double price = ArrayExerciseV3.sc.nextDouble();
        ArrayExerciseV3.sc.nextLine();
        System.out.print("Date of release (YYYY-MM-DD): ");
        String dateOfRelease = ArrayExerciseV3.sc.nextLine();

        books[nextFreePosition] = new Book(title, author, price, dateOfRelease);
        nextFreePosition++;
    }

    static void removeBook() {
        System.out.println("What is the ID of the book you would like to remove? ");
        int id = ArrayExerciseV3.sc.nextInt();
        ArrayExerciseV3.sc.nextLine();
        if (id > 0 && id <= nextFreePosition) {
            for (int i = 0; i < nextFreePosition; i++) {
                if ((books[i]).getId() == id) {
                    System.out.println("Are you sure that you want to delete the following? (Y/N)");
                    System.out.println(books[i]);
                    String answer = ArrayExerciseV3.sc.nextLine();
                    if (answer.equalsIgnoreCase("Y")) {
                        books[i] = books[nextFreePosition - 1];
                        books[nextFreePosition - 1] = null;
                        nextFreePosition--;
                        System.out.println("Deleted");
                    }
                }
            }
        } else {
            System.out.println("ID: " + id + " does not exist.");
        }
    }

    static void updateBook() {
        System.out.print("What is the ID of the book you would like to update? ");
        int id = ArrayExerciseV3.sc.nextInt();
        ArrayExerciseV3.sc.nextLine();
        printHeader();
        for (int i = 0; i < nextFreePosition; i++) {
            if ((books[i]).getId() == id) {
                boolean isValid = true;
                while (isValid) {       // == true
                    System.out.println(books[i]);
                    System.out.println("What field would you like to update? ");
                    System.out.println("1.Title  2.Author  3.Price  4.Date of release  0.Exit to main menu");
                    int choiceOfField = ArrayExerciseV3.sc.nextInt();
                    ArrayExerciseV3.sc.nextLine();
                    switch (choiceOfField) {
                        case 1:
                            System.out.println("New title: ");
                            String title = ArrayExerciseV3.sc.nextLine();
                            books[i].setTitle(title);
                            break;
                        case 2:
                            System.out.println("New author: ");
                            String author = ArrayExerciseV3.sc.nextLine();
                            books[i].setAuthor(author);
                            break;
                        case 3:
                            System.out.println("New price: ");
                            double price = ArrayExerciseV3.sc.nextDouble();
                            ArrayExerciseV3.sc.nextLine();
                            books[i].setPrice(price);
                            break;
                        case 4:
                            System.out.println("New date of release: ");
                            String dateOfRelease = ArrayExerciseV3.sc.nextLine();
                            books[i].setDateOfRelease(dateOfRelease);
                            break;
                        case 0:
                            System.out.println("Exiting to main menu..");
                            isValid = false;
                            break;
                    }
                }
            }

        }
    }

    static void printHeader() {
        System.out.println("Title                    Author              BookID   Price     Date of release");
    }

    static void printAll() {
        printHeader();
        for (int i = 0; i < nextFreePosition; i++) {
            System.out.println(books[i]);
        }
    }

    static void printOneById() {
        System.out.print("What is the ID of the book you would like to print? ");
        int id = ArrayExerciseV3.sc.nextInt();
        ArrayExerciseV3.sc.nextLine();
        for (int i = 0; i < nextFreePosition; i++) {
            if ((books[i]).getId() == id) {
                printHeader();
                System.out.println(books[i]);
            }
        }
    }

    static void printOneByTitle() {
        System.out.print("What is the title of the book you would like to print? ");
        String title = ArrayExerciseV3.sc.nextLine();
        for (int i = 0; i < nextFreePosition; i++) {
            if ((books[i].getTitle()).equalsIgnoreCase(title)) {
                printHeader();
                System.out.println(books[i]);
            }
        }
    }

    static long calculateAge(int i) {
        LocalDate releaseDate = LocalDate.parse(books[i].getDateOfRelease());
        LocalDate now = LocalDate.now();
        long age = YEARS.between(releaseDate, now);
        return age;
    }

    static Book findOldestBook() {
        int oldest = 0;
        for (int i = 1; i < books.length; i++) {
            if (calculateAge(i) > calculateAge(oldest)) {
                oldest = i;
            }
        }
        printHeader();
        System.out.println(books[oldest]);
        return books[oldest];
    }

    static Book findNewestBook() {
        int newest = 0;
        for (int i = 1; i < books.length; i++) {
            if (calculateAge(i) < calculateAge(newest)) {
                newest = i;
            }
        }
        printHeader();
        System.out.println(books[newest]);
        return books[newest];

    }

    static void findMaxPrice() {
        int max = 0;
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPrice() > books[max].getPrice()) {
                max = i;
            }
        }
        printHeader();
        System.out.println(books[max]);
    }

    static void findMinPrice() {
        int min = 0;
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPrice() < books[min].getPrice()) {
                min = i;
            }
        }
        printHeader();
        System.out.println(books[min]);
    }

}
