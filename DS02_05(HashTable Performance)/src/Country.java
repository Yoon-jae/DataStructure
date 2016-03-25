
public class Country {

	private String _country;
	private String _language;
	private int _area;
	private int _population;
	
	public Country(String country, String language, int area, int population) {
		this._country = country;
		this._language = language;
		this._area = area;
		this._population = population;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Country : " + this._country + "\n");
		buf.append("language : " + this._language + "\n");
		buf.append("Area : " + this._area + "\n");
		buf.append("Population : " + this._population + "\n");
		return buf + "";
	}
}
