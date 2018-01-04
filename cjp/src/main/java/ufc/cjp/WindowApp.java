package ufc.cjp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import ufc.cjp.services.Fachada;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.MatteBorder;

public class WindowApp extends JFrame {
    
	private static String mensagem = "Olá. Para iniciar uma conversa digite sim";
	private JPanel contentPane;
	private JTextField imputText;
	private JTextArea textArea;
    static boolean conversation = false;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public WindowApp() {
		setTitle("IA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -28, 666, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WindowApp.class.getResource("/ufc/img/Roboval-Mascot-NoBGloop.gif")));
		lblNewLabel.setBounds(397, 12, 257, 268);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea(mensagem);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Dialog", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBounds(29, 40, 360, 142);
		contentPane.add(textArea);

		// Botão Enter-------------------
		JButton botEnter = new JButton("Enter");
		botEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!imputText.getText().equals("")) {
					textArea.setText(imputText.getText());
					imputText.setText("");
				}
			}
		});
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent event) {
				if (event.getID() == KeyEvent.KEY_RELEASED && event.getKeyCode() == KeyEvent.VK_ENTER) {
					if(imputText.getText().equals("sim")) {
						conversation = true;
						JOptionPane.showMessageDialog(null, conversation);
					}
						
					else if (!imputText.getText().equals("") && conversation == true) {
						textArea.setText(imputText.getText());
						JOptionPane.showMessageDialog(null, conversation);
						imputText.setText("");

					}
					return true;
				}
				return false;
			}
		});
		botEnter.setBounds(218, 268, 75, 25);
		contentPane.add(botEnter);
		// -----------------------------------------

		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 564, 21);
		contentPane.add(menuBar);

		JMenu mnAdicionar = new JMenu("Add");
		menuBar.add(mnAdicionar);

		JMenuItem mntmWords = new JMenuItem("words");
		mnAdicionar.add(mntmWords);

		JMenuItem mntmPhrases = new JMenuItem("phrases");
		mnAdicionar.add(mntmPhrases);

		JMenu mnNewMenu = new JMenu("Dictionary");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAddWords = new JMenuItem("add words");
		mnNewMenu.add(mntmAddWords);

		JMenuItem mntmConsultDictionary = new JMenuItem("consult dictionary");
		mnNewMenu.add(mntmConsultDictionary);

		JMenuItem mntmTranslate = new JMenuItem("translate");
		mnNewMenu.add(mntmTranslate);

		imputText = new JTextField();
		imputText.setForeground(Color.BLACK);
		imputText.setFont(new Font("Dialog", Font.PLAIN, 15));
		imputText.setBounds(29, 212, 360, 44);
		contentPane.add(imputText);
		imputText.setColumns(13);

		// Botão Clear-------------------------------------
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imputText.setText("");
			}
		});
		btnClear.setAction(action);

		btnClear.setBounds(131, 268, 75, 25);
		contentPane.add(btnClear);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane, lblNewLabel, textArea,
				botEnter,menuBar, mnAdicionar, imputText }));
		// -------------------------------------------------------------
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "to clear the text");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
