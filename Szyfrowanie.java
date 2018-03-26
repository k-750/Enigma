package Enigma;

public class Szyfrowanie
{
	public static void zaszyfruj(Dane daneWejsciowe)
	{
		System.out.println("tekst: "+daneWejsciowe.getDane()+",  szyfr: "+daneWejsciowe.getSzyfr());
		char[] daneChar = daneWejsciowe.getDane().toCharArray();		// pobiera tekst z obiektu Dane
		int dlugoscDane = daneChar.length;
		char[] zaszyfrowaneChar = new char[dlugoscDane];				// tworzy tablice o dlugosci tekstu Dane
		String zaszyfrowaneString =	"";									// String do dodawania znakow i przeslania do obiektu Dane jako zkodowane
		int i = 0;
		for (char x:daneChar) 
		{
			zaszyfrowaneChar[i]=(char)(x+daneWejsciowe.getSzyfr()/10);
			zaszyfrowaneString = zaszyfrowaneString+Character.toString(zaszyfrowaneChar[i]);
			//System.out.println(zaszyfrowaneChar[i]);
			i++;
		}
		daneWejsciowe.setZakodowane(zaszyfrowaneString);
	}
	
	public static void rozszyfruj(Dane daneWejsciowe)
	{
		System.out.println("zaszyfrowane dane: "+daneWejsciowe.getZakodowane()+",  szyfr: "+daneWejsciowe.getSzyfr());
		char[] daneChar = daneWejsciowe.getZakodowane().toCharArray();		// pobiera tekst z obiektu Dane
		int dlugoscDane = daneChar.length;
		char[] odszyfrowaneChar = new char[dlugoscDane];					// tworzy tablice o dlugosci tekstu Dane
		String odszyfrowaneString = "";										// String do dodawania znakow i przeslania do obiektu Dane jako dane rozszyfrowane
		int i=0;
		for (char x:daneChar)
		{
			odszyfrowaneChar[i] = (char)(x-daneWejsciowe.getSzyfr()/10);
			odszyfrowaneString = odszyfrowaneString+Character.toString(odszyfrowaneChar[i]);
			i++;
		}
		daneWejsciowe.setDane(odszyfrowaneString);
	}
	
}
