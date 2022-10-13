/*Programmer:   Carl Finch
 * Date:        01/19/05
 * IDE Used:    Blue J 04 
 * Purpose:     To write a program to convert pesos to american currency, an vise versa.
 *              Also explore with the certain math methods learned in chapter 3
 *              Also to make another applet, and learning a little more about the java swing class library         
 */


import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;




public class Currency extends JApplet implements ActionListener  
{
       
       


        //Create the UI of the applet.  America, Euro, and Mexico labels, and inputs, and one convert button.
        JTextField txtAmerica = new JTextField(10);
        JTextField txtMexico = new JTextField(10);
        JTextField txtEuro = new JTextField(10);
        JLabel lblTitle = new JLabel("Currency Converter beta V1.0");
        JLabel lblAmerica = new JLabel("American Currency");
        JLabel lblMexico = new JLabel ("   Mexican Pesos   ");
        JButton btnConvert = new JButton ("Convert Currency");
        JButton btnClear = new JButton ("Clear all fields");
        JLabel lblIdiotUser = new JLabel("Enter an amount in one of the fields.");
        JLabel lblIdiotUser2 = new JLabel("Press the 'Convert Currency' it will");
        JLabel lblIdiotUser3 = new JLabel("then convert the currency, to the other");
        JLabel lblIdiotUser4 = new JLabel("country.  To erase your amount, and all other fields");
        JLabel lblEuro = new JLabel("     Euro Amount    ");
        JLabel lblIdiotUser5 = new JLabel("Click 'Clear all fields' to clear all fields");
        Image  logo;

       
    
    public void init()
    {
        //Add program of title to display on the App.
        JPanel Title = new JPanel();
        Title.add(lblTitle);
        Title.setBackground(Color.black);
        lblTitle.setForeground(Color.red);
        

        //Add the row that will have the american label,and text field input
        JPanel American = new JPanel();
        American.add(lblAmerica);
        American.add(txtAmerica);
        American.setBackground(Color.black);
        lblAmerica.setForeground(Color.blue);
        
        //Add the row that will have the mexico label, and text field input.
        JPanel Mexican = new JPanel();
        Mexican.add(lblMexico);
        Mexican.add(txtMexico);
        Mexican.setBackground(Color.black);
        lblMexico.setForeground(Color.blue);
        
        //Add a row for the one convert button.
        JPanel Button = new JPanel();
        Button.add(btnConvert);
        btnConvert.addActionListener(this);
        Button.add(btnClear);
        Button.setBackground(Color.black);
        btnClear.setBackground(Color.white);
        btnConvert.setBackground(Color.black);
        btnConvert.setBackground(Color.black);
        btnConvert.setForeground(Color.red);
        btnClear.setForeground(Color.red);
        //btnClear.addActionListener(clearFields);
        
        //Add the Euro label, and text field input
        JPanel Euro = new JPanel();
        Euro.add(lblEuro);
        Euro.add(txtEuro);
        Euro.setBackground(Color.black);
        lblEuro.setForeground(Color.blue);
        
        //Add the row for the idiot user as a set of instructions on what to do
        JPanel Idiot = new JPanel();
        Idiot.add(lblIdiotUser);
        Idiot.setBackground(Color.black);
        
        JPanel Idiot2 = new JPanel();
        Idiot2.add(lblIdiotUser2);
        Idiot2.setBackground(Color.black);
        
        JPanel Idiot3 = new JPanel();
        Idiot3.add(lblIdiotUser3);
        Idiot3.setBackground(Color.black);
        
        JPanel Idiot4 = new JPanel();
        Idiot4.add(lblIdiotUser4);
        Idiot4.setBackground(Color.black);
        
        JPanel Idiot5 = new JPanel();
        Idiot5.add(lblIdiotUser5);
       Idiot5.setBackground(Color.black);
        
        
        
        
        
        //Create the container for the swing components to be layed out by default with FlowLayout()
        Container Currency = getContentPane();
        Currency.setLayout(new FlowLayout());
        
        Currency.add(Title);      
        Currency.add(American); 
        Currency.add(Mexican);
        Currency.add(Euro);
        Currency.add(Button);
        Currency.add(Idiot);
        Currency.add(Idiot2);
        Currency.add(Idiot3);
        Currency.add(Idiot4);
        Currency.add(Idiot5);
        Currency.setBackground(Color.black);

        //Set the Content Pane visible
        setVisible(true);
        setContentPane(Currency);
        
        
       
    }
    
    
    /*You will see some error traffic, one if they have nothing in any field, and they try to convert.
     * Again if the try to convert a negative amount in any field.
     */
    
