package algebra.readables.variable.defaults;

import java.io.File;

import algebra.decks.VariableDeck;
import algebra.readables.variable.Variable;

public class DefaultConstant extends DefaultVar {
	public static VariableDeck<Variable> ALL_DEFAULT_CONSTANTS() {
		return new VariableDeck<Variable>(new File("res/constants.txt"), s -> new DefaultConstant(s.substring(0, s.indexOf('=') - 1), s.substring(s.indexOf('=') + 2)));
	}
	
	public DefaultConstant() {
		this.constant = true;
		this.known = true;
	}
	
	public DefaultConstant(String shortName) {
		super(shortName);
		this.constant = true;
		this.known = true;
		
	}
	
	public DefaultConstant(String shortName, String fullName) {
		super(shortName, fullName);
		this.constant = true;
		this.known = true;
	}
}
