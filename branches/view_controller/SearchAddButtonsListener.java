package view_controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SearchAddButtonsListener implements ActionListener{
	
	private BusinessObjects checkedBusinessObj;
	private DealAddEditDialog dealDialog;
	private ClientAddEditDialog clientDialog;
	private ManagerAddEditDialog managerDialog;
	private ProductAddEditDialog productDialog;
	private Frame DialogOwner;
	private JButton button;
	private JComboBox comboBox;
	public final static String ADD = "Add";
	public final static String EDIT = "Edit";
	public final static String SEARCH = "Search";
	private String usingPurpose;
	
	public SearchAddButtonsListener(Frame frame, JButton button,JComboBox combobox,String purpose){
		DialogOwner = frame;
		this.button = button;
		this.comboBox = combobox;
		button.addActionListener(this);
		comboBox.addActionListener(this);
		usingPurpose = purpose;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		checkedBusinessObj =(BusinessObjects) comboBox.getSelectedItem();
		System.out.println("event had pecup!");
		System.out.println(checkedBusinessObj);
		if(e.getActionCommand()=="Add"||e.getActionCommand()=="Find")
		switch (checkedBusinessObj){
		
		case client :try {
					System.out.println("i don't understand, what's going on?");
					clientDialog = new ClientAddEditDialog(DialogOwner,usingPurpose+" Client");
					clientDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					clientDialog.setVisible(true);
					System.out.println("where the dialog?");
		    		} catch (Exception ex) {
		    			ex.printStackTrace();
		    		} break;
		
		case manager :try {
					managerDialog = new ManagerAddEditDialog(DialogOwner,"Manager");
					managerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					managerDialog.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					} break;
		
		case product : try {
					productDialog = new ProductAddEditDialog(DialogOwner,"Product");
					productDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					productDialog.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					} break;
					
		case deal : try {
				dealDialog = new DealAddEditDialog(DialogOwner,"Deal");
				dealDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dealDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				} break;
		    		
		
		}
	}

	public String getPurpose(){
		return usingPurpose;
	}
}
