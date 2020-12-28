package Kotlin

/** */

fun main(array: Array<String>) {

    var array = arrayOf<Int>(1,2,3)

    /** Array의 Bounds
     * - 처음 만들 때 결정된다 */
    println(array.get(0))

    array.set(0,100)
    println(array[0])

    /** Array 만드는 방법(3) */
    var a1 = intArrayOf(1,2,3)
    var b2 = charArrayOf('a','b','c')
    var b3 = doubleArrayOf(1.1,100.345)
    var b4 = booleanArrayOf(true, false)

    /** Array 만드는 방법(4)
     * 람다를 활용한 방법 */
    var a5 = Array(10,{ 0 })
    var a6 = Array(5,{1;2;3;4;5})


}