package Enigma;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface Observer
{
	public void update(Object o, JTextArea dane, JTextArea szyfr,JRadioButton wyborSzyfru1,JRadioButton wyborSzyfru2,JTextField fieldSzyfr,JButton szyfruj,JButton wyczysc);
}
