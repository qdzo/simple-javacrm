package model;

public enum Priority {
	
	low(3),Medium(2),Hi(1);
	int priorityValue;
//=========================================================================================
	Priority(int priorValue){
		priorityValue = priorValue;
	}
//------------------------------------------------------------------------------------------	
//==========================================================================================
	
	int getValue(){		
		
		return priorityValue;
		}
//------------------------------------------------------------------------------------------	
}
