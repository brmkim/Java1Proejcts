/**
 * PSEInvoice package that contains the main class and others
 * for running the PSEInvoice application
 */
package PSEInvoice;

import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 ************************************************************** 
 * Class        DriverGUI
 * @filename    DriverGUI.java
 * @author      Boram Kim
 * @since       02/08/2017
 * @version     1.2
 * Platform     PC, Centos 7, Netbeans IDE 8.2, jdk 1.8.0_111
 **************************************************************
 * <pre><b>
 * This file contains the GUI driver and the main class to run 
 * the program. The program takes input of meter readings either
 * directly from the keyboard or from existing text file,
 * calculate the tax and fees payable to Puget Sound Electricity.
 * A user can save the displayed invoice into a text file or 
 * print it. The GUI form can also be printed. 
 * 
 * </pre></b>
 **************************************************************
 * Input    present meter reading; previous meter reading;
 *          account number; customer name; street address;
 *          city; zip code
 *          Or 
 *          a text file which contains above information, 
 *          and the data is comma-separated
 * Output   Monitor display of the input and calculated values 
 *              total meter reading
 *              customer name
 *              customer charge
 *              delivery charge
 *              cost of gas
 *              conservation program charge
 *              subtotal
 *              city tax
 *              total
 *
 * History Log  02/08/2017 created version 1.0 
 *              02/13/2017 added readCustomer method and 
 *                          input validations
 *              02/14/2017 resolved overload constructor
 *              02/15/2017 resolved save problem, added codes
 *                          in the customerNameJComboBox for 
 *                          extra credit, and also changed the 
 *                          stateJComboBox into 
 *                          stateJFormattedTextField so that 
 *                          parsed information can be passed
 *                          into it.
 *               
 *          
 ************************************************************** 
 */
public class DriverGUI extends javax.swing.JFrame 
{
    // Specify the input and output file names
    private String inputFileName = "src/PSEInvoice/Customers.txt"; 
    private String outputFileName = "src/PSEInvoice/InvoiceSaved.txt";
    
    private DecimalFormat dollars = new DecimalFormat("$#,##0.00");
    StringBuffer display = new StringBuffer("");
    Invoice myInvoice;
    

