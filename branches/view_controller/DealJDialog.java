package view_controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import model.Client;
import model.Destribution;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;

public class DealJDialog extends JDialog implements IModelDestribution,IDisplayable,ICommandable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402793380772715703L;
	private final JPanel contentPanel = new JPanel();
	private ICommand controller;
	private Commands commandToDo;
	private Destribution destribution;
	private ListDialog clientsViewList;
	private ListDialog managersViewList;
	private ListDialog productsViewList;
	


	public DealJDialog(Frame frame,String title) {
		super(frame,title,true);
		clientsViewList = new ListDialog();
		managersViewList = new ListDialog();
		productsViewList = new ListDialog();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblProduct = new JLabel("product:");
			GridBagConstraints gbc_lblProduct = new GridBagConstraints();
			gbc_lblProduct.anchor = GridBagConstraints.EAST;
			gbc_lblProduct.insets = new Insets(0, 0, 5, 5);
			gbc_lblProduct.gridx = 0;
			gbc_lblProduct.gridy = 0;
			contentPanel.add(lblProduct, gbc_lblProduct);
		}
		{
			JButton btnSetproduct = new JButton(" setProduct ");
			btnSetproduct.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					productsViewList.init();
				}
			});
			GridBagConstraints gbc_btnSetproduct = new GridBagConstraints();
			gbc_btnSetproduct.anchor = GridBagConstraints.WEST;
			gbc_btnSetproduct.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetproduct.gridx = 1;
			gbc_btnSetproduct.gridy = 0;
			contentPanel.add(btnSetproduct, gbc_btnSetproduct);
		}
		{
			JLabel lblClient = new JLabel("client:");
			GridBagConstraints gbc_lblClient = new GridBagConstraints();
			gbc_lblClient.anchor = GridBagConstraints.EAST;
			gbc_lblClient.insets = new Insets(0, 0, 5, 5);
			gbc_lblClient.gridx = 0;
			gbc_lblClient.gridy = 1;
			contentPanel.add(lblClient, gbc_lblClient);
		}
		{
			JButton btnSetclient = new JButton("   setClient   ");
			btnSetclient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clientsViewList.init();
				}
			});
			GridBagConstraints gbc_btnSetclient = new GridBagConstraints();
			gbc_btnSetclient.anchor = GridBagConstraints.WEST;
			gbc_btnSetclient.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetclient.gridx = 1;
			gbc_btnSetclient.gridy = 1;
			contentPanel.add(btnSetclient, gbc_btnSetclient);
		}
		{
			JLabel lblTime = new JLabel("time:");
			GridBagConstraints gbc_lblTime = new GridBagConstraints();
			gbc_lblTime.insets = new Insets(0, 0, 5, 0);
			gbc_lblTime.gridx = 3;
			gbc_lblTime.gridy = 1;
			contentPanel.add(lblTime, gbc_lblTime);
		}
		{
			JLabel lblManager = new JLabel("manager:");
			GridBagConstraints gbc_lblManager = new GridBagConstraints();
			gbc_lblManager.anchor = GridBagConstraints.EAST;
			gbc_lblManager.insets = new Insets(0, 0, 5, 5);
			gbc_lblManager.gridx = 0;
			gbc_lblManager.gridy = 2;
			contentPanel.add(lblManager, gbc_lblManager);
		}
		{
			JButton btnSetmanager = new JButton("setManager");
			btnSetmanager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					managersViewList.init();
				}
			});
			GridBagConstraints gbc_btnSetmanager = new GridBagConstraints();
			gbc_btnSetmanager.anchor = GridBagConstraints.WEST;
			gbc_btnSetmanager.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetmanager.gridx = 1;
			gbc_btnSetmanager.gridy = 2;
			contentPanel.add(btnSetmanager, gbc_btnSetmanager);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 3;
			gbc_label.gridy = 2;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel lblStatus = new JLabel("status:");
			GridBagConstraints gbc_lblStatus = new GridBagConstraints();
			gbc_lblStatus.anchor = GridBagConstraints.EAST;
			gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatus.gridx = 0;
			gbc_lblStatus.gridy = 3;
			contentPanel.add(lblStatus, gbc_lblStatus);
		}
		{
			JComboBox statusProductBox = new JComboBox();
			GridBagConstraints gbc_statusProductBox = new GridBagConstraints();
			gbc_statusProductBox.insets = new Insets(0, 0, 5, 5);
			gbc_statusProductBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_statusProductBox.gridx = 1;
			gbc_statusProductBox.gridy = 3;
			contentPanel.add(statusProductBox, gbc_statusProductBox);
		}
		{
			JLabel lblComment = new JLabel("comment:");
			GridBagConstraints gbc_lblComment = new GridBagConstraints();
			gbc_lblComment.insets = new Insets(0, 0, 0, 5);
			gbc_lblComment.gridx = 0;
			gbc_lblComment.gridy = 4;
			contentPanel.add(lblComment, gbc_lblComment);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 4;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				JTextArea commentArea = new JTextArea();
				commentArea.setLineWrap(true);
				commentArea.setWrapStyleWord(true);
				scrollPane.setViewportView(commentArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		// TODO	 implement the method to check the correction of entered information	
						if(true){
						controller.execute(commandToDo, BusinessObjects.deal, getModel());
						controller.execute(Commands.CLOSE, BusinessObjects.manager, null);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.execute(Commands.CLOSE, BusinessObjects.deal, null);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	@Override
	public void init() {
		 try {
				System.out.println("deal-dialog is popup");
				this.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
		
	}


	@Override
	public void close() {
		try{
			this.dispose();
		}catch(Exception ex){
			System.out.println("JDialog is not initialized!");
		}
		
	}
	
	
	public void setController(ICommand icommand){
		controller = icommand;
	}

	
	public void setCommandToDo(Commands nextCommand){
		commandToDo = nextCommand;
	}


	@Override
	public void setModel(Destribution destribution) {
	// TODO realize the method
		if(destribution!=null)
		this.destribution = destribution;
		}


	@Override
	public Destribution getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setClients(List<Object> listClients){
		if(listClients==null){
			System.out.println("clients not set");
			return;
		}
		clientsViewList.setItems(listClients);
			
	}
	
	public void setManagers(List<Object> listClients){
		if(listClients==null){
			System.out.println("Managers not set");
			return;
		}
		managersViewList.setItems(listClients);
			
	}
	
	public void setProducts(List<Object> listClients){
		if(listClients==null){
			System.out.println("Products not set");
			return;
		}
		productsViewList.setItems(listClients);
			
	}
}
