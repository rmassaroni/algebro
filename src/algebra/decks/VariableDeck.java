package algebra.decks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.function.Function;

import algebra.readables.term.exponent.Exponent;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public class VariableDeck<E> extends Deck<Variable> {
	private static final long serialVersionUID = 1L;
	
	
	public VariableDeck() {
		super();
	}
	
	public VariableDeck(boolean noDupes) {
		super(noDupes);
	}
	
	public VariableDeck(Variable[] arr) {
		super(arr);
	}
	
	public VariableDeck(Collection<Variable> c) {
		super(c);
	}
	
	public VariableDeck(File f, Function<String, Variable> factory) {
//		super(f, factory);		
		this();
		try {
			 Scanner reader = new Scanner(f);
			 while(reader.hasNextLine())
				 add(factory.apply(reader.nextLine()));
			 reader.close();
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
	}

	public Deck<Exponent> exponents() {
		//eventually, deck will have an auto method feature
		Deck<Exponent> e = new Deck<>();
		for(Variable v : this)
			e.add(v.exp);
		return e;
	}
	
	public VariableDeck<Variable> removeDuplicates() {
		return new VariableDeck<Variable>(new LinkedHashSet<Variable>(this)); //not removing duplicates
	}
	
	public Deck<String> extendedNames() {
		Deck<String> names = new Deck<>();
		for(Variable v : this)
			names.add(v + "^" + v.exp);
		return names;
	}
	
	public boolean contains(Variable var) {
		for(Variable v : this)
			if(v.shortName.equals(var.shortName))
				return true;
		return false;
	}
	
	public boolean checkAdd(Variable v) {
		if(!(noDupes && contains(v))) {
			add(v);
			return true;
		}
		return false;
	}
	
	public void checkAddAll(Collection<Variable> c) {
		for(Variable v : c)
			checkAdd(v);
	}
}
