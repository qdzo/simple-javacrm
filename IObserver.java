package view_controller;

import javax.swing.table.DefaultTableModel;

public interface IObserver {

	public void notifyEvent(DefaultTableModel tableEvent);
}
