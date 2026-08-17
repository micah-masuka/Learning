# Contrast checker

Type two hex colours. The program prints the contrast ratio and whether it passes WCAG AA and AAA for normal and large text.

This is the same check I use when picking type colour on a site: if the ratio is low, people cannot read it.

## Run

```bash
javac ContrastChecker.java
java ContrastChecker
```

Example: `#1c1b19` on `#f6f5f2`
