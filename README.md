[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/3K2mUKr_)
# CS230X-assignment4-F24
# Bank Accounts

## Learning Goals: 
- [ ] Practice with the Java hierarchy through inheritance
- [ ] Practice with abstract classes and polymorphism
- [ ] Practice with designing a software solution based on provided specifications

## Create a Bank with various kinds of Accounts

**How to start** Start by reviewing the requirements of this assignment and then designing your program. You must draw (using paper, whiteboard, or a digital sketching tool) the `UML diagram` of the classes you will need, along with their instance variables and their methods. Take a picture (or save) this UML diagram, you will upload this along with your code to Gradescope. This UML diagram can be done collaboratively with other students in the class, please make sure to add the names of anyone you collaborated with along with your assignment.

**Problem Description**

Design and write the basic software that will manage bank accounts and their required functionality. Below are the requirements that were provided to you by the bank manager.

According to the bank specifications, a client can **open** a new account in the bank. With every new account opened, the Bank produces a `unique` account number to associate with that new account. There are two types of accounts in the bank:

* A `Checking Account` has a `minimum balance` of \$100, and an `overdraft fee` of \$25. (The overdraft fee is a penalty that the Bank charges automatically if your balance falls under the minimum balance.) 
* A `SavingsAccount` has no minimum balance or overdraft fees. Every Savings account earns some `interest`, currently fixed at an annual rate of 0.5%. 

The following requirements must be implemented in your software:
* The two types of accounts have some attributes and behaviors in common. Think about how to use Java's inheritance model to design your application.
* A client can hold a `Checking Account` or a `Savings Account`, or both. No one can ever open just a plain Account!  
* **Depositing** money to an account functions exactly the same way for both kinds of accounts (Savings and Checking): the deposited amount is just added to the account's balance. This behavior can never be altered.
* **Withdrawing** an amount from either kind of account subtracts this amount from the account's balance. In general, for any type of account, attempts to withdraw an amount more than the account balance are simply denied.
* However, for checking accounts **ONLY**, *overdrafts* (i.e. withdraws resulting in a balance below the minimum balance, but not below zero) are allowed. Every overdraft results in the account being charged with an *overdraft fee*. At that point, the account balance can fall even below zero.

*Example*: consider a checking account with balance of \$200, minimum balance of $100 and overdraft fee of \$25.

A withdraw of \$250 is ordered. The transaction is denied.

A withdraw of \$180 is ordered. The new balance would be \$20, which is below the minimum balance. Therefore the overdraft fee of \$25 is charged, which brings the account balance to a negative value.

* Account owners should also be able to see a **display** of their account, including the kind of the account, the account number, its balance and other characteristics as appropriate (depending on the kind of the account).

* Finally, the **Bank** maintains a collection of accounts. It should be able to add directly an account to its collection, look for an account given its unique account number, print all accounts, and calculate all available funds (total of funds across all checking and saving accounts in the bank.)  

**Design and Implementation of the application**

Read the problem description above and design your application code. You should have exactly 4 classes. Think about **inheritance** when designing those classes. Some of these classes share a lot of characteristics.

Design and implement the following 4 classes:
1. `Account`,
2. `CheckingAccount`,
3. `SavingsAccount`, and
4. `Bank`

the first three classes:
- A `CheckingAccount` **is-a** (special kind of an) `Account`
- A `SavingsAccount` **is-a** (special kind of an )`Account`
- On the other hand, a `Bank` **contains** a collection of accounts.

To help you get started, here is a small description of one of the classes you should have in your application.

The `Account` class should contain all the common characteristics and functionality of any type of bank account. These include:
1. the -unique for each account- account number
2. the account balance
3. deposit(): a method for depositing an amount to the account
4. withdraw(): a method for withdrawing an amount from the account, and
5. toString(): a method to be used for printing the account

Notes:

1. The *withdraw()* method behaves differently depending on the kind of the account. Therefore, think carefully: can you provide the definition for this method in the `Account` class? If not, where should it be defined?
2. The toString() method behaves almost the same in both types of accounts, but in the case of a *checking account* it should also include the minimum balance, while in the case of a *saving account* it should include the interest rate.
3. An account cannot be removed from the `Bank` once it has been added, and the maximum number of accounts that a `Bank` can hold cannot change.

**Testing:**
To show that your programs works correctly, you should create a `main()` method for each class. Carefully think about what testing is relevant for each class. Your testing cases should contain the correct/expected results next to the produced ones, so one can access correctness easier.

