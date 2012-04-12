package model;

public enum Priority {
	
	low(3,"������"),Medium(2,"�������"),Hi(1,"�������");
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
