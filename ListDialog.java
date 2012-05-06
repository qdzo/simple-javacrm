package view_controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

import model.Client;
import model.Manager;
import model.Person;
import model.Product;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class ListDialog extends JDialog {

	private static final long serialVersionUID = -8909740801489064617L;
	private final JPanel contentPanel = new JPanel();
	private List<Object> itemList = new ArrayList<Object>();
	JList<String> listView;
	private Object binded;
	private DealJDialog dealDialog;
	/**
	 * Create the dialog.
	 */
	public ListDialog(Frame frame,String title, DealJDialog dealJDialog) {
		super(frame,title,true);
		this.dealDialog = dealJDialog;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 222, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane);
			{
				 listView = new JList<String>();
				 listView.setVisibleRowCount(10);
				scrollPane.setViewportView(listView);
				listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
						binded = itemList.get(listView.getSelectedIndex());
						if(binded.getClass().equals(Client.class)){
							dealDialog.setCurrentClient((Client) binded);
						} else if(binded.getClass().equals(Manager.class)){
							dealDialog.setCurrentManager((Manager) binded);
						} else if(binded.getClass().equals(Product.class)){
							dealDialog.setCurrentProduct((Product) binded);
						} 
						close();
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
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setItems(List<Object> nitemList){
		if(nitemList==null||nitemList.size()<0){
			System.out.println("Item list arguments is empty");
			return;	
		}
		this.itemList = nitemList;
		DefaultListModel<String> listModel= new DefaultListModel<String>();
		if(itemList.get(0).getClass().equals(Client.class)||
				itemList.get(0).getClass().equals(Manager.class)){	
		for(int i=0;i<itemList.size();i++){
			Person person = (Person) itemList.get(i);
			listModel.addElement((person.getSecondName()+"    "+person.getFirstName()));
			}	
		} else if(itemList.get(0).getClass().equals(Product.class)){
			for(int i=0;i<itemList.size();i++){
				Product product = (Product) itemList.get(i);
				listModel.addElement(product.getNameProduct());
			}
		} else return;
		listView.setModel(listModel);
	}
	
	public void init(){
		this.setVisible(true);
	}
	
	public void close(){
		try {
			listView.clearSelection();
			this.dispose();
		} catch (Exception e) {
			System.out.println("listDialog is not initialized");
		}
	}
	
}
