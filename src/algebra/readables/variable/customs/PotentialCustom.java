package algebra.readables.variable.customs;

import algebra.decks.VariableDeck;
import algebra.readables.variable.Variable;

public class PotentialCustom extends CustomVar {
	public static VariableDeck<Variable> ALL_POTENTIAL_CUSTOMS;
	//if a potential var appears multiple times, it will appear earlier in the suggested variables list
	
	public PotentialCustom() {
		super();
	}
	
	public PotentialCustom(String shortName) {
		super(shortName);
	}
}
