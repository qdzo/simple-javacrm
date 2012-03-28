package view_controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Client;
import model.Priority;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientJDialog extends JDialog implements IModelClient{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3439150533682257548L;
	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameClientField;
	private JTextField lastNameClientField;
	private JTextField telephoneClientField;
	private JTextField emailClientField;
	private Client client;
	private JComboBox priorityClientBox;
	private JComboBox statusClientBox;

	
	
	public ClientJDialog(Frame frame,String title) {
		super(frame,title,true);
		setBounds(100, 100, 320, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFirstName = new JLabel("first name:");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 0;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			firstNameClientField = new JTextField();
			GridBagConstraints gbc_firstNameClientField = new GridBagConstraints();
			gbc_firstNameClientField.insets = new Insets(0, 0, 5, 0);
			gbc_firstNameClientField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstNameClientField.gridx = 1;
			gbc_firstNameClientField.gridy = 0;
			contentPanel.add(firstNameClientField, gbc_firstNameClientField);
			firstNameClientField.setColumns(10);
		}
		{
			JLabel lblSecondName = new JLabel("last name:");
			GridBagConstraints gbc_lblSecondName = new GridBagConstraints();
			gbc_lblSecondName.anchor = GridBagConstraints.EAST;
			gbc_lblSecondName.insets = new Insets(0, 0, 5, 5);
			gbc_lblSecondName.gridx = 0;
			gbc_lblSecondName.gridy = 1;
			contentPanel.add(lblSecondName, gbc_lblSecondName);
		}
		{
			lastNameClientField = new JTextField();
			GridBagConstraints gbc_lastNameClientField = new GridBagConstraints();
			gbc_lastNameClientField.insets = new Insets(0, 0, 5, 0);
			gbc_lastNameClientField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lastNameClientField.gridx = 1;
			gbc_lastNameClientField.gridy = 1;
			contentPanel.add(lastNameClientField, gbc_lastNameClientField);
			lastNameClientField.setColumns(10);
		}
		{
			JLabel lblTelephone = new JLabel("telephone:");
			GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
			gbc_lblTelephone.anchor = GridBagConstraints.EAST;
			gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
			gbc_lblTelephone.gridx = 0;
			gbc_lblTelephone.gridy = 2;
			contentPanel.add(lblTelephone, gbc_lblTelephone);
		}
		{
			telephoneClientField = new JTextField();
			GridBagConstraints gbc_telephoneClientField = new GridBagConstraints();
			gbc_telephoneClientField.insets = new Insets(0, 0, 5, 0);
			gbc_telephoneClientField.fill = GridBagConstraints.HORIZONTAL;
			gbc_telephoneClientField.gridx = 1;
			gbc_telephoneClientField.gridy = 2;
			contentPanel.add(telephoneClientField, gbc_telephoneClientField);
			telephoneClientField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("e-mail:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 3;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			emailClientField = new JTextField();
			GridBagConstraints gbc_emailClientField = new GridBagConstraints();
			gbc_emailClientField.insets = new Insets(0, 0, 5, 0);
			gbc_emailClientField.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailClientField.gridx = 1;
			gbc_emailClientField.gridy = 3;
			contentPanel.add(emailClientField, gbc_emailClientField);
			emailClientField.setColumns(10);
		}
		{
			JLabel lblPriority = new JLabel("Priority:");
			GridBagConstraints gbc_lblPriority = new GridBagConstraints();
			gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
			gbc_lblPriority.anchor = GridBagConstraints.EAST;
			gbc_lblPriority.gridx = 0;
			gbc_lblPriority.gridy = 4;
			contentPanel.add(lblPriority, gbc_lblPriority);
		}
		{
			priorityClientBox = new JComboBox(Priority.values());
			GridBagConstraints gbc_priorityClientBox = new GridBagConstraints();
			gbc_priorityClientBox.anchor = GridBagConstraints.WEST;
			gbc_priorityClientBox.insets = new Insets(0, 0, 5, 0);
			gbc_priorityClientBox.gridx = 1;
			gbc_priorityClientBox.gridy = 4;
			contentPanel.add(priorityClientBox, gbc_priorityClientBox);
		}
		{
			JLabel lblStatus = new JLabel("Status:");
			GridBagConstraints gbc_lblStatus = new GridBagConstraints();
			gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
			gbc_lblStatus.anchor = GridBagConstraints.EAST;
			gbc_lblStatus.gridx = 0;
			gbc_lblStatus.gridy = 5;
			contentPanel.add(lblStatus, gbc_lblStatus);
		}
		{
			statusClientBox = new JComboBox(model.Status.values());
			GridBagConstraints gbc_statusClientBox = new GridBagConstraints();
			gbc_statusClientBox.anchor = GridBagConstraints.WEST;
			gbc_statusClientBox.gridx = 1;
			gbc_statusClientBox.gridy = 5;
			contentPanel.add(statusClientBox, gbc_statusClientBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new DialogController().execute(Commands.ADD);	
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}




	@Override
	public Client getModel() {
		if(client==null)
		return null;
		if(checkTheFields()){
		client.setFirstName((firstNameClientField.getText()).trim());
		client.setSecondName((lastNameClientField.getText()).trim());
		client.setTelephone((telephoneClientField.getText()).trim());
		client.setEmail((emailClientField.getText()).trim());
		client.setPriority((Priority)priorityClientBox.getSelectedItem());
		client.setStatus((model.Status)statusClientBox.getSelectedItem());
		return client;
		}else return null;
	}




	@Override
	public void setModel(Client client) {
		this.client = client;
		firstNameClientField.setText(client.getFirstName());
		lastNameClientField.setText(client.getSecondName());
		telephoneClientField.setText(client.getTelephone());
		emailClientField.setText(client.getEmail());
		priorityClientBox.setSelectedItem(client.getPriority());
		statusClientBox.setSelectedItem(client.getStatus());
	}
	
	private boolean checkTheFields(){
		boolean flag = true;
		final String  WARNING = "a correct info is required!!";
		if(!(Client.validate((firstNameClientField.getText()).trim()))){
			firstNameClientField.setText(WARNING);
			flag = false;
		}
		if(!(Client.validate((lastNameClientField.getText()).trim()))){
				lastNameClientField.setText(WARNING);
				flag = false;
		}
		if(!(Client.validateTel((telephoneClientField.getText()).trim()))){
			telephoneClientField.setText(WARNING);
			flag = false;
		}
		if(!(Client.validateEmail((emailClientField.getText()).trim()))){
			emailClientField.setText(WARNING);
			flag = false;
		}
		return flag;
	}

}
