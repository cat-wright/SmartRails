
public class SwitchTrack extends Track
{
  private boolean switchOn;
  SwitchTrack connection;

  SwitchTrack(TrackType trackType)
  {
    super(trackType);
    switchOn = true;
  }
  
  /**
   * Returns the next track in the given direction. If the switch is on and the direction corresponds with the switch,
   * the connection is returned.
   * @param direction
   * @return
   */
  @Override
  public Track getNextTrack(Direction direction)
  {
    TrackType trackType = getTrackType();
    if(switchOn)
    {
      if((direction == Direction.RIGHT &&
          (trackType == TrackType.LEFT_DOWN_SWITCH || trackType == TrackType.LEFT_UP_SWITCH)) ||
          (direction == Direction.LEFT &&
          (trackType == TrackType.RIGHT_DOWN_SWITCH || trackType == TrackType.RIGHT_UP_SWITCH))) return connection;
    }
    
    return super.getNextTrack(direction);
  }
  
  /**
   * Sets the reference to the track that the switch is connected to.
   * @param connection
   */
  public void setConnection(SwitchTrack connection)
  {
    this.connection = connection;
  }
  
  /**
   * Changes the direction of the switch.
   */
  public void switchDirection()
  {
    switchOn = !switchOn;
  }
}