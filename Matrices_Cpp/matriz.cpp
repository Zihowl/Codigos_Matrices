#include "matriz.h"
#include <iostream>

using namespace std;

Matriz::Matriz(string _index) : index(_index) {

    cout << "Ingrese el numero de filas de la matriz " << _index << ": ";
    cin >> filas;
    cout << "Ingrese el numero de columnas de la matriz " << _index << ": ";
    cin >> columnas;

    crearMatriz();
}


Matriz::Matriz(unsigned int filas, unsigned int columnas, string _index) : index(_index), filas(filas), columnas(columnas) {
    datos.resize(filas, vector<int>(columnas, 0));
}

void Matriz::crearMatriz() {
    datos.resize(filas, vector<int>(columnas, 0));
    for (unsigned int i = 0; i < filas; i++) {
        for (unsigned int j = 0; j < columnas; j++) {
            cout << "Ingrese el elemento [" << i << "][" << j << "]: ";
            cin >> datos[i][j];
        }
    }
}

unsigned int Matriz::getFilas() const {
    return filas;
}

unsigned int Matriz::getColumnas() const {
    return columnas;
}

Matriz Matriz::operator+(const Matriz& otra) const {
    if (filas != otra.filas || columnas != otra.columnas) {
        cout << "Error: Las matrices deben tener las mismas dimensiones para sumar." << endl;
        return Matriz(0, 0);
    }
    Matriz resultado(filas, columnas, "Resultante");

    for (unsigned int i = 0; i < filas; i++) {
        for (unsigned int j = 0; j < columnas; j++) {
            resultado.datos[i][j] = datos[i][j] + otra.datos[i][j];
        }
    }
    return resultado;
}

Matriz Matriz::operator-(const Matriz& otra) const {
    if (filas != otra.filas || columnas != otra.columnas) {
        cout << "Error: Las matrices deben tener las mismas dimensiones para restar." << endl;
        return Matriz(0, 0);
    }

    Matriz resultado(filas, columnas, "Resultante");
    for (unsigned int i = 0; i < filas; i++) {
        for (unsigned int j = 0; j < columnas; j++) {
            resultado.datos[i][j] = datos[i][j] - otra.datos[i][j];
        }
    }
    return resultado;
}

Matriz Matriz::operator*(const Matriz& otra) const {
    if (columnas != otra.filas) {
        cout << "Error: Las matrices no se pueden multiplicar." << endl;
        return Matriz(0, 0);
    }

    Matriz resultado(filas, otra.columnas, "Resultante");
    for (unsigned int i = 0; i < filas; i++) { // i representa las filas de la primera matriz
        for (unsigned int j = 0; j < otra.columnas; j++) { // j representa las columnas de la segunda matriz
            for (unsigned int k = 0; k < columnas; k++) { // k representa las columnas de la primera matriz y las filas de la segunda
                resultado.datos[i][j] += datos[i][k] * otra.datos[k][j];
            }
        }
    }
    return resultado;
}

void Matriz::mostrar() {
    cout << "\nMatriz " << index << ":" << endl;
    for (unsigned int i = 0; i < filas; i++) {
        cout << "[";
        for (unsigned int j = 0; j < columnas; j++) {
            cout << datos[i][j] << " ";
        }
        cout  << "\b]" << endl;
    }
    cout << endl;
}