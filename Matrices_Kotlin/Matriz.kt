package matrices_kotlin

class Matriz private constructor(
    private val _filas: Int,
    private val _columnas: Int,
    private val _datos: Array<IntArray>,
    private val _index: Int = 0
) {

    companion object {
        fun crear(index: Int): Matriz {
            var temp_fil: Int
            var temp_col: Int
            do {
                print("Ingrese el número de filas de la matriz $index: ")
                temp_fil = getEntero()
                print("Ingrese el número de columnas de la matriz $index: ")
                temp_col = getEntero()
                if (temp_fil <= 0 || temp_col <= 0) {
                    println("El número de filas y columnas debe ser positivo, intente de nuevo.")
                }
            } while (temp_fil <= 0 || temp_col <= 0)

            val datos = Array(temp_fil) { IntArray(temp_col) { 0 } }
            for (i in 0 until temp_fil) {
                for (j in 0 until temp_col) {
                    print("Ingrese el elemento [$i][$j]: ")
                    datos[i][j] = getEntero()
                }
            }
            return Matriz(temp_fil, temp_col, datos, index)
        }
    }

    operator fun plus(otra: Matriz): Matriz {
        require(_filas == otra._filas && _columnas == otra._columnas) {
            "Las matrices deben tener las mismas dimensiones para sumar"
        }
        val res = Array(_filas) { IntArray(_columnas) }
        for (i in 0 until _filas)
            for (j in 0 until _columnas)
                res[i][j] = _datos[i][j] + otra._datos[i][j]
        return Matriz(_filas, _columnas, res)
    }

    operator fun minus(otra: Matriz): Matriz {
        require(_filas == otra._filas && _columnas == otra._columnas) {
            "Las matrices deben tener las mismas dimensiones para restar"
        }
        val res = Array(_filas) { IntArray(_columnas) }
        for (i in 0 until _filas)
            for (j in 0 until _columnas)
                res[i][j] = _datos[i][j] - otra._datos[i][j]
        return Matriz(_filas, _columnas, res)
    }

    operator fun times(otra: Matriz): Matriz {
        require(_columnas == otra._filas) {
            "Las matrices deben tener dimensiones compatibles para multiplicar"
        }
        val colsRes = otra._columnas
        val res = Array(_filas) { IntArray(colsRes) }
        for (i in 0 until _filas) { //i representa las filas de la primera
            for (j in 0 until colsRes) { //j representa las columnas de la segunda
                var suma = 0
                for (k in 0 until _columnas) { //k representa las columnas de la primera y las filas de la segunda
                    suma += _datos[i][k] * otra._datos[k][j]
                }
                res[i][j] = suma
            }
        }
        return Matriz(_filas, colsRes, res)
    }

    fun getFilas(): Int {
        return _filas
    }

    fun getColumnas(): Int {
        return _columnas
    }

    fun mostrar(default: String = "\b") {
        if (_index != 0) {
            println("\nMatriz $_index:")
        }
        else {
            println("\nMatriz $default:")
        }

    for (i in 0 until _filas) {
        print("[")
        for (j in 0 until _columnas) {
            print("${_datos[i][j]} ")
        }
        println("\b]")
    }
    println()
    }
}