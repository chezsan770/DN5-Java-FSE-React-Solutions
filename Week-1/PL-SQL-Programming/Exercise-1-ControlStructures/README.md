# Exercise 1: Control Structures

This exercise contains PL/SQL blocks for three banking scenarios using loops,
conditions, updates, and output messages.

## Assumed tables

The scripts assume the following columns are available:

- `Customers(CustomerID, Name, Age, Balance, IsVIP)`
- `Loans(LoanID, CustomerID, InterestRate, DueDate)`

## Scenarios

1. Customers above 60 years old receive a 1% discount on their loan interest
   rates.
2. Customers with a balance greater than `$10,000` are marked as VIP.
3. Customers with loans due within the next 30 days receive reminder messages
   through `DBMS_OUTPUT`.

## Note

The script uses `IsVIP = 'TRUE'`, which works when the flag is stored as text.
If your Oracle table uses a real `BOOLEAN` column, change it to `IsVIP = TRUE`.
