import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Player{
    public int x;
    public int y;
    public int width;
    public int height;

    public int i_jump;
    public int i_jump_count;
    public int def_y;
    public Image sprite;
    public int jumping;

    public int speed;

    Player(int x, int y, int width, int height)
    {
        this.sprite = new ImageIcon("grafika/player.png").getImage();
        this.x = x;
        this.y = y;
        this.def_y = y;
        this.width = width;
        this.height = height;
        this.speed =8;
        this.i_jump_count=30;
    }
    public void jump(){
        if(this.jumping ==1  )
        {
            if(this.i_jump<this.i_jump_count ) {
                this.i_jump++;
                this.y -= this.speed;
            }
            else
            {
                this.jumping = 2;
            }
        }
        else if(this.jumping == 2)
        {
            if(this.y <this.def_y)
            {
                this.y += this.speed;
            }
            else
            {
                this.jumping = 0;
            }
        }
    }
    public void moving(boolean controls[])
    {
        if(controls[0] && this.jumping==0)
        {
            this.i_jump=0;
            this.jumping = 1;
        }
    }
    public void update()
    {
        jump();

    }

    public void draw(Graphics2D g2D)
    {
        g2D.drawImage(this.sprite, this.x, this.y, this.width, this.height,null);

    }


}
