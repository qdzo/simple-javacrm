package view_controller;

import javax.swing.JTable;
import javax.swing.table.TableModel;


public class ViewTable extends JTable implements IObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = -974433386690900079L;

	

	@Override
	public void notifyEvent(TableModel tableEvent) {
		this.setModel(tableEvent);
		this.createDefaultColumnsFromModel();
    }
	
	
	
	
}