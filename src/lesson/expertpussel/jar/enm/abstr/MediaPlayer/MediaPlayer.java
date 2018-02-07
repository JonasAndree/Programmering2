package lesson.expertpussel.jar.enm.abstr.MediaPlayer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Displays a video player for a given video file
 */
public class MediaPlayer extends JPanel {
    public MediaPlayer(URL mediaURL) throws IOException, CannotRealizeException, NoPlayerException {
        setLayout(new BorderLayout());
        //create the media player with the media url
        Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
        Component video = mediaPlayer.getVisualComponent();
        add(video, BorderLayout.CENTER);
        //TODO: remove next two lines for no control panel
        Component controls = mediaPlayer.getControlPanelComponent();
        add(controls, BorderLayout.SOUTH);
        //TODO remove this for no auto play
        mediaPlayer.start();
    }


}
