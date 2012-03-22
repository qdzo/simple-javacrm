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

public class DealAddEditDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402793380772715703L;
	private final JPanel contentPanel = new JPanel();
	private JTextField findManagerField;
	private JTextField findClientField;
	private JTextField findProductField;


	public DealAddEditDialog(Frame frame,String title) {
		super(frame,title);
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
			JComboBox productBox = new JComboBox();
			GridBagConstraints gbc_productBox = new GridBagConstraints();
			gbc_productBox.insets = new Insets(0, 0, 5, 5);
			gbc_productBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_productBox.gridx = 1;
			gbc_productBox.gridy = 0;
			contentPanel.add(productBox, gbc_productBox);
		}
		{
			JLabel lblSearchAProduct = new JLabel("find product:");
			GridBagConstraints gbc_lblSearchAProduct = new GridBagConstraints();
			gbc_lblSearchAProduct.insets = new Insets(0, 0, 5, 5);
			gbc_lblSearchAProduct.anchor = GridBagConstraints.EAST;
			gbc_lblSearchAProduct.gridx = 2;
			gbc_lblSearchAProduct.gridy = 0;
			contentPanel.add(lblSearchAProduct, gbc_lblSearchAProduct);
		}
		{
			findProductField = new JTextField();
			GridBagConstraints gbc_findProductField = new GridBagConstraints();
			gbc_findProductField.insets = new Insets(0, 0, 5, 0);
			gbc_findProductField.fill = GridBagConstraints.HORIZONTAL;
			gbc_findProductField.gridx = 3;
			gbc_findProductField.gridy = 0;
			contentPanel.add(findProductField, gbc_findProductField);
			findProductField.setColumns(10);
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
			JComboBox clientBox = new JComboBox();
			GridBagConstraints gbc_clientBox = new GridBagConstraints();
			gbc_clientBox.insets = new Insets(0, 0, 5, 5);
			gbc_clientBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_clientBox.gridx = 1;
			gbc_clientBox.gridy = 1;
			contentPanel.add(clientBox, gbc_clientBox);
		}
		{
			JLabel lblSearchAClient = new JLabel("find client:");
			GridBagConstraints gbc_lblSearchAClient = new GridBagConstraints();
			gbc_lblSearchAClient.insets = new Insets(0, 0, 5, 5);
			gbc_lblSearchAClient.anchor = GridBagConstraints.EAST;
			gbc_lblSearchAClient.gridx = 2;
			gbc_lblSearchAClient.gridy = 1;
			contentPanel.add(lblSearchAClient, gbc_lblSearchAClient);
		}
		{
			findClientField = new JTextField();
			GridBagConstraints gbc_findClientField = new GridBagConstraints();
			gbc_findClientField.insets = new Insets(0, 0, 5, 0);
			gbc_findClientField.fill = GridBagConstraints.HORIZONTAL;
			gbc_findClientField.gridx = 3;
			gbc_findClientField.gridy = 1;
			contentPanel.add(findClientField, gbc_findClientField);
			findClientField.setColumns(10);
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
			JComboBox managerBox = new JComboBox();
			GridBagConstraints gbc_managerBox = new GridBagConstraints();
			gbc_managerBox.insets = new Insets(0, 0, 5, 5);
			gbc_managerBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_managerBox.gridx = 1;
			gbc_managerBox.gridy = 2;
			contentPanel.add(managerBox, gbc_managerBox);
		}
		{
			JLabel lblFindManager = new JLabel("find manager:");
			GridBagConstraints gbc_lblFindManager = new GridBagConstraints();
			gbc_lblFindManager.insets = new Insets(0, 0, 5, 5);
			gbc_lblFindManager.anchor = GridBagConstraints.EAST;
			gbc_lblFindManager.gridx = 2;
			gbc_lblFindManager.gridy = 2;
			contentPanel.add(lblFindManager, gbc_lblFindManager);
		}
		{
			findManagerField = new JTextField();
			GridBagConstraints gbc_findManagerField = new GridBagConstraints();
			gbc_findManagerField.insets = new Insets(0, 0, 5, 0);
			gbc_findManagerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_findManagerField.gridx = 3;
			gbc_findManagerField.gridy = 2;
			contentPanel.add(findManagerField, gbc_findManagerField);
			findManagerField.setColumns(10);
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
			JTextArea commentArea = new JTextArea();
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.gridwidth = 3;
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 1;
			gbc_textArea.gridy = 4;
			contentPanel.add(commentArea, gbc_textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

}
