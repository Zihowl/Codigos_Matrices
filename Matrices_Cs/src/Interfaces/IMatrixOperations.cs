namespace Matrices_Cs.Interfaces
{
    using Matrices_Cs.Models;

    public interface IMatrixOperations
    {
        Matrix Add(Matrix a, Matrix b);
        Matrix Subtract(Matrix a, Matrix b);
        Matrix Multiply(Matrix a, Matrix b);
    }
}