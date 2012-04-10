package view_controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ViewTable extends JTable implements IObserver {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -974433386690900079L;



	@Override
	public void notifyEvent(DefaultTableModel tableEvent) {
		if(this.getModel().equals(tableEvent)){
			tableEvent.fireTableDataChanged();
		} else
		this.setModel(tableEvent);
		this.repaint();
	}
}
