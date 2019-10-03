package data;

public class DiscreteItem extends Item {

	/** costruttore **/
	DiscreteItem(DiscreteAttribute attribute, String value) {
		super(attribute, value);
	}

	/** implementazione metodo astratto **/
	@Override
	double distance(Object a) {

		// System.out.println(getValue());
		if (getValue().equals(a))
			return 0;
		else
			return 1;
	}
}
