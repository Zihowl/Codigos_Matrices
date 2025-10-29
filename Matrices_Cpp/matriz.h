#ifndef MATRIZ_H
#define MATRIZ_H

#include <vector>
#include <string>

using namespace std;

class Matriz {
    private:

    string index;
    unsigned int filas;
    unsigned int columnas;
    vector<vector<int>> datos;
    void crearMatriz();
    bool dimensionesIguales(const Matriz& otra) const;

    public:
    Matriz(string _index);
    Matriz(unsigned int filas, unsigned int columnas, string _index = "Resultante");
    unsigned int getFilas() const;
    unsigned int getColumnas() const;
    
    Matriz operator+ (const Matriz& otra) const;
    Matriz operator- (const Matriz& otra) const;
    Matriz operator* (const Matriz& otra) const;
    void mostrar();
};

#endif // MATRIZ_H