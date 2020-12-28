package Kotlin

/** Collection
 *  -> list, set, map */


fun main(array: Array<String>) {

    /** Immutable Collection
     * -> 값을 바꿀수 없는 콜렉션 */

    /** List
     * 중복을 허용한다 */
    var numberList = listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    /** Set
     * 중복을 허용하지 않는다
     * 순서가 없기 때문에 인덱스가 존재 하지 않는다 */
    var numberSet = setOf<Int>(1, 2, 3, 3, 3)
    println(numberSet)

    /** Map
     * key, value 방식으로 관리한다 */
    var numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println(numberMap.get("two"))


    /** Mutable Collection
     * -> 값을 바꿀수 있는 콜렉션 */
    var mnumberList = mutableListOf<Int>(1,2,3)
    mnumberList.add(mnumberList.size,4)
    println(mnumberList)

    var mNumberSet = mutableSetOf<Int>(1,2,3,4,4,4)
    mNumberSet.add(8)
    println(mNumberSet)

    var mNumberMap = mutableMapOf<String, Int>("one" to 1, "two" to 2)
    mNumberMap.put("three" , 3)
    println(mNumberMap)



}