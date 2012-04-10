package view_controller;

import javax.swing.table.TableModel;

public interface IObserver {

	public void notifyEvent(TableModel tableEvent);
}
