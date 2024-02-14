package algebra.readables.block.split;

import algebra.readables.variable.Variable;

public class Denominator extends Split {
	public Denominator(String initialName) {
		super(initialName);
//		term.exp.power *= -1;
		
		for(Variable v : term.vars) {
			v.exp.power *= -1;
		}
	}
}
