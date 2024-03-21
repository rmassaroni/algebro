package main

import main.Variable

fun main() {
    val v1 = Variable("2x^5")
    val v2 = Variable("4x")
    println("${v1.name}, ${v2.name}")
    println("${add(v1, v2).name}")

    val vars1 = Expression(v1)
}

fun add(var1: Variable, var2: Variable): Variable {
    var var3 = Variable(var1.term, var1.coef + var2.coef, var1.exp)
    return var3
}
