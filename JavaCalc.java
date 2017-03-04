import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
  
class JavaCalc implements ActionListener
{
JFrame f;
JButton b[];
JTextField tf;
double x;
double y;
double ans;
int pizza;
double memory=0.0;
JavaCalc(String s)
{
 f=new JFrame(s);
tf=new JTextField();
tf.setBounds(10,10,350,70);
f.add(tf);
b=new JButton[30];
String s1[]={"MC","MR","MS","M+","M-","<-","CE","C","+-","sqrt","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+","m^2","m^3"};
	int n=0;
	int k=0;
for(int i=0;i<6;i++)
{
	int m=0;
	for(int j=0;j<5;j++)
	{
     b[k]=new JButton(s1[k]);
     b[k].setBounds(10+m,100+n,60,40);
     f.add(b[k]);
	 k++;
     m=m+70;
    }
	n=n+50;
}
for(int i=0;i<b.length;i++)
{b[i].addActionListener(this);}
tf.addActionListener(this);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(400,450);
f.setLayout(null);
f.setVisible(true);
tf.setText("0");
}
public void actionPerformed(ActionEvent e)
{
		if(e.getSource()==b[6] || e.getSource()==b[7])
	    tf.setText("0");
		if(e.getActionCommand()=="1"||e.getActionCommand()=="2"||e.getActionCommand()=="3"||e.getActionCommand()=="4"||e.getActionCommand()=="5"||e.getActionCommand()=="6"||e.getActionCommand()=="7"||e.getActionCommand()=="8"||e.getActionCommand()=="9"||e.getActionCommand()=="0"||e.getActionCommand()==".")
		{
	     String digit = e.getActionCommand(); //gives you a String representing the action commands
	     tf.setText(tf.getText().concat(digit));
	    }
	if (e.getActionCommand() =="+") 
	{		
            x = Double.parseDouble(tf.getText());
            pizza = 1;
            tf.setText("");
	}
	if (e.getActionCommand() =="-") 
	{		
            x = Double.parseDouble(tf.getText());
            pizza = 2;
            tf.setText("");
	}
	if (e.getActionCommand() =="*") 
	{		
            x = Double.parseDouble(tf.getText());
            pizza = 3;
            tf.setText("");
	}
	if (e.getActionCommand() =="/") 
	{		
            x = Double.parseDouble(tf.getText());
            pizza = 4;
            tf.setText("");
	}
	if (e.getActionCommand() =="sqrt") 
	{		
            x = Double.parseDouble(tf.getText());
            ans = Math.pow(x, 0.5);
            tf.setText("" + ans);
	}
	if (e.getActionCommand() == "1/m") 
	{
		    x = Double.parseDouble(tf.getText());
            ans = 1.0 / x;
            tf.setText("" + ans);
	}
	if (e.getActionCommand() == "=") 
	{
            y = Double.parseDouble(tf.getText());
            switch (pizza) 
			{
                case 1: 
				{
                    ans = x + y;
                    break;
                }
                case 2: 
				{
                    ans = x - y;
                    break;
                }
                case 3: 
				{
                    ans = x * y;
                    break;
                }
                case 4: {
                    ans = x / y;
                    break;
                }
                default: 
				{
                    ans =0.00;
                }
            }
            tf.setText("" + ans);
        }
		if (e.getActionCommand() == "m^2") 
		{
            x = Double.parseDouble(tf.getText());
            ans = x * x;
            tf.setText("" + ans);
        }
		if (e.getActionCommand() == "m^3") 
		{
            x = Double.parseDouble(tf.getText());
            ans = x * x * x;
            tf.setText("" + ans);
        }
		if (e.getActionCommand() == "M+") 
		{
            x = Double.parseDouble(tf.getText());
            memory=memory+x;
			tf.setText("");
        }
		if (e.getActionCommand() == "M-") 
		{
            x = Double.parseDouble(tf.getText());
            memory=memory-x;
			tf.setText("");
        }
		if (e.getActionCommand() == "MR") 
		{
            tf.setText("" + memory);
        }
		if (e.getActionCommand() == "MC") 
		{
            memory=0.0;
			tf.setText("0.0");
        }
}    
public static void main(String s[])
{
new JavaCalc("CALCULATOR");
}
}