package input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import commons.Constants;
import model.Beverages;
import model.Ingredients;

/**
 * Processing input json data
 */

public class InputProcessor {

    public static InputRequest getInputRequest(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        JsonReader reader = new JsonReader(inputStreamReader);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        JsonObject machine = jsonObject.getAsJsonObject(Constants.MACHINE);
        JsonObject outlets = machine.getAsJsonObject(Constants.OUTLETS);

        return new InputRequest(
                getBeverageList(machine.getAsJsonObject(Constants.BEVERAGES)),
                getIngredients(machine.getAsJsonObject(Constants.ITEMS)),
                outlets.get(Constants.OUTLET_NUMBER).getAsInt()
        );

    }

    private static List<Beverages> getBeverageList(JsonObject beverages){
        List<Beverages> beveragesList = new ArrayList<>();

        for(String beveragesName : beverages.keySet()){
            beveragesList.add(
                    new Beverages(beveragesName, getIngredients(beverages.getAsJsonObject(beveragesName)))
            );
        }

        return beveragesList;
    }

    private static List<Ingredients> getIngredients(JsonObject ingredients){

        List<Ingredients> ingredientsList = new ArrayList<>();
        for(String ingredientName : ingredients.keySet()){
            ingredientsList.add(new Ingredients(ingredientName, ingredients.get(ingredientName).getAsDouble()));
        }
        return ingredientsList;
    }
}
