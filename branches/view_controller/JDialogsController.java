package view_controller;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import model.Client;
import model.Destribution;
import model.Heap;
import model.IModelPersistable;
import model.Manager;
import model.ModelStatus;
import model.Product;






public class JDialogsController implements ICommand  {

	private IDisplayable clientDialog;
	private IDisplayable managerDialog;
	private IDisplayable dealDialog;
	private IDisplayable productDialog;
	private IModelPersistable modelFasade;
	private Heap heapList;
	private Notificator notificator;
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
		//  event from add button
		case CREATE: 
				setNextCommand(bObject,Commands.ADD);
				initDialog(bObject);
				break;
			// event from find button	
		case FIND:	
				setNextCommand(bObject,Commands.SEARCH);
				initDialog(bObject);
				break;
			// event from edit button	
		case EDIT:
				setNextCommand(bObject,Commands.UPDATE);
				editDialog(currentObject);
				break;
			// update editing object	
		case UPDATE:
				updateModel(bObject,currentObject);
				break;
			// add created object	
		case ADD:
				addModel(bObject,currentObject);
				break;
		case QUICKFIND:	
				quickFind(bObject);
				break;
			// find object
		case SEARCH:
				findModel(bObject,currentObject);
				break;
			// close dialog	
		case CLOSE:
				closeDialog(bObject);
				break;
		case DELETE:
			// delete object
				deleteObject(currentObject);
				break;
			// save all changes 	
		case SAVE:
				saveModels();
				
		}
	}

	
	
	// set a next command to jdialogs, which selection depends on the pushed button 
	
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

	
	
	private void saveModels() {
	 
		if(heapList.getValueAt(0).getClass()==Client.class){
		for(int i=0;i<heapList.size();i++){
			Client client = (Client) heapList.getValueAt(i);
			switch (client.getModelStatus()){
			case Created:
				modelFasade.insert(client);
				client.setModelStatus(ModelStatus.Exist);
				heapList.set(i,client);
				break;
			case Updated:
				modelFasade.update(client);
				client.setModelStatus(ModelStatus.Exist);
				heapList.set(i, client);
				break;
			case Deleted:
				modelFasade.delete(client);
				heapList.remove(i);
				break;
			}
		}
	} else if(heapList.getValueAt(0).getClass()==Manager.class){
		for(int i=0;i<heapList.size();i++){
			Manager manager = (Manager) heapList.getValueAt(i);
			switch (manager.getModelStatus()){
			case Created:
				modelFasade.insert(manager);
				manager.setModelStatus(ModelStatus.Exist);
				heapList.set(i,manager);
				break;
			case Updated:
				modelFasade.update(manager);
				manager.setModelStatus(ModelStatus.Exist);
				heapList.set(i, manager);
				break;
			case Deleted:
				modelFasade.delete(manager);
				heapList.remove(i);
				break;
			}
		}
	} else if(heapList.getValueAt(0).getClass()==Product.class){
		for(int i=0;i<heapList.size();i++){
			Product product = (Product) heapList.getValueAt(i);
			switch (product.getModelStatus()){
			case Created:
				modelFasade.insert(product);
				product.setModelStatus(ModelStatus.Exist);
				heapList.set(i,product);
				break;
			case Updated:
				modelFasade.update(product);
				product.setModelStatus(ModelStatus.Exist);
				heapList.set(i, product);
				break;
			case Deleted:
				modelFasade.delete(product);
				heapList.remove(i);
				break;
			}
		}
	} else if(heapList.getValueAt(0).getClass()==Destribution.class){
		for(int i=0;i<heapList.size();i++){
			Destribution destribution = (Destribution) heapList.getValueAt(i);
			switch (destribution.getModelStatus()){
			case Created:
				modelFasade.insert(destribution);
				destribution.setModelStatus(ModelStatus.Exist);
				heapList.set(i,destribution);
				break;
			case Updated:
				modelFasade.update(destribution);
				destribution.setModelStatus(ModelStatus.Exist);
				heapList.set(i, destribution);
				break;
			case Deleted:
				modelFasade.delete(destribution);
				heapList.remove(i);
				break;
					
			}
		}
	} 
		
		
	}		

	
	private void deleteObject(Object currentObject) {
		
		if(currentObject.getClass()==Client.class){
			((Client) currentObject).setModelStatus(ModelStatus.Deleted);
			heapList.set(heapList.getSelectedIndex(), currentObject);
			
		} else if(currentObject.getClass()==Manager.class){
			((Manager) currentObject).setModelStatus(ModelStatus.Deleted);
			heapList.set(heapList.getSelectedIndex(), currentObject);
			
		} else if(currentObject.getClass()==Product.class){
			((Product) currentObject).setModelStatus(ModelStatus.Deleted);
			heapList.set(heapList.getSelectedIndex(), currentObject);
			
		} else if(currentObject.getClass()==Destribution.class){
			((Destribution) currentObject).setModelStatus(ModelStatus.Deleted);
			heapList.set(heapList.getSelectedIndex(), currentObject);
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
			Client client =(Client) modelFasade.find(currentObject);
			client.setModelStatus(ModelStatus.Exist);
			heapList.setNewBObject(client);
			break;
			
		case manager:
			Manager manager = (Manager) modelFasade.find(currentObject);
			manager.setModelStatus(ModelStatus.Exist);
			heapList.setNewBObject(manager);
			break;
			
		case product:
			Product product = (Product) modelFasade.find(currentObject);
			product.setModelStatus(ModelStatus.Exist);
			heapList.setNewBObject(product);
			break;
			
		case deal:
			Destribution destribution = (Destribution) modelFasade.find(currentObject);
			destribution.setModelStatus(ModelStatus.Exist);
			heapList.setNewBObject(destribution);
			break;
			
		default: throw new NullPointerException("FIND MODEL:Wrong parrameter currentObject");	
			
		}
	}

	private void quickFind(Object currentObject) {
		
		Client client =(Client) modelFasade.find(currentObject);
		client.setModelStatus(ModelStatus.Exist);
		heapList.setNewBObject(client);
		
	}

	
	private void addModel(BusinessObjects bObject, Object currentObject) {
		
		if(heapList==null){
			System.out.println("ADD MODEL:Heap is not initialized in the controller!");
			return;
		}
		if(heapList.getValueAt(0).getClass()==currentObject.getClass()){
			switch (bObject){
			case client:
				Client client = (Client)currentObject;
				client.setModelStatus(ModelStatus.Created);
				heapList.add(client);
				break;
			case manager:
				Manager manager = (Manager)currentObject;
				manager.setModelStatus(ModelStatus.Created);
				heapList.add(manager);
				break;
			case product:
				Product product = (Product)currentObject;
				product.setModelStatus(ModelStatus.Created);
				heapList.add(product);
				break;
			case deal:
				Destribution destribution = (Destribution)currentObject;
				destribution.setModelStatus(ModelStatus.Created);
				heapList.add(destribution);
			}
		}
		else {
			
			switch (bObject){
			case client:
				Client client = (Client)currentObject;
				client.setModelStatus(ModelStatus.Created);
				heapList.setNewBObject(client);
				break;
			case manager:
				Manager manager = (Manager)currentObject;
				manager.setModelStatus(ModelStatus.Created);
				heapList.setNewBObject(manager);
				break;
			case product:
				Product product = (Product)currentObject;
				product.setModelStatus(ModelStatus.Created);
				heapList.setNewBObject(product);
				break;
			case deal:
				Destribution destribution = (Destribution)currentObject;
				destribution.setModelStatus(ModelStatus.Created);
				heapList.setNewBObject(destribution);
				break;
				}
		}
		
	}

	
	// update a changed model to heapList
	// not completed
	private void updateModel(BusinessObjects bObject, Object currentObject) {
		if(heapList==null){
			System.out.println("UPDATE MODEL:Heap is not initialized in the controller!");
			return;
		}
			switch (bObject){
			case client:
				Client client = (Client)currentObject;
				if(client.getModelStatus()==ModelStatus.Exist)
				client.setModelStatus(ModelStatus.Updated);
				heapList.set(heapList.getSelectedIndex(), client);
				break;
			case manager:
				Manager manager = (Manager)currentObject;
				if(manager.getModelStatus()==ModelStatus.Exist)
				manager.setModelStatus(ModelStatus.Updated);
				heapList.set(heapList.getSelectedIndex(), manager);
				break;
			case product:
				Product product = (Product)currentObject;
				if(product.getModelStatus()==ModelStatus.Exist)
				product.setModelStatus(ModelStatus.Updated);
				heapList.set(heapList.getSelectedIndex(), product);
				break;
			case deal:
				Destribution destribution = (Destribution)currentObject;
				if(destribution.getModelStatus()==ModelStatus.Exist)
				destribution.setModelStatus(ModelStatus.Updated);
				heapList.set(heapList.getSelectedIndex(), destribution);
			}
	}

	private void editDialog(Object currentObject) {
	
		if(currentObject.getClass()==Client.class){
		IModelClient imodelClient = (IModelClient) clientDialog;
		imodelClient.setModel((Client)currentObject);
			clientDialog.init();
		} else if(currentObject.getClass()==Manager.class){
				IModelManager imodelManager = (IModelManager) managerDialog;
				imodelManager.setModel((Manager)currentObject);
					clientDialog.init(); 
					
		}  else if(currentObject.getClass()==Product.class){
			IModelProduct imodelProduct = (IModelProduct) productDialog;
			imodelProduct.setModel((Product)currentObject);
				clientDialog.init();
				
		}  else if(currentObject.getClass()==Destribution.class){
			IModelDestribution imodelDestribution = (IModelDestribution) dealDialog;
			imodelDestribution.setModel((Destribution)currentObject);
				clientDialog.init();
		}  else { System.out.println("EDIT DIALOG: invalid arguments");
			return;
		}

	}
	private void initDialog(BusinessObjects bObject) {
	switch (bObject){
		
		case client:
			IModelClient imodelClient = (IModelClient) clientDialog;
			Client client = new Client(null);
			client.setModelStatus(ModelStatus.Null);
			imodelClient.setModel(client);
			clientDialog.init();
			break;
			
		case manager:
			IModelManager imodelManager = (IModelManager) managerDialog;
			Manager manager = new Manager(null);
			manager.setModelStatus(ModelStatus.Null);
			imodelManager.setModel(manager);
			managerDialog.init();
			break;
			
		case product:
			IModelProduct imodelProduct = (IModelProduct) productDialog;
			Product product = new Product(null);
			product.setModelStatus(ModelStatus.Null);
			imodelProduct.setModel(product);
			productDialog.init();
			break;
			
		case deal:
			IModelDestribution imodelDestribution = (IModelDestribution) dealDialog;
			Destribution destribution = new Destribution(null);
			destribution.setModelStatus(ModelStatus.Null);
			imodelDestribution.setModel(destribution);
			dealDialog.init();
			break;
			
		default: throw new NullPointerException("INIT DIALOG: Invalid parrameter currentObject");	
			
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
	
	public void setIModelPersistable(IModelPersistable modelFasade){
		this.modelFasade = modelFasade;
	}

	public List<?> getHeapList() {
		return heapList;
	}

	public void setHeapList(Heap heapList) {
		this.heapList = heapList;
	}

	public Notificator getNotificator() {
		return notificator;
	}

	public void setNotificator(Notificator notificator) {
		this.notificator = notificator;
	}
	

}
