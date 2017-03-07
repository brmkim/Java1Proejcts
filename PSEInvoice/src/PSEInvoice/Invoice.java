/**
 * PSEInvoice package that contains the main class and others
 * for running the PSEInvoice application
 */
package PSEInvoice;

import java.text.NumberFormat;

/**
 ************************************************************** 
 * Class        Invoice
 * @filename    Invoice.java
 * @author      Boram Kim
 * @since       02/09/2017
 * @version     1.0
 * Platform     PC, Centos 7, Netbeans IDE 8.2, jdk 1.8.0_111
 **************************************************************
 * <pre><b>
 * This class takes the meter readings from DriverGUi
 * and calculates costs and fees paybable to Puget Sound 
 * Electricity.
 * </pre></b>
 **************************************************************
 * Input    present meter reading
 *          previous meter reading          
 * Output   following calculated values 
 *              total meter reading
 *              delivery charge
 *              cost of gas
 *              conservation program charge
 *              subtotal
 *              city tax
 *              grand total
 *
 * History Log  02/09/2017 created version 1.0 
 ************************************************************** 
 */
public class Invoice 
{
    // Constant declaration
    final double CCHARGE = 6.25;
    final double DCHARGE = 0.29062;  // per thermal unit (TU)
    final double GAS1 = 0.69156;  // <= 50 TU
    final double GAS2 = 1.23863;  // 51-100 TU
    final double GAS3 = 2.0389;   // > 100 TU
    final double CPCHARGE = 0.00437; // per TU
    final double CITYTAX = 0.06;
    final int CAP50 = 50;
    final int CAP100 = 100;
    final int MAX = 1000000000;
    final int MIN = 0;
    
    // Variable declaration
    private String customerName;
    private int meterPresent;
    private int meterPrevious;
    private int meterTotalUnits = 0;
    private double deliveryCharge = 0.0;
    private double gasCost = 0.0;
    private double conservProgCharge = 0.0;
    private double subTotal = 0.0;
    private double cityTax = 0.0;   
    private double grandTotal = 0.0;
    
    // String buffer class instance variable 
    StringBuffer display = new StringBuffer();
    
    /**
     * Overloaded constructor for Invoice class 
     * @param customerName string value from the JComboBox in the application
     * @param meterPresent int input value from the keyboard
     * @param meterPrevious int input value from the keyboard
     */
    public Invoice(String customerName, int meterPresent, int meterPrevious) 
    {
        this.customerName = customerName;
        this.meterPresent = meterPresent;
        this.meterPrevious = meterPrevious;
    }
    /**
     * takes the present and previous meter readings and calculates the difference
     * @return meterTotalUnits int value
     */
    public int meterTotalUnits()
    {
        meterTotalUnits = meterPresent - meterPrevious;
        return meterTotalUnits;
    }
   /**
    * takes the meterTotalUnits as an input and multiplies by 
    * the delivery charge fee
    * @return deliveryCharge double value for dollar amount 
    */
    public double deliveryCharge()
    {
        deliveryCharge = DCHARGE * meterTotalUnits;
        return deliveryCharge;
    }
     /**
      * calculates the cost of gas, in three different different caps depending 
      * on the total thermal units
      * @return gasCost double value for dollar amount
      */    
    public double costOfGas()
    {
        if (meterTotalUnits > CAP100)
            gasCost = ( (meterTotalUnits - CAP100) * GAS3 ) + (CAP50 * GAS2) 
                    +(CAP50 * GAS1);
        else if (meterTotalUnits > CAP50 && meterTotalUnits < CAP100)
            gasCost = ( (meterTotalUnits - CAP50) * GAS2 ) + (CAP50 * GAS1);
        else 
            gasCost = meterTotalUnits * GAS1;
            
        return gasCost;
    }
    /**
     * calculates the conservation program charge
     * @return conservProgCharge double value for dollar amount
     */
    public double conservProgCharge()
    {
       conservProgCharge = CPCHARGE * meterTotalUnits;
       return conservProgCharge;
    }
    /**
     * adds the fixed customer charge, delivery charge, conservation program 
     * charge and cost of gas
     * @return subtotal double value for dollar amount
     */
    public double subtotal()
    {
        subTotal = CCHARGE + deliveryCharge + gasCost + conservProgCharge;
        return subTotal;
    }
    /**
     * calculates the city tax amount based on the subtotal
     * @return tax double value for dollar amount
     */
    public double tax()
    {
        cityTax = CITYTAX * subTotal;
        return cityTax;
        
    }
    /**
     * adds the subtotal and the citi tax. It's the total amount owed to PSE
     * @return grandtotal
     */
    public double grandTotal()
    {
        grandTotal = subTotal + cityTax;
        return grandTotal;
    }
    /**
    * this method is for adding the customer name into the invoice
    * It adds the string value of the customer name along with the numbers 
    * calculated in this class
    * @return string customer name
    */ 
    public String toString()
    {
        return "Customer" + customerName;  // add padSpace()            
    }
    /**
     * this method displays the values indicated and calculated within the class
     *  using StringBuffer
     * @return display values appended to the StringBuffer
     */
    public StringBuffer displayBill()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
                
        // Display the bill
        display.append(padSpaces("Customer", customerName + '\n'));
        display.append('\n');
        display.append(padSpaces("Customer Charge:", 
                currency.format(CCHARGE) + '\n'));
        display.append(padSpaces("Delivery Charge:", 
                currency.format(deliveryCharge()) + '\n'));
        display.append(padSpaces("Cost of Gas:", 
                currency.format(costOfGas()) + '\n'));
        display.append(padSpaces("Conservation Program Charge:", 
                currency.format(conservProgCharge()) + '\n'));
        display.append("--------------------------------------------\n");
        display.append(padSpaces("Subtotal:", 
                currency.format(subtotal()) + '\n'));
        display.append(padSpaces("City Tax:", 
                currency.format(tax()) + '\n'));
        display.append(padSpaces("Total:", 
                currency.format(grandTotal()) + '\n'));
     
        return display;
    }
    /**
     * A method to pad space for justification
     * @param first first arg (string)
     * @param second second arg (string)
     * @return line StringBuffer that has a number of space to be placed 
     * between two strings
     */
    private StringBuffer padSpaces(String first, String second)
    {
        final int MAXSPACES = 45; // Width of invoiceJTextArea
        StringBuffer line = new StringBuffer(first);
        int numSpaces = MAXSPACES - first.length() - second.length();
        
        for (int i = 0; i < numSpaces; i++)
            line.append(" ");
        
        line.append(second);
        
        return line;
    }
    
}