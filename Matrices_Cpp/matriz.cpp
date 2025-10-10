#include "matriz.h"
#include <iostream>

using namespace std;

Matriz::Matriz(unsigned int _index) {
    index = _index;
    cout << "Ingrese el numero de filas de la matriz " << index << ": ";
    cin >> filas;
    cout << "Ingrese el numero de columnas de la matriz " << index << ": ";
    cin >> columnas;
}

    unsigned int Matriz::getFilas() const {
        return filas;
    }

    unsigned int Matriz::getColumnas() const {
        return columnas;
    }

    void Matriz::suma(const Matriz& otra) {
        if (filas != otra.filas || columnas != otra.columnas) {
            cout << "Error: Las matrices deben tener las mismas dimensiones para sumar." << endl;
            return;
        }

        for (unsigned int i = 0; i < filas; i++) {
            for (unsigned int j = 0; j < columnas; j++) {
                datos[i][j] += otra.datos[i][j];
            }
        }
    }

    void Matriz::resta(const Matriz& otra) {
        if (filas != otra.filas || columnas != otra.columnas) {
            cout << "Error: Las matrices deben tener las mismas dimensiones para restar." << endl;
            return;
        }

        for (unsigned int i = 0; i < filas; i++) {
            for (unsigned int j = 0; j < columnas; j++) {
                datos[i][j] -= otra.datos[i][j];
            }
        }
    }

    void Matriz::multiplicacion(const Matriz& otra) {
        if (columnas != otra.filas) {
            cout << "Error: Las matrices no se pueden multiplicar." << endl;
            return;
        }

        Matriz resultado(filas);
        for (unsigned int i = 0; i < filas; i++) {
            for (unsigned int j = 0; j < otra.columnas; j++) {
                for (unsigned int k = 0; k < columnas; k++) {
                    resultado.datos[i][j] += datos[i][k] * otra.datos[k][j];
                }
            }
        }
    }
    void Matriz::mostrar() {
        for (unsigned int i = 0; i < filas; i++) {
            for (unsigned int j = 0; j < columnas; j++) {
                cout << datos[i][j] << " ";
            }
            cout << endl;
        }
    }
    void Matriz::opDisponibles() {
        cout << "Operaciones disponibles:" << endl;
        cout << "1. Suma" << endl;
        cout << "2. Resta" << endl;
        cout << "3. Multiplicacion" << endl;
    }
