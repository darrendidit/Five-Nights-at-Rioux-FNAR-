public class Player
{
    private int nightNumber;
    private int cameraNumber;
    private int cameraFloorNumber;
    private boolean isOnCamera;

    public Player()
    {
        nightNumber = 1;
        cameraNumber = 1;
        cameraFloorNumber = 1;
        isOnCamera = false;
    }

    public int getNightNumber()
    {
        return nightNumber;
    }

    public int getCameraNumber()
    {
        return cameraNumber;
    }

    public int getCameraFloorNumber()
    {
        return cameraFloorNumber;
    }

    public boolean isPlayerOnCamera()
    {
        return isOnCamera;
    }

    public void incrementNightNumber()
    {
        nightNumber++;
    }

    public void setNightNumber(int nightNumber)
    {
        this.nightNumber = nightNumber;
    }

    public void setCameraNumber(int cameraNumber)
    {
        this.cameraNumber = cameraNumber;
    }

    public void setCameraFloorNumber(int cameraFloorNumber)
    {
        this.cameraFloorNumber = cameraFloorNumber;
    }

    public void flipIsPlayerOnCamera()
    {
        isOnCamera = !isOnCamera;
    }
}
