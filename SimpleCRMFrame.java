package view_controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCRMFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField QuickSearchField;
	private JTextField searchField;
	private String[] BusinessEntities = new String[] {"client","manager","product","deal"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCRMFrame frame = new SimpleCRMFrame();
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
	public SimpleCRMFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Quick Search:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		QuickSearchField = new JTextField();
		QuickSearchField.setText("enter the tel..");
		GridBagConstraints gbc_QuickSearchField = new GridBagConstraints();
		gbc_QuickSearchField.insets = new Insets(0, 0, 5, 5);
		gbc_QuickSearchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_QuickSearchField.gridx = 2;
		gbc_QuickSearchField.gridy = 0;
		contentPane.add(QuickSearchField, gbc_QuickSearchField);
		QuickSearchField.setColumns(10);
		
		JLabel lblFind = new JLabel("Find:");
		GridBagConstraints gbc_lblFind = new GridBagConstraints();
		gbc_lblFind.anchor = GridBagConstraints.EAST;
		gbc_lblFind.insets = new Insets(0, 0, 5, 5);
		gbc_lblFind.gridx = 4;
		gbc_lblFind.gridy = 0;
		contentPane.add(lblFind, gbc_lblFind);
		
		JComboBox entetiesBox = new JComboBox(BusinessEntities);
		GridBagConstraints gbc_entetiesBox = new GridBagConstraints();
		gbc_entetiesBox.insets = new Insets(0, 0, 5, 5);
		gbc_entetiesBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_entetiesBox.gridx = 5;
		gbc_entetiesBox.gridy = 0;
		contentPane.add(entetiesBox, gbc_entetiesBox);
		
		searchField = new JTextField();
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.gridwidth = 2;
		gbc_searchField.insets = new Insets(0, 0, 5, 5);
		gbc_searchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchField.gridx = 6;
		gbc_searchField.gridy = 0;
		contentPane.add(searchField, gbc_searchField);
		searchField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 7;
		contentPane.add(addButton, gbc_addButton);
		
		JComboBox entetiesBox_1 = new JComboBox(BusinessEntities);
		GridBagConstraints gbc_entetiesBox_1 = new GridBagConstraints();
		gbc_entetiesBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_entetiesBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_entetiesBox_1.gridx = 2;
		gbc_entetiesBox_1.gridy = 7;
		contentPane.add(entetiesBox_1, gbc_entetiesBox_1);
		
		JButton editButton = new JButton("Edit");
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.insets = new Insets(0, 0, 0, 5);
		gbc_editButton.gridx = 4;
		gbc_editButton.gridy = 7;
		contentPane.add(editButton, gbc_editButton);
		
		JButton saveButton = new JButton("Save");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 5;
		gbc_saveButton.gridy = 7;
		contentPane.add(saveButton, gbc_saveButton);
		
		JButton deleteButton = new JButton("Delete");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 6;
		gbc_deleteButton.gridy = 7;
		contentPane.add(deleteButton, gbc_deleteButton);
	}

}
