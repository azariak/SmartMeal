# SmartMeal
## Recipe generation, recipe storage, and nutrient management 


### Contributors

#### Nachuan Wang (December-17th)
As a user, John wants to generate recipes from the ingredients he had on hand.

UI: Main -> recipe generation -> from ingredients -> text field -> enter ingredients(max 3) -> result as list
Note: default 1 ingredient, press + button on UI to add more text field for more ingredient
Use case/Interactor: recipeSearchUI -> recipeSearchController -> recipeSearchFromIngredientUI -> recipeSearchFromIngredientController, APIController/recipeGenerationFromIngredientAPIController -> result DAO
-> Result UI
Interactor: recipe generation button controller -> from ingredients button controller 
      -> text field/add more button controller -> recipeGenerationFromIngredientAPIController -> result UI
![1.jpg](images/1.jpg)
login/signup view
![2.jpg](images/2.jpg)
Main menu view
![3.jpg](images/3.jpg)
recipe search view
![4.jpg](images/4.jpg)
ingredient search view and result view

A demo sketch for the user story and views


#### Azaria Kelman (azariak)
##### User story
As a user, Azaria wants to rank his recipes on a scale of 1 to 5, so that he could remember which recipes he likes. 
He also wants to be able to place them into folders by theme, to create an organized directory.
##### Use Cases
- Each recipe has an atrribute of an integer {1, 2, 3, 4, 5}. The user can set the integer by clicking on the respective star.
- Each recipe has a field for its folder. A user can click on a folder button, and type or select the name of the folder it should be included in.
Note: Each Folder is a Class that includes a list of recipes in that folder. Each recipe contains an atrribute for its star rating.


#### Anisa (AHK9)
Sara previously generated her favourite recipe, but
forgot what the ingredients were. She opens the SmartMeal program and 
chooses to load her saved recipes. Her previously saved recipes are displayed 
based on their rank, along with the ingredients, calories, and nutritional benefits 
of each.

#### Daniel Rafailov (danielrafailov1)
Emma needs to meal prep for the week. She opens the meal planning program, selects
her dietary preferences and available ingredients and receives a personalized meal plan with recipes.

#### Vedavi Anandan (vedavia)
Kathy is frustrated as she can’t find recipes that match her dietary restrictions. 
She’s allergic to three things and still wants to have a filling meal. She looks 
for recipes by inputting the ingredients she wants excluded from her meals. She 
saves ones that interest her in a separate folder. As she tries the recipes she 
ranks them out of 5 and removes the recipes she doesn’t like.
