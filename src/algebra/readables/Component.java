package algebra.readables;

import java.util.Collection;

import algebra.decks.VariableDeck;
import algebra.readables.block.split.Split;
import algebra.readables.variable.Variable;
import deckPack.Deck;

public abstract class Component {
	//EXTEND STRING??d
	//protected keyword
	
	
	private String name;
	private String originalName;
//	private ArrayList<Variable> vars;
	public VariableDeck<Variable> vars; //will get rid of this because some subclasses have vars(), not vars
	
	public Component() {
		this.name = "";
		this.originalName = "";
	}
	
	public Component(String initialName) {
		this.name = initialName;
		this.originalName = initialName;
	}
	
	public String name() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getOriginalName() {
		return originalName;
	}
	
	public int length() {
		return name().length();
	}

	public boolean isEmpty() {
		return length() == 0;
	}
	
	public int count(char c) {
		int counter = 0;
		for(int i = 0; i < length(); i++)
			if(name().charAt(i) == c)
				counter++;
		return counter;
	}
	
	public int count(char c, String name) {
		int counter = 0;
		for(int i = 0; i < name.length(); i++)
			if(name.charAt(i) == c)
				counter++;
		return counter;
	}
	
	public int count(char c, Collection<?> collection) {
		int counter = 0;
		for(Object element : collection)
			if(element.equals(c))
				counter++;
		return counter;
	}
	
	public boolean contains(char c) {
		return count(c) > 0;
	}
	
	public boolean contains(char c, String name) {
		return count(c, name) > 0;
	}
	
	public Deck<Integer> indexesOf(char sign) {
		Deck<Integer> indexes = new Deck<>();//deck variant with determined size: count
		//new chardeck?
		
		for(int i = 0; i < length(); i++)
			if(name().charAt(i) == sign)
				indexes.add(i);
		
		return indexes;
	}
	
	public boolean insidePar(String name, int i) {
//		return count('(', name.substring(0, i)) != count(')', name.substring(0, i)) && count('(', name.substring(i)) != count(')', name.substring(i));
		return count('(', name.substring(i)) != count(')', name.substring(i));
	}
	
	public Deck<Integer> indexesOf(char[] signs) {
		Deck<Integer> indexes = new Deck<>();
		
		for(int i = 0; i < length(); i++) {
			for(int j = 0; j < signs.length; j++) {
				if(name().charAt(i) == signs[j])
					indexes.add(i);
			}
		}
		
		return indexes;
	}

	public String cleanString(String name) {
		return removeSpaces(name);
	}
	
	public String removeSpaces(String s) {
		if(s.indexOf(" ") == -1)
			return s;
		String noSpaces = "";
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) != ' ')
				noSpaces += s.charAt(i);
		return noSpaces;
	}

	public boolean isSeparable() {
		if(this instanceof Split)
			return contains('(');
		return true;
	}

	public Deck<? extends Component> nodes() {
		return null;
	}
	
	//method that returns the substrings of index and last index of chars of a string
}
