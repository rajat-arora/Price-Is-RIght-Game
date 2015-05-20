package PriceIsRight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.3
 * Description: This class, will be the main faram gui 
 * will all the main code for the game is located. Such as
 * the buttons and weather on not if the user is a winner or looser.
 */
public class MainGui extends Init implements ActionListener {

    /**
     * This will create an array of 4 Dice utils and will be used to generate
     * random numbers
     */
    protected Dice[] die = new Dice[4];
    /**
     * This will create an array of 4 Dice and will be used to display dice
     */
    protected DiceCavas[] dice = new DiceCavas[4];
    /**
     * This will create an array of 4 above Car Value Panels and will be used to
     * display a car value if the higher button is selected
     */
    protected JLabel[] higher = new JLabel[4];
    /**
     * This will create an array of 4 below Car Value Panels and will be used to
     * display a car value if the lower button is selected
     */
    protected JLabel[] lower = new JLabel[4];
    /**
     * This will create a Panel that will Set the First Car Value given
     */
    protected JLabel defaultValue = new JLabel();
    /**
     * This will create two counters that will be used to determine which turn
     * the game is at and what array index to iterate through
     */
    protected int counter, counter2 = 0;
    /**
     * This will create a Message Box that will be used to display a message
     */
    protected JOptionPane playMessage = new JOptionPane();
    /**
     * This will Create a Car object that will be used to determine a random car
     * to play for and where the car being played for image is
     */
    protected Cars car = new Cars();
    /**
     * This will create the button play and will be used to start the game
     */
    public JButton bttn1 = new JButton("Play");
    /**
     * This will create the button exit and will be used to exit the game
     */
    public JButton bttn6 = new JButton("Exit");
    /**
     * This will create the button higher and will be used to highlight the
     * above box
     */
    public JButton bttn3 = new JButton("Higher");
    /**
     * This will create the button lower and will be used to highlight the lower
     * box
     */
    public JButton bttn4 = new JButton("Lower");
    /**
     * This will create the button lower and will be used to roll the dice
     */
    public JButton bttn2 = new JButton("Roll");
    /**
     * This will create an array of HighLow panels that will be used to
     * determine if the high or low button is selected
     */
    public int[] highLow = new int[4];
    /**
     * This will determine if the user won the game
     */
    public boolean isHigherOrLower = true;
    /**
     * This will create a dimension that will be used to set a JPanels size
     */
    protected Dimension d3 = new Dimension(80, 80);
    /**
     **This will create a dimension that will be used to set a JPanels size
     */
    protected Dimension d4 = new Dimension(40, 40);

    /**
     **This constructor will initialize and display all the elements to make
     * the game such as the buttons and panels
     */
    public MainGui() {
        /**
         **This will create an array of 4 new dice utils
         */
        for (int i = 0; i < 4; i++) {
            die[i] = new Dice();
        }
        /**
         **This will create an array of 4 Dice
         */
        for (int i = 0; i < 4; i++) {
            dice[i] = new DiceCavas(0, 0, 1, 1, Color.WHITE, Color.BLACK);
        }
        /**
         **This will create an array 4 of JLables
         */
        for (int i = 0; i < 4; i++) {
            higher[i] = new JLabel(" ");
            higher[i].setBorder(BorderFactory.createLineBorder(new Color(130, 50, 40), 3));
            lower[i] = new JLabel(" ");
            lower[i].setBorder(BorderFactory.createLineBorder(new Color(130, 50, 40), 3));
        }


        /**
         **This will set the Layout of the Main JPanel to BoxLayout
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /**
         **These will set the Color and Border of the Main JPanel
         */
        this.setBorder(BorderFactory.createLineBorder(new Color(130, 50, 40), 3));
        this.setBackground(Color.CYAN);

        /**
         **Event listeners are added here
         */
        bttn1.addActionListener(this);
        bttn6.addActionListener(this);
        bttn3.addActionListener(this);
        bttn4.addActionListener(this);
        bttn2.addActionListener(this);





        /**
         **Here A new JPanel is created and FlowLayout is added to it
         */
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());

