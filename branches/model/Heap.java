package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import view_controller.BusinessObjects;
import view_controller.IObserver;

public class Heap implements TableModel{
	


	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private Set<IObserver>	observers = new HashSet<IObserver>();
	private List<Object> myList;
	private Integer selectedIndex = null;
	
	public Heap(){
		myList = new ArrayList<Object>();
	}
	
	public Heap(List<Object> businessObjectsList){
		myList = businessObjectsList;
		notifyChanges();
	}
	
	public Heap(Object businessObject){
		myList = new ArrayList<Object>();
		myList.add(businessObject);
		notifyChanges();
	}

	
	@SuppressWarnings("unchecked")
	public void setNewList(List<? extends Object> businessObjectsList){
		myList = (List<Object>) businessObjectsList;
		notifyChanges();
	}
	
	
	private void setNewBObject(Object object){
		myList.clear();
		myList.add(object);
		notifyChanges();
		System.out.println("Set new BusinessObject in heap : "+object.getClass());
	}
	
	
	@Override
	public int getRowCount() {
		
		return myList.size();
	}

	
	@Override
	public int getColumnCount() {
		
		if(myList.get(0).getClass()==Client.class)
			return 6;
		else if(myList.get(0).getClass()==Manager.class)
			return 5;
		else if(myList.get(0).getClass()==Product.class)
			return 4;
		else if(myList.get(0).getClass()==Destribution.class)
			return 8;
		else
		return 0;
	}

	
	
	
	@Override
	public String getColumnName(int columnIndex) {
		if(myList.get(0).getClass()==Client.class)
			switch(columnIndex){
			case 0: return "First Name";
			case 1: return "Second Name";
			case 2: return "Telephone";
			case 3: return "e-mail";
			case 4: return "Priority";
			case 5: return "Status";
			}
		else if(myList.get(0).getClass()==Manager.class)
			switch(columnIndex){
			case 0: return "First Name";
			case 1: return "Second Name";
			case 2: return "Telephone";
			case 3: return "e-mail";
			case 4: return "Status";
			}
		else if(myList.get(0).getClass()==Product.class)
			switch(columnIndex){
			case 0: return "Product name";
			case 1: return "Description";
			case 2: return "Price";
			case 3: return "Quant in stock";
			}
		else if(myList.get(0).getClass()==Destribution.class)
			switch(columnIndex){
			case 0: return "Date & time";
			case 1: return "Product";
			case 2: return "Manager name";
			case 3: return "Manager surname";
			case 4: return "Client name";
			case 5: return "Client surname";
			case 6: return "Comments";
			case 7: return "Status";
			}
		return "";
	}
	
	
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(myList.get(0).getClass()==Client.class){
			Client client = (Client) myList.get(rowIndex);
			switch(columnIndex){
			case 0: return client.getFirstName();
			case 1: return client.getSecondName();
			case 2: return client.getTelephone();
			case 3: return client.getEmail();
			case 4: return client.getPriority();
			case 5: return client.getStatus();
			}
		}
			else if(myList.get(0).getClass()==Manager.class){
				Manager manager = (Manager) myList.get(rowIndex);
				switch(columnIndex){
				case 0: return manager.getFirstName();
				case 1: return manager.getSecondName();
				case 2: return manager.getTelephone();
				case 3: return manager.getEmail();
				case 4: return manager.getStatus();
				}
			}
			else if(myList.get(0).getClass()==Product.class){
				Product product =  (Product) myList.get(rowIndex);
				switch(columnIndex){
				case 0: return product.getNameProduct();
				case 1: return product.getDescription();
				case 2: return product.getPrice();
				case 3: return product.getSummary();
				}
			}
			else if(myList.get(0).getClass()==Destribution.class){
			Destribution destribution = (Destribution) myList.get(rowIndex);
				switch(columnIndex){
				case 0: return destribution.getDateTime();
				case 1: return destribution.getProductName();
				case 2: return destribution.getManagerFirstName();
				case 3: return destribution.getManagerSecondName();
				case 4: return destribution.getClientFirstName();
				case 5: return destribution.getClientSecondName();
				case 6: return destribution.getComment();
				case 7: return destribution.getStatus();
				}
			}
		return null;
	}

	
	public Object getValueAt(int rowIndex){
		return myList.get(rowIndex);
	}
	
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public void setValueAt(Object aValue, int rowIndex) {
		myList.set(rowIndex, aValue);
		notifyChanges();
	}

	@Override
	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
		
	}

	
	@Override
	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);		
	}

	
	
	public int size() {
		return myList.size();
	}

	
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	
	public boolean contains(Object o) {
		return myList.contains(o);
	}

	
	public Iterator<Object> iterator() {
			return myList.iterator();
	}

	
	public Object[] toArray() {
		return myList.toArray();
	}

	
	public Object[] toArray(Object[] a) {
		return myList.toArray(a);
	}

	
	public void add(Object object) {
		if(myList.size()>0)
		if(myList.get(0).getClass().equals(object.getClass())){
		myList.add(object);
		System.out.println("added new row in list!");
		notifyChanges();
		} else {
		setNewBObject(object);
		}
		else setNewBObject(object);
	}
	
	

	
	public void remove(Object object) {
		myList.remove(object);
		notifyChanges();
	}

	
	
	
	
	public boolean containsAll(Collection<?> c) {
		return myList.containsAll(c);
	}


	public void clear() {
		myList.clear();
	}


	public Object get(int index) {
		return myList.get(index);
	}

	
	public void set(int index, Object element) {
		 myList.set(index, element);
		notifyChanges();
	}


	public void add(int index, Object element) {
		try{
		myList.add(index, element);
		notifyChanges();
		} catch (IndexOutOfBoundsException e){
			System.out.println("heap size is smaller, than your index = "+index);
		}
	}


	public void remove(int index) {
		try{
			myList.remove(index);
			notifyChanges();
		} catch (IndexOutOfBoundsException e){
			System.out.println("heap size is smaller, than your index = "+index);
		}
		 
	}


	public int indexOf(Object o) {
		return myList.indexOf(o);
	}


	public int lastIndexOf(Object o) {
		return myList.lastIndexOf(o);
	}

	
	
	
	public Integer getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(Integer selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	
	
	public void addObserver(IObserver observer){
		observers.add(observer);
	}
	
	public void removeObserver(IObserver observer){
		observers.remove(observer);
	}
	
	private void notifyChanges(){
		for(IObserver o : observers){
			o.notifyEvent(this);
		}
	}

	public BusinessObjects getBObject(){
		try{
			if(myList.get(0).getClass().equals(Client.class)){
			return BusinessObjects.client;
		} else if(myList.get(0).getClass().equals(Manager.class)){
			return BusinessObjects.manager;
		} if(myList.get(0).getClass().equals(Product.class)){
			return BusinessObjects.product;
		} if(myList.get(0).getClass().equals(Destribution.class)){
			return BusinessObjects.deal;
		}
	}catch(IndexOutOfBoundsException e){
		System.out.println("Heap is empty! cannot get an Business-type of object from it!");
	}
		return null;
	}

}
