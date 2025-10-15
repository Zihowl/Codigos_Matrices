# Matrices Java Project

This project implements matrix operations in Java, allowing users to create matrices and perform various operations such as addition, subtraction, and multiplication. The application is designed with a strong emphasis on object-oriented programming principles, making it beginner-friendly and easy to understand.

## Project Structure

```
Matrices_Java
├── README.md
├── src
│   └── com
│       └── matrices
│           ├── Main.java
│           ├── Matrix.java
│           ├── MatrixFactory.java
│           ├── MatrixOperations.java
│           └── io
│               └── ConsoleInput.java
└── build.gradle
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Gradle 6.0 or higher

### Setup

1. Clone the repository or download the project files.
2. Navigate to the project directory in your terminal.
3. Build the project using Gradle:

   ```
   gradle build
   ```

### Running the Application

To run the application, execute the following command in the terminal:

```
gradle run
```

### Usage

1. The application will prompt you to enter the dimensions of the matrices.
2. You will then be asked to input the elements of each matrix.
3. After creating the matrices, you can choose from the available operations (addition, subtraction, multiplication).
4. The results will be displayed in the console.

## Classes Overview

- **Main.java**: Entry point of the application, initializes the program and handles user interactions.
- **Matrix.java**: Represents a matrix with properties for rows, columns, and data. Contains methods for displaying the matrix.
- **MatrixFactory.java**: Responsible for creating matrices based on user input and validating dimensions.
- **MatrixOperations.java**: Contains static methods for performing operations on matrices.
- **ConsoleInput.java**: Handles user input from the console with error checking.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or additional features.

## License

This project is licensed under the MIT License. See the LICENSE file for details.