        /**
         **Buttons are added to the new JPanel
         */
        jp2.add(bttn1);
        jp2.add(bttn2);
        jp2.add(bttn3);
        jp2.add(bttn4);
        jp2.add(bttn6);

        /**
         **Here A new JPanel is created and FlowLayout is added to it
         */
        JPanel jp3 = new JPanel();
        jp3.setLayout(new FlowLayout());
        /**
         **Here A new JPanel is created and FlowLayout is added to it
         */
        JPanel jp4 = new JPanel();
        jp4.setLayout(new FlowLayout());

        /**
         **Here A new JPanel is created and FlowLayout is added to it
         */
        JPanel jp5 = new JPanel();
        jp5.setLayout(new FlowLayout());
        /**
         **Here The Main title image is called and the size is set of it
         */
        JLabel label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PriceIsRight/title.jpg")));
        label.setPreferredSize(d3);

        /**
         **Here A new JPanel is created and BorderLayout is added to it. Then
         * the Main title image is added and Size and Color are set
         *
         */
        JPanel jp6 = new JPanel();
        jp6.setLayout(new BorderLayout(2, 2));
        jp6.add(label, BorderLayout.NORTH);
        jp6.setPreferredSize(d4);
        jp6.setSize(d4);
        jp6.setBackground(Color.CYAN);
        add(jp6);

        /**
         **Here the dimensions for the dice to be drawn are set
         */
        Dimension d = new Dimension(38 * dice[1].getSizeFactor(), 62 * dice[1].getSizeFactor());
        Dimension d1 = new Dimension(65 * dice[1].getSizeFactor(), 65 * dice[1].getSizeFactor());



        /**
         **Here the color of the jp3 - jp5 are set and jp3 and jp2's size are
         * set
         */
        jp3.setBackground(Color.CYAN);
        jp4.setBackground(Color.CYAN);
        jp5.setBackground(Color.CYAN);
        jp3.setPreferredSize(d);
        jp2.setPreferredSize(d);

        /**
         **Here the default car Panel Value is created and added to jp3
         */
        defaultValue = new JLabel(" ");
        defaultValue.setBorder(BorderFactory.createLineBorder(new Color(130, 50, 40), 3));
        defaultValue.setPreferredSize(new Dimension(50, 50));
        jp3.add(defaultValue, FlowLayout.LEFT);

        /**
         **Here the preferred sizes for the dice are set and the dice are added
         * to jp2
         */
        for (int i = 0; i < 4; i++) {
            dice[i].setPreferredSize(d1);
            jp3.add(dice[i]);
            higher[i].setPreferredSize(d1);
            lower[i].setPreferredSize(d1);
            jp4.add(higher[i]);
            jp5.add(lower[i]);
        }

        /**
         **jp2-j-5 are added to the main JFrame
         */
        this.add(jp4);
        this.add(jp3);
        this.add(jp5);
        this.add(jp2);
        /**
         **Buttons 2 -4 are disabled here
         */
        bttn2.setEnabled(false);
        bttn3.setEnabled(false);
        bttn4.setEnabled(false);


    }

    /**
     * This Method Listens to the buttons and iterates code if a button is
     * clicked
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            /**
             **The Play button will be listened for. If the play button is
             * clicked A random car will be generated. A cheer sound will be
             * played. A message for what car your playing for will appear. The
             * Default car value will be set and the play button will be
             * disabled and the Roll button will be enabled
             */
            case "Play":
                car.randomCarNumber();
                new Cheer("cheer.wav").start();
                playMessage.showMessageDialog(this, "You are playing for a " + car.getCarName(car.getRandomCarNumber()),
                        "info", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource(car.getImage(car.randomCarNumber))));
                bttn1.setEnabled(false);
                bttn2.setEnabled(true);
                defaultValue.setText(car.CarPrice[0][car.getRandomCarNumber()]);
                
                //Use this to cheat

