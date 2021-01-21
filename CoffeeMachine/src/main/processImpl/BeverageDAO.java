package processImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import dto.Inventory;
import model.Beverages;
import processor.CommonFunctionality;

public class BeverageDAO implements CommonFunctionality<Beverages>{

    private volatile static BeverageDAO instance = null;

    private BeverageDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static BeverageDAO getInstance() {

        if(instance==null) {
            synchronized (BeverageDAO.class) {

                if(instance==null) {
                    instance = new BeverageDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(Beverages value) {
    	Inventory.beveragesDB.put(value.getBeverageName(), value);
    }

    @Override
    public Optional<Beverages> get(String id) {
        return Optional.ofNullable(Inventory.beveragesDB.get(id));
    }

    @Override
    public Collection<Beverages> getAll() {
        return null;
    }

    @Override
    public List<Optional<Beverages>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Beverages value) {
    }
}