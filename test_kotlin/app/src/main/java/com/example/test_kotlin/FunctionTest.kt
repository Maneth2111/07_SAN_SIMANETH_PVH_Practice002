package com.example.test_kotlin
/*
// default value
fun greet(name: String = "Guest", age: Int = 18) {
    println("Hello, $name! You are $age years old.")
}
fun main() {
    greet()
    println("=== Passed argument ===")
    greet("Jonh")
}
*/


/*
// Named argument
fun main() {
    format(name = "Alice", age = 30)
    println("=== After passed all ===")
    format(age = 23, name = "Jully", city = "Phnom Penh")
}
fun format(name: String, age: Int, city: String = "Unknown") {
    println("$name, age $age, lives in $city.")
}
*/

fun multi(a: Int, b:Int):Int{
    return a * b
}
fun main() {
    val result = multi(4,8)
    println("The result: $result")
}