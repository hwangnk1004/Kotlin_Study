package Kotlin


fun plusThree(first: Int, second: Int, third: Int): Int {
    val result: Int = first + second + third
    return result
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun multiplyThree(first: Int = 1, second: Int = 1, third: Int = 1): Int {
    val result = first * second * third
    return result
}

/** 내부함수
 *  - 함수 안에 함수가 있다 */
fun showMyPlus(first: Int, second: Int) : Int {
    println(first)
    println(second)

    fun plus(first: Int, second: Int) : Int {
        return first + second
    }

    return plus(first , second)
}


fun main(array: Array<String>) {
    val result = plusThree(1, 2, 3)
    println(result)

    val result2 = minusThree(10, 1, 2)
    println(result2)

    val result3 = multiplyThree(2, 2, 2)
    println(result3)

    val result4 = multiplyThree()
    println(result4)

    val result5 = showMyPlus(100,300)
    println(result5)

}