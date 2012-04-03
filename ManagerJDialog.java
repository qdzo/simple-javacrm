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
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import model.Manager;
import model.Status;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerJDialog extends JDialog implements IModelManager, IDisplayable,ICommandable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7324050436165136557L;
	/**
	 * 
	 */
	
	private final JPanel contentPanel = new JPanel();
	private JTextField emailManagerField;
	private JTextField telephoneManagerField;
	private JTextField lastNameManagerField;
	private JTextField firstNameManagerField;
	private JComboBox statusManagerBox;
	private Manager manager;
	private JLabel msgLabel;
	private ICommand controller;
	private Commands commandToDo;



	public ManagerJDialog(Frame frame,String title) {
		super(frame,title,true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFirstName = new JLabel("first name:");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.gridx = 0;
			gbc_lblFirstName.gridy = 0;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			firstNameManagerField = new JTextField();
			GridBagConstraints gbc_firstNameManagerField = new GridBagConstraints();
			gbc_firstNameManagerField.gridwidth = 2;
			gbc_firstNameManagerField.insets = new Insets(0, 0, 5, 5);
			gbc_firstNameManagerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_firstNameManagerField.gridx = 1;
			gbc_firstNameManagerField.gridy = 0;
			contentPanel.add(firstNameManagerField, gbc_firstNameManagerField);
			firstNameManagerField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("last name:");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_lblLastName.anchor = GridBagConstraints.EAST;
			gbc_lblLastName.gridx = 0;
			gbc_lblLastName.gridy = 1;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			lastNameManagerField = new JTextField();
			GridBagConstraints gbc_lastNameManagerField = new GridBagConstraints();
			gbc_lastNameManagerField.gridwidth = 2;
			gbc_lastNameManagerField.insets = new Insets(0, 0, 5, 5);
			gbc_lastNameManagerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lastNameManagerField.gridx = 1;
			gbc_lastNameManagerField.gridy = 1;
			contentPanel.add(lastNameManagerField, gbc_lastNameManagerField);
			lastNameManagerField.setColumns(10);
		}
		{
			JLabel lblTelephone = new JLabel("telephone:");
			GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
			gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
			gbc_lblTelephone.anchor = GridBagConstraints.EAST;
			gbc_lblTelephone.gridx = 0;
			gbc_lblTelephone.gridy = 2;
			contentPanel.add(lblTelephone, gbc_lblTelephone);
		}
		{
			telephoneManagerField = new JTextField();
			GridBagConstraints gbc_telephoneManagerField = new GridBagConstraints();
			gbc_telephoneManagerField.gridwidth = 2;
			gbc_telephoneManagerField.insets = new Insets(0, 0, 5, 5);
			gbc_telephoneManagerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_telephoneManagerField.gridx = 1;
			gbc_telephoneManagerField.gridy = 2;
			contentPanel.add(telephoneManagerField, gbc_telephoneManagerField);
			telephoneManagerField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("e-mail:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 3;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			emailManagerField = new JTextField();
			GridBagConstraints gbc_emailManagerField = new GridBagConstraints();
			gbc_emailManagerField.gridwidth = 2;
			gbc_emailManagerField.insets = new Insets(0, 0, 5, 5);
			gbc_emailManagerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailManagerField.gridx = 1;
			gbc_emailManagerField.gridy = 3;
			contentPanel.add(emailManagerField, gbc_emailManagerField);
			emailManagerField.setColumns(10);
		}
		{
			JLabel lblStatus = new JLabel("status:");
			GridBagConstraints gbc_lblStatus = new GridBagConstraints();
			gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatus.anchor = GridBagConstraints.EAST;
			gbc_lblStatus.gridx = 0;
			gbc_lblStatus.gridy = 4;
			contentPanel.add(lblStatus, gbc_lblStatus);
		}
		{
			statusManagerBox = new JComboBox(Status.values());
			GridBagConstraints gbc_statusManagerBox = new GridBagConstraints();
			gbc_statusManagerBox.insets = new Insets(0, 0, 5, 5);
			gbc_statusManagerBox.anchor = GridBagConstraints.WEST;
			gbc_statusManagerBox.gridx = 1;
			gbc_statusManagerBox.gridy = 4;
			contentPanel.add(statusManagerBox, gbc_statusManagerBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				msgLabel = new JLabel("");
				buttonPane.add(msgLabel);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(checkTheFields()){
						controller.execute(commandToDo, BusinessObjects.manager, getModel());
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
						controller.execute(Commands.CLOSE, BusinessObjects.manager, null);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}



	@Override
	public Manager getModel() {
		if(manager==null)
			return null;
			if(checkTheFields()){
			manager.setFirstName((firstNameManagerField.getText()).trim());
			manager.setSecondName((lastNameManagerField.getText()).trim());
			manager.setTelephone((telephoneManagerField.getText()).trim());
			manager.setEmail((emailManagerField.getText()).trim());
			manager.setStatus((model.Status)statusManagerBox.getSelectedItem());
			return manager;
			}else return null;
	}



	@Override
	public void setModel(Manager manager) {
		this.manager = manager;
		firstNameManagerField.setText(manager.getFirstName());
		lastNameManagerField.setText(manager.getSecondName());
		telephoneManagerField.setText(manager.getTelephone());
		emailManagerField.setText(manager.getEmail());
		statusManagerBox.setSelectedItem(manager.getStatus());
	}

	

	private boolean checkTheFields(){
		final String WARNING = "UNCORRECT ";
		String  warningMsg = WARNING;
		if(!(Manager.validate((firstNameManagerField.getText()).trim()))){
			warningMsg+="First name, ";
		}
		if(!(Manager.validate((lastNameManagerField.getText()).trim()))){
			warningMsg+="Last name, ";
		}
		if(!(Manager.validateTel((telephoneManagerField.getText()).trim()))){
			warningMsg+="Telephone, ";
		}
		if(!(Manager.validateEmail((emailManagerField.getText()).trim()))){
			warningMsg+="E-mail!";
		}
		if(warningMsg.equals(WARNING)){
			msgLabel.setText("");
			return true;
		} else {
			msgLabel.setText(warningMsg);
			return false;
		}
	}

	
	public void init(){
		try {
			System.out.println("client dialog is popup");
			this.setVisible(true);
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
	}
	
	
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
	
}
