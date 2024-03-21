package main

public class Variable(var name: String = "", var coef: Int = 1, var exp: String = "1") {
    public var term: String

    init {
        coef *= getCoef(name)
        term = getTerm(name)
        exp = getExp(name)
        name = "$coef" + term + "^" + exp
        printInfo()
    }

    public constructor() : this("", 1)
    public constructor(name: String) : this(name, 1)
    public constructor(coef: Int) : this("", coef)

    public fun printInfo() {
        println(name)
        println(coef)
        println(term)
        println(exp)
    }
    
    public fun getCoef(input: String): Int {
        val regex = Regex("""^\d+""")
        val matchResult = regex.find(input)
        return matchResult?.value?.toIntOrNull() ?: 1
    }

    public fun getTerm(input: String): String {
        val regex = Regex("""^\d+\s*([^0-9^]+)""")
        val matchResult = regex.find(input)
        return matchResult?.groupValues?.getOrNull(1)?.trim() ?: input   
    }

    public fun getExp(input: String): String {
        val regex = Regex("""\^\s*([^ ]+)""")
        val matchResult = regex.find(input)
        return matchResult?.groupValues?.getOrNull(1) ?: "1"
    }
}
