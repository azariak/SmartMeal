# SmartMeal
## Recipe generation, recipe storage, and nutrient management 


### Contributors

#### Nachuan Wang (December-17th)
As a user, John wants to generate recipes from the ingredients he had on hand.

UI: Main -> recipe generation -> from ingredients -> text field -> enter ingredients(max 3) -> result as list
Note: default 1 ingredient, press + button on UI to add more tet field for more ingredient
Use case/Interactor: recipeSearchUI -> recipeSearchController -> recipeSearchFromIngredientUI -> recipeSearchFromIngredientController, APIController/recipeGenerationFromIngredientAPIController -> result DAO
-> Result UI
Interactor: recipe generation button controller -> from ingredients button controller 
      -> text field/add more button controller -> recipeGenerationFromIngredientAPIController -> result UI


#### Azaria Kelman (azariak)
##### User story
As a user, Azaria wants to rank his recipes on a scale of 1 to 5, so that he could remember which recipes he likes. 
He also wants to be able to place them into folders by theme, to create an organized directory.
##### Use Cases
- Each recipe has an attribute of an integer {1, 2, 3, 4, 5}. The user can set the integer by clicking on the respective star.
- Each recipe has a field for its folder. A user can click on a folder button, and type or select the name of the folder it should be included in.
Note: Each Folder is a Class that includes a list of recipes in that folder. Each recipe contains an atrribute for its star rating.


#### Anisa (AHK9)
#### User Story
Sara previously generated her favourite recipe, but
forgot what the ingredients were. She opens the SmartMeal program and 
chooses to load her saved recipes. Her previously saved recipes are displayed 
based on their rank, along with the ingredients, calories, and nutritional benefits 
of each.
#### Use Cases
- Saving: Saving the loaded recipes 
- Loading : loading the saved recipes

#### Daniel Rafailov (danielrafailov1)
#### User Story
Emma needs to meal prep for the week. She opens the meal planning program, selects
her dietary preferences and available ingredients and receives a personalized meal plan with recipes.
#### Use Cases
I want to open the SmartMeal app and be able to see the UI
I want to be able to filter recipes by dietary preferences
I want to be able to filter recipes by available ingredients


#### Vedavi Anandan (vedavia)
Kathy is frustrated as she can’t find recipes that match her dietary restrictions. 
She’s allergic to three things and still wants to have a filling meal. She looks 
for recipes by inputting the ingredients she wants excluded from her meals. She 
saves ones that interest her in a separate folder. As she tries the recipes she 
ranks them out of 5 and removes the recipes she doesn’t like.
