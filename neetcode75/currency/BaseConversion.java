package currency;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class BaseConversion {

    public static final String TO = "_to_";

    public void convertFromAndTo(CurrencyType from, CurrencyType to) {
        String fromName = from.name();
        String toName = to.name();
        String conversionStr = fromName.toLowerCase() + TO + toName.toLowerCase();
        Properties prop = new Properties();
        try {
            ResourceBundle rb = ResourceBundle.getBundle("neetcode75/currency/conversion.properties");

            //load a properties file from class path, inside static method
            prop.load(BaseConversion.class.getClassLoader().getResourceAsStream("conversion.properties"));

            //get the property value and print it out
            System.out.println(prop.getProperty(conversionStr));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

        BaseConversion baseConversion = new BaseConversion();
        baseConversion.convertFromAndTo(CurrencyType.INR, CurrencyType.USD);

    }

}
