package com.matrices;

import com.matrices.io.ConsoleInput;

public class MatrixFactory {
    public static Matrix createMatrix(int index) {
        int rows;
        int cols;
        do {
            rows = ConsoleInput.getInteger("Ingrese el número de filas de la matriz " + index + ": ");
            cols = ConsoleInput.getInteger("Ingrese el número de columnas de la matriz " + index + ": ");
            if (rows <= 0 || cols <= 0) {
                System.out.println("El número de filas y columnas debe ser positivo, intente de nuevo.");
            }
        } while (rows <= 0 || cols <= 0);

        int[][] data = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = ConsoleInput.getInteger("Ingrese el elemento [" + i + "][" + j + "]: ");
            }
        }
        return new Matrix(rows, cols, data);
    }
}