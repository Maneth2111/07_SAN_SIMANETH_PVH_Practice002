package com.example.test_kotlin

fun main() {
        val fruits: MutableList<String> = mutableListOf("Apple", "Banana")
        // Adding Elements
        fruits.add("Cherry")
        fruits.add(1, "Avocado")
        fruits.addAll(listOf("Durian", "Elderberry"))
        fruits.addAll(2, listOf("Blueberry", "Coconut"))
        println("After adding: $fruits")

        // Removing Elements
        fruits.remove("Banana")
        fruits.removeAt(0)
        fruits.removeAll(listOf("Durian", "Coconut"))
        println("After removing: $fruits")

        // Updating Elements
        fruits[0] = "Blackberry"
        fruits.set(1, "Fig")
        println("After updating: $fruits")

        // Fill all values with a single value
        fruits.fill("Kiwi")
        println("After fill(): $fruits")

        // Clear all elements
        fruits.clear()
        println("After clear(): $fruits")
}