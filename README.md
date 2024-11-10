# SmartMeal
## Recipe generation, recipe storage, and nutrient management 


### Contributors

#### Nachuan Wang (December-17th)
As a user, John wants to generate recipes from the ingredients he had on hand.

UI: MainView -> recipeSearchButton -> RecipeSearchView -> IngredientSearchButton -> IngredientSearchView -> text field/AddMoreButto  -> enter ingredients(max 3) -> SearchButton -> ResultView(TBD)
Note: default 1 ingredient, press + button on UI to add more text field for more ingredient
Use case/Interactor: MainMenuView -> RecipeSearchView -> recipeSearchController -> IngredientSearchView -> IngredientSearchInteractor/InputDataBoundary/OutputDataBoundary -> APIController/recipeGenerationFromIngredientAPIController -> result DAO(TBD)
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
- Each recipe has an attribute of an integer {1, 2, 3, 4, 5}. The user can set the integer by clicking on the respective star.
- Each recipe has a field for its folder. A user can click on a folder button, and type or select the name of the folder it should be included in.
Note: Each Folder is a Class that includes a list of recipes in that folder. Each recipe contains an atrribute for its star rating.

![Ranking_view.jpg](images/Azaria_User_Story/Ranking_view.png)
![Organizing_view.jpg](images/Azaria_User_Story/Organizing_view.png)

#### Anisa (AHK9)
#### User Story
- As a user Sara wants to reload her previously saved recipes in order to make her favorite 
recipe.
#### Use Cases
- The user clicks the saved recipes button and is then redirected to her previously
saved recipes page
- 

#### Daniel Rafailov (danielrafailov1)
#### User Story
Mia is a user with limited ingredients and/or dietary restrictions. She wants the SmartMeal app to suggest alternative
ingredients for recipes she is interested in, allowing her to make the recipe even when she doesn’t have all the
ingredients on hand.
#### Use Cases
- Mia opens a recipe and sees a list of ingredient substitutions based on her dietary preferences and the ingredients she has.
- If Mia doesn’t have a specific ingredient, she can click on it and view a list of suggested substitutes that match her dietary preferences.
- When Mia selects a substitute ingredient, the recipe automatically updates with the substitution so she can proceed with the adjusted recipe.


#### Vedavi Anandan (vedavia)
Kathy is frustrated as she can’t find recipes that match her dietary restrictions. 
She’s allergic to three things and still wants to have a filling meal. She looks 
for recipes by inputting the ingredients she wants excluded from her meals. She 
saves ones that interest her in a separate folder. As she tries the recipes she 
ranks them out of 5 and removes the recipes she doesn’t like.
