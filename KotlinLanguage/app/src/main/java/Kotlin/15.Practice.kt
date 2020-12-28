package Kotlin


fun main (array: Array<String>) {

    var a = mutableListOf<Int>(1,2,3)
    a.add(4)
    println(a)
    a.add(0,100)
    println(a)
    a.set(0,200) /** 해당 인덱스 값을 바꿀 때 set 사용*/
    println(a)
    a.removeAt(1) /** 해당 인덱스 값을 지울 때 removeAt 사용*/
    println(a)

    var b = mutableSetOf<Int>(1,2,3,4)
    b.add(2)
    println(b)
    b.remove(3) /** 해당 값을 지울 때 remove 사용*/
    println(b)
    b.remove(100)
    println(b)

    var c = mutableMapOf<String, Int>("one" to 1)
    c.put("two",2)
    println(c)
    c.replace("two", 3) /** 해당 값을 바꿀 때 replace 사용*/
    println(c)
    println(c.keys) /** 맵에 저장된 key만 확인할 때*/
    println(c.values) /** 맵에 저장된 value만 확인할 때*/
    c.clear() /** 맵에 저장된 모든 것 삭제할 때*/
    println(c)

}