//                System.out.println(car.CarPrice[1][car.randomCarNumber]);
//                System.out.println(car.CarPrice[2][car.randomCarNumber]);
//                System.out.println(car.CarPrice[3][car.randomCarNumber]);
//                System.out.println(car.CarPrice[4][car.randomCarNumber]);
                break;
            /**
             **The Roll button will be listened for. If the Roll button is
             * clicked A if statement will check if the game is between turn 1
             * to 4 then the dice will be rolled and set and the game will check
             * if you are a automatic winner when the dice is rolled. Also
             * another if statement will check if the turn is greater than 4. If
             * it is the game will check if you won the game or not by going to
             * the method theEnd().
             */
            case "Roll":

                if (0 <= counter & counter <= 3) {
                    die[counter].roll();
                    dice[counter].setValue(die[counter].getValue());
                    repaint();
                    isAutomaticWinner();

                }
                if (counter > 3) {
                    theEnd();
                }
                break;
            /**
             **The Higher button will be listened for. If the Roll button is
             * clicked A if statement will check if the game is between turn 1
             * to 4 then the game will set HighLow at the turn the game is on to
             * 1 so we know the high button is pressed. Then it will pass the
             * value 1 to HighLowDeterminer() so the method can set the high
             * panel to yellow. Also another if statement will check if the turn
             * is greater than 4. If it is the game will check if you won the
             * game or not by going to the method theEnd().
             */
            case "Higher":

                if (0 <= counter & counter <= 3) {
                    highLow[counter] = 1;
                    highLowDeterminer(1);
                    repaint();
                }
                if (counter > 3) {
                    theEnd();
                }


                break;
            /**
             **The lower button will be listened for. If the lower button is
             * clicked A if statement will check if the game is between turn 1
             * to 4 then the game will set HighLow at the turn the game is on to
             * 0 so we know the low button is pressed. Then it will pass the
             * value 0 to HighLowDeterminer() so the method can set the low
             * panel to yellow. Also another if statement will check if the turn
             * is greater than 4. If it is the game will check if you won the
             * game or not by going to the method theEnd().
             */
            case "Lower":

                if (0 <= counter & counter <= 3) {
                    highLow[counter] = 0;
                    highLowDeterminer(0);
                    repaint();
                }
                if (counter > 3) {
                    theEnd();
                }
                break;
            /**
             **The Exit button will be listened for. If the Exit Button is
             * Clicked The Game will End
             */
            case "Exit":
                System.exit(-1);
                break;

        }
    }

    /**
     * This Method will Check if the user is a automatic winner.
     */
    public void isAutomaticWinner() {
        /**
         * This will first check if the dice value rolled at the turn the user
         * is on is either 1 or 6. If it is then the High and low buttons will
         * be disabled and the if statement will move to the nested if statement
         */
        if (dice[counter].getValue() == 1 || dice[counter].getValue() == 6) {
            bttn3.setEnabled(false);
            bttn4.setEnabled(false);
            /**
             * This statement will first check if the value of the dice rolled
             * will equal the value of the car. If this is true, a message will
             * appear and counter will go up by one.
             */
            if (Integer.toString(die[counter].getValue()).equals(car.CarPrice[counter + 1][car.randomCarNumber])) {
                JOptionPane.showMessageDialog(this, "You rolled an " + die[counter].getValue() + " and the car value for this section is "
                        + car.CarPrice[counter + 1][car.randomCarNumber] + " so you dont have to guess if its higher or lower");
                counter++;
                /**
                 * If the above statement is false, This statement will check if
                 * the value of the dice rolled is greater than the value of the
                 * car. If this is true, a message will appear, the higher box
                 * will be highlighted, and highLow at the turn the user is on
                 * will equal one so we know that the higher panel is selected.
                 * As well counter will go up by one.
                 */
            } else if (die[counter].getValue() < Integer.parseInt(car.CarPrice[counter + 1][car.randomCarNumber])) {
                JOptionPane.showMessageDialog(this, "You rolled an " + die[counter].getValue() + " and we can assume the value is greater than " + die[counter].getValue()
                        + " so the higher box has been highlighted ");
                higher[counter].setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
                highLow[counter] = 1;
                counter++;
                /**
                 * If the above statement is false, This statement will check if
                 * the value of the dice rolled is less than the value of the
                 * car. If this is true, a message will appear, the higher box
                 * will be highlighted, and highLow at the turn the user is on
                 * will equal zero so we know that the lower panel is selected.
                 * As well counter will go up by one.
                 */
            } else if (die[counter].getValue() > Integer.parseInt(car.CarPrice[counter + 1][car.randomCarNumber])) {
                JOptionPane.showMessageDialog(this, "You rolled an " + die[counter].getValue() + " and we can assume the value is less than " + die[counter].getValue()
                        + " so the lower box has been highlighted ");
                lower[counter].setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
                highLow[counter] = 0;
                counter++;
            }
            /**
             * If the above statement is false, This statement will check if the
             * dice value at the turn is the user is on will not equal six or
             * one and that dice value does not equal the car value. If this is
             * true the roll button will be disabled and the high low buttons
             * will be enabled.
             */
        } else if (dice[counter].getValue() != 1 & dice[counter].getValue() != 6 & Integer.toString(die[counter].getValue()) != (car.CarPrice[counter + 1][car.randomCarNumber])) {

            bttn2.setEnabled(false);
            bttn3.setEnabled(true);
            bttn4.setEnabled(true);
            /**
             * If the above statement is false, This statement will check if the
             * dice value at the turn is the user is on will not equal six or
             * one and that dice value equals the car value. If this is true the
             * roll button will be enabled and the high low buttons will be
             * disabled. As well a message will appear and counter will
             * increase.
             */
        } else if (dice[counter].getValue() != 1 & dice[counter].getValue() != 6 & Integer.toString(die[counter].getValue()).equals(car.CarPrice[counter + 1][car.randomCarNumber])) {
            JOptionPane.showMessageDialog(this, " You rolled an " + die[counter].getValue() + " and the car value for this section is "
                    + car.CarPrice[counter][car.randomCarNumber] + " so you dont have to guess if its higher or lower ");
            counter++;
            bttn2.setEnabled(true);
            bttn3.setEnabled(false);
            bttn4.setEnabled(false);

        }
    }

    /**
     * This method will iterate all the code needed to end the game.
     */
    public void theEnd() {
        /**
         * All buttons will be disabled and a message will appear.
         */
        bttn2.setEnabled(false);
        bttn3.setEnabled(false);
        bttn4.setEnabled(false);
        bttn4.setEnabled(false);
        JOptionPane.showMessageDialog(this, " Now That all your turns are gone lets check if you won or not  ");

        /**
         * This for statement will iterate through 4 turns and check if the user
         * selected the right numbers
         */
        for (int i = 0; i <= 3; i++) {
            /**
             * This will first check if user has not entered a wrong number yet,
             * If the if statement will move to the nested if statement
             */
            if (isHigherOrLower == true) {
                /**
                 * This statement will check if the value of the dice rolled
                 * will equal the value of the car. If this is true, a message
                 * will appear.
                 */
                if (Integer.toString(die[counter2].getValue()).equals(car.CarPrice[counter2 + 1][car.randomCarNumber])) {
                    higher[counter2].setText(car.CarPrice[counter2 + 1][car.randomCarNumber]);
                    JOptionPane.showMessageDialog(this, "You rolled an " + die[counter2].getValue() + " and the car value for this section is "
                            + car.CarPrice[counter2 + 1][car.randomCarNumber] + " so you get a won in this section ");
                }
                /**
                 * This statement will check if the value of the dice rolled at
                 * counter is greater than the value of the car. If this is
                 * true, the if statement will go into the nested if statement.
                 */
                if (die[counter2].getValue() < Integer.parseInt(car.CarPrice[counter2 + 1][car.randomCarNumber])) {
                    /**
                     * This statement check first check if the higher panel is
                     * selected at a certain turn. If true, it will set that
                     * panel to the car value and a message will appear. If
                     * false, the next statement will check if the lower panel
                     * was selected. If true then the car value will be set to
                     * the panel and isHigherOrLower will be set false
                     */
                    if (highLow[counter2] == 1) {
                        higher[counter2].setText(car.CarPrice[counter2 + 1][car.randomCarNumber]);
                        JOptionPane.showMessageDialog(this, "You rolled an " + die[counter2].getValue() + " the value is greater than " + die[counter2].getValue()
                                + " so you won in this section");

                    } else if (highLow[counter2] == 0) {
                        higher[counter2].setText(car.CarPrice[counter2 + 1][car.randomCarNumber]);
                        isHigherOrLower = false;
                    }

                }
                /**
                 * This statement check first check if the lower panel is
                 * selected at a certain turn. If true, it will set that panel
                 * to the car value and a message will appear. If false, the
                 * next statement will check if the higher panel was selected.
                 * If true then the car value will be set to the panel and
                 * isHigherOrLower will be set false
                 */
                if (die[counter2].getValue() > Integer.parseInt(car.CarPrice[counter2 + 1][car.randomCarNumber])) {

                    if (highLow[counter2] == 0) {
                        lower[counter2].setText(car.CarPrice[counter2 + 1][car.randomCarNumber]);
                        JOptionPane.showMessageDialog(this, "You rolled an " + die[counter2].getValue() + "the value is less than " + die[counter2].getValue()
                                + " so won in this section");
                    } else if (highLow[counter2] == 1) {
                        lower[counter2].setText(car.CarPrice[counter2 + 1][car.randomCarNumber]);
                        isHigherOrLower = false;
                    }

                }
                /**
                 * The turn the game on increases here
                 */
                counter2++;
            }
        }
        /**
         * This statement will determine if the user won the game or not. If
         * true, then a sound and car image will appear. The game will then
         * exit. If False, then the game will play a loosing sound, a loosing
         * message will appear and the game will end.
         */
        if (isHigherOrLower == true) {
            new Cheer("cheer.wav").start();
            playMessage.showMessageDialog(this, "Congrats you have guessed all the right numbers you now have won yourself a " + car.getCarName(car.getRandomCarNumber()),
                    "info", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource(car.getImage(car.randomCarNumber))));
            playMessage.showMessageDialog(this, " This game will exit now ");
            System.exit(-1);
        } else if (isHigherOrLower == false) {
            new Cheer("loose.wav").start();
            playMessage.showMessageDialog(this, "You have guessed the wrong number in this section :-/. So you sir have lost!");
            playMessage.showMessageDialog(this, " This game will exit now ");
            System.exit(-1);
        }

    }

    /**
     * This Method will check if the above or below boxes are selected
     *
     * @param value
     */
    public void highLowDeterminer(int value) {
        /**
         * If the value given is 1, the above box will be selected at the turn
         * the user is on and the play button will be enabled, and high/low
         * buttons disabled. As well, counter will increase by one.
         */
        if (value == 1) {
            higher[counter].setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
            bttn2.setEnabled(true);
            bttn3.setEnabled(false);
            bttn4.setEnabled(false);
            counter++;
            /**
             * If the value given is 0, the below box will be selected at the
             * turn the user is on and the play button will be enabled, and
             * high/low buttons disabled. As well, counter will increase by one.
             */
        } else if (value == 0) {
            lower[counter].setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
            bttn2.setEnabled(true);
            bttn3.setEnabled(false);
            bttn4.setEnabled(false);
            counter++;

        }


    }
}
