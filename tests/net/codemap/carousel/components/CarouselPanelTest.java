package net.codemap.carousel.components;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

/**
 * Tests the CarouselPanel's drawing
 *
 * @author Anthony Benavente
 * @version 5/5/15
 */
public class CarouselPanelTest extends JPanel {

    /**
     * Creates a new Panel with a maximized carousel panel inside it
     */
    public CarouselPanelTest() {
        setLayout(new BorderLayout());

        ScalableImage toUse = new ScalableImage("res/img/example1.png",
                800, 600);
        add(new CarouselPanel(800, 600, toUse, "Test Title", "Test " +
                "Description"));
    }

    /**
     * Entry point to the program
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carousel Panel Test");
        frame.setSize(800, 600);
        frame.setContentPane(new CarouselPanelTest());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
