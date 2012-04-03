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
import view_controller.BusinessObjects;
import model.Client;
import model.Model;

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
	private BusinessObjects[] BusinessEntities = BusinessObjects.values();
	private DealJDialog dealDialog;
	private ClientJDialog clientDialog;
	private ManagerJDialog managerDialog;
	private ProductJDialog productDialog;
	private JButton deleteButton;
	private JButton saveButton;
	private JButton editButton;
	private JComboBox addEntetiesBox;
	private JButton addButton;
	private JButton searchButton;
	private JComboBox findEntetiesBox;
	private JLabel lblFind;
	private JDialogsController controller;
	private Model model;
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
	
		initMainFrame();
		initJDialogs();
		initController();
		setDefaultController(controller);
		model = new Model();
		
	}		
	
	
	private void setDefaultController(ICommand defaultController) {
		productDialog.setController(defaultController);
		dealDialog.setController(defaultController);
		clientDialog.setController(defaultController);
		managerDialog.setController(defaultController);
		
	}

	private void initController(){
		controller = new JDialogsController();
		controller.setClientDialog(clientDialog);
		controller.setDealDialog(dealDialog);
		controller.setManagerDialog(managerDialog);
		controller.setProductDialog(productDialog);
	}
	
	private void initJDialogs(){
		productDialog = new ProductJDialog(this,"Product");
		dealDialog = new DealJDialog(this,"Product") ;
		clientDialog = new ClientJDialog(this,"Client");
		managerDialog = new ManagerJDialog(this,"Manager");
	}
	
	
	private void initMainFrame(){
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
		QuickSearchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = QuickSearchField.getText().trim();
				Client sClient =  new Client(null);
				sClient.setTelephone(tel);
				controller.execute(Commands.QUICKFIND, BusinessObjects.client,sClient);
			}
		});
		QuickSearchField.setText("enter the tel..");
		GridBagConstraints gbc_QuickSearchField = new GridBagConstraints();
		gbc_QuickSearchField.insets = new Insets(0, 0, 5, 5);
		gbc_QuickSearchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_QuickSearchField.gridx = 2;
		gbc_QuickSearchField.gridy = 0;
		contentPane.add(QuickSearchField, gbc_QuickSearchField);
		QuickSearchField.setColumns(10);
		
		lblFind = new JLabel("Search:");
		GridBagConstraints gbc_lblFind = new GridBagConstraints();
		gbc_lblFind.anchor = GridBagConstraints.EAST;
		gbc_lblFind.insets = new Insets(0, 0, 5, 5);
		gbc_lblFind.gridx = 4;
		gbc_lblFind.gridy = 0;
		contentPane.add(lblFind, gbc_lblFind);
		
		findEntetiesBox = new JComboBox(BusinessEntities);
		GridBagConstraints gbc_findEntetiesBox = new GridBagConstraints();
		gbc_findEntetiesBox.insets = new Insets(0, 0, 5, 5);
		gbc_findEntetiesBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_findEntetiesBox.gridx = 5;
		gbc_findEntetiesBox.gridy = 0;
		contentPane.add(findEntetiesBox, gbc_findEntetiesBox);
		
		searchButton = new JButton("Find");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.execute(Commands.FIND,(BusinessObjects)findEntetiesBox.getSelectedItem(), null);
			}
		});
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.insets = new Insets(0, 0, 5, 5);
		gbc_btnFind.gridx = 6;
		gbc_btnFind.gridy = 0;
		contentPane.add(searchButton, gbc_btnFind);
		
		
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
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.execute(Commands.CREATE,(BusinessObjects)addEntetiesBox.getSelectedItem(), null);
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 7;
		contentPane.add(addButton, gbc_addButton);
		
		addEntetiesBox = new JComboBox(BusinessEntities);
		GridBagConstraints gbc_AddEntetiesBox = new GridBagConstraints();
		gbc_AddEntetiesBox.insets = new Insets(0, 0, 0, 5);
		gbc_AddEntetiesBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_AddEntetiesBox.gridx = 2;
		gbc_AddEntetiesBox.gridy = 7;
		contentPane.add(addEntetiesBox, gbc_AddEntetiesBox);
		
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.execute(Commands.EDIT, BusinessObjects.client, null);
			}
		});
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.insets = new Insets(0, 0, 0, 5);
		gbc_editButton.gridx = 4;
		gbc_editButton.gridy = 7;
		contentPane.add(editButton, gbc_editButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.execute(Commands.SAVE, BusinessObjects.client, null);
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 5;
		gbc_saveButton.gridy = 7;
		contentPane.add(saveButton, gbc_saveButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.execute(Commands.DELETE, BusinessObjects.client, null);
			}
		});
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 6;
		gbc_deleteButton.gridy = 7;
		contentPane.add(deleteButton, gbc_deleteButton);
	}

		
	
}
