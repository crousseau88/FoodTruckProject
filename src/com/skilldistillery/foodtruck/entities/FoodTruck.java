package com.skilldistillery.foodtruck.entities;





public class FoodTruck {
	private  int truckID = 13;
	private  int newTruckId = 0;
	private String foodTruckName;
	private String foodType;
	private double truckRating;
	
/*
 *  unique numeric id, a name ("TacoRific", "Mediterranean Medic", etc.),
 *  food type ("Tacos", "Falafel", etc.), and a numeric rating.
 */
	public FoodTruck() {
		super();
	}
public FoodTruck(int truckID, int nextId, String foodTruckName, String foodType, double truckRating) {
	super();
	this.truckID = truckID;
	this.foodTruckName = foodTruckName;
	this.foodType = foodType;
	this.truckRating = truckRating;
}
public int getTruckID() {
	return truckID;
}
public void setTruckID(int truckID) {
	this.truckID = truckID + newTruckId + 5;
}
public int getNewTruckId() {
	return newTruckId;
}
public void setNewTruckId(int newTruckId) {
	this.newTruckId = newTruckId;
	newTruckId++;
}
public String getFoodTruckName() {
	return foodTruckName;
}
public void setFoodTruckName(String foodTruckName) {
	this.foodTruckName = foodTruckName;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
public double getTruckRating() {
	return truckRating;
}
public void setTruckRating(double truckRating) {
	this.truckRating = truckRating;
}
@Override
public String toString() {
    StringBuilder builder = new StringBuilder(5);
    builder.append("Food truck name: " +foodTruckName)
    .append(" Food type: " + foodType).append(" Food truck rating: " +truckRating)
    .append(" Truck ID: " +truckID);
    return builder.toString();
}
}
