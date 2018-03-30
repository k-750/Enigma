package Enigma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Okno extends JFrame implements ActionListener
{
	private JLabel labelDane;
	private JTextArea textDane;
	private JLabel labelSzyfr;
	private JLabel labelLiczba;
	private JTextArea textSzyfr;
	private JRadioButton wyborSzyfru1;
	private JRadioButton wyborSzyfru2;
	private JLabel labelPodajSzyfr;
	private JTextField fieldSzyfr;
	private JButton szyfruj;
	private ButtonGroup grupa;
	private JButton wyczysc;
	
	private Dane dane = new Dane();		// obiekt przechowujacy dane do zaszyfrowania, szyfr i dane zaszyfrowane
	
	public Okno()
	{
		super("Enigma");
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		labelDane = new JLabel();
			labelDane.setText("Tekst przed szyfrowaniem");
			labelDane.setSize(300,20);
			labelDane.setLocation(30,15);
			add(labelDane);
		
		textDane = new JTextArea();
			JScrollPane scDane = new JScrollPane(textDane);
			scDane.setSize(400,150);
			scDane.setLocation(30,40);
			add(scDane);
			
		labelSzyfr = new JLabel();
			labelSzyfr.setText("Tekst zaszyfrowany");
			labelSzyfr.setSize(300,20);
			labelSzyfr.setLocation(30,250);
			add(labelSzyfr);
		
		textSzyfr = new JTextArea();
			JScrollPane scSzyfr = new JScrollPane(textSzyfr);
			scSzyfr.setSize(400,150);
			scSzyfr.setLocation(30,280);
			add(scSzyfr);
			
		wyborSzyfru1 = new JRadioButton("Zaszyfruj", true);
			wyborSzyfru1.setLocation(500,60);
			wyborSzyfru1.setSize(100,30);
			add(wyborSzyfru1);
			wyborSzyfru1.addActionListener(this);

		wyborSzyfru2 = new JRadioButton("Rozszyfruj", false);
			wyborSzyfru2.setLocation(500,100);
			wyborSzyfru2.setSize(100,30);
			add(wyborSzyfru2);
			wyborSzyfru2.addActionListener(this);
			
		grupa = new ButtonGroup();
			grupa.add(wyborSzyfru1);
			grupa.add(wyborSzyfru2);
			
		labelPodajSzyfr = new JLabel("Podaj szyfr:");
			labelPodajSzyfr.setSize(100,30);
			labelPodajSzyfr.setLocation(510,170);
			add(labelPodajSzyfr);
			
		labelLiczba = new JLabel("(liczba od 11 do 99)");
			labelLiczba.setSize(150,30);
			labelLiczba.setLocation(510,215);
			add(labelLiczba);
			
		fieldSzyfr = new JTextField();
			fieldSzyfr.setSize(80,20);
			fieldSzyfr.setLocation(510,200);
			add(fieldSzyfr);
			
		szyfruj = new JButton("SZYFRUJ");
			szyfruj.setSize(145,30);
			szyfruj.setLocation(480,280);
			add(szyfruj);
			szyfruj.addActionListener(this);
			
		wyczysc = new JButton("Wyczyść");
			wyczysc.setSize(145,30);
			wyczysc.setLocation(480,330);
			add(wyczysc);
			wyczysc.addActionListener(this);
	
	}

	public void setVisibleOkno()		// metoda pokazujaca cale okno programu
	{
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a)
	{
		Object source = a.getSource();
		
		if (source.equals(szyfruj)) 		// sprawdza, czy wcisnieto "szyfruj"
		{
			try
			{
				if (Integer.parseInt(fieldSzyfr.getText())>10 & Integer.parseInt(fieldSzyfr.getText())<100)		// sprawdza zakres Szyfru
				{
					dane.setSzyfr(Integer.parseInt(fieldSzyfr.getText()));		// ustawia szyfr w obiekcie dane
			
					try
					{
						if (wyborSzyfru1.isSelected())				// sprawdza, ktory JRadioButton jest zaznaczony
						{
							dane.setDane(textDane.getText());		// jeśli wybrano JRadioButton1 to wysyła tekst do zaszyfrowania i szyfr do obiektu dane
							Szyfrowanie.zaszyfruj(dane);
							textSzyfr.setText(dane.getZakodowane());
						}
						if (wyborSzyfru2.isSelected())
						{
							dane.setZakodowane(textSzyfr.getText());	// jeśli wybrano JRadioButton2 to wysyła tekst zaszyfrowany i szyfr do obiektu dane
							Szyfrowanie.rozszyfruj(dane);
							textDane.setText(dane.getDane());
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
