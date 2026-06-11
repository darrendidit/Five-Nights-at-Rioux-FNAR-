import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

/** 
* A custom JLabel class that allows the easy editing
* and intialization of JLabels
*/
public class LabelBuilder extends JLabel
{
    private int width;
    private int height;
    private int x_axis;
    private int y_axis;
    private int fontSize;

    public LabelBuilder(int x_axis, int y_axis, int width, int height, String text, int fontSize)
    {
        super(text);
        this.setBounds(x_axis, y_axis, width, height);
        this.setFont(new Font("Arial", Font.PLAIN, fontSize));
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
    }

    public LabelBuilder(int x_axis, int y_axis, int width, int height, ImageIcon icon)
    {
        super(icon);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.width = width;
        this.height = height;
        this.setBounds(x_axis, y_axis, width, height);
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
    * returns the text on the label
    *
    * @return the label text
    * @pre none
    * @post returns the current text on the label
    */
    @Override
    public String getText()
    {
        return super.getText();
    }

    /** 
    * returns the font size of the label
    *
    * @return the font size
    * @pre none
    * @post returns the current size
    */
    public int getFontSize()
    {
        return fontSize;
    }

    /** 
    * changes the dimensions of the label
    * @pre x_axis, y_axis, width, and height are all > 0
    * @post changes the dimensions of the label to the provided parameters
    */
    public void setPlacement(int x_axis, int y_axis, int width, int height)
    {
        this.setBounds(x_axis, y_axis, width, height);
    }

    /** 
    * changes the text of the label
    * @pre text != null
    * @post changes the text of the label to the provided parameter
    */
    public void setNameOfText(String text)
    {
        super.setText(text);
    }

    /** 
    * changes the font size of the label
    * @pre fontSize > 0
    * @post changes the font size of the label to the provided parameter
    */
    public void setFontSize(int fontSize)
    {
        this.setFont(new Font("Arial", Font.PLAIN, fontSize));
    }
}
