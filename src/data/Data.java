package data;

public class Data {

	/** membri attributi **/
	private Object data[][];
	int numberOfExamples = 14;
	private Attribute explanatorySet[] = new Attribute[5];

	/** costruttore **/
	public Data() {
		data = new Object[14][5];
		data[0][0] = "Sunny";
		data[1][0] = "Sunny";
		data[2][0] = "Overcast";
		data[3][0] = "Rain";
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
		data[6][1] = " Cool";
		data[7][1] = " Mild";
		data[8][1] = " Cool";
		data[9][1] = "Mild";
		data[10][1] = "Mild";
		data[11][1] = "Mild";
		data[12][1] = " Hot";
		data[13][1] = " Mild";

		data[0][2] = "High";
		data[1][2] = "High";
		data[2][2] = "High";
		data[3][2] = "High";
		data[4][2] = " Normal";
		data[5][2] = " Normal";
		data[6][2] = "Normal";
		data[7][2] = " High";
		data[8][2] = "Normal";
		data[9][2] = " Normal";
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

		String Outlookvalues[] = new String[3];
		Outlookvalues[0] = "Sunny";
		Outlookvalues[1] = "Overcast";
		Outlookvalues[2] = "Rain";

		this.explanatorySet[0] = new DiscreteAttribute("Outlook", 0, Outlookvalues);

		String Temperaturevalues[] = new String[3];
		Temperaturevalues[0] = "Hot";
		Temperaturevalues[1] = "Mild";
		Temperaturevalues[2] = "Cool";

		this.explanatorySet[1] = new DiscreteAttribute("Temperature", 1, Temperaturevalues);

		String Humidityvalues[] = new String[2];
		Humidityvalues[0] = "High";
		Humidityvalues[1] = "Normal";

		this.explanatorySet[2] = new DiscreteAttribute("Humidity", 2, Humidityvalues);

		String Windvalues[] = new String[2];
		Windvalues[0] = "Weak";
		Windvalues[1] = "Strong";

		this.explanatorySet[3] = new DiscreteAttribute("Wind", 3, Windvalues);

		String PlayTennisvalues[] = new String[2];
		PlayTennisvalues[0] = "No";
		PlayTennisvalues[1] = "Yes";

		this.explanatorySet[4] = new DiscreteAttribute("PlayTennis", 4, PlayTennisvalues);

	}

	public int getNumberOfExamples() {
		return this.numberOfExamples;
	}

	public int getNumberOfExplanatoryAttributes() {

		return this.explanatorySet.length;
	}

	public Object getValue(int exampleIndex, int attributeIndex) {
		return data[exampleIndex][attributeIndex];
	}

	public Attribute[] getAttributeSchema() {
		return explanatorySet;
	}

	/**
	 * crea e restiuisce un oggeto tuple che modella come sequenza di coppie
	 * Attributo-valore la i-esima riga in data
	 **/
	public Tuple getItemSet(int index) {
		Tuple tuple = new Tuple(explanatorySet.length);
		for (int i = 0; i < explanatorySet.length; i++)
			tuple.add(new DiscreteItem(explanatorySet[i], data[index][i]), i);
		return tuple;
	}

	@Override
	public String toString() {
		String Stringa = new String();
		Stringa = "0";
		for (int i = 0; i < getNumberOfExplanatoryAttributes(); i++) {
			Stringa = Stringa + " " + explanatorySet[i] + ",";
		}
		Stringa += "\n";

		for (int i = 1; i < numberOfExamples; i++) {
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
