package ufc.cjp;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class WindowApp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 513, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WindowApp.class.getResource("/ufc/img/Matrix.gif")));
		lblNewLabel.setBounds(24, 42, 81, 78);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Dialog", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBounds(118, 41, 360, 135);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(403, 247, 75, 25);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(118, 188, 360, 7);
		contentPane.add(separator);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 513, 21);
		contentPane.add(menuBar);
		
		JMenu mnAdicionar = new JMenu("Adicionar");
		menuBar.add(mnAdicionar);
		
		JMenuItem mntmItem = new JMenuItem("Item 1");
		mnAdicionar.add(mntmItem);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBounds(118, 196, 360, 44);
		contentPane.add(textField);
		textField.setColumns(13);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(316, 247, 75, 25);
		contentPane.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 27, 491, 272);
		contentPane.add(panel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblNewLabel, textArea, btnNewButton, separator, menuBar, mnAdicionar, mntmItem, textField}));
	}
}
