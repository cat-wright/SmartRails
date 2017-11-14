package res;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ResourceLoader
{
  static ResourceLoader rl = new ResourceLoader();
  
  public static Image getTrackImage(String fileName, double width, double height)
  {
    return getImage("tracks/"+fileName, width, height);
  }
  
  public static Image getTrainImage(String fileName, double width, double height)
  {
    return getImage("train/"+fileName, width, height);
  }
  
  public static Image getImage(String fileName, double width, double height)
  {
    InputStream is = new BufferedInputStream(rl.getClass().getResourceAsStream(fileName));
    Image image = new Image(is, width, height, false, false);
    
    return image;
  }

  public static MediaPlayer getMediaPlayer()
  {
    String musicFile = ResourceLoader.class.getResource("ThomasTheTank.mp3").toString();
    Media sound = new Media(musicFile);
    return new MediaPlayer(sound);
  }

  public static Image getTitle(int width, int height)
  {
    return getImage("SmartRailsTitle.png", width, height);
  }
}
