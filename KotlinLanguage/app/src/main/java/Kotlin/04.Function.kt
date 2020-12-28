package Kotlin

/** 04. Function
 *  함수
 *  - 어떤 input을 넣어주면 어떤 output이 나오는 것
 *  - y = x + 2
 *
 *  함수를 선언하는 방법
 *   - fun 함수명 (변수명:타입 , 변수명:타입 ) : 반환형 {
 *          함수내용
 *          return 반환값
 *    }
 *
 *
 */

fun plus(first: Int, second: Int): Int {
    println(first)
    println(second)
    val result: Int = first + second
    println(result)
    return result
}

/** 디폴트 값을 갖는 함수 */
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result

}

/** 반환 값이 없는 함수
 * Unit -> return이 없다 , 생략가능하다
 * */
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    println(result)
}

fun printPlus2(first: Int, second: Int) {
    val result: Int = first + second
    println(result)
}


/** 간단하게 함수를 선언하는 방법 */
fun plusShort(first: Int, second: Int) = first + second


/** 가변인자를 갖는 함수 선언하는 방법 */
fun plusMany(vararg numbers: Int): Unit {
    for (number in numbers) {
        println(number)
    }
}


fun main(array: Array<String>) {
    // 함수를 호출하는 방법
    val result = plus(5, 10)
    println(result)

    // 인수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 30)
    println(result2)

    val result3 = plus(second = 100, first = 10)
    println(result3)

    val result4: Int = plusFive(10, 20)
    println(result4)

    val result5: Int = plusFive(10)
    println(result5)

    printPlus(10, 20)

    val result6 = plusShort(50, 50)
    println(result6)

    plusMany(1,2,3)
}