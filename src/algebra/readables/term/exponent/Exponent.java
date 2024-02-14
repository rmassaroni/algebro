package algebra.readables.term.exponent;

import algebra.readables.Component;
import algebra.readables.expression.Expression;

public class Exponent extends Component {
	//if has pars, instantiate new expression
	
	public double power;//represents entire exp if it is just a number or represents coef of exp as an expression
	public Expression expression;
	
	public Exponent() {
		super();
		power = 1;
	}
	
	public Exponent(String initialName) {
		super(initialName);
		power = 1;
		splitPowFromExpression();
	}
	
	public Exponent(String initialName, double power) {
		super(initialName);
		this.power = power;
		splitPowFromExpression();
	}
	
	public String name() {
		return (power % 1 == 0) ? Integer.toString((int)power) : Double.toString(power) + expression;
	}
	
	public String nameAsDenominator() {
		if(isNegative())
			return name().substring(1);
		return "-" + name();
	}
	
	public String toString() {
		return name();
	}
	
	public boolean isNegative() {
		return power < 0;
	}
	
	public void splitPowFromExpression() {
		expression = new Expression();
		String powString = "";
		for(int i = 0; i < getOriginalName().length(); i++) {
			if(getOriginalName().charAt(i) == '.' || getOriginalName().charAt(i) == '-' || Character.isDigit(getOriginalName().charAt(i)))
				powString += getOriginalName().charAt(i);
			else {
				expression = new Expression(getOriginalName().substring(i));
				break;
			}
				
		}
		if(powString.length() > 0)
			power *= Double.valueOf(powString);
	}
	
	public void setExpression(String ex) {
		
	}
}
