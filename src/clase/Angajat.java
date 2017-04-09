package clase;

public class Angajat {
	private String numeAngajat;
	private String prenumeAngajat;
	private double salariuAngajat;
	private String cnpAngajat;
	private String functieAngajat;
	private int idDepartament;

	public String getNumeAngajat() {
		return numeAngajat;
	}

	public void setNumeAngajat(String numeAngajat) {
		this.numeAngajat = numeAngajat;
	}

	public String getPrenumeAngajat() {
		return prenumeAngajat;
	}

	public void setPrenumeAngajat(String prenumeAngajat) {
		this.prenumeAngajat = prenumeAngajat;
	}

	public double getSalariuAngajat() {
		return salariuAngajat;
	}

	public void setSalariuAngajat(double salariuAngajat) {
		this.salariuAngajat = salariuAngajat;
	}

	public String getCnpAngajat() {
		return cnpAngajat;
	}

	public void setCnpAngajat(String cnpAngajat) {
		this.cnpAngajat = cnpAngajat;
	}

	public String getFunctieAngajat() {
		return functieAngajat;
	}

	public void setFunctieAngajat(String functieAngajat) {
		this.functieAngajat = functieAngajat;
	}

	public int getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public Angajat(String numeAngajat, String prenumeAngajat, double salariuAngajat, String cnpAngajat,
			String functieAngajat, int idDepartament) {
		super();
		this.numeAngajat = numeAngajat;
		this.prenumeAngajat = prenumeAngajat;
		this.salariuAngajat = salariuAngajat;
		this.cnpAngajat = cnpAngajat;
		this.functieAngajat = functieAngajat;
		this.idDepartament = idDepartament;
	}

	public Angajat() {

	}

	@Override

	public String toString() {
		return getNumeAngajat() + " " + getPrenumeAngajat() + " " + getSalariuAngajat() + " " + getCnpAngajat() + " "
				+ getFunctieAngajat() + " " + getIdDepartament();
	}
}