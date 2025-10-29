#!/usr/bin/env bash
set -euo pipefail

# Ajusta estas rutas si tus carpetas están en otra ubicación
CPP_DIR="/home/zihowl/Documentos/7mo/PAyPM/Codigos_Matrices/Matrices_Cpp"
CS_DIR="/home/zihowl/Documentos/7mo/PAyPM/Codigos_Matrices/Matrices_Cs"

echo "[run_all.sh] Compilando y ejecutando proyecto C++ en: $CPP_DIR"
cd "$CPP_DIR"
# Compila con la misma opción que usas en Code Runner
g++ -std=${CPPSTD:-c++17} -Wall *.cpp -o matriz
./matriz

echo "[run_all.sh] Ejecutando proyecto C# en: $CS_DIR"
cd "$CS_DIR"
dotnet run
