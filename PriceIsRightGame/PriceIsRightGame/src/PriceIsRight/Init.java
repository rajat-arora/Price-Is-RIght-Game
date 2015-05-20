package PriceIsRight;


import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.0
 * Description: This main is used to start up the game a draw a Jpanel to a screen that
 * will have componets added to it.
 */
public class Init extends JPanel {

    /**
     * This code creates a new 600 * 400 JFrame window at location 100 * 100 on
     * the screen This JFrame is attached to the class MainGui where the buttons
     * and main code is located
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Price is Right Dice Game");
        MainGui content = new MainGui();
        window.setContentPane(content);
        window.setSize(600, 400);
        window.setResizable(false);
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
