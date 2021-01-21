package service;

import java.util.Optional;

import model.Beverages;
import processImpl.BeverageDAO;
import processor.CommonFunctionality;

/**
 * Service which performs actions related to beverages
 * like CRUD operations on beverage data
 */
public class BeverageService {

    private volatile static BeverageService instance = null;
    private CommonFunctionality<Beverages> beveragesIDAO;

    private BeverageService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
        beveragesIDAO = (CommonFunctionality<Beverages>) BeverageDAO.getInstance();
    }

    public static BeverageService getInstance() {

        if(instance==null) {
            synchronized (BeverageService.class) {

                if(instance==null) {
                    instance = new BeverageService();
                }

            }
        }

        return instance;
    }

    public void registerBeverage(Beverages beverages){
        beveragesIDAO.create(beverages);
    }

    public Beverages getBeverageDetails(String beverageId){
        Optional<Beverages> beverages = beveragesIDAO.get(beverageId);
        return beverages.orElse(null);
    }
}
