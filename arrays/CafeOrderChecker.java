
public class CafeOrderChecker {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        // check if we're serving orders first-come, first-served

        if(!(takeOutOrders.length + dineInOrders.length == servedOrders.length)){
            return false;
        }

        if (!orderSatisfied(takeOutOrders, servedOrders)) {
            return false;
        }
        if (!orderSatisfied(dineInOrders, servedOrders)) {
            return false;
        }

        return true;
    }

    public static boolean orderSatisfied(int[] takeOutOrders, int[] servedOrders) {

        int takeOut = 0;
        int served = 0;

        while (takeOut < takeOutOrders.length && served < servedOrders.length) {
            if (takeOutOrders[takeOut] == servedOrders[served]) {
                served += 1;
                takeOut += 1;
            } else {
                served += 1;
            }
        }
        if (takeOut != takeOutOrders.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        final int[] takeOutOrders = {1, 4, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 4, 5, 6};
        System.out.println(isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders));
    }
}


