import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

public class Animatronic
{
    private LabelBuilder image;
    private ArrayList<Integer> aiPerNight;
    private int index;
    
    public Animatronic(LabelBuilder image, ArrayList<Integer> aiPerNight)
    {
        this.image = image;
        this.aiPerNight = aiPerNight;
        index = 0;
    }

    // based on their nightly agression, if they move and they are within the random chance
    // and the door is open, they return true, else, return false
    public boolean moves()
    {
        int aiTonight = aiPerNight.get(five_nights_at_rioux.mrVest.getNightNumber());
        int chance = (int)(Math.random() * 20 + 1);

        if (chance <= aiTonight)
        {
            if (five_nights_at_rioux.door.isDoorOpen())
            {
                return true;
            }
        }
        return false;
    }

    public LabelBuilder getImage()
    {
        return image;
    }
}
