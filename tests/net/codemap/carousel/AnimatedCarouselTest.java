package net.codemap.carousel;

import net.codemap.carousel.components.ScalableImage;
import org.javadev.effects.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

/**
 * This class demos the functionality of the AnimatedCarousel class.
 *
 * @author Anthony Benavente
 * @version 5/4/15.
 */
public class AnimatedCarouselTest extends JPanel {

    /**
     * This is the list of transitions used when demoing the carousel
     */
    private static final String[] TRANSITIONS = new String[] {
            "Cube", "Dashboard", "Fade", "Iris", "Radial", "Slide"
    };

    /**
     * The carousel shown on the screen
     */
    protected AnimatedCarousel carousel;

    /**
     * Combo box of
     */
    private JComboBox<String> transitions;

    /**
     * Creates a new AnimatedCarouselTest
     */
    public AnimatedCarouselTest() {
        setLayout(new BorderLayout());
        setSize(800, 600);
        add(initCarousel(), BorderLayout.CENTER);
        add(initControlPanel(), BorderLayout.SOUTH);
    }

    /**
     * Initializes the control panel
     *
     * @return the initialized control panel
     */
    private JPanel initControlPanel() {
        JPanel panel = new JPanel();
        transitions = new JComboBox<>();
        for (String transitionName : TRANSITIONS) {
            transitions.addItem(transitionName + " Animation");
        }
        transitions.addActionListener(e -> carousel.setAnimation(getAnimation()));
        panel.add(transitions);
        return panel;
    }

    /**
     * Initializes an AnimatedCarousel and returns it
     *
     * @return the newly initialized carousel
     */
    protected JPanel initCarousel() {
        Animation animation = new DashboardAnimation();
        animation.setAnimationDuration(300);

        carousel = new AnimatedCarousel(getWidth(), getHeight(),
                animation, null);
        loadImagesToCarousel();
        return carousel;
    }

    /**
     * Loads images from the res/img folder into the carousel
     */
    protected void loadImagesToCarousel() {
        File[] imageFiles = new File("res/img").listFiles();
        if (imageFiles != null) {
            for (File f : imageFiles) {
                ScalableImage image = new ScalableImage(f.getAbsolutePath(),
                        carousel.getWidth(), carousel.getHeight());
                carousel.addPanel(image, f.getName(), f.getAbsolutePath());
            }
        }
    }

    /**
     * Gets the animation from the selected item in the combo box
     *
     * @return the animation selected in the combo box
     */
    public Animation getAnimation() {
        Animation result = null;
        try {
            String selectedClass = transitions.getSelectedItem().toString()
                    .replace(" ", "");
            Class loadedClass = Class.forName("org.javadev.effects." +
                    selectedClass);
            result = (Animation) loadedClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException |
                    IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Entry point to the demo
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Carousel Test");
        frame.setSize(800, 600);
        frame.setContentPane(new AnimatedCarouselTest());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
