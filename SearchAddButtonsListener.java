package view_controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SearchAddButtonsListener implements ActionListener{
	
	private Frame DialogOwner;
	private BusinessObjects checkedBusinessObj;
	public DealJDialog dealDialog;
	public  ClientJDialog clientDialog;
	public ManagerJDialog managerDialog;
	public ProductJDialog productDialog;
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
		productDialog = new ProductJDialog(DialogOwner,"Product");
		dealDialog = new DealJDialog(DialogOwner,"Product") ;
		clientDialog = new ClientJDialog(DialogOwner,usingPurpose+" Client");
		managerDialog = new ManagerJDialog(DialogOwner,"Manager");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		checkedBusinessObj =(BusinessObjects) comboBox.getSelectedItem();
		System.out.println("event is found");
		System.out.println(checkedBusinessObj);
		if(e.getActionCommand()=="Add"||e.getActionCommand()=="Find")
		switch (checkedBusinessObj){
		
		case client :try {
					System.out.println("client dialog is popup");
					clientDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					clientDialog.setVisible(true);
		    		} catch (Exception ex) {
		    			ex.printStackTrace();
		    		} break;
		
		case manager :try {
					System.out.println("manager dialog is popup");
					managerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					managerDialog.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					} break;
		
		case product : 
//			try {
//					System.out.println("product dialog is popup");
//					productDialog = 
//					productDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					productDialog.setVisible(true);
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
			dealDialog.close();
			break;
					
		case deal : 
			
			dealDialog.init();
			break;
		    		
		
		}
	}

	public String getPurpose(){
		return usingPurpose;
	}
}
