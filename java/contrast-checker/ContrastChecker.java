import java.util.Locale;
import java.util.Scanner;

/**
 * WCAG 2 contrast ratio for two hex colours.
 */
public class ContrastChecker {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Contrast checker");
    System.out.println("Enter hex colours like #1c1b19 or 1c1b19. Empty line to quit.");
    System.out.println();

    while (true) {
      System.out.print("Foreground: ");
      String foreground = input.nextLine().trim();
      if (foreground.isEmpty()) {
        break;
      }

      System.out.print("Background: ");
      String background = input.nextLine().trim();
      if (background.isEmpty()) {
        break;
      }

      try {
        double ratio = contrastRatio(parseHex(foreground), parseHex(background));
        System.out.printf(Locale.US, "%nRatio  %.2f : 1%n", ratio);
        System.out.println("Normal text  AA " + pass(ratio, 4.5) + "   AAA " + pass(ratio, 7.0));
        System.out.println("Large text   AA " + pass(ratio, 3.0) + "   AAA " + pass(ratio, 4.5));
        System.out.println();
      } catch (IllegalArgumentException error) {
        System.out.println(error.getMessage());
        System.out.println();
      }
    }
  }

  static String pass(double ratio, double minimum) {
    return ratio + 0.0001 >= minimum ? "pass" : "fail";
  }

  static int parseHex(String raw) {
    String value = raw.startsWith("#") ? raw.substring(1) : raw;
    if (value.length() == 3) {
      StringBuilder expanded = new StringBuilder(6);
      for (int i = 0; i < 3; i++) {
        expanded.append(value.charAt(i)).append(value.charAt(i));
      }
      value = expanded.toString();
    }
    if (!value.matches("(?i)[0-9a-f]{6}")) {
      throw new IllegalArgumentException("Use a 3 or 6 digit hex colour, for example #1c1b19.");
    }
    return Integer.parseInt(value, 16);
  }

  static double contrastRatio(int foreground, int background) {
    double lighter = Math.max(relativeLuminance(foreground), relativeLuminance(background));
    double darker = Math.min(relativeLuminance(foreground), relativeLuminance(background));
    return (lighter + 0.05) / (darker + 0.05);
  }

  static double relativeLuminance(int rgb) {
    double red = channel(((rgb >> 16) & 0xFF) / 255.0);
    double green = channel(((rgb >> 8) & 0xFF) / 255.0);
    double blue = channel((rgb & 0xFF) / 255.0);
    return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
  }

  static double channel(double value) {
    return value <= 0.04045 ? value / 12.92 : Math.pow((value + 0.055) / 1.055, 2.4);
  }
}
