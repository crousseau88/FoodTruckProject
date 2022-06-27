package com.skilldistillery.foodtruck.app;

import java.util.Arrays;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp ratingApp = new FoodTruckApp();
		Scanner input = new Scanner(System.in);

		ratingApp.run(input, ratingApp);
		input.close();
	}

	public void displayMenu() {
		System.out.println("############################################");
		System.out.println("# <<<<<<<<<<<(Please Choose One)>>>>>>>>>>>#");
		System.out.println("#                                          #");
		System.out.println("# 1.List all existing food trucks.         #");
		System.out.println("# 2.See the average rating of food trucks. #");
		System.out.println("# 3.Display the highest-rated food truck.  #");
		System.out.println("# 4.Quit        	                   #");
		System.out.println("#                                          #");
		System.out.println("############################################");
	}

	private void run(Scanner input, FoodTruckApp ratingApp) {

		FoodTruck[] trucks = ratingApp.inputTrucks(input);
		boolean runApp = true;
		while (runApp) {
			ratingApp.displayMenu();
			runApp = ratingApp.menuChoice(input, trucks);
		}
	}

	public FoodTruck[] inputTrucks(Scanner input) {
		FoodTruck[] trucksArr = new FoodTruck[5];

		String foodType = " ";
		double rating = 0.0;

		for (int i = 0; i < trucksArr.length; i++) {
			System.out.println("Please enter the name of a Food Truck or type 'quit' to stop entering trucks.");
			String foodTruckName = input.nextLine();

			if (foodTruckName.equals("quit")) {
				FoodTruck[] exit = Arrays.copyOf(trucksArr, i);
				return exit;

			} else {
				System.out.println("Please enter the food type.");
				foodType = input.nextLine();
			}
			do {
				System.out.println("Please enter your rating 1-5.");
				rating = input.nextDouble();
				if (rating > 5 || rating < 1) {
					System.out.println("The rating must be between 1-5. Please enter another rating.");
				}

			} while (rating > 5 || rating < 1);
			input.nextLine();

			trucksArr[i] = new FoodTruck();
			trucksArr[i].setFoodTruckName(foodTruckName);
			trucksArr[i].setFoodType(foodType);
			trucksArr[i].setTruckRating(rating);
			trucksArr[i].setTruckID(i);

		}
		return trucksArr;
	}

	public boolean menuChoice(Scanner input, FoodTruck[] trucks) {

		int choice = 0;

		do {
			System.out.println("Please enter a choice between 1-4.");
			choice = input.nextInt();

			if (choice > 4 || choice < 1) {
				System.out.println("Your choice was not in range. Please make a choice between 1-4.");

			}
		} while (choice > 4 || choice < 1);
		System.out.println();
		switch (choice) {
		case 1:
			displayFoodTrucks(trucks);
			break;
		case 2:
			showAverage(trucks);
			break;
		
		case 3:
			highestRated(trucks);
			break;
		case 4:
			System.out.println("Thank you for using the Food Truck App!");
			return false;
	}
		return true;
	}


	public void displayFoodTrucks(FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			System.out.println("All existing food trucks: ");
			System.out.println(trucks[i].toString());

		}
	}

	public void showAverage(FoodTruck[] trucks) {
		double sum = 0;
		for (int i = 0; i < trucks.length; i++) {
			sum += trucks[i].getTruckRating();
		}
		double averageRating = sum / trucks.length;
		System.out.println("The average rating of all of the trucks is: " + averageRating);
	}
	private void highestRated(FoodTruck[] trucks) {
		double highestRated = trucks[0].getTruckRating();
		for(int i = 0; i < trucks.length; i++) {
			if(trucks[i].getTruckRating() > highestRated) {
				highestRated = trucks[i].getTruckRating();
				System.out.println(highestRated + " " + trucks[i].toString() );
			}
	}
	}
}
