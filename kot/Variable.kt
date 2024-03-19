package kot

public class Variable(var name: String = "", var coef: Int = 1) {
    init {
        printInfo()
    }

    fun printInfo() {
        println(name)
        println(coef)
        println(setCoef(name))
    }
    
    fun setCoef(input: String): Int {
        val regex = Regex("""^\d+""")
        val matchResult = regex.find(input)
        return matchResult?.value?.toIntOrNull() ?: 1
    }
}
