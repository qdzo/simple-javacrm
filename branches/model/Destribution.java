package model;

public class Destribution {

	private final Integer id;
	private String DateTime;
	private int ManagerId;
	private String ManagerFirstName;
	private String ManagerSecondName;
	private int ClientId;
	private String ClientFirstName;
	private String ClientSecondName;
	private int ProductId;
	private String ProductName;
	private ModelStatus modelStatus;
	
	
	public Destribution(Integer id){
		// a default constructor
		this.id = id;
	}
	
	
	public int getManagerId() {
		return ManagerId;
	}

	
	public String getManagerFirstName() {
		return ManagerFirstName;
	}

	
	public String getManagerSecondName() {
		return ManagerSecondName;
	}


	public void setManager(int managerId,String firstName,String lastName){
		if(validateDecimal(managerId)&&validate(firstName)&&validate(lastName)){
			setManagerId(managerId);
			setManagerFirstName(firstName);
			setManagerSecondName(lastName);	
		}
	}
	
	protected void setManagerId(int managerId) {
		ManagerId = managerId;
	}




	protected void setManagerFirstName(String managerFirstName) {
			ManagerFirstName = managerFirstName;
	}



	protected void setManagerSecondName(String managerSecondName) {
			ManagerSecondName = managerSecondName;
	}


	public int getClientId() {
		return ClientId;
	}

	
	public String getClientFirstName() {
		return ClientFirstName;
	}


	public String getClientSecondName() {
		return ClientSecondName;
	}

	
	public void setClient(int clientId, String firstName, String lastName){
		if(validateDecimal(clientId)&&validate(firstName)&&validate(lastName)){
			setClientId(clientId);
			setClientFirstName(firstName);
			setClientSecondName(lastName);
			
		}
		
	}
	protected void setClientId(int clientId) {
		ClientId = clientId;
	}


	protected void setClientFirstName(String clientFirstName) {
		ClientFirstName = clientFirstName;
	}


	protected void setClientSecondName(String clientSecondName) {
		ClientSecondName = clientSecondName;
	}


	public int getProductId() {
		return ProductId;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProduct(int productId,String productName){
		if(validateDecimal(productId)&&validate(productName)){
			setProductId(productId);
			setProductName(productName);
		}
	}
	
	protected void setProductId(int productId) {
		if(validateDecimal(productId))
		ProductId = productId;
	}

	
	protected void setProductName(String productName) {
		if(validate(productName))
		ProductName = productName;
	}


	public Integer getDestributionId() {
		return id;
	}
	
	
	protected boolean validate(String line){
		if(line.length()==0||line==null){
			System.out.println("Required an argument!");
			return false;
		}
		return true;
	}
	
	protected boolean validateDecimal(Integer dec){
		if(dec==null||dec<0){
			System.out.println("Required a right decimal argument");
			return false;
		}
		return true;
	}


	public String getDateTime() {
		return DateTime;
	}


	public ModelStatus getModelStatus() {
		return modelStatus;
	}


	public void setModelStatus(ModelStatus modelStatus) {
		this.modelStatus = modelStatus;
	}


//	public void setDateTime(String dateTime) {
//		DateTime = dateTime;
//	}
	
	
	
	
	
	
}
