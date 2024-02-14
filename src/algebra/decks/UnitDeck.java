package algebra.decks;

import java.io.File;
import java.util.Collection;
import java.util.function.Function;

import deckPack.Deck;

public class UnitDeck<E> extends Deck<E> {
	private static final long serialVersionUID = 1L;
	
	public UnitDeck() {
		super();
	}
	
	public UnitDeck(E[] arr) {
		super(arr);
	}
	
	public UnitDeck(Collection<E> c) {
		super(c);
	}
	
	public UnitDeck(File f, Function<String, E> factory) {
		super(f, factory);
	}
}
