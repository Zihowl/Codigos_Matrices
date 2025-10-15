using System;
using Matrices_Cs.Interfaces;
using Matrices_Cs.Models;

namespace Matrices_Cs.Services
{
    public class MatrixOperationsService : IMatrixOperations
    {
        public Matrix Add(Matrix a, Matrix b)
        {
            if (a.Rows != b.Rows || a.Columns != b.Columns) throw new ArgumentException("Dimensiones incompatibles para sumar.");
            var res = new Matrix(a.Rows, a.Columns);
            for (int i = 0; i < a.Rows; i++)
                for (int j = 0; j < a.Columns; j++)
                    res[i, j] = a[i, j] + b[i, j];
            return res;
        }

        public Matrix Subtract(Matrix a, Matrix b)
        {
            if (a.Rows != b.Rows || a.Columns != b.Columns) throw new ArgumentException("Dimensiones incompatibles para restar.");
            var res = new Matrix(a.Rows, a.Columns);
            for (int i = 0; i < a.Rows; i++)
                for (int j = 0; j < a.Columns; j++)
                    res[i, j] = a[i, j] - b[i, j];
            return res;
        }

        public Matrix Multiply(Matrix a, Matrix b)
        {
            if (a.Columns != b.Rows) throw new ArgumentException("Dimensiones incompatibles para multiplicar.");
            var res = new Matrix(a.Rows, b.Columns);
            for (int i = 0; i < a.Rows; i++)
                for (int j = 0; j < b.Columns; j++)
                {
                    int sum = 0;
                    for (int k = 0; k < a.Columns; k++)
                        sum += a[i, k] * b[k, j];
                    res[i, j] = sum;
                }
            return res;
        }
    }
}