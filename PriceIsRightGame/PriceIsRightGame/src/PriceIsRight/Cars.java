/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceIsRight;

/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.0
 * Description: This class, is used as a utility to draw  and manage the used car 
 * for the game
 */
public class Cars {

    /**
     * This will be used to generate a random car number
     */
    protected int randomCarNumber;
    /**
     * An Array of car names are stored in this
     */
    protected String[] CarNames = {"2012 Honda Crv", "2012 Lexus Rx 450h", "2012 Ford F150", "2012 Toyota Camry",
        "2012 Ford Focus", "1980 Corvette", "2012 Mazda 6", "2013 Gmc Acadia", "2013 Ford Escape", "2013 Bmw 3 Series"};
    /**
     * An array of car prices are stored here
     */
    protected String[][] CarPrice = {
        {"2", "5", "2", "2", "3", "1", "2", "3", "3", "6"},
        {"2", "3", "6", "3", "4", "4", "3", "3", "4", "5"},
        {"2", "7", "5", "4", "5", "4", "5", "5", "4", "4"},
        {"9", "2", "5", "6", "6", "1", "6", "3", "6", "5"},
        {"5", "1", "4", "7", "5", "2", "7", "4", "7", "7"}};
    /**
     * An array of images are stored in here.
     */
    protected String[] images = {"/PriceIsRight/cars/crv.jpg", "/PriceIsRight/cars/rx450.jpg", "/PriceIsRight/cars/f150.jpg",
        "/PriceIsRight/cars/camery.jpg", "/PriceIsRight/cars/focus.jpg", "/PriceIsRight/cars/corvette.jpg", "/PriceIsRight/cars/mazda6.jpg",
        "/PriceIsRight/cars/acadia.jpg", "/PriceIsRight/cars/escape.jpg", "/PriceIsRight/cars/bmw.jpg"};

    /**
     * This constructor calls a method to generate a random number.
     */
    public Cars() {
        randomCarNumber();
    }

    /**
     * This method returns a car name at the given index.
     *
     * @param i
     * @return
     */
    public String getCarName(int i) {
        return CarNames[i];
    }

    /**
     * This method returns the car image location at the given index.
     *
     * @param i
     * @return
     */
    public String getImage(int i) {
        return images[i];
    }

    /**
     * This method Overrides the car name at the given index
     *
     * @param CarNames
     */
    public void setCarName(String[] CarNames) {
        this.CarNames = CarNames;
    }

    /**
     * This method returns all the car names.
     *
     * @return
     */
    public String[] getCarNames() {
        return CarNames;
    }

    /**
     * This method sets a cars name at given index
     *
     * @param CarNames
     */
    public void setCarNames(String[] CarNames) {
        this.CarNames = CarNames;
    }

    /**
     * This method returns a cars name at given index
     *
     * @return
     */
    public int getRandomCarNumber() {
        return randomCarNumber;
    }

    /**
     * This method sets the random car number
     *
     * @param randomCarNumber
     */
    public void setRandomCarNumber(int randomCarNumber) {
        this.randomCarNumber = randomCarNumber;
    }

    /**
     * This method gets the car price and given index
     *
     * @return
     */
    public String[][] getCarPrice() {
        return CarPrice;
    }

    /**
     * This method sets the car price and given index
     *
     * @param CarPrice
     */
    public void setCarPrice(String[][] CarPrice) {
        this.CarPrice = CarPrice;
    }

    /**
     * This method generates a random car number at a given index
     */
    public void randomCarNumber() {
        setRandomCarNumber((int) (Math.random() * 9) + 0);
    }

    /**
     * This will convert all the dice parameters to string
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cars{" + "randomCarNumber=" + randomCarNumber + ", CarNames=" + CarNames + ", CarPrice=" + CarPrice + ", images=" + images + '}';
    }
}
