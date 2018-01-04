package ufc.cjp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ResultaSearchDictionary extends JFrame {

	private JPanel contentPane;
	String word, meaning, exemple;

	public ResultaSearchDictionary(String word, String meaning, String exemple) {
		this.word = word;
		this.meaning = meaning;
		this.exemple = exemple;
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 448, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea(word);
		textArea.setBackground(SystemColor.control);
		textArea.setBounds(38, 52, 356, 28);
		contentPane.add(textArea);

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBounds(38, 35, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblMeaning = new JLabel("Meaning");
		lblMeaning.setBounds(38, 90, 74, 22);
		contentPane.add(lblMeaning);

		JTextArea textArea_1 = new JTextArea(meaning);
		textArea_1.setBackground(SystemColor.control);
		textArea_1.setBounds(38, 112, 370, 63);
		contentPane.add(textArea_1);

		JLabel lblExemple = new JLabel("Exemple");
		lblExemple.setBounds(38, 184, 74, 22);
		contentPane.add(lblExemple);

		JTextArea textArea_2 = new JTextArea(exemple);
		textArea_2.setBackground(SystemColor.control);
		textArea_2.setBounds(38, 210, 370, 46);
		contentPane.add(textArea_2);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel.setBounds(10, 24, 422, 259);
		contentPane.add(panel);
	}
}
