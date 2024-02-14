package algebra.readables.block;

import algebra.decks.SplitDeck;
import algebra.decks.TermDeck;
import algebra.decks.VariableDeck;
import algebra.readables.Component;
import algebra.readables.block.split.Split;
import algebra.readables.term.Term;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class Block extends Component {
	//surround blocks with []?
	//throw exception if name() does not = name from coef + term. all variables should add up
	//maybe blocks should just be renamed when they are created so that they are easier to read.  maybe remove spaces
	//option to keep coefficients with splits and not automatically get product
	
	public double coefficient;
	public Term term;
//	public VariableDeck<Variable> customs;
	public SplitDeck<Split> splits;
	
	
	public Block() {
		super();
		this.coefficient = 0;
		this.term = null;
	}	
	
	public Block(String initialName) {
		super(initialName);
		splitify(cleanString(initialName));
	}
	
	public Block(String initialName, boolean isNegative) {
		this(initialName);
		if(isNegative)
//			coefficient *= -1;
			splits.get(0).coefficient *= -1;
	}
	
	public String name() {
//		return removeSpaces(super.name()); //or removeSpaces(getOriginalName());
		return splits.toBlockName();
	}
	
	public String toString() {
		return name();
	}
	
	public String simplifiedName() {
		return getCoefficient() + "" + term;
	}
	
	public String ignoreNegative() {
		if(isNegative())
			return name().substring(1);
		return name();
	}
	
	public double getCoefficient() {
		return splits.productOfCoefficients();
	}
	
	public Deck<Integer> signs(String name) {//should this be a component method
		Deck<Integer> indexes = new Deck<>();
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(!insidePar(name, i) && (c == '*' || c == '/')) // will eventually account for all symbols
				indexes.add(i);
		}
		return indexes;
	}
	
	public void splitify(String name) {
		splits = new SplitDeck<>();
		if(signs(name).size() == 0)
			splits.add(new Split(name));
		else {
			splits.add(new Split(name.substring(0, signs(name).get(0))));
			for(int i = 0; i < signs(name).size() - 1; i++)
				splits.add(new Split(name.substring(signs(name).get(i) + 1, signs(name).get(i + 1)), name.charAt(signs(name).get(i)) == '/'));
			splits.add(new Split(name.substring(signs(name).get(signs(name).size() - 1) + 1), name.charAt(signs(name).get(signs(name).size() - 1)) == '/'));
		}
	}
	
	public VariableDeck<Variable> vars() {
		return splits.vars();
	}
	
	public TermDeck<Term> terms() {
		return splits.terms();
	}
	
	public boolean isNegative() {
		return splits.productOfCoefficients() < 0;
	}

	public String insertSigns(String name) {//clean
		String s = removeSpaces(name); //might not be necessary
		if(!contains('(', s))
			return s;
		if(s.indexOf(')') < s.length() - 1 && Character.isDigit(s.charAt(s.indexOf(')') + 1)))
			s = s.substring(0, s.indexOf(')') + 1) + "*" + insertSigns(s.substring(s.indexOf(')') + 1));
		if(s.charAt(0) == '(') //might not be necessary
			return '(' + insertSigns(s.substring(1));
		if(!(s.charAt(s.indexOf('(') - 1) == '*' || s.charAt(s.indexOf('(') - 1) == '/' || s.charAt(s.indexOf('(') - 1) == '+' || s.charAt(s.indexOf('(') - 1) == '-'))
			if(!Character.isDigit(s.charAt(s.indexOf('(') - 1)))
				return s.substring(0, s.indexOf('(')) + "*(" + insertSigns(s.substring(s.indexOf('(') + 1));
		
		return s;
	}
	
	public String cleanString(String name) {
		return insertSigns(removeSpaces(name));
	}

	public Deck<? extends Component> nodes() {
		return splits;
	}
	
	
	public static void main(String[] args) {
		Block b = new Block("x(y+3(2x)2)2(3z)");
		System.out.println(b);
		System.out.println(b.cleanString(b.getOriginalName()));
		System.out.println(b.splits);
		System.out.println(b.splits.coefficients());
		System.out.println(b.terms());
		System.out.println(b.vars());
		
	}
}
