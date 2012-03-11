package model;

public abstract class Person {
	
	
	private int id;
	private String firstName;
	private String secondName;
	private String telephone;
	private String email;
	private Status status;
	
//===================================================================================================================
	

	public Person(int personId,String firstName,String secondName,String tel,String email,Status status){
		
		this.id = personId;
		this.firstName = firstName;
		this.secondName = secondName;
		this.telephone = tel;
		this.email = email;
		this.status = status;
	}
	
	
//====================================================================================================================
	
	public void setFirstName(String name){
		
		this.firstName = name;
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
//====================================================================================================================
	
	public void setSecondName(String secName){
		
		this.secondName = secName;
	}
	
//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================
	
	public void setTelephone(String tel){
		
		this.telephone = tel;
	}

//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================
	
	public void setEmail(String mail){
		
		this.email = mail;
	}
	
//--------------------------------------------------------------------------------------------------------------------	
//====================================================================================================================	
	
	public String getFirstName(){
		
		return this.firstName;
	}
	
//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================

	public String getSecondName(){
		
		return this.secondName;
	}
	
//--------------------------------------------------------------------------------------------------------------------	
//====================================================================================================================
	
	public String getTelephone(){
		
		return this.telephone;
		
	}
	
//--------------------------------------------------------------------------------------------------------------------	
//====================================================================================================================

public String getEmail(){
		
		return this.email;
	}

//--------------------------------------------------------------------------------------------------------------------	
//====================================================================================================================

	public int getId(){
		
		return this.id;
		
	}
//--------------------------------------------------------------------------------------------------------------------	
//====================================================================================================================
	
	public Status getStatus(){
		
		return this.status;
	}
	
//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================
	
	public void setStatus(Status status){
		
		this.status = status;
	}
}