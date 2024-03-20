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

    fun printInfo() {
        println(name)
        println(coef)
        println(term)
        println(exp)
    }
    
    fun getCoef(input: String): Int {
        val regex = Regex("""^\d+""")
        val matchResult = regex.find(input)
        return matchResult?.value?.toIntOrNull() ?: 1
    }

    fun getTerm(input: String): String {
        val regex = Regex("""^\d+\s*\^?\s*\d*\s*""")
        return input.replaceFirst(regex, "").trim()
    }

    fun getExp(input: String): String {
        val regex = Regex("""\^\s*([^ ]+)""")
        val matchResult = regex.find(input)
        return matchResult?.groupValues?.getOrNull(1) ?: "1"
    }
}
