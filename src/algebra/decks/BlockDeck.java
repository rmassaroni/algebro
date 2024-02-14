package algebra.decks;

import algebra.readables.block.Block;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class BlockDeck<E> extends Deck<Block> {
	private static final long serialVersionUID = 1L;
	//should not start with a negative block
	
	public BlockDeck() {
		super();
	}
	
	public String toExpressionName() {
		String s = "";
		for(int i = 0; i < size(); i++) {
			if(i > 0) {
				if(get(i).isNegative())
					s += "-";
				else
					s += "+";
			}
			
			s += get(i).cleanString(get(i).ignoreNegative());
		}
		return s;
	}
	
	public Deck<Double> coefficients() {
		Deck<Double> coefficients = new Deck<>();
		for(Block b : this)
			coefficients.add(b.getCoefficient());
		return coefficients;
	}
	
	public Deck<Boolean> isNegative() { //will i ever need this?
		Deck<Boolean> isNegative = new Deck<>();
		for(Block b : this)
			isNegative.add(b.isNegative());
		return isNegative;
	}
	
	public VariableDeck<Variable> vars() {
		VariableDeck<Variable> vars = new VariableDeck<>();
		for(Block b : this)
//			if(b.vars().size() > 0)
				vars.addAll(b.vars());
		return vars;
	}
}