   //Adding the Action Event for the applet.
    public void actionPerformed(ActionEvent ae)
    {

        if(txtAmerica.getText().equals("") && txtMexico.getText().equals("") && txtEuro.getText().equals(""))
        {
           //Create an "ERROR" method, use it for each object on the applet.
            Error();
        }
        //If they enter something in only the mexico box lets solve for the other two.
        if(txtAmerica.getText().equals("") && txtEuro.getText().equals(""))
        {
        try
    {
        //Go to the main mexico method, and solve
       getAndshowPesos();  
       
    }
    catch (ArithmeticException mathE)
    {
     
    }
    }

    //If the Euro input is filled up lets solve for the other two.
     if(txtMexico.getText().equals("") && txtAmerica.getText().equals(""))
    {
        try
        {
            //Main method to convert the Euro in the other two languages
            Euro();
        }
        catch(ArithmeticException mathE)
        {
            
        }
    }
    
    //OK if the american textfield has something in it, lets solve for the other two languages
    if(txtMexico.getText().equals("") && txtEuro.getText().equals(""));
    {
        try
       {
           //Main method to convert the American currency in the other two languages
           getAndshowAmericaCurrency();
        }
        catch(ArithmeticException mathE)
        {
            
        }
        
    }
    
    
    // void clearFields()
    //{
     //txtMexico.setText(""):   
    //}
    

}


    
    //Main method if the mexico field has something in it, and the other two do not.
    public void getAndshowPesos()
    {
        //declaring vars.  EConvert is the conversion on Euro, and AConvert is the American conversion
        double EConvert = 1.3;
        double AConvert = 11.2;
        double Mamount = Double.parseDouble(txtMexico.getText());
        if(Mamount <=-1)
        {
         Impossible();   
        }
        else if (Mamount >=0)
        {
        double ATotal = Mamount / AConvert;
        double ETotal = (Mamount / AConvert) * EConvert;
        //Lets display the answers in the textfields, but first lets round off, our final answer.
       txtAmerica.setText("" + Math.round(ATotal));
       txtMexico.setText("" + Math.round(Mamount));
       txtEuro.setText("" + Math.round(ETotal));
       
       
    }
      
    }
 
    //Funtion method, to convert the American Currency to Pesos, and Euro
    public void getAndshowAmericaCurrency()
    {
        //Declare the vars.  AConverter is from american to mexico, and EConverter is american to euro.
        double AConverter = 11.2;
        double EConverter = 1.3;
        double Aamount = Double.parseDouble(txtAmerica.getText());
        if(Aamount <= -1)
        {
         Impossible();   
        }
        else if (Aamount >= 0)
        {
        double PTotally  = Aamount * AConverter;
        double ETotally =  Aamount * EConverter;
        
        
        //Lets 
        txtAmerica.setText(" " + Math.round(Aamount));
        txtEuro.setText(" " + Math.round(ETotally));
        txtMexico.setText(" " + Math.round(PTotally));
    }


    }
    
    //Lets display the answers in the textfields, but first lets round off, our final answer.
    public void Euro()
    {
        //Construct the vars.  AConverter is the american convert, and the Econverter is the euro converter
        double AConverter = 11.2;
        double EConverter = 1.3;
        double Eamount = Double.parseDouble(txtEuro.getText());
        if(Eamount <= -1)
        {
         Impossible();   
        }
        else if (Eamount >= 0)
        {
        double ATotally  = Eamount / EConverter;
        double PTotally =  (Eamount / EConverter) / AConverter;
        
      //Lets display the answers in the textfields, but first lets round off, our final answer.
        txtAmerica.setText(" " + Math.round(ATotally));
        txtEuro.setText(" " + Math.round(Eamount));
        txtMexico.setText(" " + Math.round(PTotally));
    }
    }
    //Method of error saying it is impossible to convert 3 nothings  (Ha Ha Ha....)
    public void Error()
    {
     
     JOptionPane.showMessageDialog(null, "You have to start out with a value in one of the input boxes for this to be a currency converter.","Error - [westhenderson_javastudent]",JOptionPane.ERROR_MESSAGE);
    }
    
    ////Method of Impossible saying it is impossible in "REAL LIFE" to convert negative currecny to pesos, and vise versa
    public void Impossible()
    {
     JOptionPane.showMessageDialog(null, "Can you convert a negative amount of money?  Not if you owe me.","Error - [westhenderson_javastudent]",JOptionPane.ERROR_MESSAGE);   
    }
  
}