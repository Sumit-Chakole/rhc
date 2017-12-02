package com.ts.rhc.model;

public class AppWSOutput {

	
	private int operationStatus;
	Object resultSet=null;
	
	public int getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(int operationStatus) {
		this.operationStatus = operationStatus;
	}
	public Object getResultSet() {
		return resultSet;
	}
	public void setResultSet(Object resultSet) {
		this.resultSet = resultSet;
	}
	@Override
	public String toString() {
		return "NvieinWSOutput [operationStatus=" + operationStatus + ", resultSet=" + resultSet + "]";
	}
	
	
}
