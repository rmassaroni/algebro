package algebra.readables.equation;

import algebra.readables.Component;
import algebra.readables.equation.side.Side;
import deckPack.Deck;

public class Equation extends Component {
	
	public Side[] sides;
	
	public Equation(String initialName) {
		super(initialName);

		sides = new Side[2];
		sides[0] = new Side(cleanString(initialName.substring(0, initialName.indexOf('=') - 1)));
		sides[1] = new Side(cleanString(initialName.substring(initialName.indexOf('=') + 1)));
	}

	public String name() {
		return sides[0] + " = " + sides[1];
	}

	public String toString() {
		return name();
	}


	public Deck<? extends Component> nodes() {
		return new Deck<>(sides);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Equation e = new Equation("y = m*x + b");
		System.out.println(e);
	}
	
}
