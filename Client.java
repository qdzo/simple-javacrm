package model;

public class Client extends Person{

	Priority priority;
	
//==================================================================================================
	public Client(int id,String firstName,String secondName,String tel,String email,Status status,Priority priority){
		
		super(id,firstName,secondName,tel,email,status);
		
				this.priority = priority;
	}
	
//--------------------------------------------------------------------------------------------------
//==================================================================================================

	public Priority getPriority(){
		//  получение  приоритета клиента
		return this.priority;
	}
	
//--------------------------------------------------------------------------------------------------
//==================================================================================================

	public void setPriority(Priority priority){
		// установка приоритета клиента
		this.priority = priority;
	}
//--------------------------------------------------------------------------------------------------
	

}
