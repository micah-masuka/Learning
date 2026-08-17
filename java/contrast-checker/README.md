# Contrast checker

Type two hex colours. The program prints the contrast ratio and whether it passes WCAG AA and AAA for normal and large text.

This is the same check I use when picking type colour on a site: if the ratio is low, people cannot read it.

## Run

```bash
javac ContrastChecker.java
java ContrastChecker
```

Example: `#1c1b19` on `#f6f5f2`

[Try the browser demo](https://micah-masuka.github.io/Learning/java/contrast-checker/) — no JDK needed. The demo mirrors this Java program with JavaScript because GitHub Pages serves static web files and cannot run Java console programs directly.
