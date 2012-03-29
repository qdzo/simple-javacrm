package model;

public class Client extends Person{

	Priority priority;
	
//==================================================================================================
	public Client(int id,String firstName,String secondName,String tel,String email,Status status,Priority priority){
		
		super(id,firstName,secondName,tel,email,status);
		
				this.priority = priority;
	}
	
	
	public Client(Integer id){
		super(id);
	}
	
//--------------------------------------------------------------------------------------------------
//==================================================================================================

	public Priority getPriority(){
		// get a value of  client priority
		return this.priority;
	}
	
//--------------------------------------------------------------------------------------------------
//==================================================================================================

	public void setPriority(Priority priority){
		// set a value of  client priority
		this.priority = priority;
	}
//--------------------------------------------------------------------------------------------------
	

}
