package net.codemap.carousel.animation;

import net.codemap.carousel.components.ScalableImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;

/**
 * TODO: Something descriptive about this
 *
 * @author Anthony Benavente
 * @version 5/5/15
 */
public class FadeAnimationTest extends JPanel implements AnimationListener {

    public FadeAnimationTest() {
        setSize(800, 600);

        Animation animation = new SlideAnimation();
        animation.setDuration(2000);
        animation.setDirection(Animation.AnimationDirection.BACKWARD);
        ScalableImage img1 = new ScalableImage("res/img/example1.png",
                800, 600);
        ScalableImage img2 = new ScalableImage("res/img/example2.png",
                800, 600);
        add(animation.animate(img2, img1));
        animation.addAnimationListener(this);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onAnimationStart() {
        System.out.println("STARTED");
    }

    @Override
    public void onAnimationEnd() {
        System.out.println("ENDED");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fade Animation Test");
        frame.setSize(800, 600);
        frame.setContentPane(new FadeAnimationTest());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
