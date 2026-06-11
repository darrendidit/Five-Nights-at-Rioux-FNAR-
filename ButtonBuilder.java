import javax.swing.JButton;

/** 
* A custom JButton class that sets the bounds and name of
* the button on creation. Also has methods to alter certain things
* about it afterwards
*/
public class ButtonBuilder extends JButton
{
    private int width;
    private int height;
    private int x_axis;
    private int y_axis;
    private String name;

    public ButtonBuilder(int x_axis, int y_axis, int width, int height, String name)
    {
        super(name);
        this.setBounds(x_axis, y_axis, width, height);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    /** 
    * returns the width of the button
    *
    * @return the width of the button in pixels
    * @pre none
    * @post returns the current width of the button
    */
    public int getWidth()
    {
        return width;
    }

    /** 
    * returns the height of the button
    *
    * @return the height of the button in pixels
    * @pre none
    * @post returns the current height of the button
    */
    public int getHeight()
    {
        return height;
    }

    /** 
    * returns the x position of the button
    *
    * @return the x position of the button in pixels
    *         from the top left of the screen
    * @pre none
    * @post returns the current x-coordinate of the button
    */
    public int getXAxis()
    {
        return x_axis;
    }

    /** 
    * returns the y position of the button
    *
    * @return the y position of the button in pixels
    *         from the top left of the screen
    * @pre none
    * @post returns the current y-coordinate of the button
    */
    public int getYAxis()
    {
        return y_axis;
    }

    /** 
    * returns the text on the button
    *
    * @return the button text
    * @pre none
    * @post returns the text that is on the button
    */
    public String getName()
    {
        return super.getText();
    }

    /** 
    * changes the x, y, width, and height of the button
    * @pre x_axis, y_axis, width, and height > 0
    * @post changes the current button object to the specified dimensions
    */
    public void changeBounds(int x_axis, int y_axis, int width, int height)
    {
        this.setBounds(x_axis, y_axis, width, height);
        this.width = width;
        this.height = height;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    /** 
    * changes the name that is displayed on the button
    * @pre name != null
    * @post changes the name of the button object to the given name
    */
    public void changeName(String name)
    {
        this.setText(name);
    }

    @Override
    public String toString()
    {
        return "width: " + width + ", height: " + height + ", name: " + name + "\natcoordinates: " + x_axis + " , " + y_axis + ", displaying the text: " + super.getName();
    }
}
