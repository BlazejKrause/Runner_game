
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Button {
    public int x;
    public int y;
    public int width;
    public int height;
    public String text;
    public Image sprite = (new ImageIcon("grafika/button.png")).getImage();
    Button(int x, int y, int width, int height, String text)
    {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public boolean clicked(int x, int y)
    {
        if(x >=this.x && x<=this.x+this.width && y>=this.y && y<=this.y+this.height)
        {
            return true;

        }
        else
        {
            return false;
        }

    }
    public void hovered(int x, int y)
    {
        if(x >=this.x && x<=this.x+this.width && y>=this.y && y<=this.y+this.height)
        {
            this.sprite = (new ImageIcon("grafika/buttonHovered.png")).getImage();

        }
        else
        {
            this.sprite = (new ImageIcon("grafika/button.png")).getImage();
        }

    }
    public void pressed(int x, int y)
    {
        if(x >=this.x && x<=this.x+this.width && y>=this.y && y<=this.y+this.height)
        {
            this.sprite = (new ImageIcon("grafika/buttonPressed.png")).getImage();

        }
        else
        {
            this.sprite = (new ImageIcon("grafika/button.png")).getImage();
        }

    }
    public void draw(Graphics2D g2D)
    {
        //rysowanie obrazka
        g2D.drawImage(this.sprite, this.x, this.y, this.width, this.height,null);
        //ustawienie koloru
        g2D.setColor(Color.BLACK);
        //Ustawienie czcionki
        g2D.setFont(new Font("Arial",Font.BOLD,20));
        //Wypisanie Tekstu
        g2D.drawString(text,x+5,y+45);
    }
}
