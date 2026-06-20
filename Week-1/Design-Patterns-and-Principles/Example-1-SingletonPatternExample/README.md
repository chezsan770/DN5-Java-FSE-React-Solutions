# SingletonPatternExample

This Java project demonstrates the Singleton design pattern with a logging utility.

## Run

From the project directory:

```powershell
javac -d out src\Logger.java src\SingletonTest.java
java -cp out SingletonTest
```

`Logger` uses a private constructor and a single eagerly initialized static instance.
The test verifies with `==` that two calls to `getInstance()` return the same object.
