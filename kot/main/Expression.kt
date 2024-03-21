package main

import main.Variable

public class Expression(var name: String = "", var vars: ArrayList<Variable> = ArrayList()) {
    
    init {
        name = cleanName(name)
    }

    public constructor(v: Variable) : this("", ArrayList<Variable>().apply{add(v)})

    public fun cleanName(n: String): String {
        return n //unfinished
    }
}
