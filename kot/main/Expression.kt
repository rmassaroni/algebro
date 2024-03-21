package main

import main.Variable

public class Expression(var name: String = "", var vars: ArrayList<Variable> = ArrayList()) {
    
    init {
        name = cleanName(name)
        printInfo()
    }

    public constructor(v: Variable) : this("", ArrayList<Variable>().apply{add(v)})

    public fun printInfo() {
        println(name)
        println(getTerms())
    }

    public fun cleanName(n: String): String {
        return n //unfinished
    }

    public fun setVars(n: String): ArrayList<Variable> {
        return vars //unfinished
    }

    public fun getTerms(): ArrayList<String> {
        var terms: ArrayList<String> = ArrayList()
        for(v in vars) {
            if(terms.contains(v.term) == false)
                terms.add(v.term)
        }
        return terms
    }

    public fun simplify() {
        for(v in vars) {
            
        }
    }

    public fun multiply(v: Variable) {
        vars.add(v)
    }

    public fun divide(v: Variable) {
        vars.add(v.reciprocal())
    }
}
