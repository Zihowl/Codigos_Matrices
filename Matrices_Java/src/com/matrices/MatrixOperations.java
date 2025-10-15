package com.matrices;

public class MatrixOperations {
    public static Matrix add(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para sumar");
        }
        int rows = a.getRows();
        int cols = a.getColumns();
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[i][j] = a.getElement(i, j) + b.getElement(i, j);
        return new Matrix(rows, cols, res);
    }

    public static Matrix subtract(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para restar");
        }
        int rows = a.getRows();
        int cols = a.getColumns();
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res[i][j] = a.getElement(i, j) - b.getElement(i, j);
        return new Matrix(rows, cols, res);
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getColumns() != b.getRows()) {
            throw new IllegalArgumentException("Las matrices deben tener dimensiones compatibles para multiplicar");
        }
        int rows = a.getRows();
        int cols = b.getColumns();
        int common = a.getColumns();
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += a.getElement(i, k) * b.getElement(k, j);
                }
                res[i][j] = sum;
            }
        }
        return new Matrix(rows, cols, res);
    }
}