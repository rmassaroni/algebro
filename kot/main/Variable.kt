package main

public class Variable(var name: String = "") {
    public var coef: Int
    public var term: String
    public var exp: String

    init {
        coef = getCoef(name)
        term = getTerm(name)
        exp = getExp(name)
        printInfo()
    }

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
