package algebra.readables.expression.parentheses;

import algebra.readables.expression.Expression;
import algebra.readables.term.exponent.Exponent;

public class Par extends Expression {
	//should this extend expression or split?

	public Par(String initialName) {
		super(initialName.substring(1, initialName.length() - 1));
		
	}
	
	public Par(String initialName, Exponent exp) {
		
	}
	
	public String name() {
		return '(' + super.name() + ')';
	}
	
	public String toString() {
		return name();
	}

}
