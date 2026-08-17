import java.util.Scanner;

public class PasswordGate {
  private static final String PASSWORD = "try-me";

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Password-locked note");
    System.out.println("A recruiter should get in. A random visitor should not.");
    System.out.println();

    while (true) {
      System.out.print("Password: ");
      String attempt = input.nextLine().trim();
      if (attempt.equalsIgnoreCase(PASSWORD)) {
        showNote();
        return;
      }
      System.out.println("Incorrect password. Hint: try-me");
      System.out.println();
    }
  }

  static void showNote() {
    System.out.println();
    System.out.println("You are in.");
    System.out.println();
    System.out.println("For a portfolio, this is enough: it slows down casual clicks");
    System.out.println("and still lets a hiring manager through.");
    System.out.println();
    System.out.println("It is not security. Anyone can open the source.");
    System.out.println("Do not put client originals or private data behind a check like this.");
  }
}
