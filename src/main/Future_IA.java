package main;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import repository.ClubRepository;
import repository.ScheduleRepository;

import javax.swing.SpringLayout;

import model.Club;
import model.Schedule;

import javax.swing.JList;

public class Future_IA {

	private JFrame frame;
	private JTextField searchbox;
	private JTextField fname;
	private JTextField sname;
	private JTextField title;
	private JTextField location;
	private JTextField txtWriteAShort;
	private JTextField description;

	DatabaseConnection databaseConnection;
	ClubRepository clubRepository;
	ScheduleRepository scheduleRepository;
	
	
	JLabel lblteacher;
	JLabel lbltitle;
	JLabel lblcategory;
	JLabel lbldescription;
	JLabel lbllocation;
	JList listTime;
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
		databaseConnection = new DatabaseConnection();
		databaseConnection.connect();
		scheduleRepository = new ScheduleRepository(databaseConnection);
		clubRepository = new ClubRepository(databaseConnection);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel Main = new JPanel();
		frame.getContentPane().add(Main, "name_57465519047166");

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

		JPanel result = new JPanel();
		frame.getContentPane().add(result, "name_257718714039661");
		
		result.setLayout(null);

		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(73, 78, 46, 14);
		result.add(lblTeacher);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(73, 53, 46, 14);
		result.add(lblTitle);

		JLabel lblCategory_1 = new JLabel("Category");
		lblCategory_1.setBounds(73, 153, 46, 14);
		result.add(lblCategory_1);

		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(73, 103, 46, 14);
		result.add(lblNewLabel);

		JLabel lblLocation_1 = new JLabel("Location");
		lblLocation_1.setBounds(73, 127, 46, 14);
		result.add(lblLocation_1);

		JLabel lblDescription_1 = new JLabel("Description");
		lblDescription_1.setBounds(73, 178, 60, 14);
		result.add(lblDescription_1);

		lbltitle = new JLabel("New label");
		lbltitle.setBounds(147, 53, 46, 14);
		result.add(lbltitle);

		lblteacher = new JLabel("New label");
		lblteacher.setBounds(147, 78, 46, 14);
		result.add(lblteacher);

		lbllocation = new JLabel("New label");
		lbllocation.setBounds(147, 127, 46, 14);
		result.add(lbllocation);

		lblcategory = new JLabel("New label");
		lblcategory.setBounds(147, 153, 46, 14);
		result.add(lblcategory);

		lbldescription = new JLabel("New label");
		lbldescription.setBounds(147, 178, 46, 14);
		result.add(lbldescription);

