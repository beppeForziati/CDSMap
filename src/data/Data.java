package data;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Data {

	/** membri attributi **/
	private Object data[][];
	int numberOfExamples = 14;
	private List<Attribute> explanatorySet = new LinkedList<Attribute>();

	/** costruttore **/
	public Data() {
		data = new Object[14][5];
		data[0][0] = "Sunny";
		data[1][0] = "Sunny";
		data[2][0] = "Overcast";
		data[3][0] = "Rain";
		data[4][0] = "Rain";
		data[5][0] = "Rain";
		data[6][0] = "Overcast";
		data[7][0] = "Sunny";
		data[8][0] = "Sunny";
		data[9][0] = "Rain";
		data[10][0] = "Sunny";
		data[11][0] = "Overcast";
		data[12][0] = "Overcast";
		data[13][0] = "Rain";

		data[0][1] = "Hot";
		data[1][1] = "Hot";
		data[2][1] = "Hot";
		data[3][1] = "Mild";
		data[4][1] = "Cool";
		data[5][1] = "Cool";
		data[6][1] = "Cool";
		data[7][1] = "Mild";
		data[8][1] = "Cool";
		data[9][1] = "Mild";
		data[10][1] = "Mild";
		data[11][1] = "Mild";
		data[12][1] = "Hot";
		data[13][1] = "Mild";

		data[0][2] = "High";
		data[1][2] = "High";
		data[2][2] = "High";
		data[3][2] = "High";
		data[4][2] = "Normal";
		data[5][2] = "Normal";
		data[6][2] = "Normal";
		data[7][2] = "High";
		data[8][2] = "Normal";
		data[9][2] = "Normal";
		data[10][2] = "Normal";
		data[11][2] = "High";
		data[12][2] = "Normal";
		data[13][2] = "High";

		data[0][3] = "Weak";
		data[1][3] = "Strong";
		data[2][3] = "Weak";
		data[3][3] = "Weak";
		data[4][3] = "Weak";
		data[5][3] = "Strong";
		data[6][3] = "Strong";
		data[7][3] = "Weak";
		data[8][3] = "Weak";
		data[9][3] = "Weak";
		data[10][3] = "Strong";
		data[11][3] = "Strong";
		data[12][3] = "Weak";
		data[13][3] = "Strong";

		data[0][4] = "No";
		data[1][4] = "No";
		data[2][4] = "Yes";
		data[3][4] = "Yes";
		data[4][4] = "Yes";
		data[5][4] = "No";
		data[6][4] = "Yes";
		data[7][4] = "No";
		data[8][4] = "Yes";
		data[9][4] = "Yes";
		data[10][4] = "Yes";
		data[11][4] = "Yes";
		data[12][4] = "Yes";
		data[13][4] = "No";

		Set<String> Outlookvalues = new TreeSet<String>();
		Outlookvalues.add("Sunny");
		Outlookvalues.add("Overcast");
		Outlookvalues.add("Rain");
		this.explanatorySet.add(new DiscreteAttribute("Outlook", 0, Outlookvalues));

		Set<String> Temperaturevalues = new TreeSet<String>();
		Temperaturevalues.add("Hot");
		Temperaturevalues.add("Mild");
		Temperaturevalues.add("Cool");
		this.explanatorySet.add(new DiscreteAttribute("Temperature", 1, Temperaturevalues));

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
			tuple.add(new DiscreteItem((DiscreteAttribute) explanatorySet.get(i), (String) data[index][i]), i);
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
