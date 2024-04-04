package main

import main.Variable

public class Product(var name: String = "", var vars: ArrayList<Variable> = ArrayList()) {
    //is name neccesary?

    init {
        println("Product of: " + vars.toString())
        println("Terms: " + getTerms().toString())
    }

    public fun getTerms(): ArrayList<String> {
        var terms: ArrayList<String> = ArrayList()
        for(v in vars)
            if(terms.contains(v.term) == false) terms.add(v.term)
        return terms
    }
}
