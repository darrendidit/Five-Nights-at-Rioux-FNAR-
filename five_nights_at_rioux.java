import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.ArrayList;

/**
* The main class for the Java Error Practice App
* allowing the user to practice fixing or making Java
* errors and tracks their progress
*/
public class five_nights_at_rioux 
{
    /** Max width of my screen */
    final static int max_x = 1072;

    /** Max height of my screen */
    final static int max_y = 528;

    // making the background for all of the screens
    static FrameBuilder screen = new FrameBuilder(max_x, max_y, "basic name aswell");
    // (width, height, name)

    static Player mrVest = new Player();
    static int timePerNight = 3 * 60;

    static ArrayList<Integer> numbers = new ArrayList<>();

    static
    {
        numbers.add(2);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        numbers.add(13);
    }

    static LabelBuilder riouxImage = new LabelBuilder((int)(max_x * 3 / 4) - 350, (int)(max_y/2) - 150, 354, 300, new ImageIcon("Images/Ms_Rioux.png"));
    static LabelBuilder chenjieImage = new LabelBuilder(200, 200, 347, 347, new ImageIcon("Images/Chenjie.png"));
    static LabelBuilder anshImage = new LabelBuilder(100, 100, 332, 427, new ImageIcon("Images/Ansh.png"));
    static LabelBuilder presImage = new LabelBuilder(400, 200, 225, 282, new ImageIcon("Images/Pres.png"));

    static Animatronic rioux = new Animatronic(riouxImage, numbers);
    static Animatronic chenjie = new Animatronic(chenjieImage, numbers);
    static Animatronic ansh = new Animatronic(anshImage, numbers);
    static Animatronic pres = new Animatronic(presImage, numbers);
    
    // ---------- Screen 1 (Menu) Components ----------
    // buttons (x, y, width, height, name)
    static ButtonBuilder newGameBtn = new ButtonBuilder(100, (int)(max_y/2) - 25, 300, 50, "New Game");
    static ButtonBuilder continueBtn = new ButtonBuilder(100, (int)(max_y/2) + 50, 300, 50, "Continue");
    static ButtonBuilder MrVestBtn = new ButtonBuilder(100, (int)(max_y/2) + 125, 300, 50, "Python Mode");
    
    // labels (x, y, width, height, text)
    static LabelBuilder titleLbl1 = new LabelBuilder(40, (int)(max_y/2.5) - 200, 1000, 100, "Five Nights at Rioux's", 40);
    static LabelBuilder explanationLbl1 = new LabelBuilder(115, (int)(max_y/2.5) - 170, 1000, 100, "\"MR. VEST... SAVE CODE SOCIETY!\"", 16);

    static LabelBuilder vestImage = new LabelBuilder((int)(max_x * 3 / 4) - 50, (int)(max_y/2) - 219, 282, 438, new ImageIcon("Images/Mr_Vest.png"));

    // ---------- Screen 2 (Debreif) Components ----------
    // buttons (x, y, width, height, name)
    static ButtonBuilder nextBtn = new ButtonBuilder(max_x - 200, max_y - 100, 200, 100, "Start The Night");
    static ButtonBuilder menuBtn = new ButtonBuilder(0, max_y - 100, 100, 100, "Go Back");

    // labels (x, y, width, height, text)
    static LabelBuilder newspaper = new LabelBuilder((int)(max_x/2) - 210, (int)(max_y/2) - 239, 420, 478, new ImageIcon("Images/Newspaper.png"));

    // ---------- Screen 3 (Office) Components ----------
    static ButtonBuilder cameraBtn = new ButtonBuilder((int)((max_x - 315)/2) - 200, max_y - 50, 400, 50, "^");
    static LabelBuilder officeImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Office.png"));
    // https://cdn12.picryl.com/photo/2016/12/31/computer-laptop-pc-computer-communication-c852c3-1024.png

