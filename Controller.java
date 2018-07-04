package Enigma;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controller implements Observer
{
	private Model model;
	private View view;
	private Szyfrowanie szyfr;
	
	public Controller(Model model, View view, Szyfrowanie szyfr)
	{
		this.model = model;
		this.view = view;
		this.szyfr = szyfr;
	}

	@Override
	public void update(Object s, JTextArea textDane, JTextArea textSzyfr,JRadioButton wyborSzyfru1,JRadioButton wyborSzyfru2,JTextField fieldSzyfr,JButton szyfruj,JButton wyczysc)
	{
		model.setDane(textDane.getText());
		Object source = s;
		
		if (source.equals(szyfruj)) 		// sprawdza, czy wcisnieto "szyfruj"
		{
			try
			{
				if (Integer.parseInt(fieldSzyfr.getText())>10 & Integer.parseInt(fieldSzyfr.getText())<100)		// sprawdza zakres Szyfru
				{
					model.setSzyfr(Integer.parseInt(fieldSzyfr.getText()));		// ustawia szyfr w obiekcie dane
			
					try
					{
						if (wyborSzyfru1.isSelected())				// sprawdza, ktory JRadioButton jest zaznaczony
						{
							model.setDane(textDane.getText());		// jeśli wybrano JRadioButton1 to wysyła tekst do zaszyfrowania i szyfr do obiektu dane
							szyfr.zaszyfruj(model);
							textSzyfr.setText(model.getZakodowane());
						}
						if (wyborSzyfru2.isSelected())
						{
							model.setZakodowane(textSzyfr.getText());	// jeśli wybrano JRadioButton2 to wysyła tekst zaszyfrowany i szyfr do obiektu dane
							szyfr.rozszyfruj(model);
							textDane.setText(model.getDane());
						}
					} catch (Exception e)
					{
						JOptionPane.showMessageDialog(null, "Błędne dane");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Szyfr poza zakresem");
				}
			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "Niewłaściwy szyfr");
			}
		}
		
		if (source.equals(wyczysc))				// sprawdza czy wcisnieto wyczysc
		{
			textDane.setText("");
			textSzyfr.setText("");
			fieldSzyfr.setText("");
		}		
	}

}
