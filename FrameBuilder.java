import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** 
* A custom JFrame class that allows the user to easily
* add buttons, text fields, and labels to the frame
* along with other predetermined functions for the app
*/
public class FrameBuilder extends JFrame
{
    private int width;
    private int height;
    private String name;

    public FrameBuilder(int width, int height, String name)
    {
        super(name);
        this.setSize(width, height);
        this.width = width;
        this.height = height;
        this.name = name;
    }

    /** 
    * returns the width of the frame
    *
    * @return the width of the frame in pixels
    * @pre none
    * @post returns the current width of the frame
    */
    public int getWidth()
    {
        return width;
    }

    /** 
    * returns the height of the frame
    *
    * @return the height of the frame in pixels
    * @pre none
    * @post returns the current height of the frame
    */
    public int getHeight()
    {
        return height;
    }

    /** 
    * returns the name of the frame
    *
    * @return the name of the frame
    * @pre none
    * @post returns the current name of the frame
    */
    public String getName()
    {
        return name;
    }

    /** 
    * allows you to set the name of the frame to a desired input
    * @pre name != null
    * @post changes the current name of the frame to the given parameter
    */
    public void setName(String name)
    {
        super.setTitle(name);
    }

    /** 
    * sets the frame visibility so it can be seen
    * @pre none
    * @post allows the screen to be visible on the screen
    */
    public void setVisibility()
    {
        super.setVisible(true);
    }

    /** 
    * sets the new size of the frame to a given width and height
    * @pre width && height > 0
    * @post sets the current screen to the given parameters
    */
    public void setSize(int width, int height)
    {
        super.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    /** 
    * sets up basic GUI settings: close operation and layout
    * @pre none
    * @post frame has null layout and closes on exit
    */
    public void setUpGUI()
    {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
    }
    
    /** 
    * adds a button to the frame
    * @pre button != null
    * @post adds a button object to the frame
    */
    public void setUpButton(ButtonBuilder button)
    {   
        JButton bt = button;
        this.add(bt);
    }

    /** 
    * removes a button from the frame
    * @pre button != null
    * @post removes a button object from the frame
    */
    public void removeButton(ButtonBuilder button)
    {
        JButton bt = button;
        this.remove(bt);
    }

    /** 
    * adds a label to the frame
    * @pre label != null
    * @post adds a label object to the frame
    */
    public void setUpLabel(LabelBuilder label)
    {
        JLabel lb = label;
        this.add(lb);
    }

    /** 
    * removes a label from the frame
    * @pre label != null
    * @post removes a label object from the frame
    */
    public void removeLabel(LabelBuilder label)
    {
        JLabel lb = label;
        this.remove(lb);
    }

    /** 
    * adds a text field to the frame
    * @pre field != null
    * @post adds a text field object to the frame
    */
    public void setUpTextField(TextFieldBuilder field)
    {
        JTextField tf = field;
        this.add(tf);
    }

    /** 
    * removes a text field from the frame
    * @pre field != null
    * @post removes a text field object from the frame
    */
    public void removeTextField(TextFieldBuilder field)
    {
        JTextField tf = field;
        this.remove(tf);
    }

    /** 
    * Sets up the screen function for a button
    *
    * @param button the button that triggers the screen function
    * @param text the text will be printed on press
    * @param screen_num the screen it will change to
    * @pre button != null, text != null, screen_num >= 1 && screen_num <= 3
    * @post changes screen based on what button and screen is selected
    */
    public void setUpButtonFunctionS(ButtonBuilder button, int screen_num)
    {
        JButton bt = button;
        ActionListener buttonListener = new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (screen_num == 1)
                {
                    five_nights_at_rioux.removeScreen2();
                    five_nights_at_rioux.setUpScreen1();
                }
                else if (screen_num == 2)
                {
                    five_nights_at_rioux.removeScreen1();
                    five_nights_at_rioux.setUpScreen2();
                }
                else if (screen_num == 3)
                {
                    five_nights_at_rioux.removeScreen2();
                    five_nights_at_rioux.setUpScreen3();
                    five_nights_at_rioux.gameTimer();
                }

                // how the camera works
                else if (screen_num == 4)
                {
                    if (five_nights_at_rioux.mrVest.isPlayerOnCamera())
                    {
                        five_nights_at_rioux.unSetUpCamera();
                        five_nights_at_rioux.mrVest.flipIsPlayerOnCamera();
                    }
                    else
                    {
                        five_nights_at_rioux.setUpCamera();
                        five_nights_at_rioux.mrVest.flipIsPlayerOnCamera();
                    }
                }
                else if (screen_num == 5)
                {
                    five_nights_at_rioux.removeFloorOneCamImgs();
                    five_nights_at_rioux.removeFloorTwoCamImgs();
                    five_nights_at_rioux.changeCameraFloor();
                }
            }
        };

        bt.addActionListener(buttonListener);
    }

    // controls each of the buttons on the cameras.
    // camera_num references the camera that is being used.
    public void setUpButtonFunctionC(ButtonBuilder button, int camera_num)
    {
        JButton bt = button;
        ActionListener buttonListener = new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                five_nights_at_rioux.removeFloorOneCamImgs();
                five_nights_at_rioux.removeFloorTwoCamImgs();
                if (camera_num == 1)
                {
                    five_nights_at_rioux.cam1a();
                }
                else if (camera_num == 2)
                {
                    five_nights_at_rioux.cam2a();
                }
                else if (camera_num == 3)
                {
                    five_nights_at_rioux.cam3a();
                }
                else if (camera_num == 4)
                {
                    five_nights_at_rioux.cam1b();
                }
                else if (camera_num == 5)
                {
                    five_nights_at_rioux.cam2b();
                }
            }
        };

        bt.addActionListener(buttonListener);
    }


    // controls the door and the light buttons
    public void setUpButtonFunctionD(ButtonBuilder button, int door)
    {
        JButton bt = button;
        ActionListener buttonListener = new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (door == 1)
                {
                    if (five_nights_at_rioux.door.isDoorOpen())
                    {
                        five_nights_at_rioux.closeDoor();
                    }
                    else
                    {
                        five_nights_at_rioux.openDoor();
                    }
                    five_nights_at_rioux.door.clopenDoor();
                }
                else if (door == 2)
                {
                    if (five_nights_at_rioux.door.isDoorLit())
                    {
                        five_nights_at_rioux.unlightDoor();
                    }
                    else
                    {
                        five_nights_at_rioux.lightDoor();
                    }
                    five_nights_at_rioux.door.turnDoorLight();
                }
            }
        };

        bt.addActionListener(buttonListener);
    }

    /** 
    * Sets up the vest function for a button
    *
    * @param button the button that triggers the check
    * @pre button != null
    * @post Prints out a message and kicks the user from the app
    */
    public void setUpButtonFunctionQ(ButtonBuilder button)
    {
        ActionListener buttonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        };

        JButton bt = button;
        bt.addActionListener(buttonListener);
    }

    @Override
    public String toString()
    {
        return "width: " + width + ", height: " + height + ", name: " + name;
    }
}
