import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import static java.lang.Math.abs;
import java.util.Random;

public class Game {
    public Button exitButton;
    public Button startButton;
    public Image background;

    public int width;
    public int height;
    public boolean finish;
    public boolean init;
    public Player player;
    public Road road;
    Game(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.exitButton = new Button(1000, 900,130,60,"Wyjdź");
        this.startButton = new Button(200, 900,130,60,"Start");
        this.background = new ImageIcon("grafika/background.png").getImage();

        this.road = new Road(0,this.height-400,this.width, 50);
        this.player = new Player(50,this.height-500,100,100);
        this.init = false;
    }

    public void prepare()
    {
        this.road = new Road(0,this.height-400,this.width, 50);
        this.player = new Player(50,this.height-500,100,100);
        this.init = true;
    }

    public void update(boolean controls[])
    {
        if(this.init)
        {
            this.player.moving(controls);
            this.player.update();

        }
    }
    public void click(int x, int y)
    {
        //kolizja z przyciskiem wyjścia
        if(exitButton.clicked(x,y))
        {
            quit();
        }
        else if(startButton.clicked(x,y))
        {
            this.prepare();
        }

    }
    public void move(int x, int y)
    {

        this.exitButton.hovered(x,y);
        this.startButton.hovered(x,y);

    }
    public void press(int x, int y)
    {

        this.exitButton.pressed(x,y);
        this.startButton.pressed(x,y);

    }
    //Czyszczenie wszelkich danych związanych z poziomem przed wyjściem
    public void quit()
    {

        System.exit(0);
    }
    public void draw(Graphics2D g2D)
    {
        g2D.setColor(Color.white);
        g2D.drawImage(this.background, 0, 0, this.width, this.height, (ImageObserver)null);

        this.road.draw(g2D);
        this.player.draw(g2D);
        startButton.draw(g2D);
        exitButton.draw(g2D);
    }
}

