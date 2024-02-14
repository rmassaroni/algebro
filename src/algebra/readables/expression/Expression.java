package algebra.readables.expression;

import algebra.decks.BlockDeck;
import algebra.decks.VariableDeck;
import algebra.readables.Component;
import algebra.readables.block.Block;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class Expression extends Component {
	//any group of blocks without an = sign: side, parentheses
	
	public BlockDeck<Block> blocks = new BlockDeck<>();
	
	public Expression() {
		super();
	}
	
	public Expression(String initialName) {
		super(initialName);
		
		blockify(removeSpaces(initialName));//remove spaces?
	}
	
	public String name() {
		return blocks.toExpressionName();
	}
	
	public String toString() {
		return name();
	}
	
	public void blockify(String name) { //clean
		blocks = new BlockDeck<>();
		if(signs(name).size() == 0)
			blocks.add(new Block(name));
		else {
			blocks.add(new Block(name.substring(0, signs(name).get(0))));
			for(int i = 0; i < signs(name).size() - 1; i++)
				blocks.add(new Block(name.substring(signs(name).get(i) + 1, signs(name).get(i + 1)), name.charAt(signs(name).get(i)) == '-'));
			blocks.add(new Block(name.substring(signs(name).get(signs(name).size() - 1) + 1), name.charAt(signs(name).get(signs(name).size() - 1)) == '-'));
		}
	}
	
	public Deck<Integer> signs(String name) {//should this be a component method. clean
		Deck<Integer> indexes = new Deck<>();
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(c == '+' || c == '-')
				if(!insidePar(name, i))
					indexes.add(i);
		}
		return indexes;
	}

	public VariableDeck<Variable> vars() {
		return blocks.vars();
	}

	
	public void searchPars() {
////		Deque<Character> stack = new ArrayDeque<Character>();
//		
//		String possiblePar= "";
//		
//		ArrayList<Character> pars = new ArrayList<>();
//		
//		boolean insidePar = false;
//		
//		for(int i = 0; i < length(); i++) {
//			char c = name().charAt(i);
//			if (c == '(' || c == ')') {
////                stack.push(c);
//				pars.add(c);
//				
//				if(pars.size() == 1) {
//					insidePar = true;
//				}
//            }
//			
//			if(insidePar == true) {
//				possiblePar += c;
//			}
////			System.out.println(pars);
//			if(count('(', pars) == count(')', pars) && possiblePar.length() > 0) {
//				insidePar = false;
//				pars.clear();
//				System.out.println(possiblePar);
//				this.pars.add(new Par(possiblePar.substring(1, possiblePar.length() - 1)));
//				possiblePar = "";
//			}
//		}
	}
	
	public Deck<? extends Component> nodes() {
		return blocks;
	}
	
	
	
	public static void main(String[] args) {
//		Expression e = new Expression("m*x-b*(2x+(2))*(3x)"); //wont work until i account for pars
//		System.out.println(e);
//		System.out.println(e.blocks);
		
		
		
		Expression e = new Expression("y*z+x*3y-y");//y should be negative`
		System.out.println(e);
		System.out.println(e.blocks);
		System.out.println(e.blocks.coefficients());
		System.out.println(e.blocks.isNegative());
		System.out.println(e.blocks.get(1).terms());
	}

}
