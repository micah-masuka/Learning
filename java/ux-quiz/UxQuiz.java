import java.util.Scanner;

public class UxQuiz {
  public static void main(String[] args) {
    Question[] questions = {
      new Question(
          "A page has one main action. Where should the primary button sit?",
          new String[] {
            "At the end of the task, easy to find",
            "Hidden in a menu on desktop, so the page stays clean",
            "Styled exactly like every other text link"
          },
          0,
          "People should not hunt for the next step. One clear button, in the path of the task."
      ),
      new Question(
          "Someone types the wrong password. What is the better response?",
          new String[] {
            "\"Error 401\" and nothing else",
            "\"Incorrect password. Try again or email Micah.\" next to the field",
            "A popup that vanishes after one second"
          },
          1,
          "Say what went wrong and what to do next. Keep the message next to the field they just used."
      ),
      new Question(
          "Placeholder text inside a form field…",
          new String[] {
            "Can replace the visible label",
            "Disappears when you type, so it should not be the only instruction",
            "Is required by browsers"
          },
          1,
          "Labels stay. Placeholders vanish. If the hint matters, put it outside the field."
      ),
      new Question(
          "A \"skip to content\" link is for…",
          new String[] {
            "Skipping the website entirely",
            "Keyboard users jumping past the nav to the main content",
            "Search engines only"
          },
          1,
          "Screen reader and keyboard users should not tab through every nav link on every page."
      ),
      new Question(
          "A password on a public case-study page is…",
          new String[] {
            "Bank-level security",
            "A polite gate for casual visitors. Real secrets still should not live in the public files",
            "Useless, so never use one"
          },
          1,
          "It slows down nosy clicks. It does not hide source code. Size the lock to the risk."
      ),
      new Question(
          "Four answers to one question should be marked up as…",
          new String[] {
            "Clickable divs with no form controls",
            "Radio buttons in a fieldset, with the question as the legend",
            "A dropdown labelled \"Select\""
          },
          1,
          "Radios are made for \"pick one.\" A fieldset + legend tells assistive tech what the group is about."
      )
    };

    Scanner input = new Scanner(System.in);
    int score = 0;

    System.out.println("UX quiz");
    System.out.println("Six questions. Type 1, 2, or 3.");
    System.out.println();

    for (int i = 0; i < questions.length; i++) {
      Question question = questions[i];
      System.out.println((i + 1) + " / " + questions.length);
      System.out.println(question.prompt);
      for (int option = 0; option < question.options.length; option++) {
        System.out.println("  " + (option + 1) + ") " + question.options[option]);
      }

      int choice = readChoice(input, question.options.length);
      boolean correct = choice == question.answerIndex;
      if (correct) {
        score += 1;
        System.out.print("Yes. ");
      } else {
        System.out.print("Not that one. ");
      }
      System.out.println(question.why);
      System.out.println();
    }

    System.out.println("Score  " + score + " / " + questions.length);
    System.out.println(resultCopy(score));
  }

  static int readChoice(Scanner input, int optionCount) {
    while (true) {
      System.out.print("Your answer: ");
      String raw = input.nextLine().trim();
      try {
        int value = Integer.parseInt(raw);
        if (value >= 1 && value <= optionCount) {
          return value - 1;
        }
      } catch (NumberFormatException ignored) {
        // fall through
      }
      System.out.println("Type a number from 1 to " + optionCount + ".");
    }
  }

  static String resultCopy(int score) {
    if (score == 6) {
      return "Full marks. You notice the boring stuff that makes a page usable.";
    }
    if (score >= 4) {
      return "Solid. You are thinking about the person in front of the screen, not only the layout.";
    }
    if (score >= 2) {
      return "A fair start. The \"why\" under each answer is the useful bit.";
    }
    return "No stress. Read the notes, then try again.";
  }

  static final class Question {
    final String prompt;
    final String[] options;
    final int answerIndex;
    final String why;

    Question(String prompt, String[] options, int answerIndex, String why) {
      this.prompt = prompt;
      this.options = options;
      this.answerIndex = answerIndex;
      this.why = why;
    }
  }
}
