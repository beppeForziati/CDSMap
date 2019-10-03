package data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Data {

	/** membri attributi **/
	private List<Example> data=new ArrayList<Example>();
	int numberOfExamples = 14;
	private List<Attribute> explanatorySet = new LinkedList<Attribute>();

	/**
	 * costruttore
	 * 
	 * @throws EmptyDatasetException
	 **/
	public Data(String table) throws EmptyDatasetException {
		table.
		

		Set<String> Outlookvalues = new TreeSet<String>();
		Outlookvalues.add("Sunny");
		Outlookvalues.add("Overcast");
		Outlookvalues.add("Rain");
		this.explanatorySet.add(new DiscreteAttribute("Outlook", 0, Outlookvalues));

		this.explanatorySet.add(new ContinuousAttribute("Temperature", 1, 0, 30.3));

		Set<String> Humidityvalues = new TreeSet<String>();
		Humidityvalues.add("High");
		Humidityvalues.add("Normal");
		this.explanatorySet.add(new DiscreteAttribute("Humidity", 2, Humidityvalues));

		Set<String> Windvalues = new TreeSet<String>();
		Windvalues.add("Weak");
		Windvalues.add("Strong");
		this.explanatorySet.add(new DiscreteAttribute("Wind", 3, Windvalues));

		Set<String> PlayTennisvalues = new TreeSet<String>();
		PlayTennisvalues.add("No");
		PlayTennisvalues.add("Yes");
		this.explanatorySet.add(new DiscreteAttribute("PlayTennis", 4, PlayTennisvalues));

		if (data == null)
			throw new EmptyDatasetException();
	}

	public int getNumberOfExamples() {
		return this.numberOfExamples;
	}

	public int getNumberOfExplanatoryAttributes() {

		return this.explanatorySet.size();
	}

	public Object getValue(int exampleIndex, int attributeIndex) {
		return data[exampleIndex][attributeIndex];
	}

	public List<Attribute> getAttributeSchema() {
		return explanatorySet;
	}

	/**
	 * crea e restiuisce un oggeto tuple che modella come sequenza di coppie
	 * Attributo-valore la i-esima riga in data
	 **/
	public Tuple getItemSet(int index) {
		Tuple tuple = new Tuple(explanatorySet.size());
		for (int i = 0; i < explanatorySet.size(); i++)
			if (explanatorySet.get(i) instanceof ContinuousAttribute) {
				tuple.add(new ContinuousItem(explanatorySet.get(i), data[index][i]), i);
			} else {
				tuple.add(new DiscreteItem((DiscreteAttribute) explanatorySet.get(i), (String) data[index][i]), i);

			}
		return tuple;
	}

	@Override
	public String toString() {
		String Stringa = new String();
		Stringa = "";
		for (int i = 0; i < getNumberOfExplanatoryAttributes(); i++) {
			Stringa = Stringa + " " + explanatorySet.get(i) + ",";
		}
		Stringa += "\n";

		for (int i = 0; i < numberOfExamples; i++) {
			Stringa += (i) + ",";

			Stringa += "\n";
			for (int j = 0; j < getNumberOfExplanatoryAttributes(); j++) {
				Stringa += data[i][j] + ",";
			}
			Stringa += "\n";

		}
		return Stringa;
	}
}
