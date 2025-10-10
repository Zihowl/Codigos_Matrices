package matrices_kotlin

class Matriz(private val index: Int) {
    private val filas: Int
    private val columnas: Int
    private val datos: Array<Array<Int>>

    init {
        var temp_fil: Int
        var temp_col: Int
        do {
            print("\nIngrese el número de filas de la matriz $index: ")
            temp_fil = getEntero()
            print("Ingrese el número de columnas de la matriz $index: ")
            temp_col = getEntero()
            if (temp_fil <= 0 || temp_col <= 0) {
                println("El número de filas y columnas debe ser positivo, intente de nuevo.")
            }
        } while (temp_fil <= 0 || temp_col <= 0)

        filas = temp_fil
        columnas = temp_col

        datos = Array(filas) { Array(columnas) { 0 } }
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                print("Ingrese el elemento [$i][$j]: ")
                val entrada = getEntero()
                datos[i][j] = entrada
            }
        }
    }

    fun getFilas(): Int {
        return filas
    }

    fun getColumnas(): Int {
        return columnas
    }

fun sumar(otra: Matriz) {
    if (filas != otra.getFilas() || columnas != otra.getColumnas()) {
        println("Las matrices deben tener las mismas dimensiones para sumar")
        return
    }
    val resultado = Array(filas) { Array(columnas) { 0 } }
    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            resultado[i][j] = datos[i][j] + otra.datos[i][j]
        }
    }

    println("\nResultado de la suma:")
    for (i in 0 until filas) {
        print("[")
        for (j in 0 until columnas) {
            print("${resultado[i][j]} ")
        }
        println("\b]")
    }
}

fun restar(otra: Matriz) {
    if (filas != otra.getFilas() || columnas != otra.getColumnas()) {
        println("Las matrices deben tener las mismas dimensiones para restar")
        return
    }
    val resultado = Array(filas) { Array(columnas) { 0 } }
    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            resultado[i][j] = datos[i][j] - otra.datos[i][j]
        }
    }

    println("\nResultado de la resta:")
    for (i in 0 until filas) {
        print("[")
        for (j in 0 until columnas) {
            print("${resultado[i][j]} ")
        }
        println("\b]")
    }
}

fun multiplicar(otra: Matriz) { //La matriz resultante tiene las filas de la primera y las columnas de la segunda
    if (columnas != otra.getFilas()) {
        println("Las matrices deben tener dimensiones compatibles para multiplicar")
        return
    }
    val colsRes = otra.getColumnas()
    val resultado = Array(filas) { Array(colsRes) { 0 } }
    for (i in 0 until filas) { //i representa las filas de la primera
        for (j in 0 until colsRes) { //j representa las columnas de la segunda
            var suma = 0
            for (k in 0 until columnas) { //k representa las columnas de la primera y las filas de la segunda
                suma += datos[i][k] * otra.datos[k][j]
            }
            resultado[i][j] = suma
        }
    }

    println("\nResultado de la multiplicación:")
    for (i in 0 until filas) {
        print("[")
        for (j in 0 until colsRes) {
            print("${resultado[i][j]} ")
        }
        println("\b]")
    }
}

fun mostrar() {
    println("\nMatriz $index:")
    for (i in 0 until filas) {
        print("[")
        for (j in 0 until columnas) {
            print("${datos[i][j]} ")  
        }
        println("\b]")
    }
}

fun opsDisponibles(otra: Matriz) {
    val caso: Int
    println("\nOperaciones disponibles: ")
    if (filas == otra.getFilas() && columnas == otra.getColumnas()) {
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar\n")
        caso = 1
    } else if (columnas == otra.getFilas()) {
        println("3. Multiplicar\n")
        caso = 2
    } else {
        println("No hay operaciones disponibles entre las matrices.")
        return
    }

    print("Seleccione una operación: ")
    var opcion: Int
    if (caso == 1){
        do {
            opcion = getEntero()
            when (opcion) {
                1 -> sumar(otra)
                2 -> restar(otra)
                3 -> multiplicar(otra)
                else -> print("Opción inválida, intente de nuevo: ")
            }
        } while (opcion !in 1..3)
    } else if (caso == 2) {
        do {
            opcion = getEntero()
            when (opcion) {
                3 -> multiplicar(otra)
                else -> print("Opción inválida, intente de nuevo: ")
            }
        } while (opcion != 3)
    }
    
}
}