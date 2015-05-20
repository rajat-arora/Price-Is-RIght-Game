package PriceIsRight;


/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.0
 * Description: This class, is used as a utility to draw dice on a screen
 */
public class Dice {

    /**
     * This will be used to store the dices number
     */
    protected int value;

    /**
     * This constructor will call roll and generate a random number
     */
    public Dice() {
        roll();
    }

    /**
     * This will get the dice value and return it
     *
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * this will set the dice value if given a value
     *
     * @param value
     */
    public void setValue(int value) {
        if (value >= 1 & value <= 6) {
            this.value = value;
        }
    }

    /**
     * This method will generate a random dice number from 1- 6
     */
    public void roll() {
        setValue((int) (Math.random() * 6) + 1);
    }

    /**
     * This will convert all the dice parameters to string
     *
     * @return
     */
    @Override
    public String toString() {
        return "Dice{" + "value=" + value + '}';
    }
}
