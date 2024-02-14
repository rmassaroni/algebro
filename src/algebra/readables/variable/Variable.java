package algebra.readables.variable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algebra.decks.UnitDeck;
import algebra.decks.VariableDeck;
import algebra.readables.term.exponent.Exponent;
import algebra.readables.variable.customs.CustomConstant;
import algebra.readables.variable.customs.CustomVar;
import algebra.readables.variable.defaults.DefaultConstant;
import algebra.readables.variable.defaults.DefaultVar;

public class Variable {
	//component?
	public static VariableDeck<Variable> ALL_VARS() {
		VariableDeck<Variable> vars = new VariableDeck<Variable>(DefaultVar.ALL_DEFAULT_VARS());
		vars.addAll(DefaultConstant.ALL_DEFAULT_CONSTANTS());
		vars.addAll(CustomVar.ALL_CUSTOM_VARS);
		vars.addAll(CustomConstant.ALL_CUSTOM_CONSTANTS);
		//fix access safety from subclasses
		return vars;
	}
	
	public boolean constant;
	public boolean known;
	public double value;
	public String shortName;
	public String fullName;
	public Unit unit;
	public UnitDeck<Unit> units;//will add units to txt. after second = sign.
	public Exponent exp; //do not need
	
	public Variable() {
		
	}
	
	public Variable(String shortName) {
		this.shortName = shortName;
	}
	
	public Variable(String shortName, Exponent exponent) {
		//for making var decks of contained vars
		this(shortName);
		this.exp = exponent;
		
	}
	
	public Variable(String shortName, String fullName) {
		this(shortName);
		this.fullName = fullName;
	}
	
	public String toString() {
		return shortName;
	}
	
	
	public static void main(String[] args) {
		try {
		      File myObj = new File("res/variables.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		System.out.println(ALL_VARS());
	}
}
