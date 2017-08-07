package main;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;


public class Future_IA {

	private JFrame frame;
	private JTextField txtSearch;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtWriteAShort;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Future_IA window = new Future_IA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Future_IA() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Main = new JPanel();
		frame.getContentPane().add(Main, "name_57465519047166");
		Main.setLayout(null);
		
		JPanel search = new JPanel();
		frame.getContentPane().add(search, "name_57465586081248");
		search.setLayout(null);
		
		
		JPanel favourite = new JPanel();
		frame.getContentPane().add(favourite, "name_57465619305276");
		favourite.setLayout(null);
		
		JPanel create = new JPanel();
		frame.getContentPane().add(create, "name_57465656037423");
		create.setLayout(null);
		
		JPanel help = new JPanel();
		frame.getContentPane().add(help, "name_57465686176449");
		help.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(true);
				search.setVisible(false);
			}
		});
		btnBack.setBounds(22, 273, 66, 23);
		search.add(btnBack);
		
		txtSearch = new JTextField();
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtSearch.setText("");
			}
		});
		txtSearch.setText("Search");
		txtSearch.setBounds(68, 48, 416, 38);
		search.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblAccordingTo = new JLabel("According to");
		lblAccordingTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccordingTo.setBounds(68, 122, 83, 20);
		search.add(lblAccordingTo);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		String[] options = {"Name", "Teacher", "Category"};
		comboBox.setBounds(68, 153, 134, 20);
		search.add(comboBox);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(true);
				favourite.setVisible(false);
			}
		});
		btnBack_1.setBounds(22, 273, 66, 23);
		favourite.add(btnBack_1);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.setVisible(true);
				create.setVisible(false);
			}
		});
		btnBack_2.setBounds(22, 273, 66, 23);
		create.add(btnBack_2);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFirstName.setBounds(24, 62, 66, 23);
		create.add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second Name");
		lblSecondName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSecondName.setBounds(23, 96, 79, 23);
		create.add(lblSecondName);
		
		textField = new JTextField();
		textField.setBounds(110, 63, 86, 20);
		create.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 97, 86, 20);
		create.add(textField_1);
		
		JLabel lblTitleOfThe = new JLabel("Title of the club");
		lblTitleOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTitleOfThe.setBounds(24, 130, 78, 14);
		create.add(lblTitleOfThe);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 127, 86, 20);
		create.add(textField_2);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLocation.setBounds(222, 66, 46, 14);
		create.add(lblLocation);
		
		textField_3 = new JTextField();
		textField_3.setBounds(292, 63, 86, 20);
		create.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblClubCreator = new JLabel("Club Creator");
		lblClubCreator.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblClubCreator.setBounds(167, 23, 79, 23);
		create.add(lblClubCreator);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTime.setBounds(222, 100, 46, 14);
		create.add(lblTime);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCategory.setBounds(222, 130, 46, 14);
		create.add(lblCategory);
		
		txtWriteAShort = new JTextField();
		txtWriteAShort.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtWriteAShort.setText("");
			}
		});
		txtWriteAShort.setText("Write a short description (5-7 sentences) about your club");
		txtWriteAShort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtWriteAShort.setHorizontalAlignment(SwingConstants.CENTER);

		create.add(txtWriteAShort);
		txtWriteAShort.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDescription.setBounds(100, 173, 65, 17);
		create.add(lblDescription);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(335, 215, 89, 23);
		create.add(btnSave);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 201, 197, 50);
		create.add(textField_4);
		textField_4.setColumns(10);
		
		String  [] time  = {"16:00-17:00","16:30-17:30", "17:00-18:00", "17:30-18:30", "18:00-19:00"};
		JComboBox comboBox_1 = new JComboBox(time);
		comboBox_1.setBounds(292, 97, 67, 20);
		create.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(369, 97, 66, 20);
		create.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(292, 127, 66, 20);
		create.add(comboBox_3);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(true);
				help.setVisible(false);
			}
		});
		btnBack_3.setBounds(22, 273, 66, 23);
		help.add(btnBack_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.setVisible(false);
				search.setVisible(true);
			}
		});
		btnSearch.setBounds(40, 68, 116, 23);
		Main.add(btnSearch);
		
		JButton btnFavourite = new JButton("Favourite club");
		btnFavourite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				favourite.setVisible(true);
			}
		});
		btnFavourite.setBounds(40, 117, 116, 23);
		Main.add(btnFavourite);
		
		JButton btnCreate = new JButton("Create a club");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				create.setVisible(true);
			}
		});
		btnCreate.setBounds(40, 181, 116, 23);
		Main.add(btnCreate);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				help.setVisible(true);
			}
		});
		btnHelp.setBounds(40, 231, 116, 23);
		Main.add(btnHelp);
		
		JLabel lblWelcomeMrmsUser = new JLabel("Welcome, Mr/Ms User!");
		lblWelcomeMrmsUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWelcomeMrmsUser.setForeground(new Color(0, 0, 0));
		lblWelcomeMrmsUser.setBounds(137, 11, 153, 46);
		Main.add(lblWelcomeMrmsUser);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/Club.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(254, 117, 250, 103);
		Main.add(label);
		
		
		
		
		
	}
}
