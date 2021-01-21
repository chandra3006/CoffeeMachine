package dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Beverages;
import model.Ingredients;
import model.Outlet;

/**
 * DB storage of the data and relationShips
 */
public class Inventory {

    public static Map<String, Outlet> outletDB = new HashMap<>();
    public static Map<String, Beverages> beveragesDB = new HashMap<>();
    public static Map<String, Ingredients> ingredientsDB = new HashMap<>();

    public static List<OutletToBeverages> outletToBeveragesList = new ArrayList<>();
    public static List<OutletToIngredients> outletToIngredientList = new ArrayList<>();

}
