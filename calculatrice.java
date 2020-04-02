package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
public class a extends JFrame implements ActionListener{
	static int val(char c) 
	{ 
	    if (c >= '0' && c <= '9') 
	        return (int)c - '0'; 
	    else
	        return (int)c - 'A' + 10; 
	} 
	static int toDeci(String str,int base) 
	{ 
	    int len = str.length(); 
	    int power = 1; 
	    int num = 0;
	    int i; 
	    for (i = len - 1; i >= 0; i--) 
	    { 
	        if (val(str.charAt(i)) >= base) 
	        { 
	        System.out.println("Invalid Number"); 
	        return -1; 
	        } 
	  
	        num += val(str.charAt(i)) * power; 
	        power = power * base; 
	    } 
	    return num; 
	}
	
	static char reVal(int num) 
	{ 
	    if (num >= 0 && num <= 9) 
	        return (char)(num + 48); 
	    else
	        return (char)(num - 10 + 65); 
	} 
	
	static String fromDeci(int base1, int inputNum) 
	{ 
	    String s = ""; 
	    while (inputNum > 0) 
	    { 
	        s += reVal(inputNum % base1); 
	        inputNum /= base1; 
	    } 
	    StringBuilder ix = new StringBuilder();  
	        ix.append(s);  
	    return new String(ix.reverse()); 
	}
    boolean DEC = true;
    boolean BIN = false;
    boolean HEX = false;
    boolean OCT = false;

    String Cu = "10";
    String Pr = "10";
    
    private JPanel contentPane;
    private JMenu jMenuFile, jMenuHelp;
    private JPanel jMaster, jplBackSpace, jplControl;
    private JLabel jLabelOuput;
    private JLabel jBase;
    private JButton JbnButtons[];
    private JButton JrnButtons[];
    private boolean firstInput = true;
    private String numStr1 = "0";
    private String numStr2 = "0";
    Font f12 = new Font("Times New Roman", 0, 12);
    Font f121 = new Font("Times New Roman", 1, 12);
    private String op;
 
 
 
   
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    a frame = new a();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * Create the frame.
     */
    public a() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 571, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
       
        // MEnu File
        contentPane.setBackground(Color.LIGHT_GRAY);
        
        jMenuFile = new JMenu("File");
 
        // MEnu Help
        jMenuHelp = new JMenu("Help");
 
        // Menu Bar
        JMenuBar mb = new JMenuBar();
        mb.add(jMenuFile);
        mb.add(jMenuHelp);
        setJMenuBar(mb);
 
        // frame component
        jMaster = new JPanel();        
          jLabelOuput = new JLabel("0");
          jBase       = new JLabel("");
          jBase.setForeground(Color.red);
          jBase.setFont(f12);
//		  add our component to frame
        
        getContentPane().add(jLabelOuput, BorderLayout.NORTH);
        getContentPane().add(jBase, BorderLayout.CENTER);
       
        JbnButtons = new JButton[29];
        JrnButtons = new JButton[4];
        
        JrnButtons[0] = new JButton("LA base 2");    
        JrnButtons[1] = new JButton("To Base 8");
        JrnButtons[2] = new JButton("To Base 10");    
        JrnButtons[3] = new JButton("LA base 16");
        
        for(int i = 0; i < JrnButtons.length; i++) {
        	JrnButtons[i].setForeground(Color.yellow);
        	JrnButtons[i].setBackground(Color.red);
        	JrnButtons[1].setVisible(false);
        	JrnButtons[2].setVisible(false);
        }
        
