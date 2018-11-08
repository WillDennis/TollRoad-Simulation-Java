/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String customerNotFound) {
        super("Customer not Found:\n" + customerNotFound);
    }

}
