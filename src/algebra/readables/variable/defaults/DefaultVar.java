package algebra.readables.variable.defaults;

import java.io.File;

import algebra.decks.VariableDeck;
import algebra.readables.variable.Variable;

public class DefaultVar extends Variable {
	public static VariableDeck<Variable> ALL_DEFAULT_VARS() {
		return new VariableDeck<Variable>(new File("res/variables.txt"), s -> new DefaultVar(s.substring(0, s.indexOf('=') - 1), s.substring(s.indexOf('=') + 2)));
		//instead of having a dynamic deck method, i can add variables to the static deck in the constructor when they are created.
	}
	
	public DefaultVar() {
		
	}
	
	public DefaultVar(String shortName) {
		super(shortName);
	}
	
	public DefaultVar(String shortName, String fullName) {
		super(shortName, fullName);
	}
}
