package PriceIsRight;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.0
 * Description: This class, is used to Draw dice to a screen.
 */
public class DiceCavas extends JPanel {

    private int xDir, yDir, sizeFactor, value = 0;
    private Color diceColor, dieCircleColor;

    /**
     * This method will set all the parameters needed to draw the dice
     *
     * @param xDir
     * @param yDir
     * @param sizeFactor
     * @param value
     * @param diceColor
     * @param dieCircleColor
     */
    public DiceCavas(int xDir, int yDir, int sizeFactor, int value, Color diceColor, Color dieCircleColor) {
        setxDir(xDir);
        setyDir(yDir);
        setSizeFactor(sizeFactor);
        setValue(value);
        setDiceColor(diceColor);
        setDieCircleColor(dieCircleColor);
    }

    /**
     * This method will return the dice color
     *
     * @return
     */
    public Color getDiceColor() {
        return diceColor;
    }

    /**
     * This method will set the dice color
     *
     * @param diceColor
     */
    public void setDiceColor(Color diceColor) {
        this.diceColor = diceColor;
    }

    /*
     * This method will return the dice's mini circle color @return
     */
    public Color getDieCircleColor() {
        return dieCircleColor;
    }

    /**
     * This method will return the dice 's mini circle color
     *
     * @param dieCircleColor
     */
    public void setDieCircleColor(Color dieCircleColor) {
        this.dieCircleColor = dieCircleColor;
    }

    /**
     * This method will return the size factor
     *
     * @return
     */
    public int getSizeFactor() {
        return sizeFactor;
    }

    /**
     * This method will set the size factor
     *
     * @param sizeFactor
     */
    public void setSizeFactor(int sizeFactor) {
        this.sizeFactor = sizeFactor;
    }

    /**
     * This method will get the dice value
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * This method will set the dice value
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    /**
     * This method will return the x direction
     *
     * @return
     */
    public int getxDir() {
        return xDir;
    }

    /**
     * This method will set the x direction
     *
     * @param xDir
     */
    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    /**
     * This method will return the y direction
     *
     * @return
     */
    public int getyDir() {
        return yDir;
    }

    /**
     * This method will set the y dir
     *
     * @param yDir
     */
    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    /**
     * This method will paint the dice on the screen
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        drawGraphics(g, getValue(), getxDir(), getyDir(), getSizeFactor(), getDieCircleColor(), getDiceColor());
    }

    /**
     * This method will draw the dice on the screen
     *
     * @param
     */
    void drawGraphics(Graphics g, int val, int x, int y, int size, Color circle, Color die) {
        g.setColor(die);
        g.fillRect(x * size, y * size, 35 * size, 35 * size);
        g.setColor(circle);
        g.drawRect(x * size, y * size, 34 * size, 34 * size);
        g.setColor(circle);
        if (val > 1) // upper left dot
        {
            g.fillOval(x + 3 * size, y + 3 * size, 9 * size, 9 * size);
        }
        if (val > 3) // upper right dot
        {
            g.fillOval(x + 23 * size, y + 3 * size, 9 * size, 9 * size);
        }
        if (val == 6) // middle left dot
        {
            g.fillOval(x + 3 * size, y + 13 * size, 9 * size, 9 * size);
        }
        if (val % 2 == 1) // middle dot (for odd-numbered val's)
        {
            g.fillOval(x + 13 * size, y + 13 * size, 9 * size, 9 * size);
        }
        if (val == 6) // middle right dot
        {
            g.fillOval(x + 23 * size, y + 13 * size, 9 * size, 9 * size);
        }
        if (val > 3) // bottom left dot
        {
            g.fillOval(x + 3 * size, y + 23 * size, 9 * size, 9 * size);
        }
        if (val > 1) // bottom right dot
        {
            g.fillOval(x + 23 * size, y + 23 * size, 9 * size, 9 * size);
        }
    }

    /**
     * This will convert all the dice parameters to string
     *
     * @return
     */
    @Override
    public String toString() {
        return "DiceCavas{" + "xDir=" + xDir + ", yDir=" + yDir + ", sizeFactor=" + sizeFactor + ", value=" + value + ", diceColor=" + diceColor + ", dieCircleColor=" + dieCircleColor + '}';
    }
}
