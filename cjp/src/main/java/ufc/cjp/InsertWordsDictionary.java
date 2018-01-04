package ufc.cjp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import ufc.cjp.control.Fachada;
import ufc.cjp.control.Perfil;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class InsertWordsDictionary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblWordPalavra_1;
	private JPanel panel;
	Fachada fachada = new Fachada();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */

	public InsertWordsDictionary() {
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 451, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(40, 88, 364, 43);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(40, 168, 364, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(40, 247, 364, 66);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblWordPalavra = new JLabel("Word");
		lblWordPalavra.setBounds(41, 63, 93, 14);
		contentPane.add(lblWordPalavra);

		JLabel lblTra = new JLabel("Meaning");
		lblTra.setBounds(40, 143, 145, 23);
		contentPane.add(lblTra);

		JLabel lblDescriptionDescrio = new JLabel("Example");
		lblDescriptionDescrio.setBounds(40, 222, 134, 14);
		contentPane.add(lblDescriptionDescrio);

		lblWordPalavra_1 = new JLabel("Add word dictionary");
		lblWordPalavra_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWordPalavra_1.setBounds(140, 11, 185, 33);
		contentPane.add(lblWordPalavra_1);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action_1);
		btnNewButton.setBounds(242, 323, 108, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBounds(105, 323, 108, 35);
		contentPane.add(btnNewButton_1);

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 44, 425, 329);
		contentPane.add(panel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			if (textField.getText().equals("") || textField_1.getText().equals("")
					|| textField_2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Algum campo vazio");
			} else {
				try {
					Fachada.insertWord(textField.getText(), textField_1.getText(), textField_2.getText(),
							Perfil.word);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				} catch (Exception e2) {

				}
			}
		}
	}
}
