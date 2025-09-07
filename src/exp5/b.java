package exp5;
import java.awt.*;
import java.awt.event.*;
class SimpleCalc implements ActionListener{
    Frame f1 = new Frame();

    Label l1 = new Label("First Number");
    Label l2 = new Label("Second Number");
    Label l3 = new Label("Result");

    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();

    Button b1 = new Button("Add+");
    Button b2 = new Button("Sub-");
    Button b3 = new Button("Mul*");
    Button b4 = new Button("Div/");
    Button b5 = new Button("Cancel");

    SimpleCalc(){
        l1.setBounds(40,100,100,20);
        l2.setBounds(40,140,100,20);
        l3.setBounds(40,180,100,20);

        t1.setBounds(160,100,100,20);
        t2.setBounds(160,140,100,20);
        t3.setBounds(160,180,100,20);

        b1.setBounds(50,250,45,25);
        b2.setBounds(110,250,45,25);
        b3.setBounds(170,250,45,25);
        b4.setBounds(230,250,45,25);
        b5.setBounds(290,250,45,25);

        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(400,350);
    }
    public void actionPerformed(ActionEvent e){
        try {
            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());

            if(e.getSource()==b1){
                t3.setText(String.valueOf(n1+n2));
            }
            else if(e.getSource()==b2){
                t3.setText(String.valueOf(n1-n2));
            }
            else if(e.getSource()==b3){
                t3.setText(String.valueOf(n1*n2));
            }
            else if(e.getSource()==b4){
                if(n2!=0){
                    t3.setText(String.valueOf(n1/n2));
                }
                else{
                    t3.setText("Divide by 0");
                }
            }
            else if(e.getSource()==b5){
                System.exit(0);
            }
        }
        catch (NumberFormatException ex){
            t3.setText("Invalid Input");
        }
    }
}
public class b {
    public static void main(String[] args){
        new SimpleCalc();
    }
}
