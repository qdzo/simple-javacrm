package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Heap implements List<Object>, TableModel{
	
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	List<Object> myList;
	
	
	public Heap(List<Object> businessObjectsList){
		myList = businessObjectsList;
		
	}
	
	public Heap(Object businessObject){
		myList = new ArrayList<Object>();
		myList.add(businessObject);
	}

	@Override
	public int getRowCount() {
		
		return myList.size();
	}

	
	@Override
	public int getColumnCount() {
		
		if(myList.getClass()==Client.class)
			return 6;
		else if(myList.getClass()==Manager.class)
			return 5;
		else if(myList.getClass()==Product.class)
			return 4;
		else if(myList.getClass()==Destribution.class)
			return 8;
		else
		return 0;
	}

	
	
	
	@Override
	public String getColumnName(int columnIndex) {
		if(myList.getClass()==Client.class)
			switch(columnIndex){
			case 0: return "First Name";
			case 1: return "Second Name";
			case 2: return "Telephone";
			case 3: return "e-mail";
			case 4: return "Priority";
			case 5: return "Status";
			}
		else if(myList.getClass()==Manager.class)
			switch(columnIndex){
			case 0: return "First Name";
			case 1: return "Second Name";
			case 2: return "Telephone";
			case 3: return "e-mail";
			case 4: return "Status";
			}
		else if(myList.getClass()==Product.class)
			switch(columnIndex){
			case 0: return "Product name";
			case 1: return "Description";
			case 2: return "Price";
			case 3: return "Quant in stock";
			}
		else if(myList.getClass()==Destribution.class)
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
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
		
	}

	
	@Override
	public void removeTableModelListener(TableModelListener listener) {
		listeners.remove(listener);		
	}

	
	@Override
	public int size() {
		return myList.size();
	}

	@Override
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return myList.contains(o);
	}

	@Override
	public Iterator<Object> iterator() {
			return myList.iterator();
	}

	@Override
	public Object[] toArray() {
		return myList.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		return myList.toArray(a);
	}

	@Override
	public boolean add(Object object) {
		return myList.add(object);
	}
	
	

	@Override
	public boolean remove(Object object) {
		
		return myList.remove(object);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return myList.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<?> c) {
		return myList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<?> c) {
		return myList.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return myList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return myList.retainAll(c);
	}

	@Override
	public void clear() {
		myList.clear();
	}

	@Override
	public Object get(int index) {
		return myList.get(index);
	}

	@Override
	public Object set(int index, Object element) {
		return myList.set(index, element);
	}

	@Override
	public void add(int index, Object element) {
		myList.add(index, element);
	}

	@Override
	public Object remove(int index) {
		return myList.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return myList.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return myList.lastIndexOf(o);
	}

	@Override
	public ListIterator<Object> listIterator() {
		return myList.listIterator();
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		return myList.listIterator(index);
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		return myList.subList(fromIndex, toIndex);
	}

}
