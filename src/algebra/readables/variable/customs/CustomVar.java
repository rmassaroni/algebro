package algebra.readables.variable.customs;

import algebra.decks.VariableDeck;
import algebra.readables.variable.Variable;

public class CustomVar extends Variable {
	public static VariableDeck<Variable> ALL_CUSTOM_VARS;

	public CustomVar() {
		super();
	}
	
	public CustomVar(String shortName) {
		super(shortName);
	}
}
