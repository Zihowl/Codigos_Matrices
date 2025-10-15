package com.matrices;

public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public Matrix(int rows, int columns, int[][] data) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, columns);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getData() {
        int[][] copy = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, copy[i], 0, columns);
        }
        return copy;
    }

    public void display() {
        display("Matriz");
    }

    public void display(String label) {
        System.out.println();
        System.out.println(label + ":");
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + (j + 1 < columns ? " " : ""));
            }
            System.out.println("]");
        }
        System.out.println();
    }

    void setElement(int row, int col, int value) {
        data[row][col] = value;
    }

    int getElement(int row, int col) {
        return data[row][col];
    }
}