    static LabelBuilder doorClosed = new LabelBuilder(max_x - 350, max_y - 520, 350, 520, new ImageIcon("Images/DoorClosed.png"));
    static LabelBuilder doorOpen = new LabelBuilder(max_x - 350, max_y - 520, 350, 520, new ImageIcon("Images/DoorOpen.png"));
    static LabelBuilder doorLit = new LabelBuilder(max_x - 350, max_y - 520, 350, 520, new ImageIcon("Images/DoorLit.png"));

    static Door door = new Door(doorOpen, doorClosed, doorLit);

    static ButtonBuilder lightBtn = new ButtonBuilder(510, 380, 100, 50, "Light");
    static ButtonBuilder doorBtn = new ButtonBuilder(610, 380, 100, 50, "Door");

    // ---------- Screen ??? (Camera) Components ----------
    static ButtonBuilder cameraChanger = new ButtonBuilder(max_x - 344, max_y - 424, 100, 50, "Floor 1");

    // floor 1 elements
    static LabelBuilder cameraImg1 = new LabelBuilder(max_x - 344, max_y - 424, 319, 396, new ImageIcon("Images/FirstFloorCamera.png"));
    
    static ButtonBuilder camera1a = new ButtonBuilder(975, 365, 55, 40, "1A");
    static LabelBuilder camera1aImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Camera1A.png"));
    // https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA1L3BkMjMzLW1hc3Rlcm1yZzEwOTAwMTA5MjIuanBn.jpg

    static ButtonBuilder camera2a = new ButtonBuilder(810, 360, 55, 40, "2A");
    static LabelBuilder camera2aImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Camera2A.png"));
    // https://storage.needpix.com/rsynced_images/flight-of-stairs.jpg

    static ButtonBuilder camera3a = new ButtonBuilder(810, 200, 55, 40, "3A");
    static LabelBuilder camera3aImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Camera3A.png"));
    // https://i1.pickpik.com/photos/502/264/929/hotel-corridor-conference-architecture-preview.jpg

    // floor 2 elements
    static LabelBuilder cameraImg2 = new LabelBuilder(max_x - 344, max_y - 470, 319, 396, new ImageIcon("Images/SecondFloorCamera.png"));

    static ButtonBuilder camera1b = new ButtonBuilder(975, 350, 55, 40, "1B");
    static LabelBuilder camera1bImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Camera1B.png"));
    // https://alquimiainc.com/wp-content/uploads/2018/08/3030-Post-Oak-402-29.jpg

    static ButtonBuilder camera2b = new ButtonBuilder(820, 160, 55, 40, "2B");
    static LabelBuilder camera2bImg = new LabelBuilder(0, 0, max_x, max_y, new ImageIcon("Images/Camera2B.png"));
    // https://upload.wikimedia.org/wikipedia/commons/8/82/Hotel_Hallway.jpeg

    /** 
    * Main method that starts the application
    * and loads the first screen
    * @pre none
    * @post Screen 1 GUI and functions are initialized
    */
    public static void main(String[] args) 
    {
        System.out.println("I glaze python\n- Mr. Vest");
        // sets up the screen background
        screen.setUpGUI();

        // sets up the first screen
        setUpScreen1();
    }

    /** 
    * sets up the first screen using buttons and labels
    * @pre all buttons and labels are initialized
    * @post Screen 1 components are visible and buttons have functions
    */
    public static void setUpScreen1()
    {
        if (mrVest.getNightNumber() != 1)
        {
            screen.setUpButton(continueBtn);
        }
        screen.setUpButton(newGameBtn);
        screen.setUpButton(MrVestBtn);
        screen.setUpLabel(titleLbl1);
        screen.setUpLabel(riouxImage);
        screen.setUpLabel(vestImage);
        screen.setUpLabel(explanationLbl1);
        screen.setUpButtonFunctionS(newGameBtn, 2);
        screen.setUpButtonFunctionS(continueBtn, 3);
        screen.setUpButtonFunctionQ(MrVestBtn);
        screen.setVisibility();
    }