        for(int i = 0; i<= 9; i++) {
            JbnButtons[i] = new JButton(String.valueOf(i));
        }
       
       
     // Create operator Jbuttons
            JbnButtons[10] = new JButton("+/-");
            JbnButtons[11] = new JButton(".");
            JbnButtons[12] = new JButton("=");
            JbnButtons[13] = new JButton("/");
            JbnButtons[14] = new JButton("*");
            JbnButtons[15] = new JButton("-");
            JbnButtons[16] = new JButton("+");
            JbnButtons[17] = new JButton("sqrt");
            JbnButtons[18] = new JButton("1/x");
            JbnButtons[19] = new JButton("%");
            jplBackSpace = new JPanel();
            jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));
            JbnButtons[20] = new JButton("Backspace");
            jplBackSpace.add(JbnButtons[20]);
            jplControl = new JPanel();
            jplControl.setLayout(new GridLayout(1, 2, 2, 2));
            JbnButtons[21] = new JButton(" CE ");
            JbnButtons[22] = new JButton("C");
            
            JbnButtons[23] = new JButton("A");
            JbnButtons[24] = new JButton("B");
            JbnButtons[25] = new JButton("C");
            JbnButtons[26] = new JButton("D");
            JbnButtons[27] = new JButton("E");
            JbnButtons[28] = new JButton("F");
            
            jplControl.add(JbnButtons[21]);
            jplControl.add(JbnButtons[22]);
            //      Setting all Numbered JButton's to Blue. The rest to Red
            for (int i = 0; i < JbnButtons.length; i++) {
                JbnButtons[i].setFont(f12);
                if (i < 10) {
                    JbnButtons[i].setForeground(Color.yellow);
                	JbnButtons[i].setBackground(Color.red);}
                else {
                    JbnButtons[i].setForeground(Color.yellow);
                    JbnButtons[i].setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                	JbnButtons[i].setBackground(Color.red);}
                }
       
        JPanel jPLButtons = new JPanel();
        jPLButtons.setLayout(new GridLayout(6, 5));
       
        // add button to the jPLButtons
        	jPLButtons.add(JbnButtons[13]);
        for(int i = 7; i<=9; i++) {
            jPLButtons.add(JbnButtons[i]);
        }
       
       
     // add button / and sqrt
            jPLButtons.add(JbnButtons[17]);
            // Second row
            jPLButtons.add(JbnButtons[14]);
            for (int i = 4; i <= 6; i++) {
                jPLButtons.add(JbnButtons[i]);
            }
            // add button * and x^2
            jPLButtons.add(JbnButtons[18]);
            // Third row
            jPLButtons.add(JbnButtons[15]);
            for (int i = 1; i <= 3; i++) {
                jPLButtons.add(JbnButtons[i]);
            }
            //adds button - and %
            jPLButtons.add(JbnButtons[19]);
            //Fourth Row
            // add 0, +/-, ., +, and =
            jPLButtons.add(JbnButtons[10]);
            jPLButtons.add(JbnButtons[11]);
            jPLButtons.add(JbnButtons[0]);
            jPLButtons.add(JbnButtons[16]);
            jPLButtons.add(JbnButtons[12]);
            jPLButtons.add(JbnButtons[23]);
            jPLButtons.add(JbnButtons[24]);
            jPLButtons.add(JbnButtons[25]);
            jPLButtons.add(JbnButtons[26]);
            jPLButtons.add(JbnButtons[27]);
            jPLButtons.add(JbnButtons[28]);
            
            JPanel jRDButton = new JPanel();
            jRDButton.setLayout(new GridLayout(1, 4));
           
            jRDButton.add(JrnButtons[0]);
            jRDButton.add(JrnButtons[1]);
            jRDButton.add(JrnButtons[2]);
            jRDButton.add(JrnButtons[3]);
         
 
            JbnButtons[23].setVisible(false);
            JbnButtons[24].setVisible(false);
            JbnButtons[25].setVisible(false);
            JbnButtons[26].setVisible(false);
            JbnButtons[27].setVisible(false);
            JbnButtons[28].setVisible(false);
            
        // JPANEL MASET
        jMaster.setLayout(new BorderLayout());
        jMaster.add(jPLButtons, BorderLayout.PAGE_END);
        jMaster.add(jRDButton, BorderLayout.NORTH);
        jMaster.add(jplBackSpace, BorderLayout.WEST);
        jMaster.add(jplControl, BorderLayout.EAST);
       
       
       
        // add component to frame
        getContentPane().add(jMaster, BorderLayout.SOUTH);
        requestFocus();
       
        //add listener to button
        for(int i = 0; i< JbnButtons.length; i++) {
            JbnButtons[i].addActionListener(this);
        }
        for(int i = 0; i< JrnButtons.length; i++) {
        	JrnButtons[i].addActionListener(this);
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String resultStr="0";                                  
        String str = String.valueOf(e.getActionCommand());  
        System.out.println(str);    
        
        if(str == "To Base 2")  {Pr = Cu ; Cu = "2";jBase.setText("Base 2");}
       
        if(str == "To Base 16") {Pr = Cu ; Cu = "16";jBase.setText("Base 16");}
        
        if(Cu == "16") {
        JbnButtons[23].setVisible(true);
        JbnButtons[24].setVisible(true);
        JbnButtons[25].setVisible(true);
        JbnButtons[26].setVisible(true);
        JbnButtons[27].setVisible(true);
        JbnButtons[28].setVisible(true);        
        }else {
            JbnButtons[23].setVisible(false);
            JbnButtons[24].setVisible(false);
            JbnButtons[25].setVisible(false);
            JbnButtons[26].setVisible(false);
            JbnButtons[27].setVisible(false);
            JbnButtons[28].setVisible(false);
        }
        
        System.out.println(Cu+" "+" "+Pr);
        
        switch(str)          
        {
        
        case "To Base 16" : 
        
        case "To Base 2"  :
        	if (Cu == Pr) {}else {
        		if (Cu == "10") {
        			numStr1=String.valueOf(toDeci(String.valueOf(numStr1), Integer.valueOf(Pr)));
                    jLabelOuput.setText(numStr1);
                    firstInput = true;
                    break;}
        		if (Pr == "10") {
        			numStr1=String.valueOf(fromDeci(Integer.valueOf(Cu),(Integer.valueOf(numStr1))));
                    jLabelOuput.setText(numStr1);
                    firstInput = true;
                    break;
        		}else {
        			numStr1=String.valueOf(toDeci(String.valueOf(numStr1), Integer.valueOf(Pr)));
        			numStr1=String.valueOf(fromDeci(Integer.valueOf(Cu),(Integer.valueOf(numStr1))));
        			jLabelOuput.setText(numStr1);
                    firstInput = true;
                    break;
        		}
        	}
        	
        	
        	break;
        case "0":
        case "A":
        case "B":
        case "C":
        case "1":
        case "D":
        case "E":
        case "F":
        case "2":                      
        case "3": 
        case "4": 
        case "5":
        case "6": 
        case "7": 
        case "8":
        case "9": 
        	
        			if(firstInput)
                  {
                     numStr1 = numStr1 + str;
                     jLabelOuput.setText(numStr1);
                  }
                  else
                  {
                      numStr2 = numStr2 + str;
                      jLabelOuput.setText(numStr2);
                  }
                  break;
        case "+":
        case "-":
        case "*":
        case "%":
        case "/": op = str;
                  firstInput = false;
                  break;
        case "=":
                if (numStr1 != null && numStr2 != null && op != null) {
                  resultStr = String.valueOf(evaluate());
                  jLabelOuput.setText(resultStr);
                  numStr1 = resultStr;
                  numStr2 = "";
                  firstInput = true;
                }
                else {
                 resultStr = numStr1;
                }
                break;
        case "CLEAR": jLabelOuput.setText("");
                  numStr1 = "0";
                  numStr2 = "0";
                  firstInput = true;
                  Pr = "10";Cu ="10";
                  break;
        case "1/x":
                  op = str;
                  numStr2 = "0";
                  firstInput = true;
                  break;
        case "+/-":
                  numStr1=String.valueOf(-Double.parseDouble(numStr1));
                  jLabelOuput.setText(numStr1);
                  firstInput = true;
                  break;
        case "sqrt":
                  numStr1=String.valueOf(Math.sqrt(Double.parseDouble(numStr1)));
                  jLabelOuput.setText(numStr1);
                  firstInput = true;
                  break;
        case ".":
                  numStr1=numStr1.concat(".");
                  jLabelOuput.setText(numStr1);
                  break;
        	}
        }
    private double evaluate() {
        double resultat=0;
        double x = Double.parseDouble(numStr1);
        double y = Double.parseDouble(numStr2);
       
        switch(op)                                          
        {
        case "+":   resultat = x + y; break;
        case "-":   resultat = x - y; break;
        case "*":   resultat = x * y; break;
        case "/":   resultat = x / y; break;
        case "%":   resultat = x % y; break;
        case "1/x": resultat = 1 / x; break;
        }
       
        return resultat;
    }
}
