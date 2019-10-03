package data;

@SuppressWarnings("serial")
public class ContinuousAttribute extends Attribute {

	/** membri attributi **/
	private double max;
	private double min;

	/** costruttore **/
	public ContinuousAttribute(String name, int index, double min, double max) {
		super(name, index);
		this.max = max;
		this.min = min;
	}

	/** ritorna valore normalizzato **/
	public double getScaledValue(double v) {
		return (v - min) / (max - min);
	}
}
