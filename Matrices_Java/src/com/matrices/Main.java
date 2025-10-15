package com.matrices;

import com.matrices.io.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Operaciones con Matrices ===");
        
        Matrix m1 = MatrixFactory.createMatrix(1);
        m1.display();
        
        Matrix m2 = MatrixFactory.createMatrix(2);
        m2.display();

        while (true) {
            System.out.println("Operaciones disponibles:");
            if (m1.getRows() == m2.getRows() && m1.getColumns() == m2.getColumns()) {
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar\n");
            } else if (m1.getColumns() == m2.getRows()) {
                System.out.println("3. Multiplicar\n");
            } else {
                System.out.println("No hay operaciones disponibles entre las matrices. Saliendo del programa.");
                return;
            }

            int option = ConsoleInput.getInteger("Seleccione una operación: ");
            try {
                switch (option) {
                    case 1:
                        Matrix resultAdd = MatrixOperations.add(m1, m2);
                        resultAdd.display("resultante");
                        break;
                    case 2:
                        Matrix resultSub = MatrixOperations.subtract(m1, m2);
                        resultSub.display("resultante");
                        break;
                    case 3:
                        Matrix resultMul = MatrixOperations.multiply(m1, m2);
                        resultMul.display("resultante");
                        break;
                    default:
                        System.out.println("Opción inválida, intente de nuevo:");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            String response = ConsoleInput.getString("¿Desea realizar otra operación? (s/n): ").trim().toLowerCase();
            if (!response.equals("s")) {
                System.out.println("Saliendo del programa.");
                break;
            }
        }
    }
}