SET SERVEROUTPUT ON;

-- Scenario 1:
-- Apply a 1% discount to loan interest rates for customers above 60 years old.
BEGIN
    FOR customer_record IN (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = customer_record.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Applied 1% interest discount for customer ID: ' ||
            customer_record.CustomerID
        );
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2:
-- Promote customers with a balance greater than $10,000 to VIP status.
BEGIN
    FOR customer_record IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = customer_record.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID ' || customer_record.CustomerID ||
            ' has been promoted to VIP status.'
        );
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3:
-- Print reminders for customers whose loans are due within the next 30 days.
BEGIN
    FOR loan_record IN (
        SELECT c.CustomerID,
               c.Name,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
            ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_record.Name ||
            ' (Customer ID: ' || loan_record.CustomerID ||
            ') has loan ID ' || loan_record.LoanID ||
            ' due on ' || TO_CHAR(loan_record.DueDate, 'DD-MON-YYYY') || '.'
        );
    END LOOP;
END;
/
