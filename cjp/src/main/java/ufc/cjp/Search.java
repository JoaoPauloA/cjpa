package ufc.cjp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import ufc.cjp.control.Fachada;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Search extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblWordPalavra_1;
	private JPanel panel;
	Fachada fachada = new Fachada();
	private final Action action_1 = new SwingAction();

	public Search() {
		setAutoRequestFocus(false);
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 451, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(31, 64, 265, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		lblWordPalavra_1 = new JLabel("search word");
		lblWordPalavra_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWordPalavra_1.setBounds(181, 11, 115, 33);
		contentPane.add(lblWordPalavra_1);

		JButton btnNewButton = new JButton("s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action_1);
		btnNewButton.setBounds(306, 64, 108, 35);
		contentPane.add(btnNewButton);

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 43, 425, 74);
		contentPane.add(panel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String[] b;
			try {
				b = Fachada.consultDictionary(textField.getText());
				if (b != null) {
					new ResultaSearchDictionary("  - " + b[0], "  - " + b[1], "  - " + b[2]);
				} else {
					JOptionPane.showMessageDialog(null, "You still have not taught me that word");
				}

			} catch (Exception e2) {

			}
		}
	}
}
