package lesson.expertpussel.jar.enm.abstr.MediaPlayer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws CannotRealizeException, IOException, NoPlayerException {
        URL mediaURL = new File("Valve.avi").toURL();
        JPanel frame = new MediaPlayer(mediaURL);
        int result = JOptionPane.showConfirmDialog(
                null,
                frame,
                "Video test",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }
}
