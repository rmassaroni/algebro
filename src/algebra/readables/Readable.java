package algebra.readables;

public interface Readable {
	public String toString();
	public String getOriginalName();
	public int getLength();
	public boolean isEmpty();
	public void simplify();
}
