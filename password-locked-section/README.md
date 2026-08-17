# Password-locked web sections

A recruiter should be able to open a confidential case study. A random visitor should not.

That is a **gate**, not a vault. I used one on my [Sanex case study](https://micah.digitale-tech.com/case-studies/sanex).

## What I wanted

- A password I can put in a job application
- A clear form: label, field, button, error next to the field
- Once they get in, they should not have to type it again in the same visit
- No extra server, no login accounts

## How it works (simple version)

The page loads a lock screen first. If the password matches, the rest of the case study is shown. The browser remembers “unlocked” for that tab with `sessionStorage`, so a refresh does not kick them out.

Try the [tiny demo](index.html). Password: `try-me`

## What this is not

Anyone can open the page source and find the check. That is fine for a portfolio. It is **not** fine for bank details, client originals, or anything that would hurt someone if it leaked.

If the files must stay private, do not put them on a public site. Send them another way, or keep the real files off GitHub.

## What I would do next

For something more serious, the check would happen on the server, and the protected pages would not be sitting in the public files at all. For a UX portfolio, the polite gate was enough.
