package Enigma;

public class Model
{
	private String dane;			// tekst do zaszyfrowania przeslany z obiektu Okno
	private String zakodowane;		// tekst zaszyfrowany przeslany z obiektu Okno
	private int szyfr;
	
	public String getDane()
	{
		return dane;
	}
	public void setDane(String dane)
	{
		this.dane = dane;
	}
	public String getZakodowane()
	{
		return zakodowane;
	}
	public void setZakodowane(String zakodowane)
	{
		this.zakodowane = zakodowane;
	}
	public int getSzyfr()
	{
		return szyfr;
	}
	public void setSzyfr(int szyfr)
	{
		this.szyfr = szyfr;
	}
}
