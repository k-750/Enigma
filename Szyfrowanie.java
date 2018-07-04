package Enigma;

import java.util.Random;

public class Szyfrowanie
{
	public void zaszyfruj(Model daneWejsciowe)
	{
		System.out.println("tekst: "+daneWejsciowe.getDane()+",  szyfr: "+daneWejsciowe.getSzyfr());
		char[] daneChar = daneWejsciowe.getDane().toCharArray();		// pobiera tekst z obiektu Dane
		int dlugoscDane = daneChar.length;
		char[] zaszyfrowaneChar = new char[dlugoscDane];				// tworzy tablice o dlugosci tekstu Dane
		String zaszyfrowaneString =	"";									// String do dodawania znakow i przeslania do obiektu Dane jako zkodowane
		//List<Character> listaZaszyfrowana = new LinkedList<Character>();
		int n = 0;
		Random losowy = new Random();
		for (char x:daneChar) 		// pierwsze szyfrowanie - zmiana znakow
		{
			zaszyfrowaneChar[n]=(char)(x+daneWejsciowe.getSzyfr()/10);
			System.out.println("zaszyfrowane: "+zaszyfrowaneChar[n]);
			n++;
		}
		for (int i = 0; i<zaszyfrowaneChar.length; i++)			// drugie szyfrowanie i dodanie do listy
		{
			zaszyfrowaneString = zaszyfrowaneString + Character.toString(zaszyfrowaneChar[i]);
			System.out.println("szyfr%10 = "+daneWejsciowe.getSzyfr()%10);
			for (int m = 0; m < (daneWejsciowe.getSzyfr()%10); m++)
			{
				char losowyChar = 65;
				losowyChar += losowy.nextInt(57);
				zaszyfrowaneString = zaszyfrowaneString+Character.toString(losowyChar);
			}
		}
		daneWejsciowe.setZakodowane(zaszyfrowaneString);
	}
	
	public void rozszyfruj(Model daneWejsciowe)
	{
		System.out.println("zaszyfrowane dane: "+daneWejsciowe.getZakodowane()+",  szyfr: "+daneWejsciowe.getSzyfr());
		char[] daneChar = daneWejsciowe.getZakodowane().toCharArray();		// pobiera tekst z obiektu Dane
		int dlugoscDane = daneChar.length;
		char[] odszyfrowaneChar = new char[dlugoscDane];					// tworzy tablice o dlugosci tekstu Dane (zaszyfrowane)
		String odszyfrowaneString = "";										// String do dodawania znakow i przeslania do obiektu Dane jako dane rozszyfrowane
		int i=0;				// numer wiersza tabeli do zapisu odszyfrowanego tekstu
		int j=0;				// numer wiersza zaszyfrowanego tekstu sprawdzanego
		System.out.println("daneChar.lebgth - ilosc petli: "+(daneChar.length/(daneWejsciowe.getSzyfr()%10)-1));
		for (i = 0; i < (dlugoscDane/(daneWejsciowe.getSzyfr()%10+1)); i++)		
		{
			System.out.println("długość daneChar%10: "+(daneWejsciowe.getSzyfr()%10)+" i = "+i);
			odszyfrowaneChar[i] = (char)(daneChar[j]-daneWejsciowe.getSzyfr()/10);
			odszyfrowaneString = odszyfrowaneString+Character.toString(odszyfrowaneChar[i]);
			System.out.println("String: "+odszyfrowaneString);
			for (int n = 0; n < (daneWejsciowe.getSzyfr()%10); n++) j++;
			j++;
		}
		daneWejsciowe.setDane(odszyfrowaneString);
	}
	
}
