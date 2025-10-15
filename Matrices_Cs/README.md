# Matrices_Cs Project

This project implements basic matrix operations in C#. It allows users to create matrices, perform operations such as addition, subtraction, and multiplication, and display the results. The project is designed with a strong emphasis on object-oriented programming principles, promoting code reusability and maintainability.

## Project Structure

- **Matrices_Cs.csproj**: Project file containing configuration and dependencies.
- **README.md**: Documentation for the project.
- **src/Interfaces/IMatrixOperations.cs**: Interface defining matrix operation methods.
- **src/Models/Matrix.cs**: Class representing a matrix and its properties.
- **src/Program.cs**: Entry point of the application.
- **src/Services/MatrixOperationsService.cs**: Class implementing matrix operations.
- **src/Utilities/ConsoleInput.cs**: Utility methods for console input handling.

## Getting Started

To run the application, follow these steps:

1. **Clone the repository**:
   ```
   git clone <repository-url>
   ```

2. **Navigate to the project directory**:
   ```
   cd Matrices_Cs
   ```

3. **Build the project**:
   ```
   dotnet build
   ```

4. **Run the application**:
   ```
   dotnet run --project src/Program.cs
   ```

## Usage

Upon running the application, you will be prompted to enter the dimensions and elements of two matrices. After creating the matrices, you can choose from the available operations:

- **Add**: Sum two matrices.
- **Subtract**: Subtract one matrix from another.
- **Multiply**: Multiply two matrices.

The results will be displayed in the console.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License

This project is licensed under the MIT License. See the LICENSE file for details.