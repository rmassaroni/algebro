package main

import main.Variable

public class Expression(var name: String = "", var vars: ArrayList<Variable> = ArrayList()) {
    
    init {
        if(vars.size == 0)
            setVars()
        name = cleanName()
        printInfo()
    }

    public constructor(v: Variable) : this(v.name, ArrayList<Variable>().apply{add(v)})

    public fun printInfo() {
        println(name)
        println(getTerms())
    }

    public fun cleanName(): String {
        var n: String = ""
        for(v in vars)
            n += "*" + v.name
        return n
    }

    public fun setVars() {
        for(split in name.split('*'))
            vars.add(Variable(split.trim()))
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
