import java.io.IOException;

import input.InputProcessor;
import input.InputRequest;
import service.CoffeeService;

/**
 * Main method
 * Parses input and then asks application layer to serve the request
 */
public class CoffeeMachine {

    public static void main(String [] args) throws IOException {
        CoffeeService coffeeService = CoffeeService.getInstance();

        InputRequest inputRequest = InputProcessor.getInputRequest("src/main/resources/input.json");
        coffeeService.serve(inputRequest);
    }
}
