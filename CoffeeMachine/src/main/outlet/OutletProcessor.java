package outlet;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Outlet;

/**
 * Process outlet beverages
 * It decides the parallelProcessingPower power of outlet by number of machines
 * Creates a thread pool with number of thread equals to parallelProcessingPower
 * submits the outlet task to these pool for parallel processing
 */

public class OutletProcessor{

    private Outlet outletDetails;
    private Integer parallelProcessingPower;
    private ExecutorService executorService;

    public OutletProcessor(Outlet outletDetails, Integer parallelProcessingPower) {
        this.outletDetails = outletDetails;
        this.parallelProcessingPower = parallelProcessingPower;
        this.executorService = Executors.newFixedThreadPool(parallelProcessingPower);
    }

    public void process() {

        List<String> listOfBeverages = OutletService.getInstance().getAllBeverageRelatedToOutlet(outletDetails.getOutletName());
        List<String> listOfIngredientId = OutletService.getInstance().getAllIngredientsRelatedToOutlet(outletDetails.getOutletName());


        for(String beverageId : listOfBeverages){
            executorService.submit(new OutletTask(outletDetails.getOutletName(), beverageId, listOfIngredientId));
        }
    }
}