    /** 
     * Creates a form DriverGUI for the program
     */
    public DriverGUI() 
    {
        initComponents();
         // set Calculate button as default
        this.getRootPane().setDefaultButton(displayBillJButton);
        // center the form
        this.setLocationRelativeTo(null);
        // set an icon 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(
                "src/PSEInvoice/pseLogo.jpg"));
        
        // set the cursor at the present reading field at the start of the
        // program
        presentJFormattedTextField.requestFocus();
        
        // Call a method to read a patient's name and fill the patient's 
        // combo box 
        readCustomers(inputFileName);
        // Set title
        this.setTitle("PSE Invoice Program");
        // Get today's date for the form
        setDate();
        
    }
    /** 
     * Shows today's date in the text field
     * @see java.text.DateFormat
     * @see java.text.SimpleDateFormat
     */
     private void setDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
        Date today = new Date();
        invoiceDateJFormattedTextField.setText(dateFormat.format(today));
    }
    /**
     * This methods reads a text file and put the information into
     * customerJComboBox. 
     * @param fileName path and name of the file to be read
     */ 
    private void readCustomers(String fileName)
    {
        try 
        {
            FileReader freader = new FileReader(fileName);
            BufferedReader input = new BufferedReader(freader);
            // read first line from file
            String customerName = input.readLine();
            // read all the names until the EOF (where null is returned)
            while(customerName != null)
            {
                //add the name to the JComboBox  
                customerNameJComboBox.addItem(customerName);
                // read the next patient name
                customerName = input.readLine();
            }
            
            input.close();
                        
        }
        catch (FileNotFoundException exp)
        {
            // Bring up a JFileChooser to find the file
            JOptionPane.showMessageDialog(null, "FIle not found", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            
            
        }
        catch (IOException exp)
        {
            // Bring up a JFileChooser to find the file
            JOptionPane.showMessageDialog(null, "Cannot read file", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            
            
        }
    }
     
     
     
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meterReadingsJPanel = new javax.swing.JPanel();
        presentJLabel = new javax.swing.JLabel();
        presentJFormattedTextField = new javax.swing.JFormattedTextField();
        previousJLabel = new javax.swing.JLabel();
        previousJFormattedTextField = new javax.swing.JFormattedTextField();
        totalUnitsJLabel = new javax.swing.JLabel();
        totalUnitsJFormattedTextField = new javax.swing.JFormattedTextField();
        customerNameJPanel = new javax.swing.JPanel();
        customerNameJLabel = new javax.swing.JLabel();
        customerNameJComboBox = new javax.swing.JComboBox<>();
        meterReadingsJLabel = new javax.swing.JLabel();
        rightMostJPanel = new javax.swing.JPanel();
        invoiceDateJLabel = new javax.swing.JLabel();
        invoiceDateJFormattedTextField = new javax.swing.JFormattedTextField();
        accountNumberJLabel = new javax.swing.JLabel();
        accountNumberJFormattedTextField = new javax.swing.JFormattedTextField();
        companyInfoJScrollPane = new javax.swing.JScrollPane();
        companyInfoJTextArea = new javax.swing.JTextArea();
        customerInfoJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJFormattedTextField = new javax.swing.JFormattedTextField();
        addressJLabel = new javax.swing.JLabel();
        addressJFormattedTextField = new javax.swing.JFormattedTextField();
        cityJLabel = new javax.swing.JLabel();
        cityJFormattedTextField = new javax.swing.JFormattedTextField();
        stateJLabel = new javax.swing.JLabel();
        stateJFormattedTextField = new javax.swing.JFormattedTextField();
        zipJLabel = new javax.swing.JLabel();
        zipJFormattedTextField = new javax.swing.JFormattedTextField();
        invoiceJScrollPane = new javax.swing.JScrollPane();
        invoiceJTextArea = new javax.swing.JTextArea();
        control1JPanel = new javax.swing.JPanel();
        displayBillJButton = new javax.swing.JButton();
        printInvoiceJButton = new javax.swing.JButton();
        control2JPanel = new javax.swing.JPanel();
        clearJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        thanksJLabel = new javax.swing.JLabel();
        pic1JLabel = new javax.swing.JLabel();
        pic2JLabel = new javax.swing.JLabel();
        menuJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        printFormJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        JSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        meterReadingsJPanel.setLayout(new java.awt.GridLayout(3, 2, 5, 6));

        presentJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        presentJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        presentJLabel.setText("Present");
        meterReadingsJPanel.add(presentJLabel);

        presentJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        presentJFormattedTextField.setToolTipText("Enter the present meter reading");
        presentJFormattedTextField.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        presentJFormattedTextField.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        presentJFormattedTextField.setNextFocusableComponent(previousJFormattedTextField);
        presentJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentJFormattedTextFieldActionPerformed(evt);
            }
        });
        meterReadingsJPanel.add(presentJFormattedTextField);

        previousJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        previousJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        previousJLabel.setText("Previous");
        meterReadingsJPanel.add(previousJLabel);

        previousJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        previousJFormattedTextField.setDragEnabled(true);
        previousJFormattedTextField.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        previousJFormattedTextField.setNextFocusableComponent(accountNumberJFormattedTextField);
        previousJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousJFormattedTextFieldActionPerformed(evt);
            }
        });
        meterReadingsJPanel.add(previousJFormattedTextField);

        totalUnitsJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        totalUnitsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalUnitsJLabel.setText("Total Units");
        meterReadingsJPanel.add(totalUnitsJLabel);

        totalUnitsJFormattedTextField.setEditable(false);
        totalUnitsJFormattedTextField.setBackground(new java.awt.Color(207, 200, 200));
        totalUnitsJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalUnitsJFormattedTextField.setDragEnabled(true);
        totalUnitsJFormattedTextField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        meterReadingsJPanel.add(totalUnitsJFormattedTextField);

        customerNameJLabel.setText("Customer: ");
        customerNameJPanel.add(customerNameJLabel);

        customerNameJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));
        customerNameJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameJComboBoxActionPerformed(evt);
            }
        });
        customerNameJPanel.add(customerNameJComboBox);

        meterReadingsJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        meterReadingsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        meterReadingsJLabel.setText("Meter Readings");

        invoiceDateJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        invoiceDateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        invoiceDateJLabel.setText("Invoice Date");

        invoiceDateJFormattedTextField.setEditable(false);
        invoiceDateJFormattedTextField.setBackground(new java.awt.Color(207, 200, 200));
        invoiceDateJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        invoiceDateJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        invoiceDateJFormattedTextField.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N

        accountNumberJLabel.setFont(new java.awt.Font("Cantarell", 3, 14)); // NOI18N
        accountNumberJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        accountNumberJLabel.setText("Account #");

        try {
            accountNumberJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        accountNumberJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        accountNumberJFormattedTextField.setNextFocusableComponent(nameJFormattedTextField);
        accountNumberJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberJFormattedTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightMostJPanelLayout = new javax.swing.GroupLayout(rightMostJPanel);
        rightMostJPanel.setLayout(rightMostJPanelLayout);
        rightMostJPanelLayout.setHorizontalGroup(
            rightMostJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightMostJPanelLayout.createSequentialGroup()
                .addGroup(rightMostJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightMostJPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(invoiceDateJFormattedTextField))
                    .addGroup(rightMostJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(accountNumberJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightMostJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(rightMostJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceDateJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(accountNumberJLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        rightMostJPanelLayout.setVerticalGroup(
            rightMostJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightMostJPanelLayout.createSequentialGroup()
                .addComponent(invoiceDateJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceDateJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountNumberJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accountNumberJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        companyInfoJTextArea.setEditable(false);
        companyInfoJTextArea.setBackground(new java.awt.Color(207, 200, 200));
        companyInfoJTextArea.setColumns(20);
        companyInfoJTextArea.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        companyInfoJTextArea.setRows(5);
        companyInfoJTextArea.setText("Payment Processing\nP.O. Box 91269\nBellevue, WA 98009\nwww.pse.com\n");
        companyInfoJScrollPane.setViewportView(companyInfoJTextArea);

        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("Name");

        nameJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameJFormattedTextField.setNextFocusableComponent(addressJFormattedTextField);
        nameJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJFormattedTextFieldActionPerformed(evt);
            }
        });

        addressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressJLabel.setText("Address");

        addressJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        addressJFormattedTextField.setNextFocusableComponent(cityJFormattedTextField);
        addressJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressJFormattedTextFieldActionPerformed(evt);
            }
        });

        cityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityJLabel.setText("City");

        cityJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cityJFormattedTextField.setNextFocusableComponent(stateJFormattedTextField);
        cityJFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityJFormattedTextFieldActionPerformed(evt);
            }
        });

        stateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stateJLabel.setText("State");

        try {
            stateJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        stateJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stateJFormattedTextField.setNextFocusableComponent(zipJFormattedTextField);

        zipJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        zipJLabel.setText("Zip");

        try {
            zipJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        zipJFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        zipJFormattedTextField.setNextFocusableComponent(displayBillJButton);

        javax.swing.GroupLayout customerInfoJPanelLayout = new javax.swing.GroupLayout(customerInfoJPanel);
        customerInfoJPanel.setLayout(customerInfoJPanelLayout);
        customerInfoJPanelLayout.setHorizontalGroup(
            customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressJLabel)
                    .addComponent(cityJLabel)
                    .addComponent(nameJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                        .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addressJFormattedTextField)
                            .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cityJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stateJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stateJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zipJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zipJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))
                    .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                        .addComponent(nameJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        customerInfoJPanelLayout.setVerticalGroup(
            customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerInfoJPanelLayout.createSequentialGroup()
                        .addComponent(addressJLabel)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerInfoJPanelLayout.createSequentialGroup()
                        .addComponent(addressJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(customerInfoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityJLabel)
                    .addComponent(cityJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateJLabel)
                    .addComponent(zipJLabel)
                    .addComponent(stateJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        invoiceJTextArea.setEditable(false);
        invoiceJTextArea.setColumns(20);
        invoiceJTextArea.setFont(new java.awt.Font("Courier 10 Pitch", 0, 12)); // NOI18N
        invoiceJTextArea.setRows(5);
        invoiceJScrollPane.setViewportView(invoiceJTextArea);

        control1JPanel.setLayout(new java.awt.GridLayout(2, 2, 0, 3));

        displayBillJButton.setMnemonic('D');
        displayBillJButton.setText("Display Bill");
        displayBillJButton.setNextFocusableComponent(printInvoiceJButton);
        displayBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBillJButtonActionPerformed(evt);
            }
        });
        control1JPanel.add(displayBillJButton);

        printInvoiceJButton.setMnemonic('P');
        printInvoiceJButton.setText("Print Invoice");
        printInvoiceJButton.setNextFocusableComponent(clearJButton);
        printInvoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printInvoiceJButtonActionPerformed(evt);
            }
        });
        control1JPanel.add(printInvoiceJButton);

        control2JPanel.setLayout(new java.awt.GridLayout(1, 2, 3, 0));

        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.setNextFocusableComponent(quitJButton);
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        control2JPanel.add(clearJButton);

        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setNextFocusableComponent(saveJButton);
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        control2JPanel.add(quitJButton);

        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setToolTipText("");
        saveJButton.setNextFocusableComponent(presentJFormattedTextField);
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        control2JPanel.add(saveJButton);

        thanksJLabel.setFont(new java.awt.Font("Cantarell", 3, 18)); // NOI18N
        thanksJLabel.setForeground(new java.awt.Color(38, 125, 109));
        thanksJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thanksJLabel.setText("Thank you for using our service!");

        pic1JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pic1JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PSEInvoice/pse_sm.jpg"))); // NOI18N

        pic2JLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pic2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PSEInvoice/pic2.jpg"))); // NOI18N
        pic2JLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        clearJMenuItem.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printJMenuItem.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        printFormJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        printFormJMenuItem.setMnemonic('M');
        printFormJMenuItem.setText("Print Form");
        printFormJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printFormJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printFormJMenuItem);

        saveJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(JSeparator);

        quitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitJMenuItem.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        menuJMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        menuJMenuBar.add(helpJMenu);

        setJMenuBar(menuJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerNameJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pic1JLabel)
                                    .addComponent(pic2JLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(meterReadingsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(meterReadingsJLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rightMostJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(companyInfoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(customerInfoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(thanksJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(invoiceJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(control2JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(control1JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rightMostJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meterReadingsJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(meterReadingsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerNameJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pic1JLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyInfoJScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pic2JLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(customerInfoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(control1JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(control2JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(invoiceJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thanksJLabel)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * displays the invoice calculated from the Invoice class
     * @param evt event of JButton being clicked
     */
    private void displayBillJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBillJButtonActionPerformed
         
        final int MAX = 1000000000;
        final int MIN = 0;
        boolean invalidPrevious = false;
        boolean invalidPresent = false;
       
        String errorMessage = "Please check if your previous reading exceeds"
                +" the present OR if your input is out of range.\n"
                + "Range: [" + MIN + ", " + MAX + "]";
           
        try
        {
            // Get meter readings and validate the input
            int meterPresent = Integer.parseInt(presentJFormattedTextField.getText());
            invalidPresent= (meterPresent > MAX) || (meterPresent <= MIN) 
                    || (presentJFormattedTextField.equals(""));
            int meterPrevious = Integer.parseInt(previousJFormattedTextField.getText());
            invalidPrevious = (meterPrevious > meterPresent) 
                    || (meterPrevious <= MIN) || (meterPrevious > MAX) 
                    || (previousJFormattedTextField.equals(""));           
                
                        
            // If input is invalid and throws an exception 
            boolean invalidInput = invalidPrevious || invalidPresent;
            if (invalidInput)
                throw new NumberFormatException();

            myInvoice = new Invoice(nameJFormattedTextField.getText(), 
                    meterPresent, meterPrevious);

            // Display the total meter reading (calculated from Invoice.java)
            int meterTotal = myInvoice.meterTotalUnits();
            totalUnitsJFormattedTextField.setValue(meterTotal);        
    
            // See if any information is missing
            String customerName = nameJFormattedTextField.getText();
            String accountNumber = accountNumberJFormattedTextField.getText();
            String address = addressJFormattedTextField.getText();
            String city = cityJFormattedTextField.getText();
            String zip = stateJFormattedTextField.getText();
            
            if ( (customerName.isEmpty()) || (accountNumber.equals("   -   -   - "))
                    || (address.isEmpty()) || (city.isEmpty()) 
                    || (zip.equals("     ")) )                
            {
                JOptionPane.showMessageDialog(null, "Please fill out all the"
                        + " customer information and/or get the proper "
                        + "meter reading", "Missing Information", 
                        JOptionPane.WARNING_MESSAGE);
            }

            else   // All is good. Do the calculation
            {
                display.delete(0, display.length()); //clear the display
                invoiceJTextArea.setText(myInvoice.displayBill().toString());            
            }
        }
        catch(NumberFormatException exp)
        {
            // Throws an error message
            JOptionPane.showMessageDialog(this, errorMessage, "Invalid Data", 
                    JOptionPane.WARNING_MESSAGE);
            
            // Hightlight the invalid value text field
            if (invalidPrevious)
            {
                previousJFormattedTextField.requestFocus();
                previousJFormattedTextField.selectAll();
            }
            if (invalidPresent)
            {
                presentJFormattedTextField.requestFocus();
                presentJFormattedTextField.selectAll();
            }            
        }
    }//GEN-LAST:event_displayBillJButtonActionPerformed
/**
 * Saves the invoice into a text file
 * @param evt save JButton is clicked
 */
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        // TODO add your handling code here:
        FileWriter fwriter = null;
        PrintWriter outputFile = null;
        try
        {
            // Create a text file and save the bill to it
           fwriter = new FileWriter(outputFileName);
           outputFile = new PrintWriter(fwriter);
           
            // Write the display into a file
           outputFile.println(myInvoice.display.toString());
           //outputFile.write(display.toString());
           
           //fwriter.close();
           outputFile.flush();
          // outputFile.close();
           
        }
        catch (IOException ex)
        {
            //Logeer.getLogger(DentalGUI.class.getName()).log(level.SEVERE, null
            JOptionPane.showMessageDialog(null, "Error in saving file", 
                    "Error in Saving", JOptionPane.ERROR_MESSAGE);
                    
        }
        finally
        {
            if (outputFile != null)
                outputFile.close();
        }
    }//GEN-LAST:event_saveJButtonActionPerformed
/**
 * Print the invoice 
 * @param evt print JButton is clicked
 * @see PrintUtilities.java
 */
    private void printInvoiceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printInvoiceJButtonActionPerformed
        // Print the invoice  
        try
        {
            // Print the content of the JTextArea
            invoiceJTextArea.print();
        } catch (PrinterException ex)
        {
            //Logger.getLogger(DentalGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cannot print invoice", "Print Error", 
                    JOptionPane.ERROR_MESSAGE);
        } 
        
    }//GEN-LAST:event_printInvoiceJButtonActionPerformed
/**
 * Print the invoice
 * @param evt printInvoiceJButton is fired by clicking this menu item
 * @see PrintUtilities.java
 */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // Print the invoice
        //PrintUtilities.printComponent(this);
        printInvoiceJButton.doClick();
    }//GEN-LAST:event_printJMenuItemActionPerformed
/**
 * save the invoice into a file
 * @param evt chosen from the menu. saveJButton gets fired.
 */
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        // Save the invoice into a text file
        saveJButton.doClick();
    }//GEN-LAST:event_saveJMenuItemActionPerformed
/**
 * exit out of the application
 * @param evt quitJButton is clicked
 */
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        // Exit out of the application
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed
/**
 * exit out of the application
 * @param evt exit menu item is chosen
 */
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        // Exit out of the application
        quitJButton.doClick();
    }//GEN-LAST:event_quitJMenuItemActionPerformed
/**
 * clears all text fields
 * @param evt clearJButton is clicked
 */
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
// clear all inputs/outputs in the text fields
        presentJFormattedTextField.setText("");
        previousJFormattedTextField.setText("");
        totalUnitsJFormattedTextField.setText("");
        accountNumberJFormattedTextField.setText("");
        nameJFormattedTextField.setText("");
        addressJFormattedTextField.setText("");
        cityJFormattedTextField.setText("");
        zipJFormattedTextField.setText("");
        stateJFormattedTextField.setText("");
        invoiceJTextArea.setText("");
        // Refocus the cursur to the customer name JComboBox
        presentJFormattedTextField.requestFocus();        
    }//GEN-LAST:event_clearJButtonActionPerformed
/**
 * clears all text fields
 * @param evt clear menu item is chosen
 */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // TODO add your handling code here:
        clearJButton.doClick();
    }//GEN-LAST:event_clearJMenuItemActionPerformed
/**
 * prints the entire GUI form, including the invoice
 * @param evt print form menu item is chosen
 * @see PrintUtilities.java
 */
    private void printFormJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printFormJMenuItemActionPerformed
        // Print the GUI form
        PrintUtilities.printComponent(this);       
    }//GEN-LAST:event_printFormJMenuItemActionPerformed
/**
 * shows the about page
 * @param evt about menu item under the help menu is selected
 */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // Create an About form and show it.
        About myAbout = new About(this, true);
        myAbout.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void presentJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentJFormattedTextFieldActionPerformed
        // When the focus is lost, call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_presentJFormattedTextFieldActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void previousJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousJFormattedTextFieldActionPerformed
        // When the focus is lost,  call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_previousJFormattedTextFieldActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void accountNumberJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberJFormattedTextFieldActionPerformed
        // When the focus is lost, call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_accountNumberJFormattedTextFieldActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void nameJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJFormattedTextFieldActionPerformed
        // When the focus is lost, call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_nameJFormattedTextFieldActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void addressJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressJFormattedTextFieldActionPerformed
        // When the focus is lost, call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_addressJFormattedTextFieldActionPerformed
/**
 * focus had been lost in this text field. 
 * I had to add this line in each input field. 
 * @param evt enter key is fired
 */
    private void cityJFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityJFormattedTextFieldActionPerformed
        // When the focus is lost, call the displayBill Jbutton handler 
        displayBillJButton.doClick();
    }//GEN-LAST:event_cityJFormattedTextFieldActionPerformed
/**
 * displays the information from the JComboBox on the appropriate data field 
 * in the GUI
 * @param evt combo box item (customer information) is selected
 * @see Customer.java
 */
    private void customerNameJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameJComboBoxActionPerformed

            Customer myCustomer = new Customer(customerNameJComboBox.getSelectedItem().toString());
            nameJFormattedTextField.setText(myCustomer.displayName().toString());
            addressJFormattedTextField.setText(myCustomer.displayAddress().toString());
            cityJFormattedTextField.setText(myCustomer.displayCity().toString());
            stateJFormattedTextField.setText(myCustomer.displayState().toString());
            zipJFormattedTextField.setText(myCustomer.displayZip().toString());
    }//GEN-LAST:event_customerNameJComboBoxActionPerformed

    /**
     * The main class for running the PSEInvoice program. It forms the GUI 
     * and make it visible.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DriverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriverGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator JSeparator;
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JFormattedTextField accountNumberJFormattedTextField;
    private javax.swing.JLabel accountNumberJLabel;
    private javax.swing.JFormattedTextField addressJFormattedTextField;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JFormattedTextField cityJFormattedTextField;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JScrollPane companyInfoJScrollPane;
    private javax.swing.JTextArea companyInfoJTextArea;
    private javax.swing.JPanel control1JPanel;
    private javax.swing.JPanel control2JPanel;
    private javax.swing.JPanel customerInfoJPanel;
    private javax.swing.JComboBox<String> customerNameJComboBox;
    private javax.swing.JLabel customerNameJLabel;
    private javax.swing.JPanel customerNameJPanel;
    private javax.swing.JButton displayBillJButton;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JFormattedTextField invoiceDateJFormattedTextField;
    private javax.swing.JLabel invoiceDateJLabel;
    private javax.swing.JScrollPane invoiceJScrollPane;
    private javax.swing.JTextArea invoiceJTextArea;
    private javax.swing.JMenuBar menuJMenuBar;
    private javax.swing.JLabel meterReadingsJLabel;
    private javax.swing.JPanel meterReadingsJPanel;
    private javax.swing.JFormattedTextField nameJFormattedTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JLabel pic1JLabel;
    private javax.swing.JLabel pic2JLabel;
    private javax.swing.JFormattedTextField presentJFormattedTextField;
    private javax.swing.JLabel presentJLabel;
    private javax.swing.JFormattedTextField previousJFormattedTextField;
    private javax.swing.JLabel previousJLabel;
    private javax.swing.JMenuItem printFormJMenuItem;
    private javax.swing.JButton printInvoiceJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JPanel rightMostJPanel;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JFormattedTextField stateJFormattedTextField;
    private javax.swing.JLabel stateJLabel;
    private javax.swing.JLabel thanksJLabel;
    private javax.swing.JFormattedTextField totalUnitsJFormattedTextField;
    private javax.swing.JLabel totalUnitsJLabel;
    private javax.swing.JFormattedTextField zipJFormattedTextField;
    private javax.swing.JLabel zipJLabel;
    // End of variables declaration//GEN-END:variables

}
