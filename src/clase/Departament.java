package clase;

public class Departament {
	private int idDepartament;
	private String denumireDepartament;
	private int numarAngajati;

	public int getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public String getDenumireDepartament() {
		return denumireDepartament;
	}

	public void setDenumireDepartament(String denumireDepartament) {
		this.denumireDepartament = denumireDepartament;
	}

	public int getNumarAngajati() {
		return numarAngajati;
	}

	public void setNumarAngajati(int numarAngajati) {
		this.numarAngajati = numarAngajati;
	}

	public Departament(int idDepartament, String denumireDepartament, int numarAngajati) {
		super();
		this.idDepartament = idDepartament;
		this.denumireDepartament = denumireDepartament;
		this.numarAngajati = numarAngajati;
	}

	public Departament() {

	}

	@Override
	public String toString() {
		return getIdDepartament() + " " + getDenumireDepartament() + " " + getNumarAngajati();
	}
}