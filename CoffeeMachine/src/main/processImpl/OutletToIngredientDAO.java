package processImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import dto.Inventory;
import dto.OutletToIngredients;
import processor.CommonFunctionality;

public class OutletToIngredientDAO implements CommonFunctionality<OutletToIngredients> {
    private volatile static OutletToIngredientDAO instance = null;

    private OutletToIngredientDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static OutletToIngredientDAO getInstance() {

        if(instance==null) {
            synchronized (OutletToIngredientDAO.class) {

                if(instance==null) {
                    instance = new OutletToIngredientDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(OutletToIngredients value) {
    	Inventory.outletToIngredientList.add(value);
    }

    @Override
    public Optional<OutletToIngredients> get(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<OutletToIngredients> getAll() {
        return Inventory.outletToIngredientList;
    }

    @Override
    public List<Optional<OutletToIngredients>> getBatch(String id) {
        List<Optional<OutletToIngredients>> outletIngredientList = new ArrayList<>();

        for(OutletToIngredients outletToIngredients : Inventory.outletToIngredientList){
            if(outletToIngredients.getOutletId().equals(id)){
                outletIngredientList.add(Optional.of(outletToIngredients));
            }
        }
        return outletIngredientList;
    }

    @Override
    public void update(OutletToIngredients value) {

    }
}