		listTime = new JList();
		listTime.setBounds(329, 78, 194, 25);
		result.add(listTime);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(true);
				search.setVisible(false);
			}
		});
		btnBack.setBounds(22, 273, 66, 23);
		search.add(btnBack);

		searchbox = new JTextField();
		searchbox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				searchbox.setText("");
			}
		});
		searchbox.setText("Search");
		searchbox.setBounds(68, 48, 416, 38);
		search.add(searchbox);
		searchbox.setColumns(10);

		JLabel lblAccordingTo = new JLabel("According to");
		lblAccordingTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAccordingTo.setBounds(68, 122, 83, 20);
		search.add(lblAccordingTo);

		DefaultListModel<Club> listModel = new DefaultListModel();
		JList<Club> list = new JList<Club>(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList list = (JList) e.getSource();
				if (e.getClickCount() == 2) {
					// Double-click detected
					int index = list.locationToIndex(e.getPoint());
					resultPanelGetClub(listModel.get(index));
					search.setVisible(false);
					result.setVisible(true);
				}

			}
		});
		list.setBounds(293, 122, 191, 20);
		search.add(list);

		String[] searchm = { "Title", "Category", "Teacher" };
		JComboBox comboBox = new JComboBox(searchm);
		comboBox.setBounds(68, 153, 134, 20);
		search.add(comboBox);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchBy = comboBox.getSelectedItem().toString();
				Club club;
				if (searchBy.equals("Title")) {
					club = clubRepository.getClubByName(searchbox.getText());
					listModel.addElement(club);
				} else if (searchBy.equals("Category")) {
				} else if (searchBy.equals("Teacher")) {

				}
			}
		});
		btnSearch_1.setBounds(491, 56, 89, 23);
		search.add(btnSearch_1);

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

		fname = new JTextField();
		fname.setBounds(110, 63, 86, 20);
		create.add(fname);
		fname.setColumns(10);

		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(110, 97, 86, 20);
		create.add(sname);

		JLabel lblTitleOfThe = new JLabel("Title of the club");
		lblTitleOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTitleOfThe.setBounds(24, 130, 78, 14);
		create.add(lblTitleOfThe);

		title = new JTextField();
		title.setColumns(10);
		title.setBounds(110, 127, 86, 20);
		create.add(title);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLocation.setBounds(222, 66, 46, 14);
		create.add(lblLocation);

		location = new JTextField();
		location.setBounds(292, 63, 86, 20);
		create.add(location);
		location.setColumns(10);

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
		txtWriteAShort
				.setText("Write a short description (5-7 sentences) about your club");
		txtWriteAShort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtWriteAShort.setHorizontalAlignment(SwingConstants.CENTER);

		create.add(txtWriteAShort);
		txtWriteAShort.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDescription.setBounds(100, 173, 65, 17);
		create.add(lblDescription);

		String[] time = { "16:00-17:00", "16:30-17:30", "17:00-18:00",
				"17:30-18:30", "18:00-19:00" };
		JComboBox clock = new JComboBox(time);
		clock.setBounds(292, 97, 89, 20);
		create.add(clock);

		String[] week = { "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday" };
		JComboBox day = new JComboBox(week);
		day.setBounds(402, 97, 66, 20);
		create.add(day);

		String[] category = { "Music", "Creativity", "Sport", "Service" };
		JComboBox cat = new JComboBox(category);
		cat.setBounds(292, 127, 66, 20);
		create.add(cat);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Club club = new Club();
				Schedule schedule = new Schedule();
				club.setTeacher(fname.getText() + " " + sname.getText());
				club.setName(title.getText());
				club.setCategory(cat.getSelectedItem().toString());
				club.setDescription(description.getText());
				clubRepository.addClub(club);
				club = clubRepository.getClubByName(club.getName());
				schedule.setIdClub(club.getIdClub());
				schedule.setTime(clock.getSelectedItem().toString() + " "
						+ day.getSelectedItem().toString());
				scheduleRepository.addSchedule(schedule);
				// JOptionPane.showMessageDialog(null,
				// "You have successfully registered");
			}
		});
		btnSave.setBounds(335, 215, 89, 23);
		create.add(btnSave);

		description = new JTextField();
		description.setBounds(100, 201, 197, 50);
		create.add(description);
		description.setColumns(10);

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
		SpringLayout sl_Main = new SpringLayout();
		sl_Main.putConstraint(SpringLayout.NORTH, btnSearch, 68,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, btnSearch, 40,
				SpringLayout.WEST, Main);
		sl_Main.putConstraint(SpringLayout.EAST, btnSearch, 156,
				SpringLayout.WEST, Main);
		Main.setLayout(sl_Main);
		Main.add(btnSearch);

		JButton btnFavourite = new JButton("Favourite club");
		sl_Main.putConstraint(SpringLayout.NORTH, btnFavourite, 117,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, btnFavourite, 40,
				SpringLayout.WEST, Main);
		sl_Main.putConstraint(SpringLayout.EAST, btnFavourite, 156,
				SpringLayout.WEST, Main);
		btnFavourite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				favourite.setVisible(true);
			}
		});
		Main.add(btnFavourite);

		JButton btnCreate = new JButton("Create a club");
		sl_Main.putConstraint(SpringLayout.NORTH, btnCreate, 181,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, btnCreate, 40,
				SpringLayout.WEST, Main);
		sl_Main.putConstraint(SpringLayout.EAST, btnCreate, 156,
				SpringLayout.WEST, Main);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				create.setVisible(true);
			}
		});
		Main.add(btnCreate);

		JButton btnHelp = new JButton("Help");
		sl_Main.putConstraint(SpringLayout.NORTH, btnHelp, 231,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, btnHelp, 40,
				SpringLayout.WEST, Main);
		sl_Main.putConstraint(SpringLayout.EAST, btnHelp, 156,
				SpringLayout.WEST, Main);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setVisible(false);
				help.setVisible(true);
			}
		});
		Main.add(btnHelp);

		JLabel lblWelcomeMrmsUser = new JLabel("Welcome, Mr/Ms User!");
		sl_Main.putConstraint(SpringLayout.NORTH, lblWelcomeMrmsUser, 11,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, lblWelcomeMrmsUser, 137,
				SpringLayout.WEST, Main);
		sl_Main.putConstraint(SpringLayout.SOUTH, lblWelcomeMrmsUser, 57,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.EAST, lblWelcomeMrmsUser, 290,
				SpringLayout.WEST, Main);
		lblWelcomeMrmsUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWelcomeMrmsUser.setForeground(new Color(0, 0, 0));
		Main.add(lblWelcomeMrmsUser);

		JLabel label = new JLabel("");
		sl_Main.putConstraint(SpringLayout.NORTH, label, 117,
				SpringLayout.NORTH, Main);
		sl_Main.putConstraint(SpringLayout.WEST, label, 254, SpringLayout.WEST,
				Main);
		sl_Main.putConstraint(SpringLayout.SOUTH, label, 220,
				SpringLayout.NORTH, Main);
		Image img = new ImageIcon(this.getClass().getResource("/Club.png"))
				.getImage();
		label.setIcon(new ImageIcon(img));
		Main.add(label);

	}

	void resultPanelGetClub(Club club) {
		lbltitle.setText(club.getName());
		lblteacher.setText(club.getTeacher());
		lblcategory.setText(club.getCategory());
		lbllocation.setText(club.getLocation());
		lbldescription.setText(club.getDescription());
		DefaultListModel scheduleListModel = new DefaultListModel();
		List<Schedule> scheduleList = scheduleRepository.getClubSchedule(club.getIdClub());
		for(Schedule schedule: scheduleList){
			scheduleListModel.addElement(schedule.getTime());
		}
		listTime.setModel(scheduleListModel);
	}
}
