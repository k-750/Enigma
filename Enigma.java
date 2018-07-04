package Enigma;

public class Enigma
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Szyfrowanie szyfr = new Szyfrowanie();
		Controller controller = new Controller(model,view,szyfr);
		view.addObserver(controller);
	}

}
