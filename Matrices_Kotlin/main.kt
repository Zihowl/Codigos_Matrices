package matrices_kotlin

fun getEntero(mensaje: String? = null): Int {
    if (mensaje != null) {
        print(mensaje)
    }
    do {
        val entrada = readlnOrNull()?.toIntOrNull()
        if (entrada != null) {
            return entrada
        }
        print("Entrada inválida, intente de nuevo: ")
    } while (true)
}

fun crearMatriz(index: Int): Matriz {
    var filas: Int
    var columnas: Int
    do {
        filas = getEntero("Ingrese el número de filas de la matriz $index: ")
        columnas = getEntero("Ingrese el número de columnas de la matriz $index: ")
        if (filas <= 0 || columnas <= 0) {
            println("El número de filas y columnas debe ser positivo, intente de nuevo.")
        }
    } while (filas <= 0 || columnas <= 0)

    val datos = Array(filas) { IntArray(columnas) }
    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            datos[i][j] = getEntero("Ingrese el elemento [$i][$j]: ")
        }
    }
    return Matriz(filas, columnas, datos)
}

fun main() {
    println("\n=== Operaciones con Matrices ===")
    val m1 = crearMatriz(1)
    m1.mostrar("1")
    val m2 = crearMatriz(2)
    m2.mostrar("2")

    do {
        println("Operaciones disponibles:")
        if (m1.filas == m2.filas && m1.columnas == m2.columnas) {
            println("1. Sumar")
            println("2. Restar")
            println("3. Multiplicar\n")
        } else if (m1.columnas == m2.filas) {
            println("3. Multiplicar\n")
        } else {
            println("No hay operaciones disponibles entre las matrices. Saliendo del programa.")
            return
        }

        var respuesta: String?

        do {
            val opcion = getEntero("Seleccione una operación: ")
            try {
                when (opcion) {
                    1 -> {
                        val r = m1 + m2
                        r.mostrar("resultante")
                    }
                    2 -> {
                        val r = m1 - m2
                        r.mostrar("resultante")
                    }
                    3 -> {
                        val r = m1 * m2
                        r.mostrar("resultante")
                    }
                    else -> {
                        println("Opción inválida, intente de nuevo.")
                    }
                }
            } catch (e: IllegalArgumentException) {
                println("Error: ${e.message}")
            }
        } while (opcion !in 1..3)

        print("¿Desea realizar otra operación? (s/n): ")
        respuesta = readlnOrNull()?.trim()?.lowercase() ?: "n"
        if (respuesta != "s") {
            println("Saliendo del programa.")
            break
        }

    } while (respuesta == "s")
}