package data;

@SuppressWarnings("serial")
public class ContinuousItem extends Item {

	public ContinuousItem(Attribute attribute, Object value) {
		super(attribute, value);
	}

	@Override
	public double distance(Object a) {
		Double num1 = ((ContinuousAttribute) this.getAttribute()).getScaledValue((double) this.getValue());
		Double num2 = ((ContinuousAttribute) this.getAttribute()).getScaledValue((double) a);
		return Math.abs(num1 - num2);
	}

}
