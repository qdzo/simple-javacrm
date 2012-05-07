package view_controller;

import java.util.List;

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
	private Heap heap;
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
				quickFind(currentObject);
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
				notificator.sendMessage("Данные Сохранены!", "Simple-java CRM!");
				break;
		case SHOW:
				showModels(bObject);
				
		}
	}

	
	
	private void showModels(BusinessObjects bObject) {
switch (bObject){
		
		case client:
			@SuppressWarnings("unchecked")
			List<Client> clients =(List<Client>) modelFasade.selectTO(new Client(null));
			heap.setNewList(clients);
			break;
			
		case manager:
			@SuppressWarnings("unchecked")
			List<Manager> managers = (List<Manager>) modelFasade.selectTO(new Manager(null));
			heap.setNewList(managers);
			break;
			
		case product:
			@SuppressWarnings("unchecked")
			List<Product> products = (List<Product>) modelFasade.selectTO(new Product(null));
			heap.setNewList(products);
			break;
			
		case deal:
			@SuppressWarnings("unchecked")
			List<Destribution> destributions = (List<Destribution>) modelFasade.selectTO(new Destribution(null));
			heap.setNewList(destributions);
			break;
			
		default: throw new NullPointerException("FIND MODEL:Wrong parrameter currentObject");	
			
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
	 
		if(heap.getValueAt(0).getClass()==Client.class){
		for(int i=0;i<heap.size();i++){
			Client client = (Client) heap.getValueAt(i);
			switch (client.getModelStatus()){
			case Created:
				modelFasade.insert(client);
				client.setModelStatus(ModelStatus.Exist);
				heap.set(i,client);
				break;
			case Updated:
				modelFasade.update(client);
				client.setModelStatus(ModelStatus.Exist);
				heap.set(i, client);
				break;
			case Deleted:
				modelFasade.delete(client);
				heap.remove(i);
				break;
			}
		}
	} else if(heap.getValueAt(0).getClass()==Manager.class){
		for(int i=0;i<heap.size();i++){
			Manager manager = (Manager) heap.getValueAt(i);
			switch (manager.getModelStatus()){
			case Created:
				modelFasade.insert(manager);
				manager.setModelStatus(ModelStatus.Exist);
				heap.set(i,manager);
				break;
			case Updated:
				modelFasade.update(manager);
				manager.setModelStatus(ModelStatus.Exist);
				heap.set(i, manager);
				break;
			case Deleted:
				modelFasade.delete(manager);
				heap.remove(i);
				break;
			}
		}
	} else if(heap.getValueAt(0).getClass()==Product.class){
		for(int i=0;i<heap.size();i++){
			Product product = (Product) heap.getValueAt(i);
			switch (product.getModelStatus()){
			case Created:
				modelFasade.insert(product);
				product.setModelStatus(ModelStatus.Exist);
				heap.set(i,product);
				break;
			case Updated:
				modelFasade.update(product);
				product.setModelStatus(ModelStatus.Exist);
				heap.set(i, product);
				break;
			case Deleted:
				modelFasade.delete(product);
				heap.remove(i);
				break;
			}
		}
	} else if(heap.getValueAt(0).getClass()==Destribution.class){
		for(int i=0;i<heap.size();i++){
			Destribution destribution = (Destribution) heap.getValueAt(i);
			switch (destribution.getModelStatus()){
			case Created:
				modelFasade.insert(destribution);
				destribution.setModelStatus(ModelStatus.Exist);
				heap.set(i,destribution);
				break;
			case Updated:
				modelFasade.update(destribution);
				destribution.setModelStatus(ModelStatus.Exist);
				heap.set(i, destribution);
				break;
			case Deleted:
				modelFasade.delete(destribution);
				heap.remove(i);
				break;
					
			}
		}
	} 
		
		
	}		

	
	private void deleteObject(Object currentObject) {
		
		if(currentObject.getClass()==Client.class){
			((Client) currentObject).setModelStatus(ModelStatus.Deleted);
			heap.set(heap.getSelectedIndex(), currentObject);
			System.out.println("some client marked to delete");
			
		} else if(currentObject.getClass()==Manager.class){
			((Manager) currentObject).setModelStatus(ModelStatus.Deleted);
			heap.set(heap.getSelectedIndex(), currentObject);
			System.out.println("some manager marked to delete");
			
		} else if(currentObject.getClass()==Product.class){
			notificator.sendAlert("Вы не можете удалять данные о продукции!!!", "Уровень безопасности данных");
//			((Product) currentObject).setModelStatus(ModelStatus.Deleted);
//			heap.set(heap.getSelectedIndex(), currentObject);
//			System.out.println("some product marked to delete");
		} else if(currentObject.getClass()==Destribution.class){
			
			((Destribution) currentObject).setModelStatus(ModelStatus.Deleted);
			heap.set(heap.getSelectedIndex(), currentObject);
			System.out.println("some destribution marked to delete");
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
			if(client!=null){
			client.setModelStatus(ModelStatus.Exist);
			heap.clear();
			heap.add(client);
			} else notificator.sendMessage("Клиент не найден", "База данных");
			break;
			
		case manager:
			Manager manager = (Manager) modelFasade.find(currentObject);
			if(manager!=null){
			manager.setModelStatus(ModelStatus.Exist);
			heap.clear();
			heap.add(manager);
			} else notificator.sendMessage("Мэнеджер не найден", "База данных");
			break;
			
		case product:
			Product product = (Product) modelFasade.find(currentObject);
			if(product!=null){
			product.setModelStatus(ModelStatus.Exist);
			heap.clear();
			heap.add(product);
			} else notificator.sendMessage("Продукт не найден", "База данных");
			break;
			
		case deal:
			Destribution destribution = (Destribution) modelFasade.find(currentObject);
			if(destribution!=null){
			destribution.setModelStatus(ModelStatus.Exist);
			heap.clear();
			heap.add(destribution);
			} else notificator.sendMessage("Продажа не найдена", "База данных");
			break;
			
		default: throw new NullPointerException("FIND MODEL:Wrong parrameter currentObject");	
			
		}
	}

	private void quickFind(Object currentObject) {
		
		Client client =(Client) modelFasade.find(currentObject);
		if(client!=null){
		client.setModelStatus(ModelStatus.Exist);
		heap.add(client);
	} else notificator.sendMessage("Нет клиента с таким номером телефона", "База данных");
		
	}

	
	private void addModel(BusinessObjects bObject, Object currentObject) {
		
		if(heap==null){
			System.out.println("ADD MODEL:Heap is not initialized in the controller!");
			return;
		}
			switch (bObject){
			case client:
				Client client = (Client)currentObject;
				client.setModelStatus(ModelStatus.Created);
				heap.add(client);
				break;
			case manager:
				Manager manager = (Manager)currentObject;
				manager.setModelStatus(ModelStatus.Created);
				heap.add(manager);
				break;
			case product:
				Product product = (Product)currentObject;
				product.setModelStatus(ModelStatus.Created);
				heap.add(product);
				break;
			case deal:
				Destribution destribution = (Destribution)currentObject;
				destribution.setModelStatus(ModelStatus.Created);
				heap.add(destribution);
			}
		
	}

	
	// update a changed model to heapList
	// not completed
	private void updateModel(BusinessObjects bObject, Object currentObject) {
		if(heap==null){
			System.out.println("UPDATE MODEL:Heap is not initialized in the controller!");
			return;
		}
			switch (bObject){
			case client:
				Client client = (Client)currentObject;
				if(client.getModelStatus()==ModelStatus.Exist)
				client.setModelStatus(ModelStatus.Updated);
				heap.set(heap.getSelectedIndex(), client);
				break;
			case manager:
				Manager manager = (Manager)currentObject;
				if(manager.getModelStatus()==ModelStatus.Exist)
				manager.setModelStatus(ModelStatus.Updated);
				heap.set(heap.getSelectedIndex(), manager);
				break;
			case product:
				Product product = (Product)currentObject;
				if(product.getModelStatus()==ModelStatus.Exist)
				product.setModelStatus(ModelStatus.Updated);
				heap.set(heap.getSelectedIndex(), product);
				break;
			case deal:
				Destribution destribution = (Destribution)currentObject;
				if(destribution.getModelStatus()==ModelStatus.Exist)
				destribution.setModelStatus(ModelStatus.Updated);
				heap.set(heap.getSelectedIndex(), destribution);
			}
	}

	//============================================================================================================
	
	
	
	
	private void editDialog(Object currentObject) {
	
		if(currentObject.getClass()==Client.class){
		IModelClient imodelClient = (IModelClient) clientDialog;
		imodelClient.setModel((Client)currentObject);
			clientDialog.init();
		} else if(currentObject.getClass()==Manager.class){
				IModelManager imodelManager = (IModelManager) managerDialog;
				imodelManager.setModel((Manager)currentObject);
					managerDialog.init(); 
					
		}  else if(currentObject.getClass()==Product.class){
			IModelProduct imodelProduct = (IModelProduct) productDialog;
			imodelProduct.setModel((Product)currentObject);
				productDialog.init();
				
		}  else if(currentObject.getClass()==Destribution.class){
			IModelDestribution imodelDestribution = (IModelDestribution) dealDialog;
			imodelDestribution.setModel((Destribution)currentObject);
				dealDialog.init();
		}  else { System.out.println("EDIT DIALOG: invalid arguments");
			return;
		}

	}
	@SuppressWarnings("unchecked")
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
			DealJDialog dealJDialog = (DealJDialog) dealDialog;
			dealJDialog.setClients((List<Object>) modelFasade.selectTO(new Client(null)));
			dealJDialog.setManagers((List<Object>) modelFasade.selectTO(new Manager(null)));
			dealJDialog.setProducts((List<Object>) modelFasade.selectTO(new Product(null)));
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

	
//===============================================================================================================	
	
	
	
	public void setProductDialog(IDisplayable productDialog) {
		this.productDialog = productDialog;
	}
	
	public void setIModelPersistable(IModelPersistable modelFasade){
		this.modelFasade = modelFasade;
	}

	
	
	public List<?> getHeapList() {
		return (List<?>) heap;
	}

	public void setHeapList(Heap heapList) {
		this.heap = heapList;
	}

	
	
	public Notificator getNotificator() {
		return notificator;
	}

	public void setNotificator(Notificator notificator) {
		this.notificator = notificator;
	}
	

}
