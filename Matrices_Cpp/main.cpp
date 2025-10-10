#include <iostream>
#include "matriz.h"

using namespace std;

int main() {
    Matriz m1(1);
    cout << "Matriz 1: " << m1.getFilas() << "x" << m1.getColumnas() << endl;
    Matriz m2(2);
    return 0;
}