An example of running the Bank's main method is given here:
```
Current state of Bank:

This bank currently manages 4 accounts: 
----------------------------------------------
Checking Account #0	Balance: $1,000.00	Minimum balance: 100.0	Overdraft fee: 25
Savings Account #1	Balance: $1,000.00	Interest rate: 0.5
Checking Account #2	Balance: $500.00	Minimum balance: 100.0	Overdraft fee: 25
Savings Account #3	Balance: $500.00	Interest rate: 0.5
----------------------------------------------
Total Funds: $3000.0

Depositing $4,000 into Checking #0:
Expected: Checking Account #0	Balance: $5,000.00	Minimum balance: 100.0	Overdraft fee: 25
Result:   Checking Account #0	Balance: $5,000.00	Minimum balance: 100.0	Overdraft fee: 25

Depositing $2,000 into Savings #1:
Expected: Savings Account #1	Balance: $3,000.00	Interest rate: 0.5
Result:   Savings Account #1	Balance: $3,000.00	Interest rate: 0.5

Withdrawing $5K MORE THAN AVAILABLE from Savings #1:
Expected: ** Withdrawal DENIED **: Insufficient balance.
Result:   ** Withdrawal DENIED **: Insufficient balance.

Withdrawing $6K -- MORE THAN AVAILABLE from Checking #1:
Expected: ** Withdrawal DENIED **: Insufficient balance.
Result:   ** Withdrawal DENIED **: Insufficient balance.

Withdrawing $4901 from Checking #1 triggers Overdraft:
Expected: ** NOTE: Balance is low. Overdraft Fee was charged.
Result:   ** NOTE: Balance is low. Overdraft Fee was charged.
Checking Account #0	Balance: $74.00	Minimum balance: 100.0	Overdraft fee: 25

Withdrawing $70 from Checking #1 triggers Overdraft:
Expected: ** NOTE: Balance is low. Overdraft Fee was charged.
Result:   ** NOTE: Balance is low. Overdraft Fee was charged.
Checking Account #0	Balance: -$21.00	Minimum balance: 100.0	Overdraft fee: 25

Withdrawing $10 from Checking #1 not allowed:
Expected: ** Withdrawal DENIED **: Insufficient balance.
Result:   ** Withdrawal DENIED **: Insufficient balance.
Checking Account #0	Balance: -$21.00	Minimum balance: 100.0	Overdraft fee: 25

New state of Bank accounts:
This bank currently manages 4 accounts: 
----------------------------------------------
Checking Account #0	Balance: -$21.00	Minimum balance: 100.0	Overdraft fee: 25
Savings Account #1	Balance: $3,000.00	Interest rate: 0.5
Checking Account #2	Balance: $500.00	Minimum balance: 100.0	Overdraft fee: 25
Savings Account #3	Balance: $500.00	Interest rate: 0.5
----------------------------------------------
Total Funds: $3979.0
```

## SAVING YOUR WORK ON GITHUB
As we have discussed in class, it is important to work on labs and assignments regularly and save frequently. You should test your work incrementally, which will require you to save your file before compiling/running it. In addition to saving your work on your local machine, you should also frequently push your work to this Github repository. You can refer to Lab0 and the [Git and Github tutorial](https://github.com/CS230X-F24/github-starter-course) for a refresher on using these tools. 

## SUBMITTING TO GRADESCOPE
Turn in your work submitting files Account.java, CheckingAccount.java, SavingsAccount.java, Bank.java, and a photo of your UML diagram to your Gradescope account for Assignment 4. Make sure that your UML diagram includes the names of collaborators, if any. You can all submit the same diagram but you must each indivdiually upload your own copy. [Click here for Gradescope instructions.](https://docs.google.com/document/d/1zGAJrbdAhfPZVlyDP9N3MmdKXWvNo7rQqehKNM5Q0_M/edit) 

## AUTOGRADER
When you submit your assignment to Gradecope, you will not immediately see feedback. You are welcome to resubmit as many times as you wish until the deadline but you will only receive feedback after the grades have been published. Click here for 230X instructions on: [testing your code](https://docs.google.com/document/d/19cKOyolT8UtSfMNrVw8MGgVWS-lYgHpBs8g2Cf_8Vvc/edit#heading=h.rt39ohf1jp6s), [styling your code](https://docs.google.com/document/d/14uwj9HAjNKfFBm0ZjUpWR7jdqKSj13rudIEJaG74mPk/edit), and [documenting your code](https://docs.google.com/document/d/15uqs_NH8y2sAuLLpiZuSxlI0UsL6a8CHuWY_qcvF4B4/edit). 

## ASSIGNMENT SOLUTIONS
Assignment solutions will not be shared. If you did not get full credit on the assignment, you should review the feedback and ask me or the TAs if you have further questions.   
