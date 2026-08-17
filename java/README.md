# Java

Small console apps. Try the browser demos on [GitHub Pages](https://micah-masuka.github.io/Learning/java/), or clone this repo and compile the original Java source with a JDK.

```bash
brew install openjdk
```

On a Mac, you may also need:

```bash
sudo ln -sfn $(brew --prefix openjdk)/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
```

Then, from a project folder:

```bash
cd contrast-checker
javac ContrastChecker.java
java ContrastChecker
```

- **[Contrast checker](https://micah-masuka.github.io/Learning/java/contrast-checker/)** — two hex colours in, WCAG contrast ratio out
- **[UX quiz](https://micah-masuka.github.io/Learning/java/ux-quiz/)** — the same six questions as the web game, in the terminal
- **[Password gate](https://micah-masuka.github.io/Learning/java/password-gate/)** — a console version of the portfolio lock screen