    /** 
    * clears every component used on the first screen from the screen
    * @pre screen 1 is visible
    * @post screen 1 components are no longer visible on the screen
    */
    public static void removeScreen1()
    {
        screen.remove(newGameBtn);
        screen.remove(continueBtn);
        screen.remove(MrVestBtn);
        screen.remove(titleLbl1);
        screen.remove(riouxImage);
        screen.remove(vestImage);
        screen.remove(explanationLbl1);
        screen.revalidate();
        screen.repaint();
    }

    /** 
    * sets up the second screen using buttons and labels
    * @pre all buttons and labels are initialized
    * @post Screen 2 components are visible and buttons have functions
    */
    public static void setUpScreen2()
    {
        screen.setUpButton(nextBtn);
        screen.setUpButton(menuBtn);
        screen.setUpLabel(newspaper);
        screen.setUpButtonFunctionS(nextBtn, 3);
        screen.setUpButtonFunctionS(menuBtn, 1);
        screen.setVisibility();
    }

    /** 
    * clears every component used on the first screen from the screen
    * @pre screen 2 is visible
    * @post screen 2 components are no longer visible on the screen
    */
    public static void removeScreen2()
    {
        screen.remove(nextBtn);
        screen.remove(menuBtn);
        screen.remove(newspaper);
        screen.revalidate();
        screen.repaint();
    }

    // sets up all of the elements that are to be on screen 3
    public static void setUpScreen3()
    {
        screen.setUpButton(cameraBtn);
        screen.setUpButtonFunctionS(cameraBtn, 4);
        screen.setUpLabel(door.getDoorOpen());
        screen.setUpButton(lightBtn);
        screen.setUpButtonFunctionD(lightBtn, 2);
        screen.setUpButton(doorBtn);
        screen.setUpButtonFunctionD(doorBtn, 1);
        screen.setUpLabel(officeImg);
        screen.setVisibility();
        
    }

    // removes all of the elements that are on screen 3
    public static void removeScreen3()
    {
        screen.remove(cameraBtn);
        screen.remove(officeImg);
        screen.remove(door.getDoorOpen());
        screen.remove(door.getDoorClosed());
        screen.remove(door.getDoorLit());
        screen.remove(lightBtn);
        screen.remove(doorBtn);
        screen.revalidate();
        screen.repaint();
    }

    // kills the player if any of the animatronics succeed on their movement attempts,
    // and also pulls the camera up so the player can see their surroundings
    public static void setUpCamera()
    {
        if (rioux.moves() || chenjie.moves() || ansh.moves() || pres.moves())
        {
            System.exit(0);
        }
        screen.remove(officeImg);
        screen.remove(door.getDoorOpen());
        screen.remove(door.getDoorClosed());
        screen.remove(door.getDoorLit());
        screen.remove(lightBtn);
        screen.remove(doorBtn);
        screen.setUpButton(cameraChanger);
        screen.setUpButtonFunctionS(cameraChanger, 5);
        if (mrVest.getCameraFloorNumber() == 1)
        {
            addFloorOneCameras();
            screen.setUpLabel(cameraImg1);
        }
        else
        {
            addFloorTwoCameras();
            screen.setUpLabel(cameraImg2);
        }
        screen.revalidate();
        screen.repaint();
    }

    // pulls the camera down so the player can see the office
    public static void unSetUpCamera()
    {
        screen.remove(cameraImg1);
        removeFloorOneCameras();
        removeFloorOneCamImgs();
        screen.remove(cameraImg2);
        removeFloorTwoCameras();
        removeFloorTwoCamImgs();
        screen.remove(cameraChanger);
        screen.setUpLabel(door.getDoorOpen());
        screen.setUpButton(lightBtn);
        screen.setUpButton(doorBtn);
        screen.setUpLabel(officeImg);
        screen.revalidate();
        screen.repaint();
    }

