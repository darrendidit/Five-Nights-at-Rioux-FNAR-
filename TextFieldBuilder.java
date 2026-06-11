import javax.swing.JTextField;

/** 
* A custom JTextField class that allows for the easy changing,
* access, intialization of JTextField objects
*/
public class TextFieldBuilder extends JTextField
{
    private int columns;
    private int width;
    private int height;
    private int x_axis;
    private int y_axis;

    public TextFieldBuilder(int columns, int x_axis, int y_axis, int width, int height)
    {
        super(columns);
        this.setBounds(x_axis, y_axis, width, height);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.width = width;
        this.height = height;
    }

    /** 
    * returns the colums of the text field
    *
    * @return the colums of the text field 
    * @pre none
    * @post tells us approx. how many characters the text field can handle
    */
    public int getColums()
    {
        return columns;
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
    * returns the x value of the label
    *
    * @return the x value of the label in pixels
    * @pre none
    * @post returns the current x value of the label
    */
    public int getXAxis()
    {
        return x_axis;
    }

    /** 
    * returns the y value of the label
    *
    * @return the y value of the label in pixels
    * @pre none
    * @post returns the current y value of the label
    */
    public int getYAxis()
    {
        return y_axis;
    }

    /** 
    * returns the text in the text field
    *
    * @return current text that is entered in the text field
    * @pre none
    * @post returns the current text that is inputed in the text field
    */
    public String acquireText()
    {
        return this.getText();
    }

    /** 
    * changes the colums in the text field
    * @pre colums > 0
    * @post changes the colums to the given parameter ammount
    */
    public void changeColumns(int columns)
    {
        this.setColumns(columns);
    }

    /** 
    * changes the bounds of the text field
    * @pre x_axis, y_axis, width, and height are all > 0
    * @post changes the dimensions of the text field to the provided parameters
    */
    public void changeBounds(int x_axis, int y_axis, int width, int height)
    {
        this.setBounds(x_axis, y_axis, width, height);
        this.width = width;
        this.height = height;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }
}
