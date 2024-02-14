package algebra.decks;

import java.util.Collection;

import algebra.readables.block.split.Split;
import algebra.readables.term.Term;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class SplitDeck<E> extends Deck<Split> {
	private static final long serialVersionUID = 1L;
	
	public SplitDeck() {
		super();
	}
	
	public SplitDeck(Split[] arr) {
		super(arr);
	}
	
	public SplitDeck(Collection<Split> c) {
		super(c);
	}
	
	public boolean areAllDenominators() {
		for(Split s : this)
			if(s.exp().isNegative())
				return false;
		return true;
	}
	
	public VariableDeck<Variable> vars() {
		return vars(true);
//		VariableDeck<Variable> vars = new VariableDeck<>(true); //noDupes not workinh
////		System.out.println(vars.noDupes);
//		for(Split s : this) {
//
//			if(s.term.var != null)
//				vars.checkAdd(s.var());
//			if(s.term.par != null)
//				vars.checkAddAll(s.term.par.vars());
//		}
//		return vars;
	}

	public VariableDeck<Variable> vars(boolean noDupes) {
		VariableDeck<Variable> vars = new VariableDeck<>(noDupes);
		for(Split s : this) {

			if(s.term.var != null)
				vars.checkAdd(s.var());
			if(s.term.par != null)
				vars.checkAddAll(s.term.par.vars());
		}
		return vars;
	}
	
	public TermDeck<Term> terms() {
		TermDeck<Term> terms = new TermDeck<>();
		for(Split s : this)
			terms.add(s.term);
		return terms;
	}
	
	public double productOfCoefficients() {
		double coef = 1;
		for(Split s : this)
			coef *= s.coefficient;
		return coef;
	}
	
	public String toBlockName() {
		String s = "";
		if(productOfCoefficients() < 0)
			s += "-";
		if(Math.abs(productOfCoefficients()) != 1) {
			if(productOfCoefficients() % 1 == 0)
				s += (int)productOfCoefficients();
			else
				s += productOfCoefficients();
		}
//		s += '['; //temp
		for(int i = 0; i < size(); i++) {
			if(i > 0 && !get(i).isCoefficient()) {
				if(get(i).isDenominator())
					s += "/";
				else
					s += "*";
			}
			if(get(i).isDenominator())
				s += get(i).flip();
			else
				s += get(i).nameWithoutCoef(); // temp
		}
//		s += ']'; //temp
		return s;
	}
	
	public boolean numeratorsInFront() {
		return true; //unfinished
	}
	
	public Deck<Double> coefficients() {
		Deck<Double> coefficients = new Deck<>();
		for(Split s : this)
			coefficients.add(s.coefficient);
		return coefficients;
	}
}
