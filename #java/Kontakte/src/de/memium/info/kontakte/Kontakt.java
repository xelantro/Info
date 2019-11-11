package de.memium.info.kontakte;

public class Kontakt {
	private String eMail;
	private long telefonNr;
	private String vorname;
	private String nachname;

	public Kontakt(String eMail, long telefonNr, String vorname, String nachname) {
		this.eMail = eMail;
		this.telefonNr = telefonNr;
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public boolean isGreater(Kontakt k)
	{
		return this.geteMail().hashCode()>k.geteMail().hashCode();
	}
	public boolean isLess(Kontakt k)
	{
		return this.geteMail().hashCode()<k.geteMail().hashCode();
	}
	public boolean isEquals(Kontakt k)
	{
		return this.geteMail().hashCode()==k.geteMail().hashCode();
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(long telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		return this.vorname+" "+this.nachname+", "+this.telefonNr+", "+this.eMail;
	}
}
