package algebra.readables.block.split;

import algebra.decks.BlockDeck;
import algebra.readables.Component;
import algebra.readables.block.Block;
import algebra.readables.expression.parentheses.Par;
import algebra.readables.term.exponent.Exponent;
import algebra.readables.term.Term;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class Split extends Component {
	//should split extend term since it is just a term with a potential coef in front of it?
	//A split can contain a par
	//structured like coef par term
	//is par one split or part of a split
	//is it the par's exponent or the splits's?
	
	public double coefficient;
	public Term term;
	public Exponent exp;//should a split have it's own exp, or just a reference to the exp of the term?
	public Par par;
	
	public Split() {
		super();
		coefficient = 1; //or 0?
		term = null;
	}
	
	public Split(String initialName) {
		super(initialName);
		setCoefficient(initialName);
		exp = new Exponent();
		setPar(initialName);
		setTerm(initialName);
	}
	
	public Split(String initialName, boolean isDenominator) {
		this(initialName);
		if(isDenominator)
			term.exp.power *= -1;
//		System.out.println(initialName);
		
	}
	
	public Split(Par p, Exponent e) {
		super(p.name());
		coefficient = 1;
		term.exp = e;
	}
	
	private void setCoefficient(String name) {
//		System.out.println(name);
		if(name.length() != 0 && (Character.isLetter(name.charAt(0)) || name.charAt(0) == '('))
			coefficient = 1;
		else {
			for(int i = 0; i < name.length(); i++) {
				if(Character.isLetter(name.charAt(i)) || name.charAt(i) == '(') {
//					System.out.println(name.charAt(i));
//					System.out.println(name.substring(0, i));
					coefficient = Double.valueOf(name.substring(0, i));
					
					break;
				}
				else if(i == name.length() - 1) //to account for names containing no letters at all.  could be done better
					coefficient = Double.valueOf(name);
			}
		}
	}
	
	private void setTerm(String name) {//clean
		term = new Term(); //or null?
		if(name.length() != 0 && Character.isLetter(name.charAt(0)))
			term = new Term(name);
		else if(name.indexOf('(') != -1) {
			term = new Term(name.substring(name.indexOf('(')));
		}
		else 
			for(int i = 0; i < name.length(); i++) { //can prob be optimized
				if(Character.isLetter(name.charAt(i))) {
					term = new Term(name.substring(i));
//					if(name.charAt(i - 1) == '/')   from OldSplit.  Is this necessary?
//						term.exp.power *= -1;
					break;
				}
			}
		
		//THE TERM AS A PAR WILL INCLUDE ALL THE VARS AND EXPONENTS OF THE INTERNAL EXPRESSION. no
		
//		if(par != null)
//			simplifyPar();
	}
	
	private void simplifyPar() {
		if(par.blocks.size() == 1 && !contains('(', par.blocks.first().name())) {
			if(par.blocks.first().splits.size() == 1) {
				coefficient *= par.blocks.first().splits.productOfCoefficients();
//				System.out.println("___"+par.blocks);
				if(par.vars().size() == 1)
					term = new Term(par.vars().first());
				else
					term = new Term();
				par = null;
			}
		}
	}
	
	private void setPar(String name) { //should prob be deleted to avoid confusion
		par = null;
		if(contains('(', name))
			par = new Par(name.substring(name.indexOf('('), name.lastIndexOf(')')));
	}
	
	
	public String name() {
		//need to account for negative coefficients. they should change overall block coef.
		String name = "";
		if(Math.abs(coefficient) != 1) {
			if(coefficient % 1 == 0)
				name += (int)coefficient;
			else
				name += coefficient;
		}
		name += term;
		return name;
	}
	
	public String toString() {
		return name();
	}
	
	public String nameWithoutCoef() {//dont need?
		return term.name();
	}
	
	public boolean isDenominator() {
		return term.isDenominator();
	}
	
	public boolean isCoefficient() {
		return term.var == null && term.par == null;
	}
	
	public boolean containsPar() {
		return term.par != null;
	}
	
	public Exponent exp() { //?
		return term.exp;
	}
	
	public Variable var() {
		return term.var;
	}
	
	public String flip() {
		return term.flip();
	}

	public Deck<? extends Component> nodes() {
		if(par == null)
			return null;
		return par.blocks;
	}
}
