import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

//Leyla Gasimova
//Calculator is the class which implement swing to build GUI for the calculator
//t is for textfield where the xpression entered by the user and the calculated result will appear
//there are buttons for numbers, operands, delete, clear and turning off the server
//object NumbersAndOperand is used to collect the final expression entered by the user to be accessed by the client
class Calculator implements ActionListener {
    JFrame frame;
    JTextField t;
    JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0, divide,
            multiply, subtract, add, equals, delete, clear, turnoff, popup;
    int num1, num2, operand, ifEquals = 0;
    double result = 0;
    String expression = "", operandstr = "", password = "";
    String[] NaOstr;
    NumbersAndOperand NaO = new NumbersAndOperand(0, 0, 0);

    // this public method is written for the Client class to be able to access the
    // equation to later send it to the server
    public NumbersAndOperand getNumbersAndOperand() {
        return this.NaO;
    }

    // update text is the method to update the content of the textfield and it is
    // private so only methods in calculator will be responsible for the contents
    private void updateText(String text) {
        this.t.setText(text);
    }

    // this public method is written for the Client to be able to update the result
    // of the calculation, which is sent from the server
    // in this method we check if the result is negative because negative numbers
    // from server stand for error codes
    // -1 stands for the division by zero exception
    // -2 stands for the negative result exception
    // -3 stands for the server not being able to calculate the result if we send
    // back the wrong operand in NumbersAndOperands object
    // in case there is no problem the result will be set and will appear on the
    // textfield for the user to see the final answer
    public void setResult(double result) {
        this.result = result;

        if (result == -1) {
            showMessageDialog(null, "You tried to divide by zero,\nserver threw an exception!");
        } else if (result == -2) {
            showMessageDialog(null, "The result is negative,\nserver threw an exception!");

        } else if (result == -3) {
            showMessageDialog(null, "The problem with the operand \nserver threw an exception!");

        } else {
            updateText(String.valueOf(result));
        }

        if (result < 0) {
            this.expression = "";
            this.operandstr = "";
            updateText(expression);
            setResult(0);
            setEquals(0);
        }
    };

    // this method is used when user clicks on the "X" button to turn off the server
    // and is asked to enter the password, which thanks to this method will be saved
    // in the password variable
    private void setPassword(String pass) {
        this.password = pass;
    }

    // this method is used for the Client class to access the entered password and
    // check if the password is right or no
    public String getPassword() {
        return this.password;
    }

    // ifEquals is an integer which is responsible in this code for defining is user
    // has clicked the "equals" button or no
    private void setEquals(int equals) {
        this.ifEquals = equals;
    }

    // if the user has clicked it, it means that the expression has been entered and
    // is waiting to be calculated, the Client code checks for the "ifEquals" value
    // using this method, and when it is 1, it accesses Calculator's
    // NumberAndOperand object and send the values of it to the server
    public int getEquals() {
        return this.ifEquals;
    }

    Calculator() {
        // initializing frame
        frame = new JFrame("Calculator");
        frame.getContentPane().setBackground(new java.awt.Color(184, 196, 228));

        // initializing buttons and textfield
        t = new JTextField();
        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        button_0 = new JButton("0");
        divide = new JButton("/");
        multiply = new JButton("*");
        subtract = new JButton("-");
        add = new JButton("+");
        equals = new JButton("=");
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        turnoff = new JButton("X");

        turnoff.setBackground(new java.awt.Color(238, 212, 229));

        // defining the position of each element
        delete.setBounds(50, 50, 100, 40);
        clear.setBounds(180, 50, 100, 40);
        t.setBounds(300, 50, 150, 40);

        button_7.setBounds(50, 120, 80, 50);
        button_8.setBounds(158, 120, 80, 50);
        button_9.setBounds(266, 120, 80, 50);
        divide.setBounds(371, 120, 80, 50);

        button_4.setBounds(50, 190, 80, 50);
        button_5.setBounds(158, 190, 80, 50);
        button_6.setBounds(266, 190, 80, 50);
        multiply.setBounds(371, 190, 80, 50);

        button_1.setBounds(50, 260, 80, 50);
        button_2.setBounds(158, 260, 80, 50);
        button_3.setBounds(266, 260, 80, 50);
        subtract.setBounds(371, 260, 80, 50);

        turnoff.setBounds(50, 330, 80, 50);
        button_0.setBounds(158, 330, 80, 50);
        equals.setBounds(266, 330, 80, 50);
        add.setBounds(371, 330, 80, 50);

        // making it impossible for the user to edit the textfield directly
        t.setEditable(false);

        frame.add(t);
        frame.add(button_7);
        frame.add(button_8);
        frame.add(button_9);
        frame.add(divide);
        frame.add(button_4);
        frame.add(button_5);
        frame.add(button_6);
        frame.add(multiply);
        frame.add(button_1);
        frame.add(button_2);
        frame.add(button_3);
        frame.add(subtract);
        frame.add(button_0);
        frame.add(equals);
        frame.add(add);
        frame.add(delete);
        frame.add(clear);
        frame.add(turnoff);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        // adding action listeners for each button and overriding them when needed
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_6.addActionListener(this);
        button_7.addActionListener(this);
        button_8.addActionListener(this);
        button_9.addActionListener(this);
        button_0.addActionListener(this);
        add.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        subtract.addActionListener(this);
        equals.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);

