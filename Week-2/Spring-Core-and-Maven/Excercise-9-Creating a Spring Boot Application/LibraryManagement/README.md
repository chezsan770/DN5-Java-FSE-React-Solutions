# Exercise 9: LibraryManagement

## How to run

1. Open `LibraryManagement` in IntelliJ IDEA.
2. Load Maven dependencies.
3. Run `LibraryManagementApplication.java`.
4. The application starts on:

```text
http://localhost:8080
```

## H2 database

Open:

```text
http://localhost:8080/h2-console
```

Use:

```text
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: 1234
```

## API endpoints

Load sample books into the database:

```text
GET http://localhost:8080/load
```

Get all books:

```text
GET http://localhost:8080/book
```

Add a book:

```text
POST http://localhost:8080/book
```

Request body:

```json
{
  "bookName": "New Book"
}
```

Get a book by ID:

```text
GET http://localhost:8080/book/{id}
```

Delete a book by ID:

```text
DELETE http://localhost:8080/book/{id}
```
