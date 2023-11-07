////////// Hola mundo con Kotlin -- Clase 7 / 37
fun main(args: Array<String>) {
 println("Hola Mundo")
}

////////// Variables en Kotlin -- Clase 8 / 37
const val PI = 3.1416
fun main(args: Array<String>) {
    var dinero = 10
    println(dinero)
    dinero = 5
    println(dinero)

    val nombre = "Maria"
    println(nombre)

    println(PI)
}

////////// Kotlin y sus tipos de variables -- Clase 9 / 37
fun main(args: Array<String>) {
    val boolean = true
    val numeroLong  = 3L
    val double = 2.7182
    val float = 1.1F

    val nombre = "Rubiel"
    println("mi nomnbre es $nombre")
}

////////// Estructuras de control: ifClase 13 / 37
fun main(args: Array<String>) {
    val nombre = "Maria"
    if(nombre.isNotEmpty()) println("Longitud ${nombre.length}") else println("La variable está vacía")

    val mensaje : String = if(nombre.length > 4 ){
        "Tu nombre es largo"
    }else if(nombre.isEmpty()){
        "Nombre vacío"
    }else{
        "Tienes un nombre corto"
    }
    println(mensaje)

}

////////// Estructuras de Control: when -- Clase 14 / 37
fun main(args: Array<String>) {
    val nombreColor = "Carmesi"

    when (nombreColor) {
        "Amarillo" -> println("Amarillo de alegría")
        "Rojo","Carmesí" -> println("Rojo y Carmesí, tonos de pasión")
        else -> println("Error, No tengo informacion del color")
    }

    val code = 404

    when(code){
        in 200..299 -> println("dento del rango 200 a 299")
        in 400..500 -> println("dentro del rango 400 a 500")
        else -> println("Codigo desconocido, algo ha fallado")
    }

    val tallaZapatos = 41
    val mensaje = when(tallaZapatos){
        41,43 -> "Tenemos disponible"
        42,44 -> "No hay disponibles"
        45 -> "Lo siento, no tenemos disponibles"
        else -> " Solo vienen en tallas 41,42,43,44 y 45"
    }

    println(mensaje)

}

////////// Bucles: While y Do WhileClase 15 / 37
fun main(args: Array<String>) {
    var contador = 10
    while (contador > 0){
        println("valor : $contador ")
        contador--
    }

    do{
        println("Generando numero aleatorio...")
        val numeroAleatorio = (0..100).random()
        println("Número aleatorio : $numeroAleatorio")
    } while (numeroAleatorio > 50)
}

////////// Ciclos --Clase 16 / 37
fun main(args: Array<String>) {
    val listaDeFrutas = listOf("Manzana","Pera","Frambuesa","Durazno")
    for(fruta in listaDeFrutas) println("Hoy comeré $fruta")

    listaDeFrutas.forEach{fruta -> println("Fruta : $fruta") }

    val caracteresDeFruta : List<Int> = listaDeFrutas.map { fruta -> fruta.length }
    println(caracteresDeFruta)

    val listaFiltrada = caracteresDeFruta.filter { lengthDeFruta -> lengthDeFruta > 5 }
    println(listaFiltrada)
}

////////// Null-Safety en Kotlin -- Clase 17 / 37 TEORICA

////////// Valores nulos, Double bang y cómo solucionarlos. -- Clase 18 / 37 TEORICA

////////// clase 19 - try catch
fun main(args: Array<String>) {
    var nombre : String? = null

    try{
        nombre!!.length
    } catch (exception : NullPointerException){
        println("Error  NullPointerException")
    } finally {
        println("finaliza proceso")
    }


    try{
        throw NullPointerException("Referencia Nula")
    } catch (exception : NullPointerException){
        println("Error  NullPointerException : " + exception.message)
    } finally {
        println("finaliza proceso 2")
    }

    val primeValor = 10
    val segundoValor = 0
    val resultado : Int = try {primeValor/segundoValor} catch (exception : Exception){0}
    println(resultado)
}

//////////Clase 20 - Elvis Operator
fun main(args: Array<String>) {
    var nombre : String? = null
    val caracteresDeNombre : Int = nombre?.length?: 0 // Se usa valor por defecto 0 - Elvis Operator
    println(caracteresDeNombre)
}

////////// Listas - Clase 21 / 37
fun main(args: Array<String>) {
    val listaDeNombre = listOf("Juan","Enrique","Camila") // inmutable
    println(listaDeNombre)

    val listaVacia = mutableListOf<String>()
    println(listaVacia)

    listaVacia.add("Juan")
    println(listaVacia)

    val valorUsandoGet = listaVacia.get(0)
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)

    val primerValor: String? = listaDeNombre.firstOrNull()
    println(primerValor)

    listaVacia.removeAt(0)
    println(listaVacia)

    listaVacia.add("Enrique")
    println(listaVacia)
    listaVacia.removeIf{caracteres -> caracteres.length > 4}
    println(listaVacia)

    val myArray = arrayOf(1,2,3,4)
    println("Nuestro Array $myArray")
    println("Array como lista ${myArray.toList()}")

    // para un super performance usar array de lo contraio listas
}

