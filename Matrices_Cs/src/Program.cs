using Matrices_Cs.Interfaces;
using Matrices_Cs.Models;
using Matrices_Cs.Services;
using Matrices_Cs.Utilities;

namespace Matrices_Cs
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("\n=== Operaciones con Matrices ===");
            Matrix m1 = Matrix.Create(1);
            m1.Display();
            Matrix m2 = Matrix.Create(2);
            m2.Display();

            IMatrixOperations matrixOperations = new MatrixOperationsService();

            while (true)
            {
                Console.WriteLine("Operaciones disponibles:");
                if (m1.Rows == m2.Rows && m1.Columns == m2.Columns)
                {
                    Console.WriteLine("1. Sumar");
                    Console.WriteLine("2. Restar");
                }
                if (m1.Columns == m2.Rows)
                {
                    Console.WriteLine("3. Multiplicar");
                }
                else
                {
                    Console.WriteLine("No hay operaciones disponibles entre las matrices. Saliendo del programa.");
                    return;
                }

                Console.Write("Seleccione una operación: ");
                int option = ConsoleInput.GetInteger();

                try
                {
                    switch (option)
                    {
                        case 1:
                            Matrix resultAdd = matrixOperations.Add(m1, m2);
                            resultAdd.Display("resultante");
                            break;
                        case 2:
                            Matrix resultSubtract = matrixOperations.Subtract(m1, m2);
                            resultSubtract.Display("resultante");
                            break;
                        case 3:
                            Matrix resultMultiply = matrixOperations.Multiply(m1, m2);
                            resultMultiply.Display("resultante");
                            break;
                        default:
                            Console.WriteLine("Opción inválida, intente de nuevo:");
                            break;
                    }
                }
                catch (ArgumentException e)
                {
                    Console.WriteLine($"Error: {e.Message}");
                }

                Console.Write("¿Desea realizar otra operación? (s/n): ");
                string response = Console.ReadLine()?.Trim().ToLower() ?? "n";
                if (response != "s")
                {
                    Console.WriteLine("Saliendo del programa.");
                    break;
                }
            }
        }
    }
}