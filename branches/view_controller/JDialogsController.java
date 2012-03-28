package view_controller;

import model.Person;





public class JDialogsController implements ICommand  {

	public JDialogsController(){
		
	}

	@Override
	public void execute(Commands command, BusinessObjects bObject, Object currentObject) {
		if (command == null)
			throw new NullPointerException("Empty parrameter command");
		if (bObject == null)
			throw new NullPointerException("Empty parrameter BusinessObject");
		if(!(currentObject==null||(currentObject.getClass()).equals(model.Client.class)||
				(currentObject.getClass()).equals(model.Manager.class)||
				(currentObject.getClass()).equals(model.Product.class)||
				(currentObject.getClass()).equals(model.Destribution.class)))
			throw new NullPointerException("Wrong parrameter currentObject");
		
		switch(command){
		
		case CREATE: 
				initDialog(bObject);
				break;
		case FIND:	
				initDialog(bObject);
				break;
		case EDIT:
				editDialog(bObject,currentObject);
				break;
		case UPDATE:
				updateModel(bObject,currentObject);
				break;
		case ADD:
				addModel(bObject,currentObject);
				break;
		case QUICKFIND:	
				quickFind(bObject);
				break;
		case SEARCH:
				findModel(bObject,currentObject);
				break;
		case CLOSE:
				closeDialog(bObject);
				break;
		case DELETE:
				deleteObject(bObject,currentObject);
				break;
		case SAVE:
				saveModel(bObject,currentObject);
				
		}
	}

	
	
	
	
	private void saveModel(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void deleteObject(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void closeDialog(BusinessObjects bObject) {
		// TODO Auto-generated method stub
		
	}

	private void findModel(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void quickFind(BusinessObjects bObject) {
		// TODO Auto-generated method stub
		
	}

	private void addModel(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void updateModel(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void editDialog(BusinessObjects bObject, Object currentObject) {
		// TODO Auto-generated method stub
		
	}

	private void initDialog(BusinessObjects bObject) {
			
	}
	
	
	

}
