package model;

public abstract class Person {
	
	
	private final Integer id;
	private String firstName;
	private String secondName;
	private String telephone;
	private String email;
	private Status status;
	
//===================================================================================================================
	
	
	public Person(Integer id){
		this.id = id;
		firstName = null;
		secondName = null;
		telephone = null;
		email = null;
		status = null;
		
	}
	
	
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
		if(validate(name))
		this.firstName = name;
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
//====================================================================================================================
	
	public void setSecondName(String secName){
		if(validate(secName))
		this.secondName = secName;
	}
	
//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================
	
	public void setTelephone(String tel){
		if(validateTel(tel));
		this.telephone = tel;
	}

//--------------------------------------------------------------------------------------------------------------------
//====================================================================================================================
	
	public void setEmail(String mail){
		if(validateEmail(mail))
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
	
	
	protected boolean validate(String line){
		if(line==null||line==""){
			System.out.println("Reauired an argument!!");
		return false;
		} else return true;
	}
	
	protected boolean validateTel(String line){
		if(validate(line)){
			Long number = Long.parseLong(line);
			if(number!=null)
				return true;
			else System.out.println("this is not a decimal argument");
		}
		return false;
	}
	
	protected boolean validateEmail(String line){
		if(validate(line)){
			if(line.contains("@")||line.contains("."))
				return true;
			else System.out.println("it's a wrong email adress!!");
		}
		return false;
	}
}
