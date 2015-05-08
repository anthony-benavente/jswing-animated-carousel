package net.codemap.carousel;

import org.javadev.effects.CubeAnimation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * This is an extension of the AnimatedCarouselTest in that instead of an
 * AnimatedCarousel, it is an AutoCarousel.
 *
 * @author Anthony Benavente
 * @version 5/4/15
 */
public class AutoCarouselTest extends AnimatedCarouselTest {

    /**
     * Used to change the carousel from being an AnimatedCarousel to an
     * AutoCarousel
     *
     * @return the initialized AutoCarousel
     */
    @Override
    protected JPanel initCarousel() {
        carousel = new AutoCarousel(800, 600,
                new CubeAnimation(), null, 3000);
        loadImagesToCarousel();
        ((AutoCarousel) carousel).start();
        return carousel;
    }

    /**
     * Entry point to the demo
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Carousel Test");
        frame.setSize(800, 600);
        frame.setContentPane(new AutoCarouselTest());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
