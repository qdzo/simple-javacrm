package model;

import java.util.Date;

public class Destribution {

	private final Integer id;
	private Date dateTime;
	private Integer managerId;
	private String managerFirstName;
	private String managerSecondName;
	private Integer clientId;
	private String clientFirstName;
	private String clientSecondName;
	private Integer productId;
	private String productName;
	private String comment;
	private DestributionStatus destributionStatus;
	private ModelStatus modelStatus;
	
	
	public Destribution(Integer id){
		// a default constructor
		this.id = id;
		managerId = null;
		clientId = null;
		productId = null;
	}
	
	
	public Integer getManagerId() {
		return managerId;
	}

	
	public String getManagerFirstName() {
		return managerFirstName;
	}

	
	public String getManagerSecondName() {
		return managerSecondName;
	}


	public void setManager(int managerId,String firstName,String lastName){
		if(validateDecimal(managerId)&&validate(firstName)&&validate(lastName)){
			setManagerId(managerId);
			setManagerFirstName(firstName);
			setManagerSecondName(lastName);	
		}
	}
	
	
	public void setManager(Manager manager){
		if(manager!=null){
			setManagerId(manager.getId());
			setManagerFirstName(manager.getFirstName());
			setManagerSecondName(manager.getSecondName());	
		}
	}
	protected void setManagerId(int managerId) {
		this.managerId = managerId;
	}




	protected void setManagerFirstName(String managerFirstName) {
			this.managerFirstName = managerFirstName;
	}



	protected void setManagerSecondName(String managerSecondName) {
			this.managerSecondName = managerSecondName;
	}


	public Integer getClientId() {
		return clientId;
	}

	
	public String getClientFirstName() {
		return clientFirstName;
	}


	public String getClientSecondName() {
		return clientSecondName;
	}

	
	
	
	
	public void setClient(Client client){
		if(client!=null){
			setClientId(client.getId());
			setClientFirstName(client.getFirstName());
			setClientSecondName(client.getSecondName());
		}
	}
	protected void setClientId(int clientId) {
		this.clientId = clientId;
	}


	protected void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}


	protected void setClientSecondName(String clientSecondName) {
		this.clientSecondName = clientSecondName;
	}


	public Integer getProductId() {
		return productId;
	}


	public String getProductName() {
		return productName;
	}


	
	public void setProduct(Product product){
		if(product!=null){
			setProductId(product.getProductId());
			setProductName(product.getNameProduct());
		}
	}
	
	protected void setProductId(int productId) {
		if(validateDecimal(productId))
		this.productId = productId;
	}

	
	protected void setProductName(String productName) {
		if(validate(productName))
		this.productName = productName;
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


	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date date){
		this.dateTime = date;
	}
	
	public ModelStatus getModelStatus() {
		return modelStatus;
	}


	public void setModelStatus(ModelStatus modelStatus) {
		this.modelStatus = modelStatus;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public DestributionStatus getStatus() {
		return destributionStatus;
	}


	public void setStatus(DestributionStatus status) {
		destributionStatus = status;
	}

	
}
