# Exercise 3: Stored Procedures

This exercise contains stored procedures for common banking operations.

## Assumed tables

The procedures assume these columns are available:

- `Accounts(AccountID, CustomerID, AccountType, Balance)`
- `Employees(EmployeeID, Name, Department, Salary)`

## Procedures

### `ProcessMonthlyInterest`

Applies 1% monthly interest to all accounts where `AccountType` is `SAVINGS`.

### `UpdateEmployeeBonus`

Accepts a department and bonus percentage, then updates salaries for employees in
that department.

Example:

```sql
EXEC UpdateEmployeeBonus('IT', 10);
```

### `TransferFunds`

Transfers money from one account to another after checking:

- The transfer amount is greater than zero.
- The source account exists.
- The source account has sufficient balance.
- The destination account exists.

The procedure rolls back the transaction if the transfer cannot be completed.
