
package ufc.cjp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ufc.cjp.control.Fachada;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class WindowApp extends JFrame {

	private JPanel contentPane;
	String text = " type yes to start";
	private JTextField imput;
	String frameText;
	static int lines;
	JTextArea textArea;
	static JTextArea countWords;
	boolean conversation = false;
	String[] b;
	Fachada fachada = new Fachada();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApp frame = new WindowApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowApp() throws IOException {
		setTitle("Eng");
		lines = fachada.countLine();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WindowApp.class.getResource("/ufc/img/Roboval-Mascot-NoBGloop.gif")));
		lblNewLabel.setBounds(491, 33, 256, 261);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Dialog", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBounds(25, 42, 467, 227);
		contentPane.add(textArea);

		JSeparator separator = new JSeparator();
		separator.setBounds(27, 281, 603, 2);
		contentPane.add(separator);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 834, 21);
		contentPane.add(menuBar);

		JMenu mnAdicionar = new JMenu("Add");
		menuBar.add(mnAdicionar);

		JMenuItem mntmWord = new JMenuItem("word");
		mntmWord.setAction(action_1);
		mnAdicionar.add(mntmWord);

		JMenuItem mntmPhrase = new JMenuItem("phrase");
		mntmPhrase.setAction(action_3);
		mnAdicionar.add(mntmPhrase);

		JMenu mnDictionary = new JMenu("Dictionary");
		menuBar.add(mnDictionary);

		JMenuItem mntmConsult = new JMenuItem("consult");
		mntmConsult.setAction(action_5);
		mnDictionary.add(mntmConsult);

		JMenuItem mntmInsertwords = new JMenuItem("insert_words");
		mntmInsertwords.setAction(action_4);
		mnDictionary.add(mntmInsertwords);

		imput = new JTextField();
		imput.setForeground(Color.BLACK);
		imput.setFont(new Font("Dialog", Font.PLAIN, 18));
		imput.setBounds(27, 291, 548, 72);
		contentPane.add(imput);
		imput.setColumns(13);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setAction(action_2);
		btnClear.setBounds(588, 333, 122, 30);
		contentPane.add(btnClear);

		countWords = new JTextArea("words and phrases:\n " + String.valueOf(fachada.countLine()));
		countWords.setWrapStyleWord(true);
		countWords.setEditable(false);
		countWords.setFont(new Font("Cambria", Font.PLAIN, 15));
		countWords.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		countWords.setBounds(499, 221, 145, 36);
		contentPane.add(countWords);

		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conversation == false && imput.getText().equals("yes")) {
					try {
						conversation = true;
						b = fachada.conversation().split(";");
						textArea.setText(b[0]);
						imput.setText("");
					} catch (IOException e1) {

					}

				} else if (conversation == true && imput.getText().equals("show -ld")) {
					JOptionPane.showMessageDialog(null, b[2]);
					imput.setText("");
				}

				else if (conversation == true && !imput.getText().equals("show -ld")) {
					if (imput.getText().equals(b[1])) {
						frameText = "correto!!!\n";
					}

					else {
						frameText = ">>> não desista\n";
					}
					try {
						b = fachada.conversation().split(";");
						textArea.setText(frameText + b[0]);
						imput.setText("");
					} catch (IOException e1) {

					}

				}

			}
		});
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent event) {
				if (event.getID() == KeyEvent.KEY_RELEASED && event.getKeyCode() == KeyEvent.VK_ENTER) {
					if (conversation == false && imput.getText().equals("yes")) {
						try {
							conversation = true;
							b = fachada.conversation().split(";");
							textArea.setText(b[0]);
							imput.setText("");
						} catch (IOException e1) {

						}
					} else if (conversation == true && imput.getText().equals("ls -d")) {
						JOptionPane.showMessageDialog(null, b[2]);
						imput.setText("");
						
					} else if (conversation == true && !imput.getText().equals("")) {
						if (imput.getText().equals(b[1])) {
							frameText = "correto!!!\n";

						} else {
							frameText = ">>> não desista\n";
						}
						try {
							b = fachada.conversation().split(";");
							textArea.setText(frameText + b[0]);
							imput.setText("");
						} catch (IOException e1) {

						}

					}

					return true;
				}
				return false;
			}
		});

		enter.setBounds(587, 295, 123, 30);
		contentPane.add(enter);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 34, 738, 343);
		contentPane.add(panel);

		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { contentPane, lblNewLabel, textArea, separator, menuBar, mnAdicionar, imput }));
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "word");
			putValue(SHORT_DESCRIPTION, "add word");
		}

		public void actionPerformed(ActionEvent e) {
			new Words();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			imput.setText("");
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "phrases");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			new Phrase();
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "insert_words");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			new InsertWordsDictionary();
		}
	}

	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "colsult");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			new Search();

		}

	}

	public static void countWords() {
		countWords.setText("words and phrases:\n " + String.valueOf(Fachada.count()));

	}
}
