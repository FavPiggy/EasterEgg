
import java.awt.*;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * The following class represents a GUI for the Easter Egg.
 * Random change 2
 * @author Arwain Karlin
 * @version 1.0
 */
public class PiggyGUI implements PropertyChangeListener {

    /**
     * A JFrame for the GUI.
     */
    private final JFrame myWindow;
    /**
     * Logo for Piggy.
     */
    private final ImageIcon myPiggyLogo = new ImageIcon("./src/piggy.jpg");

    /**
     * A default constructor for the GUI.
     */
    public PiggyGUI() {

        myWindow = new JFrame("Favorite Piggy");
        setup();
        myWindow.setIconImage(myPiggyLogo.getImage());
        myWindow.pack();
    }

    /**
     * This method makes the JFrame visible.
     */
    public void start() {
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
    }

    /**
     * A setup for the JFrame.
     */
    private void setup() {
        JPanel panel = new JPanel();
        panel.getUI();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JLabel jlabel = new JLabel("We are Favorite Piggy!\n");
        jlabel.setFont(new Font("Verdana", 1, 20));
        panel.add(jlabel);
        JLabel jlabel2 = new JLabel("Arwain Karlin - Coder for hire!\n");
        jlabel2.setFont(new Font("Papyrus", 1, 10));
        panel.add(jlabel2);
        JLabel jlabel3 = new JLabel("Kirtwinder Gulati - 1/2 cup coder, 2 cups baker, 1 tsp vanilla and " +
                "1/2 cup chocolate chips.\n Mix thoroughly to combine, bake at 360 for 21 minutes");
        jlabel2.setFont(new Font("Verdana", 1, 10));
        panel.add(jlabel3);
        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        myWindow.add(panel);


    }

    /**
     * Below initializes an exit action when the quit button is pushed.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("Goodbye".equals(theEvent.getPropertyName())) {
            myWindow.dispatchEvent(new WindowEvent(myWindow, WindowEvent.WINDOW_CLOSING));
        }
    }

}



