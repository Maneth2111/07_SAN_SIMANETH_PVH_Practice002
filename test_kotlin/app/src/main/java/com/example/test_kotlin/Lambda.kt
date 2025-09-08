package com.example.test_kotlin

/* higher-expression function
fun main() {
    val sum  = testLambda(1,2){x,y -> x+y}
    val minus = testLambda(4,1){x,y -> x-y}
    val multi = testLambda(3,5){x,y -> x*y}
    println("Sum: $sum")
    println("Minus: $minus")
    println("Multi: $multi")
}

fun testLambda(a: Int, b: Int, calculation : (Int, Int)->Int): Int{
    return calculation(a, b)
}

*/


/* inline function
fun main() {
    hello {
        println("How about you")
    }

    val hi= wah(1,2){x,y -> x+y}
    println(hi)

}

inline fun hello (say: () -> Unit){
    println("Wow Wow")
    say()
    println("My name is JK")
}

inline fun wah (a:Int , b: Int, sum: (Int, Int)-> Int ):Int{
    println("Sum")
    return sum(a,b)
}
*/


//Noinline
fun main() {
    val myAction = { println("stored Lambda") }
    action(
        { println("Inline") },myAction
    )

}
inline fun action (inlineAction: ()-> Unit, noinline process: () -> Unit){
    inlineAction()
    process()
}





