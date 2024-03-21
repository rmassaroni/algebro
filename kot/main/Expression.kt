package main

import main.Variable

import java.util.Stack

public class Expression(var name: String = "", var vars: ArrayList<Variable> = ArrayList()) {
    public var subExpressions: ArrayList<Expression> = ArrayList()
    
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
        for(v in vars) {
            if(n != "")
                n += "*"
            n += "" + v.name
        }
        return n
    }

    public fun setVars() {
        for(split in name.split('*'))
            vars.add(Variable(split.trim()))
    }

    public fun getTerms(): ArrayList<String> {
        var terms: ArrayList<String> = ArrayList()
        for(v in vars)
            if(terms.contains(v.term) == false)
                terms.add(v.term)
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

    public fun parseExpression(expression: String): ArrayList<String> {
        val terms = ArrayList<String>()
        val stack = Stack<Char>()

        var term = StringBuilder()

        for (char in expression) {
            when (char) {
                '(' -> stack.push(char)
                ')' -> {
                    stack.pop()
                    if (stack.isEmpty()) {
                        terms.add(term.toString())
                        term = StringBuilder()
                    }
                }
                else -> {
                    if (stack.isEmpty()) {
                        if (char == '+' || char == '-') {
                            terms.add(term.toString())
                            term = StringBuilder()
                        }
                    }
                    term.append(char)
                }
            }
        }

        if (term.isNotEmpty()) {
            terms.add(term.toString())
        }

        return terms
    }
}
