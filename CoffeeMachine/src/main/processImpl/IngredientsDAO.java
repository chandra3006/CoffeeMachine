package processImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import dto.Inventory;
import model.Ingredients;
import processor.CommonFunctionality;

public class IngredientsDAO implements CommonFunctionality<Ingredients>{
    private volatile static IngredientsDAO instance = null;

    private IngredientsDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static IngredientsDAO getInstance() {

        if(instance==null) {
            synchronized (IngredientsDAO.class) {

                if(instance==null) {
                    instance = new IngredientsDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(Ingredients value) {
        Inventory.ingredientsDB.put(value.getIngredientsName(), value);
    }

    @Override
    public Optional<Ingredients> get(String id) {
        return Optional.ofNullable(Inventory.ingredientsDB.get(id));
    }

    @Override
    public Collection<Ingredients> getAll() {
        return null;
    }

    @Override
    public List<Optional<Ingredients>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Ingredients value) {
    	Inventory.ingredientsDB.put(value.getIngredientsName(), value);
    }
}