        // when turn off button is clicked the popup window appears and asks user for
        // the password, user enters the password and the "pass" variable saves it
        // then the variable passwros is set to pass, and the Client may access the
        // password and check it if it right or wrong, if it is right the server is
        // turned off, if it is wrong nothing happens
        turnoff.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String pass = JOptionPane.showInputDialog(frame, "Enter password", "");
                if (pass != null)
                    setPassword(pass);
            }

        });
    }

    // in this method we check which buttons have been clicked and run the code for
    // each case
    public void actionPerformed(ActionEvent e) {

        // by this if statement we make sure that the user will not enter the expression
        // like "*78+-=14", we check that if the expression is empty or that is the
        // operand has been clicked already, then the user is not able to click on the
        // operands again until deleting them or clearing the whole expression
        if ((e.getSource() == add || e.getSource() == subtract || e.getSource() == divide || e.getSource() == multiply)
                && (expression == "" || operandstr != "")) {
            showMessageDialog(null,
                    "Please make sure that you enter a number first not the operand,\n and make sure that your number is positive as we in this calculator don't work with negativity :) \n and overall please make sure that the expression you are trying to enter is correct and have a good day :)");

        }

        // when numeric buttons are clicked their value is simply added to the
        // expression in form of string
        else if (e.getSource() == button_0) {
            expression += "0";
        } else if (e.getSource() == button_1) {
            expression += "1";
        } else if (e.getSource() == button_2) {
            expression += "2";
        } else if (e.getSource() == button_3) {
            expression += "3";
        } else if (e.getSource() == button_4) {
            expression += "4";
        } else if (e.getSource() == button_5) {
            expression += "5";
        } else if (e.getSource() == button_6) {
            expression += "6";
        } else if (e.getSource() == button_7) {
            expression += "7";
        } else if (e.getSource() == button_8) {
            expression += "8";
        } else if (e.getSource() == button_9) {
            expression += "9";
        }

        // when the operands are clicked they are added to the expression
        // each operand has a corresponding integer number on the server, and those are
        // assigned to the operand integer
        // in order to remember in shape of string which operand has been clicked we
        // also assign it to the operandstr variable
        else if (e.getSource() == add) {
            operand = 1;
            expression += "+";
            operandstr = "\\+";
        }

        else if (e.getSource() == subtract) {
            operand = 2;
            expression += "-";
            operandstr = "\\-";
        }

        else if (e.getSource() == divide) {
            operand = 3;
            expression += "/";
            operandstr = "\\/";
        }

        else if (e.getSource() == multiply) {
            operand = 4;
            expression += "*";
            operandstr = "\\*";
        }
        // when equals is clicked and the expression is not empty and operand has been
        // clicked as well we know that we have a nice expressiom
        // and once we have expression we need to send it to the server, but first we
        // get our number1 and number2 from the expressoin by parsing it into 2 strings
        // by oprandstr
        // once we have everythin we assign the values to our NumbersAndOperand object
        // and let know the client by setting ifEquals to 1, that the expression is
        // ready and can be sent to the server
        else if (e.getSource() == equals && expression != "" && operand != 0) {
            NaOstr = expression.split(operandstr);
            num1 = Integer.parseInt(NaOstr[0]);
            num2 = Integer.parseInt(NaOstr[1]);
            NaO.setNum1(num1);
            NaO.setNum2(num2);
            NaO.setOperand(operand);
            setEquals(1);
        }
        // when delete is clicked we remember first the last character in the expression
        // string, and later on we compare those characters to the operands, if the
        // deleted character was the operand we set operand to 0 and operandstr to an
        // empty string to allow use to choose another operand
        else if (e.getSource() == delete && expression != "") {
            String last = expression.substring(expression.length() - 1);
            if (last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*")) {
                operandstr = "";
                operand = 0;
            }

            expression = expression.substring(0, expression.length() - 1);
        }
        /// when clear is clicked basically everything is reset and ready for the new
        /// expression to be entered
        else if (e.getSource() == clear && expression != "") {
            expression = "";
            setResult(0);
            NaO.setOperand(0);
            updateText("");
            operandstr = "";
            operand = 0;
            setEquals(0);

        }
        // after each click the modified version of the expression appears on the
        // textfield
        updateText(expression);

    }

}
