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
    val m1 = Matriz(1)
    m1.mostrar()
    val m2 = Matriz(2)
    m2.mostrar()
    m1.opsDisponibles(m2)
}