import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Door
{
    private LabelBuilder doorOpen;
    private LabelBuilder doorClosed;
    private LabelBuilder doorLit;
    private boolean isOpen;
    private boolean isLit;

    public Door(LabelBuilder doorOpen, LabelBuilder doorClosed, LabelBuilder doorLit)
    {
        this.doorOpen = doorOpen;
        this.doorClosed = doorClosed;
        this.doorLit = doorLit;
        this.isOpen = true;
        this.isLit = false;
    }

    public LabelBuilder getDoorOpen()
    {
        return doorOpen;
    }

    public LabelBuilder getDoorClosed()
    {
        return doorClosed;
    }

    public LabelBuilder getDoorLit()
    {
        return doorLit;
    }

    public boolean isDoorOpen()
    {
        return isOpen;
    }

    public boolean isDoorLit()
    {
        return isLit;
    }

    public void clopenDoor()
    {
        isOpen = !isOpen;
    }

    public void turnDoorLight()
    {
        isLit = !isLit;
    }
}