    // allows the user to see the cameras on the first and second floor
    public static void changeCameraFloor()
    {
        if (cameraChanger.getText().equals("Floor 1"))
        {
            cameraChanger.changeName("Floor 2");
            screen.remove(cameraImg1);
            removeFloorOneCameras();
            addFloorTwoCameras();
            screen.setUpLabel(cameraImg2);
            mrVest.setCameraFloorNumber(2);
        }
        else
        {
            cameraChanger.changeName("Floor 1");
            screen.remove(cameraImg2);
            removeFloorTwoCameras();
            addFloorOneCameras();
            screen.setUpLabel(cameraImg1);
            mrVest.setCameraFloorNumber(1);
        }
        screen.revalidate();
        screen.repaint();
    }

    public static void addFloorOneCameras()
    {
        screen.setUpButton(camera1a);
        screen.setUpButtonFunctionC(camera1a, 1);
        screen.setUpButton(camera2a);
        screen.setUpButtonFunctionC(camera2a, 2);
        screen.setUpButton(camera3a);
        screen.setUpButtonFunctionC(camera3a, 3);
    }

    public static void removeFloorOneCameras()
    {
        screen.remove(camera1a);
        screen.remove(camera2a);
        screen.remove(camera3a);
    }

    public static void removeFloorOneCamImgs()
    {
        screen.remove(camera1aImg);
        screen.remove(camera2aImg);
        screen.remove(camera3aImg);
    }

    public static void addFloorTwoCameras()
    {
        screen.setUpButton(camera1b);
        screen.setUpButtonFunctionC(camera1b, 4);
        screen.setUpButton(camera2b);
        screen.setUpButtonFunctionC(camera2b, 5);
    }

    public static void removeFloorTwoCameras()
    {
        screen.remove(camera1b);
        screen.remove(camera2b);
    }
    
    public static void removeFloorTwoCamImgs()
    {
        screen.remove(camera2bImg);
        screen.remove(camera1bImg);
    }

    public static void cam1a()
    {
        screen.setUpLabel(camera1aImg);
        screen.revalidate();
        screen.repaint();
    }

    public static void cam2a()
    {
        screen.setUpLabel(camera2aImg);
        screen.revalidate();
        screen.repaint();
    }

    public static void cam3a()
    {
        screen.setUpLabel(camera3aImg);
        screen.revalidate();
        screen.repaint();
    }

    public static void cam1b()
    {
        screen.setUpLabel(camera1bImg);
        screen.revalidate();
        screen.repaint();
    }

    public static void cam2b()
    {
        screen.setUpLabel(camera2bImg);
        screen.revalidate();
        screen.repaint();
    }

    public static void closeDoor()
    {
        screen.remove(door.getDoorLit());
        screen.remove(door.getDoorOpen());
        screen.setUpLabel(door.getDoorClosed());
        screen.revalidate();
        screen.repaint();
    }

    public static void openDoor()
    {
        screen.remove(door.getDoorLit());
        screen.remove(door.getDoorClosed());
        screen.setUpLabel(door.getDoorOpen());
        screen.revalidate();
        screen.repaint();
    }
    
    public static void lightDoor()
    {
        screen.remove(door.getDoorOpen());
        screen.remove(door.getDoorClosed());
        screen.setUpLabel(door.getDoorLit());
        screen.revalidate();
        screen.repaint();
    }

    public static void unlightDoor()
    {
        screen.remove(door.getDoorOpen());
        screen.remove(door.getDoorClosed());
        screen.setUpLabel(door.getDoorLit());
        screen.revalidate();
        screen.repaint();
    }

    // sets a game timer that ticks every second until the player wins the game
    public static void gameTimer()
    {
        Timer timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timePerNight--;

                if (timePerNight <= 0)
                {
                    mrVest.incrementNightNumber();
                    removeScreen3();
                    setUpScreen1();
                    ((Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
    }
}
