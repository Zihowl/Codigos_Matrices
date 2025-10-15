using System;

namespace Matrices_Cs.Models
{
    public class Matrix
    {
        private readonly int[,] _data;
        public int Rows { get; }
        public int Columns { get; }

        public Matrix(int rows, int cols)
        {
            if (rows <= 0 || cols <= 0) throw new ArgumentException("Filas y columnas deben ser positivas.");
            Rows = rows;
            Columns = cols;
            _data = new int[rows, cols];
        }

        public int this[int r, int c]
        {
            get => _data[r, c];
            set => _data[r, c] = value;
        }

        public static Matrix Create(int index)
        {
            Console.Write($"Ingrese el número de filas de la matriz {index}: ");
            int rows = Utilities.ConsoleInput.GetInteger();
            Console.Write($"Ingrese el número de columnas de la matriz {index}: ");
            int cols = Utilities.ConsoleInput.GetInteger();
            var m = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                {
                    Console.Write($"Ingrese el elemento [{i}][{j}]: ");
                    m[i, j] = Utilities.ConsoleInput.GetInteger();
                }
            return m;
        }

        public void Display(string label = "")
        {
            if (!string.IsNullOrEmpty(label))
                Console.WriteLine($"\nMatriz {label}:");
            else
                Console.WriteLine("\nMatriz:");
            for (int i = 0; i < Rows; i++)
            {
                Console.Write("[ ");
                for (int j = 0; j < Columns; j++)
                {
                    Console.Write($"{_data[i, j]} ");
                }
                Console.WriteLine("]");
            }
            Console.WriteLine();
        }
    }
}