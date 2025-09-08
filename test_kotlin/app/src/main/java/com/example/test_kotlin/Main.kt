package com.example.test_kotlin

fun main() {
        val list: List<String> = listOf("Apple", "Banana", "Cherry", "Banana")
        println(list.joinToString(separator = " | ", limit = 2, truncated = "... and more", transform = {it.uppercase()}))
//        println("get(1): ${list.get(1)}")
//        println("list[2]: ${list[2]}")
//        println("first(): ${list.first()}")
//        println("last(): ${list.last()}")
//        println("elementAt(0): ${list.elementAt(0)}")
//        println("indexOf(\"Banana\"): ${list.indexOf("Banana")}")
//        println("lastIndexOf(\"Banana\"): ${list.lastIndexOf("Banana")}")
}

// Size and Checks
//println("size: ${list.size}")                     // 4
//println("isEmpty(): ${list.isEmpty()}")           // false
//println("contains(\"Cherry\"): ${list.contains("Cherry")}")     // true
//println("containsAll(listOf(\"Apple\", \"Banana\")): ${list.containsAll(listOf("Apple", "Banana"))}") // true
//
//// Iteration
//println("forEach:")
//list.forEach { println(it) }
//
//println("iterator:")
//val iterator = list.iterator()
//while (iterator.hasNext()) {
//    print("${iterator.next()} ")
//}
//println()
//
//// Transformation and Filtering
//val upper = list.map { it.uppercase() }
//println("map (uppercase): $upper")
//
//val filtered = list.filter { it.startsWith("B") }
//println("filter (starts with B): $filtered")
//
//println("sorted: ${list.sorted()}")               // Alphabetically
//println("sortedDescending: ${list.sortedDescending()}")
//
//println("subList(1, 3): ${list.subList(1, 3)}")    // [Banana, Cherry]
