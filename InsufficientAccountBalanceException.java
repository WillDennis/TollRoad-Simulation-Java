/*
 * Author : William Dennis
 * Date : 19/04/2018
 * Version : 1.3
 */
package tollroad;

public class InsufficientAccountBalanceException extends Exception {

    public InsufficientAccountBalanceException(String insufficientFunds) {
        super(insufficientFunds);
    }
}
