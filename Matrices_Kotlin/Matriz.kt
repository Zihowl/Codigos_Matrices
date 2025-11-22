package matrices_kotlin

class Matriz(val filas: Int, val columnas: Int, private val datos: Array<IntArray>) {

    init {
        require(datos.size == filas && datos.all { it.size == columnas }) {
            "Las dimensiones de los datos no coinciden con las filas y columnas especificadas."
        }
    }

    operator fun plus(otra: Matriz): Matriz {
        require(filas == otra.filas && columnas == otra.columnas) {
            "Las matrices deben tener las mismas dimensiones para sumar"
        }
        val res = Array(filas) { i ->
            IntArray(columnas) { j ->
                datos[i][j] + otra.datos[i][j]
            }
        }
        return Matriz(filas, columnas, res)
    }

    operator fun minus(otra: Matriz): Matriz {
        require(filas == otra.filas && columnas == otra.columnas) {
            "Las matrices deben tener las mismas dimensiones para restar"
        }
        val res = Array(filas) { i ->
            IntArray(columnas) { j ->
                datos[i][j] - otra.datos[i][j]
            }
        }
        return Matriz(filas, columnas, res)
    }

    operator fun times(otra: Matriz): Matriz {
        require(columnas == otra.filas) {
            "Las matrices deben tener dimensiones compatibles para multiplicar"
        }
        val colsRes = otra.columnas
        val res = Array(filas) { i ->
            IntArray(colsRes) { j ->
                var suma = 0
                for (k in 0 until columnas) {
                    suma += datos[i][k] * otra.datos[k][j]
                }
                suma
            }
        }
        return Matriz(filas, colsRes, res)
    }

    fun mostrar(titulo: String? = null) {
        if (titulo != null) {
            println("\nMatriz $titulo:")
        } else {
            println("\nMatriz:")
        }
        println(this.toString())
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (row in datos) {
            sb.append("[")
            sb.append(row.joinToString(" "))
            sb.append("]\n")
        }
        return sb.toString()
    }
}