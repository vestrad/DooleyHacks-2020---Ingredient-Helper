import javax.swing.JOptionPane;
import java.util.Arrays;

public class IngredientHelper {
	
	public static void main(String[] args) {

		// collects number of ingredienst
		String numIngredientsString = JOptionPane.showInputDialog("Enter how many ingredients you have");
		int numIngredients = Integer.parseInt(numIngredientsString);

		String[] inputIngredients = new String[numIngredients];

		// keeps asking again and again
		for (int i = 1; i < numIngredients + 1; i++) {
			inputIngredients[i - 1] = JOptionPane.showInputDialog("Enter ingredient " + i);
		}
		String ingredients = convertToString(inputIngredients);
		JOptionPane.showMessageDialog(null, ingredients, "Ingredients", JOptionPane.PLAIN_MESSAGE);

		String[][] recipe = buildRecipeBook(); // the database of all recipes

		String canMake = " "; // Final Result of Recipes You can Make

		/*
		for (int i = 0; i < inputIngredients.length; i++) {
			System.out.println("i value " + i);
			System.out.println("inputIngredients " + inputIngredients[i]);
			System.out.println("recipe length " + recipe.length);
			if(inRecipe(inputIngredients[i], recipe) == 1) {
				System.out.println(" In for loop");
				canMake += recipe[i][0] + ", ";
			}
		}
		*/

		for (int i = 0; i < recipe.length; i++) {
			boolean check = true;
			for (int j = 1; j < recipe[i].length; j++) {
				if (!inRecipe(inputIngredients, recipe[i][j])) {
					check = false;
			}
		}
			if (check) {
			canMake += recipe[i][0] + ", ";
			}
		}






		String finalMake = "";
		for (int i = 0; i < canMake.length() - 2; i++) {
			finalMake += canMake.charAt(i);
		}
		//canMake = canMake.substring(0, canMake.length() - 2);
		if (canMake.length() == 1) {
			JOptionPane.showMessageDialog(null, "You can make no recipes", "You can make", JOptionPane.PLAIN_MESSAGE);	
		}
		 else {
		 	JOptionPane.showMessageDialog(null, "You can make" + finalMake, "You can make", JOptionPane.PLAIN_MESSAGE);	
	}	}

	
	/*
	public static int inRecipe(String ingredientCheck, String[][] recipeDatabase){
		int answer = 0;
		for (int i = 0; i < recipeDatabase.length; i++) {
			for (int j = 1; j < recipeDatabase[i].length; j++){
				if (ingredientCheck.equals(recipeDatabase[i][j])){
					answer = 1;
				}
			}
		}
		return answer;
	}
	*/

	public static boolean inRecipe(String[] ingredientCheck, String recipeDatabase){
		for (int i = 0; i < ingredientCheck.length; i++) {
			if (ingredientCheck[i].equals(recipeDatabase)) {
				return true;
		}
		}
		return false;
	}

	public static String convertToString(String[] inputIngredients){
		if (inputIngredients.length == 0) {
			return "You have no ingredients";
		} else if (inputIngredients.length == 1) {
			return inputIngredients[0];
		} else {
			String answer = inputIngredients[0] + ", ";
			for (int i = 1; i < inputIngredients.length - 1; i++) {
				answer += inputIngredients[i] + ", ";
			}
			answer += "and " + inputIngredients[inputIngredients.length - 1];
			return answer;
		}
	}

	public static String[][] buildRecipeBook() {
		String[][] answer = {
			{"Scrambled eggs","egg","milk","salt","pepper", "butter"},
			{"Cereal","cereal","milk"},
			{"Coffee","coffee beans","milk"},
			{"Bacon Egg and Cheese","bagel","butter", "bacon","egg","cheese","salt","pepper"},
			{"Omelot","egg","water", "salt","pepper", "butter","cheese"},
			{"Pizza","water","yeast", "flour","olive oil", "cheese","pepperoni"},
			{"Fried Chicken","chicken","vegetable oil", "flour","salt", "pepper","garlic powder","onion powder","cayenne powder"},		
			{"Chicken Parmesian","chicken","pepper", "egg","cheese", "flour","olive oil","tomato","basil"},
			{"Enchiladas","oil","flour", "pepper","onion", "olives","cheese"},
			{"Mashed Potatoes","potatoes","butter", "salt","pepper"},
			{"Buffalo Wings","chicken","vegetable oil", "salt","pepper", "butter","cheese"},
			{"Macaroni and Cheese","egg","water", "salt","pepper", "butter","celery"},
			{"Sushi","sushi","rice", "salmon","cream cheese", "avocado","soy sauce"},
			{"Tacos","beef","chili", "salt","pepper", "tomato","taco shells"},
			{"Peanut Butter","peanuts","honey", "sugar","salt"},
			{"Steak","butter","parsley", "garlic","soy sauce", "steak","salt","pepper"},
			{"Cheeseburger","chuck","onion powder", "salt","pepper", "cheese","burger buns"},
			{"Sausage","egg","water", "salt","pepper", "butter","cheese"},
		};
		return answer;
	}
}