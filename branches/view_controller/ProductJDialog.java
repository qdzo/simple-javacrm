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

import model.Product;

public class ProductJDialog extends JDialog implements IModelProduct, IDisplayable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9083311417037541673L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameProductField;
	private JTextField priceProductField;
	private JTextField sumProductField;
	private Product product;
	private JTextArea descriptionProductArea;
	private JLabel msgLabel;
	
	public ProductJDialog(Frame frame,String title) {
		super(frame,title,true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("name:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			nameProductField = new JTextField();
			GridBagConstraints gbc_nameProductField = new GridBagConstraints();
			gbc_nameProductField.insets = new Insets(0, 0, 5, 0);
			gbc_nameProductField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nameProductField.gridx = 1;
			gbc_nameProductField.gridy = 0;
			contentPanel.add(nameProductField, gbc_nameProductField);
			nameProductField.setColumns(10);
		}
		{
			JLabel lblPrice = new JLabel("price:");
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.anchor = GridBagConstraints.EAST;
			gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrice.gridx = 0;
			gbc_lblPrice.gridy = 1;
			contentPanel.add(lblPrice, gbc_lblPrice);
		}
		{
			priceProductField = new JTextField();
			GridBagConstraints gbc_priceProductField = new GridBagConstraints();
			gbc_priceProductField.insets = new Insets(0, 0, 5, 0);
			gbc_priceProductField.fill = GridBagConstraints.HORIZONTAL;
			gbc_priceProductField.gridx = 1;
			gbc_priceProductField.gridy = 1;
			contentPanel.add(priceProductField, gbc_priceProductField);
			priceProductField.setColumns(10);
		}
		{
			JLabel lblSum = new JLabel("sum:");
			GridBagConstraints gbc_lblSum = new GridBagConstraints();
			gbc_lblSum.anchor = GridBagConstraints.EAST;
			gbc_lblSum.insets = new Insets(0, 0, 5, 5);
			gbc_lblSum.gridx = 0;
			gbc_lblSum.gridy = 2;
			contentPanel.add(lblSum, gbc_lblSum);
		}
		{
			sumProductField = new JTextField();
			GridBagConstraints gbc_sumProductField = new GridBagConstraints();
			gbc_sumProductField.insets = new Insets(0, 0, 5, 0);
			gbc_sumProductField.fill = GridBagConstraints.HORIZONTAL;
			gbc_sumProductField.gridx = 1;
			gbc_sumProductField.gridy = 2;
			contentPanel.add(sumProductField, gbc_sumProductField);
			sumProductField.setColumns(10);
		}
		{
			JLabel lblDescription = new JLabel("description:");
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescription.gridx = 0;
			gbc_lblDescription.gridy = 3;
			contentPanel.add(lblDescription, gbc_lblDescription);
		}
		{
			descriptionProductArea = new JTextArea();
			GridBagConstraints gbc_descriptionProductArea = new GridBagConstraints();
			gbc_descriptionProductArea.fill = GridBagConstraints.BOTH;
			gbc_descriptionProductArea.gridx = 1;
			gbc_descriptionProductArea.gridy = 3;
			contentPanel.add(descriptionProductArea, gbc_descriptionProductArea);
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
	public Product getModel() {
		if(product==null)
			return null;
			if(checkTheFields()){
			product.setNameProduct((nameProductField.getText()).trim());
			product.setPrice((priceProductField.getText()).trim());
			product.setSummary((sumProductField.getText()).trim());
			product.setDescription((descriptionProductArea.getText()).trim());
			return product;
			}else return null;
	}


	@Override
	public void setModel(Product product) {
		try {
			this.product = product;
			nameProductField.setText(product.getNameProduct());
			priceProductField.setText(String.valueOf(product.getPrice()));
			sumProductField.setText(String.valueOf(product.getSummary()));
			descriptionProductArea.setText(product.getDescription());
		} catch (Exception e) {
			System.out.println(" No argument exception!");
		}
	}
	
	
	private boolean checkTheFields(){
		final String WARNING = "UNCORRECT ";
		String  warningMsg = WARNING;
		if(!(Product.validate((nameProductField.getText()).trim()))){
			warningMsg+="Product name";
		}
		if(!(Product.validate((priceProductField.getText()).trim()))){
			warningMsg+=", price";
		}
		if(!(Product.validateDecimal((sumProductField.getText()).trim()))){
			warningMsg+=", number";
		}
		if(!(Product.validateDecimalLong((descriptionProductArea.getText()).trim()))){
			warningMsg+=", description!";
		}
		if(warningMsg.equals(WARNING)){
			return true;
		} else {
			msgLabel.setText(warningMsg);
			return false;
		}
	}
	
	

	@Override
	public void init() {
		 try {
				System.out.println("product dialog is popup");
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



}
