package matrices_kotlin

fun getEntero(): Int {
    do {
        val entrada = readLine()?.toIntOrNull()
        if (entrada != null) {
            return entrada
        }
        print("Entrada inválida, intente de nuevo: ")
    } while (true)
}

fun main() {
    println("\n=== Operaciones con Matrices ===")
    val m1 = Matriz.crear(1)
    m1.mostrar()
    val m2 = Matriz.crear(2)
    m2.mostrar()

    do {
    println("Operaciones disponibles:")
    if (m1.getFilas() == m2.getFilas() && m1.getColumnas() == m2.getColumnas()) {
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar\n")
    } else if (m1.getColumnas() == m2.getFilas()) {
        println("3. Multiplicar\n")
    } else {
        println("No hay operaciones disponibles entre las matrices. Saliendo del programa.")
        return
    }

    var respuesta: String?

    do {
        print("Seleccione una operación: ")
        val opcion = getEntero()
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
                    println("Opción inválida, intente de nuevo:")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    } while (opcion !in 1..3)

            print("¿Desea realizar otra operación? (s/n): ")
            respuesta = readLine()?.trim()?.lowercase() ?: "n"
            if (respuesta != "s") {
                println("Saliendo del programa.")
                break
            }

    } while (respuesta == "s")
}