package model;

public enum Priority {
	
	low(1),Medium(2),Hi(3);
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
