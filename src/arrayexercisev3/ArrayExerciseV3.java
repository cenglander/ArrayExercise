package arrayexercisev3;

/**
 *
 * @author Charlotte Englander
 */
import java.util.Scanner;

public class ArrayExerciseV3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BookManagement.fillArray();
        menu();

    }

    static void menu() {
        System.out.println("*** Array of books ***");
        boolean returnToMenu = true;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1.Add new book  2.Remove book  3.Update book  \n4.Print all books  5.Print one book by ID  6.Print one book by title  \n7.Find oldest book  8.Find newest book  \n9.Find book with highest price  10.Find book with lowest price\n0.Exit program");
            int choiceInMenu = sc.nextInt();
            sc.nextLine();
            switch (choiceInMenu) {
                case 1:
                    System.out.println("Add new book");
                    System.out.println("************");
                    BookManagement.addBook();
                    break;
                case 2:
                    System.out.println("Remove book");
                    System.out.println("***********");
                    BookManagement.removeBook();
                    break;
                case 3:
                    System.out.println("Update information of one book");
                    System.out.println("******************************");
                    BookManagement.updateBook();
                    break;
                case 4:
                    System.out.println("Print all books");
                    System.out.println("***************");
                    BookManagement.printAll();
                    break;
                case 5:
                    System.out.println("Print one book by ID");
                    System.out.println("********************");
                    BookManagement.printOneById();
                    break;
                case 6:
                    System.out.println("Print one book by title");
                    System.out.println("***********************");
                    BookManagement.printOneByTitle();
                    break;
                case 7:
                    System.out.println("Find oldest book");
                    System.out.println("****************");
                    BookManagement.findOldestBook();
                    break;
                case 8:
                    System.out.println("Find newest book");
                    System.out.println("****************");
                    BookManagement.findNewestBook();
                    break;
                case 9:
                    System.out.println("Book with highest price");
                    System.out.println("***********************");
                    BookManagement.findMaxPrice();
                    break;
                case 10:
                    System.out.println("Book with lowest price");
                    System.out.println("**********************");
                    BookManagement.findMinPrice();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.out.println("");
                    returnToMenu = false;
                    break;
            }
        } while (returnToMenu == true);

    }

}
