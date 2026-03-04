## Project Reflection (CS320)

### How can I ensure that my code, program, or software is functional and secure?
I start by building functionality around clear rules and enforcing them in code. For example, my `Contact` class validates IDs, names, phone numbers, and addresses up front and rejects invalid input immediately, which prevents bad data from ever entering the system.
On top of that, I use unit tests to prove the “happy path” works and that failure cases are handled correctly. My tests cover duplicate IDs, missing IDs, deletes, full updates, and partial updates, which helps catch regressions early. 
From a security standpoint, this same mindset matters: validate inputs, fail fast, and keep state changes controlled through a service layer instead of letting callers modify data freely. 

### How do I interpret user needs and incorporate them into a program?
I treat requirements as the source of truth, then translate each one into (1) validation rules in the classes and (2) tests that prove the requirement is met. In my Project Two write-up, I used a requirement-driven approach where each requirement gets at least one valid test and at least one invalid test, so I can show coverage instead of guessing.  
This keeps me honest because the tests force the code to behave the way the user (or stakeholder) actually asked, not the way I assumed it should work.

### How do I approach designing software?
I design in layers: domain objects hold the data and enforce their own invariants, and service classes handle operations like add, delete, and update while protecting the collection from invalid actions (like duplicate IDs or updates to missing records). 
Then I build tests alongside the design so every method has proof it works under both normal and incorrect inputs. That approach makes changes safer later because I can refactor with confidence and immediately see if I broke a requirement.
