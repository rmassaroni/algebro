package algebra.readables.term;

import algebra.readables.Component;
import algebra.readables.expression.parentheses.Par;
import algebra.readables.term.exponent.Exponent;
import algebra.readables.variable.Variable;

public class Term extends Component {
	//new Term that only takes one variable and exp. (for splits)
	//block terms will be different
	//single var? no deck?
	//if we just do one var per term, vars won't need their own exp variable.
	//since this new term is so simplified, can i just combine it with split?
	//confusing relationship between initialExp and exp from setVar.  Should they be multiplied together? or should there only be one
	//a term can have a single var or a par
	//is the par the var or the split
	
	public Variable var;
	public Par par;
	public Exponent exp;
	
	public Term() {
		super();
		var = null;
		par = null;
		this.exp = new Exponent();
	}
	
	public Term(String initialName) {
		super(initialName);
		this.exp = new Exponent();
		setVar(initialName);
	}
	
	public Term(String initialName, Exponent initialExp) {
		super(initialName);
		this.exp = initialExp; //should exp be set by initialExp or the exp from setVar? which one will take priority?
		setVar(initialName);
	}
	
	public Term(Variable v) {
		super(v.shortName);
		var = v;
		par = null;
		exp = new Exponent();
//		System.out.println("var: " + var);
	}
	
	private void setVar(String name) {//clean. possibly separate into two methods for pars and vars
		var = null;
		par = null;
		exp = new Exponent();
		if(contains('(', name))
			par = new Par(name.substring(name.indexOf('('), name.lastIndexOf(')') + 1));
		else if(!contains('^', name))
			var = new Variable(name, exp);
		else
			var = new Variable(name.substring(0, name.indexOf("^")));
		if(contains('^'))
			exp = new Exponent(name.substring(name.indexOf("^") + 1));
	}
	
	public String name() {
		//should name() be private since toString is public?
		String name = "";
		if(var != null)
			name = var.shortName;
		if(par != null)
			name = par.name();
		
		if(Math.abs(exp.power) != 1)
			name += "^" + exp;
		return name;
	}
	
	public String toString() {
		return name();
	}
	
	public boolean isDenominator() {
		return exp.power < 0;
	}
	
	public String flip() {
		String name = var.shortName;
		
		if(isDenominator()) {
			if(Math.abs(exp.power) != 1)
				name += "^" + exp.name().substring(1);
			return name;
		}
		else {
			if(Math.abs(exp.power) != 1)
				name += "^-" + exp.name().substring(1);
			return name;
		}
	}
}