//////////Como ordenar listas con las funciones que tiene Kotlin - Clase 22 / 37
fun main(args: Array<String>) {
    val numeroDeLoteria = listOf(11,22,43,56,78,66)

    val numerosSorted = numeroDeLoteria.sorted()
    println(numerosSorted)

    val numerosDeLoteriaDescendentes = numeroDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendentes)

    // los numeros menores a 50 se colocan al final de la lista
    val ordernarPorMultiplos = numeroDeLoteria.sortedBy { numero -> numero < 50 }
    println(ordernarPorMultiplos)

    val numerosAleatorios = numeroDeLoteria.shuffled()
    println(numerosAleatorios) // se ordena de forma aleatoria

    val numerosEnReversa = numeroDeLoteria.reversed()
    println(numerosEnReversa) // se ordenar al contrario

    val mensajesDenumeros = numeroDeLoteria.map { num -> "Tu número de loteria es $num" }
    println(mensajesDenumeros)

    val numerosFilrados = numeroDeLoteria.filter { num -> num > 50 }
    println(numerosFilrados)
}

//////////Maps - Clase 23 / 37
fun main(args: Array<String>) {
    val edadSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )

    println(edadSuperHeroes)

    val edadSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )

    println(edadSuperHeroesMutable)

    edadSuperHeroesMutable.put("Wolverine",45)
    println(edadSuperHeroesMutable)

    edadSuperHeroesMutable["Storm"] = 30
    println(edadSuperHeroesMutable)

    val edadIronMan = edadSuperHeroesMutable["Ironman"]
    println(edadIronMan)

    edadSuperHeroesMutable.remove("Wolverine")
    println(edadSuperHeroesMutable)

    println(edadSuperHeroesMutable.keys)

    println(edadSuperHeroesMutable.values)
}

//////////Sets Clase 24 / 37
fun main(args: Array<String>) {
    val vocalesRepetidas = setOf("a","e","i","o","u","a","e","i")
    println(vocalesRepetidas) // setOf elimina duplicados

    val numerosfavoritos = mutableSetOf(1,2,3,4)
    println(numerosfavoritos)

    numerosfavoritos.add(5)
    numerosfavoritos.add(5)
    println(numerosfavoritos) // no permite agregar valores duplicados

    numerosfavoritos.remove(5)
    println(numerosfavoritos)

    val valorDelSet: Int? = numerosfavoritos.firstOrNull(){ num -> num > 2}
    println(valorDelSet)
}

//////////¿Qué son las funciones? - Clase 25 / 37 - TEORICA

//////////Funciones y funciones de extensión -- Clase 26 / 37
fun main(args: Array<String>) {
    val fraseAleatoria = "En PLATZI nunca paramos de aprender"
    imprimirFrase(randomCase(fraseAleatoria))

    // funcion de extension
    val fraseAleatoria2 = "En PLATZI nunca paramos de aprender".randomCase2()
    imprimirFrase(fraseAleatoria2)
}

fun imprimirFrase(frase : String) : Unit{
    println("Tu frase es : $frase")
}

fun randomCase(frase : String): String {
    val numeroAleatorio = 0..99
    val resultadoAletorio = numeroAleatorio.random()

    return if(resultadoAletorio.rem(2) == 0){
        frase.uppercase()
    } else {
        frase.lowercase()
    }
}

// funcion de extension
fun String.randomCase2(): String {
    val numeroAleatorio = 0..99
    val resultadoAletorio = numeroAleatorio.random()

    return if(resultadoAletorio.rem(2) == 0){
        this.uppercase()
    } else {
        this.lowercase()
    }
}

//////////Tipos de parámetros en las funcionesClase 27 / 37
fun main(args: Array<String>) {
    imprimirNombre(nombre = "Rubiel", apellido = "Chapal")
}
fun imprimirNombre( nombre: String, segundoNombre: String = "", apellido: String){
    println("Mi nombre es $nombre $segundoNombre $apellido")
}

//////////Lambdas - Clase 28 / 37
fun main(args: Array<String>) {
    val myLambda : (String) -> Int = {valor -> valor.length}
    val lambdaEjecutada: Int = myLambda("Hola Platzi")
    println(lambdaEjecutada)

    val saludos = listOf("Hello", "Hola", "Ciao")

    val longituDeSaludos = saludos.map(myLambda)
    println(longituDeSaludos)
}

//////////High Order functions -- Clase 29 / 37
fun main(args: Array<String>) {
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!", block = {
            valor -> valor.length
    })
    println(largoDelValorInicial)

    // sin los parametros nombrados
    val largoDelValorInicial2 = superFuncion(valorInicial = "Hola!") { valor ->
        valor.length
    }
    println(largoDelValorInicial2)

    val lambda : () -> String = funcionInception("Enrique")
    val valorLambda : String = lambda()
    println(valorLambda)
}
fun superFuncion(valorInicial : String, block : (String) -> Int) : Int {
    return block(valorInicial)
}

