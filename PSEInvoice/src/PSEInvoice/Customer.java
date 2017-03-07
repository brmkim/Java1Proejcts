/**
 * PSEInvoice package that contains the main class and others
 * for running the PSEInvoice application
 */
package PSEInvoice;
/**
 ************************************************************** 
 * Class        Customer
<<<<<<< HEAD
 * @filename    Customer.java
=======
 * filename     Customer.java
>>>>>>> 47cc80045ddf2edee006e7c2dc944a86626dec26
 * @author      Boram Kim
 * Created      02/15/2017
 * @version     1.0
 * Platform     PC, Centos 7, Netbeans IDE 8.2, jdk 1.8.0_111
 **************************************************************
 * <pre><b>
 * This class is for extra credit. This class reads the selected 
 * string item from customerNameJComboBox from DriverGUI class, 
 * parse the string, put the parsed word into a string-buffer 
 * variable, then returns the display of the string buffer. 
 * Please note that the redundant codes inside every method is 
 * intentional, because it gives an error if I put them outside 
<<<<<<< HEAD
 * of the each method or put into a separate method. 
 * </pre></b>
=======
 * of the each method or put into a separate method. </b>
 * </pre>
>>>>>>> 47cc80045ddf2edee006e7c2dc944a86626dec26
 **************************************************************
 * Input    A selected, comma-separated string item from 
 *          customerNameJComboBox (from DriverGUI.java)
 * Output   String buffer display of parsed input words
 *          including-
 *              customer's name
 *              customer's street address
 *              city
 *              state 
 *              ZIP
 * 
 * History Log  02/15/2017 Created version 1.0 after many 
 *              hours of thinking, trial and error.
 *          
 ************************************************************** 
 */

public class Customer 
{
    private String customerInfo;
/**
* Overload constructor for Customer class 
* @param customerName information which includes name and address
*/
    public Customer(String customerName)
    {
        // Assign the value fromt the JComboBox into a string variable
        this.customerInfo = customerName;
    }

 /**
<<<<<<< HEAD
 * Once again, the redundant codes inside each display* methods
=======
 * Once again, the duplicate codes inside each display* methods
>>>>>>> 47cc80045ddf2edee006e7c2dc944a86626dec26
 * are intentional. I wasn't able to make it work otherwise.
 */

 /**
 * displayName method creates local StringBuffer instance
 * and parse the string customerInfo by comma, and assign its
 * first element into a "name" variable. It appends the 
 * value of the variable into the display and returns it.
 * @return display StringBuffer which contains the name of 
 *         customer
 */
    public StringBuffer displayName()
    {
        // String buffer class instance variable 
         StringBuffer display = new StringBuffer(); 
        // Parse the customerInfo (selected string from JComboBox)
        String input = customerInfo.trim();
        String[] splittedText = input.split(",");
        // Assign the first element in the array to a variable "name"
        String name = splittedText[0];
        display.append(name);
        return display;        
    }
 /**
 * displayAddress method creates local StringBuffer instance
 * and parse the string customerInfo by comma, and assign its
 * second element into a "address" variable. It appends the 
 * value of the variable into the display and returns it.
 * @return display StringBuffer containing the value of 
 *         customer's street address
 */    
    public StringBuffer displayAddress()
    {
        StringBuffer display = new StringBuffer();
        String input = customerInfo.trim();
        String[] splittedText = input.split(",");
       
        String address = splittedText[1];
        display.append(address);
        return display;
    }
/**
 * displayCity method creates local StringBuffer instance
 * and parse the string customerInfo by comma, and assign its
 * first element into a "city" variable. It appends the 
 * value of the variable into the display and returns it.
 * @return display StringBuffer containing the name of 
 *         a city the customer resides
 */        
    public StringBuffer displayCity()
    {
        StringBuffer display = new StringBuffer();
        String input = customerInfo.trim();
        String[] splittedText = input.split(",");
        
        String city = splittedText[2];
        display.append(city);
        return display;
    }
 /**
 * displayState method creates local StringBuffer instance
 * and parse the string customerInfo by comma, and assign its
 * first element into a "state" variable. It appends the 
 * value of the variable into the display and returns it.
 * @return display StringBuffer containing the name of 
 *         state variable which is usually wrtten in 
 *         a two upper-letter format
 */ 
     public StringBuffer displayState()
    {
        StringBuffer display = new StringBuffer();
        String input = customerInfo.trim();
        String[] splittedText = input.split(",");
        
        String state= splittedText[3];
        display.append(state);
        return display;
    }
 /**
 * displayZip method creates local StringBuffer instance
 * and parse the string customerInfo by comma, and assign its
 * first element into a "zip" variable. It appends the 
 * value of the variable into the display and returns it.
 * @return display StringBuffer containing the zip code value
 */
    public StringBuffer displayZip()
    {
        StringBuffer display = new StringBuffer();
        String input = customerInfo.trim();
        String[] splittedText = input.split(",");
        
        String zip = splittedText[4];
        display.append(zip);
        return display;
    }
       
    
}
