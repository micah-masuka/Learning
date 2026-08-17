# Java

Small console apps. They do not run in the browser. Clone this repo, install a JDK, then compile.

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

- **[Contrast checker](contrast-checker/)** — two hex colours in, WCAG contrast ratio out
- **[UX quiz](ux-quiz/)** — the same six questions as the web game, in the terminal
- **[Password gate](password-gate/)** — a console version of the portfolio lock screen
