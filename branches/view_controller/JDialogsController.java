package view_controller;

import model.Client;






public class JDialogsController implements ICommand  {

	private IDisplayable clientDialog;
	private IDisplayable managerDialog;
	private IDisplayable dealDialog;
	private IDisplayable productDialog;
	
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
				setNextCommand(bObject,Commands.ADD);
				break;
		case FIND:	
				initDialog(bObject);
				setNextCommand(bObject,Commands.SEARCH);
				break;
		case EDIT:
				editDialog(bObject,currentObject);
				setNextCommand(bObject,Commands.UPDATE);
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

	
	
	
	
	private void setNextCommand(BusinessObjects bObject,Commands nextCommand) {
		switch (bObject){
		
		case client:
			((ICommandable)clientDialog).setCommandToDo(nextCommand);
			break;
			
		case manager:
			((ICommandable)managerDialog).setCommandToDo(nextCommand);
			break;
			
		case product:
			((ICommandable)productDialog).setCommandToDo(nextCommand);
			break;
			
		case deal:
			((ICommandable)dealDialog).setCommandToDo(nextCommand);
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
		
	}

	private void saveModel(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}	
	}

	private void deleteObject(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			 
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void closeDialog(BusinessObjects bObject) {
	switch (bObject){
		
		case client:
			clientDialog.close();
			break;
			
		case manager:
			managerDialog.close();
			break;
			
		case product:
			productDialog.close();
			break;
			
		case deal:
			dealDialog.close();
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}	
	}

	private void findModel(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void quickFind(BusinessObjects bObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void addModel(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void updateModel(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void editDialog(BusinessObjects bObject, Object currentObject) {
	switch (bObject){
		
		case client:
			
			break;
			
		case manager:
			
			break;
			
		case product:
			
			break;
			
		case deal:
			
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}
	}

	private void initDialog(BusinessObjects bObject) {
	switch (bObject){
		
		case client:
			clientDialog.init();
			IModelClient imodelClient = (IModelClient)clientDialog;
			imodelClient.setModel(new Client(null));
			break;
			
		case manager:
			managerDialog.init();
			break;
			
		case product:
			productDialog.init();
			break;
			
		case deal:
			dealDialog.init();
			break;
			
		default: throw new NullPointerException("Wrong parrameter currentObject");	
			
		}	
	}

	
	
	
	
	public IDisplayable getClientDialog() {
		return clientDialog;
	}

	public void setClientDialog(IDisplayable clientDialog) {
		this.clientDialog = clientDialog;
	}

	public IDisplayable getManagerDialog() {
		return managerDialog;
	}

	public void setManagerDialog(IDisplayable managerDialog) {
		this.managerDialog = managerDialog;
	}

	public IDisplayable getDealDialog() {
		return dealDialog;
	}

	public void setDealDialog(IDisplayable dealDialog) {
		this.dealDialog = dealDialog;
	}

	public IDisplayable getProductDialog() {
		return productDialog;
	}

	public void setProductDialog(IDisplayable productDialog) {
		this.productDialog = productDialog;
	}
	
	
	

}
