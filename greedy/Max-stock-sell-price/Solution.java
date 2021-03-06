//https://www.interviewcake.com/question/java/stock-price
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    
  
    
    public static int getMaxProfit(int[] stockPrices) {

        int maxProfit = Integer.MIN_VALUE;
        int minPrice = stockPrices[0];
        
        for(int i=1;i<stockPrices.length;i++){
            int currPrice = stockPrices[i];
            if(currPrice - minPrice > maxProfit){
                maxProfit = currPrice - minPrice;
            }
            if(minPrice > currPrice){
                minPrice = currPrice;
            }
        }
        
        if(stockPrices.length<2){
             throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }
        return maxProfit;
    }

    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[] {1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[] {7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void bigIncreaseThenSmallIncreaseTest() {
        final int actual = getMaxProfit(new int[] {2, 10, 1, 4});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[] {9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[] {5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[] {});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}