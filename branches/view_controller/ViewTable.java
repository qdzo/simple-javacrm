package view_controller;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Heap;

public class ViewTable extends JTable implements IObserver {

	private Heap heap;
	/**
	 * 
	 */
	private static final long serialVersionUID = -974433386690900079L;

	public void notifyEvent(){
		this.revalidate();
	}
}
