/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceIsRight;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/*
 * Creator: Rajat Arora 
 * Date Completed: Thursday, April 10, 2012
 * Version: v1.0
 * Description: This class, will take in a song an play it.
 */
public class Cheer extends Thread {

    private String filename;
    private Position curPosition;
    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

    enum Position {

        LEFT, RIGHT, NORMAL
    };

    /**
     * This will take in the wavfile and read it
     *
     * @param wavfile
     */
    public Cheer(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }

    /**
     * This will take in the wavFile and read it at a certin interval
     *
     * @param wavfile
     * @param p
     */
    public Cheer(String wavfile, Position p) {
        filename = wavfile;
        curPosition = p;
    }

    /**
     * This will read and play the song
     */
    public void run() {

        File soundFile = new File(filename);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
        }

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (auline.isControlSupported(FloatControl.Type.PAN)) {
            FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            if (curPosition == Position.RIGHT) {
                pan.setValue(1.0f);
            } else if (curPosition == Position.LEFT) {
                pan.setValue(-1.0f);
            }
        }

        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cheer{" + "filename=" + filename + ", curPosition=" + curPosition + ", EXTERNAL_BUFFER_SIZE=" + EXTERNAL_BUFFER_SIZE + '}';
    }
}