fun funcionInception(nombre : String) : () -> String{
    return {
        "Hola desde la lambda $nombre"
    }
}

//////////Let -- Clase 30 / 37
// let evita el nullponterException
fun main(args: Array<String>) {
    var nombre : String? = null
    nombre?.let {
        valor -> println("El nombre no es nulo $nombre")
    }

    nombre = "Rubiel"
    nombre.let {
            valor -> println("El nombre no es nulo $nombre")
    }
}

////////// With -- Clase 31 / 37
// La función with nos ayuda a acceder directamente a las propiedades de la variable o a la misma variable utilizando this
fun main(args: Array<String>) {
    val colores = listOf("Azul","Amarillo","rojo")
    with(colores){
        println("Nuestos colores $this")
        println("Cantidad de colores $size")
    }
}

//////////Run -- Clase 32 / 37
// https://kotlin.desarrollador-android.com/modismos-y-patrones/funciones-estandar/run/
fun main(args: Array<String>) {
    val moviles = mutableListOf("Google Pixel 2XL","Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf{movil -> movil.contains("Google")}
            this
        }
    println(moviles)
}

////////// Apply -- Clase 33 /
/*
El propósito de la función apply es tomar como alcance al objeto recibidor T
sobre el que es invocado, aplicar las sentencias
del parámetro block que recibe sobre dicho contexto y retornar el mismo objeto modificado.

La función apply trabaja similar a with, solo que apply es una función de extensión y retorna al objeto recibidor como resultado.

Esto te permite inicializar propiedades cuando creas u obtienes instancias de una clase e incluso encadenar operaciones subsecuentes.

Ejemplo Con La Función apply Tomemos como ejemplo la declaración de una clase que representa un par de zapatos en el inventario de un negocio.
*/
fun main(args: Array<String>) {
    val moviles = mutableListOf("Google Pixel 2XL","Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .apply { removeIf{movil -> movil.contains("Google")} }
    println(moviles)

    val colores: List<String>? = null
    colores?.apply {
        println("Colores son $this")
        println("cantidad de colores es $size")
    }

    val colors : MutableList<String> = mutableListOf("Amarillo","Azul","Rojo")
    colors.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size")
    }
}

//////////Also -- Clase 34 / 37
/*
apply y also devuelve el objeto contexto directamente. let, run, y with retorna el último valor de la lambda.

 La función also es otra función de alcance, cuyo objetivo es permitirte añadir acciones adicionales sobre un objeto, a través de una lambda regular como parámetro.

Su uso se traduce a «y también hacer lo siguiente con el objeto».
 */
fun main(args: Array<String>) {
    val moviles = mutableListOf("Google Pixel 2XL","Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .also {
            lista -> println("El valor original de la lista es $lista")
        }.asReversed()

    println(moviles)
}



//////////Creando el menú de nuestra bola mágica -- Clase 35 / 37
//////////Contestando aleatoriamente -- Clase 36 / 37

// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)

fun main() {
    // Declarar el mensaje de entrada del programa
    println("Hola soy tu bola 8 magica creada en Kotlin. ¿Cual de estas opciones deseas realizar? ")
    println("1. Realizar una pregunta.")
    println("2. Revisar todas las respuestas.")
    println("3. Salir")

    // Obtener el valor del usuario y convertirlo a un entero nullable
    val valorIngresado = readLine()

    // Dependiendo del numero utilizamos el when para realizar una acción.
    when (valorIngresado){
        "1" -> realizarPregunta()
        "2" -> mostrarRespuestas()
        "3" -> salir()
        else -> mostrarError()
    }

}

//Mostramos un error por pantalla
fun mostrarError() {
    println("Vaya parece que has elegido una opción no valida, intenta de nuevo.")
}

//Mostramos un mensaje de despedida por pantalla
fun salir() {
    println("¡Hasta luego!")
}

//Mostramos un menu para seleccionar una de las opciones al usuario
fun mostrarRespuestas() {
    println("Selecciona una opción")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas afirmativas")
    println("3. Revisar solo las respuestas dudodas")
    println("4. Revisar solo las respuestas negativas")

    val opcionIngresada = readLine()?.toInt()
    when(opcionIngresada){
        1 ->  mostrarRespuestasPorTipo()
        2 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        3 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        4 -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        else -> println("Respuesta no valida, adios.")
    }

}

// Mostramos las respuestas dependiendo del tipo que se pase como parametro
fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS") {
    when (tipoDeRespuesta){
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }
        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }

        RESPUESTA_NEGATIVA -> respuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }

        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }
    }
}

// Preguntamos al usuario que deberiamos mostrarle y le mostramos una respuesta al azar
fun realizarPregunta() {
    println("¿Que preguntas deseas realizar?")
    readLine()
    println("Asi que esa es tu pregunta... La respuesta a eso es:")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}

//////////
fun main(args: Array<String>) {

}