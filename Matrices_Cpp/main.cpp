#include <iostream>
#include "matriz.h"

using namespace std;

int getEntero() {
    int numero;
    while (!(cin >> numero)) {
        cin.clear(); // Para limpiar el estado de error
        cin.ignore(10000, '\n'); // Descarta la entrada no valida
        cout << "Entrada invalida, intente de nuevo: ";
    }
    return numero;
}

int main() {
    cout << "\n=== Operaciones con Matrices ===" << endl;
    Matriz m1("1");
    m1.mostrar();
    Matriz m2("2");
    m2.mostrar();

    char respuesta;
    do {
        cout << "Operaciones disponibles:" << endl;
        bool sumRest = (m1.getFilas() == m2.getFilas() && m1.getColumnas() == m2.getColumnas());
        bool mult = (m1.getColumnas() == m2.getFilas());

        if (sumRest) {
            cout << "1. Sumar" << endl;
            cout << "2. Restar" << endl;
            cout << "3. Multiplicar\n" << endl;
        } else if (mult) {
            cout << "3. Multiplicar\n" << endl;
        } else {
            cout << "No hay operaciones disponibles entre las matrices. Saliendo del programa." << endl;
            return 0;
        }

        int opcion;
        do {
            cout << "Seleccione una operacion: ";
            opcion = getEntero();

            if ((opcion == 1 || opcion == 2) && !sumRest) {
                cout << "Opcion invalida, intente de nuevo:" << endl;
                continue;
            }
            if (opcion == 3 && !mult) {
                cout << "Opcion invalida, intente de nuevo:" << endl;
                continue;
            }

            switch (opcion) {
                case 1: {
                    Matriz resultado = m1 + m2;
                    resultado.mostrar();
                    break;
                }
                case 2: {
                    Matriz resultado = m1 - m2;
                    resultado.mostrar();
                    break;
                }
                case 3: {
                    Matriz resultado = m1 * m2;
                    resultado.mostrar();
                    break;
                }
                default:
                    cout << "Opcion invalida, intente de nuevo:" << endl;
                    continue;
            }
            break;
        } while (true);

        cout << "¿Desea realizar otra operacion? (s/n): ";
        cin >> respuesta;
        if (respuesta != 's' && respuesta != 'S') {
            cout << "Saliendo del programa." << endl;
            break;
        }

    } while (respuesta == 's' || respuesta == 'S');

    return 0;
}