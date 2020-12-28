package Kotlin

fun main(array: Array<String>) {

    var a: Int? = null
    var b: Int = 10
    var c: Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b + c == 110) {
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }

    /** 엘비스 연산자
     * -> 코틀린 언어가 가진 특징 */
    var number : Int? = 100
    var number2 = number ?: 10
    println()
    println(number2)

    var num1 : Int = 10
    var num2 : Int = 20

    var max = if (num1 > num2) {
        num1
    } else if (num1 == num2) {
        num2
    } else{
        100
    }





}