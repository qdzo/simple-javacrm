package model;

public enum Priority {
	
	low(3,"низкий"),Medium(2,"средний"),Hi(1,"высокий");
	int priorityValue;
	String priorityName;
//=========================================================================================
	Priority(int priorValue,String prioName){
		priorityValue = priorValue;
		priorityName = prioName;
	}
//------------------------------------------------------------------------------------------	
//==========================================================================================
	
	int getValue(){		
		
		return priorityValue;
		}
	
	String getName(){
		
		return priorityName;
	}
//------------------------------------------------------------------------------------------	
}
