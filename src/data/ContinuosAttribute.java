package data;

public class ContinuosAttribute extends Attribute {

	/** membri attributi **/
	double max;
	double min;

	/** costruttore **/
	ContinuosAttribute(String name, int index, double max, double min) {
		super(name, index);
		this.max = max;
		this.min = min;
	}

	/** ritorna valore normalizzato **/
	public double getScaledValue(double v) {
		return (v - min) / (max - min);
	}
}
