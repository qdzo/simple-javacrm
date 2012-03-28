package view_controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SearchAddButtonsListener implements ActionListener{
	
	private BusinessObjects checkedBusinessObj;
	private DealJDialog dealDialog;
	public static ClientJDialog clientDialog;
	private ManagerJDialog managerDialog;
	private ProductJDialog productDialog;
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
		System.out.println("event is found");
		System.out.println(checkedBusinessObj);
		if(e.getActionCommand()=="Add"||e.getActionCommand()=="Find")
		switch (checkedBusinessObj){
		
		case client :try {
					System.out.println("client dialog is popup");
					clientDialog = new ClientJDialog(DialogOwner,usingPurpose+" Client");
					clientDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					clientDialog.setVisible(true);
					System.out.println("where the dialog?");
		    		} catch (Exception ex) {
		    			ex.printStackTrace();
		    		} break;
		
		case manager :try {
					System.out.println("manager dialog is popup");
					managerDialog = new ManagerJDialog(DialogOwner,"Manager");
					managerDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					managerDialog.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					} break;
		
		case product : try {
					System.out.println("product dialog is popup");
					productDialog = new ProductJDialog(DialogOwner,"Product");
					productDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					productDialog.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					} break;
					
		case deal : try {
				System.out.println("deal-dialog is popup");
				dealDialog = new DealJDialog(DialogOwner,"Deal");
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
