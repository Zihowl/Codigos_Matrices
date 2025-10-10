#ifndef MATRIZ_H
#define MATRIZ_H

// #include <vector>

using namespace std;

class Matriz {
    private:
    int index;
    unsigned int filas;
    unsigned int columnas;
    int datos[10][10];
    // vector<vector<int>> datos;

    public:
    Matriz(unsigned int _index);
    unsigned int getFilas() const;
    unsigned int getColumnas() const;
    void suma(const Matriz& otra);
    void resta(const Matriz& otra);
    void multiplicacion(const Matriz& otra);
    void mostrar();
    void opDisponibles();
};

#endif // MATRIZ_H