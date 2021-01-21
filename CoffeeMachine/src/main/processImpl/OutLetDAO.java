package processImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import dto.Inventory;
import model.Outlet;
import processor.CommonFunctionality;

public class OutLetDAO implements CommonFunctionality<Outlet>{

    private volatile static OutLetDAO instance = null;

    private OutLetDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static OutLetDAO getInstance() {

        if(instance==null) {
            synchronized (OutLetDAO.class) {

                if(instance==null) {
                    instance = new OutLetDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(Outlet value) {
    	Inventory.outletDB.put(value.getOutletName(), value);
    }

    @Override
    public Optional<Outlet> get(String id) {
        return Optional.of(Inventory.outletDB.get(id));
    }

    @Override
    public Collection<Outlet> getAll() {
        List<Outlet> outletIdList = new ArrayList<>();

        for(Map.Entry<String, Outlet> entry : Inventory.outletDB.entrySet()){
            outletIdList.add(entry.getValue());
        }

        return outletIdList;
    }

    @Override
    public List<Optional<Outlet>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Outlet value) {

    }
}