package gui;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Saravana
 */
public class Main {

    public static void main(String[] args) {

        // here we are setting the theme for swing UI
        Plastic3DLookAndFeel.setPlasticTheme(new SkyBlue());
        try {
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {

        }

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.display();
        scoreBoard.setMaximized();

        System.out.println("Displayed....");

    }

}
