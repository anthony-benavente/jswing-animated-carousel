package net.codemap.carousel.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Demo program showing ScalableImage's capabilities
 *
 * @author Anthony Benavente
 * @version 5/4/15
 */
public class ScalableImageTest extends JPanel implements ChangeListener {

    /**
     * The image that is drawn to the screen
     */
    private ScalableImage image;

    /**
     * Controls the width of the image
     */
    private JSlider widthSlider;

    /**
     * Controls the height of the image
     */
    private JSlider heightSlider;

    /**
     * Sets up the panel that is on the JFrame
     */
    public ScalableImageTest() {
        setLayout(new BorderLayout());
        add(createImagePanel(), BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
    }

    /**
     * Creates the panel that has the sliders for width/height
     *
     * @return the newly created panel for sliders
     */
    private JPanel createControlPanel() {
        JPanel result = new JPanel();

        widthSlider = new JSlider(0, 800);
        heightSlider = new JSlider(0, 500);

        // To see what the sliders do, see the implemented method in this class
        widthSlider.addChangeListener(this);
        heightSlider.addChangeListener(this);

        result.add(new JLabel("Width:"));
        result.add(widthSlider);
        result.add(new JLabel("Height:"));
        result.add(heightSlider);

        return result;
    }

    /**
     * Creates the panel with the image
     *
     * @return the newly created panel containing the scalable image
     */
    private JPanel createImagePanel() {
        JPanel result = new JPanel();
        image = new ScalableImage("res/img/example1.png", 400, 400);
        image.setBorder(new LineBorder(Color.gray));
        result.add(image);
        result.setBorder(new LineBorder(Color.black));
        return result;
    }

    /**
     * Called when any of the sliders are changed. The image's dimensions are
     * updated here.
     *
     * @param e the event fired from the sliders
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        image.setWidth(widthSlider.getValue());
        image.setHeight(heightSlider.getValue());
    }

    /**
     * Entry point to the demo
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scalable Image Test");
        frame.setSize(800, 600);
        frame.setContentPane(new ScalableImageTest());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
