import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Main extends JFrame{
    private Timer timer;
    //public InfoMenu infoMenu; // Deklaracja menu z zasadami
    //public SelectionMenu selectionMenu; // Deklaracja menu wyboru poziomu trudności
    public Game game; // Deklaracja pozycji, w której dzieje się akcja gry
    public boolean controls[];
    class Loop extends TimerTask {


        public void run() {
            if (game.init) {
                game.update(controls);
                repaint();
            }
        }
    }

    Main(){
        super("Runner"); //Napis na okienku
        setMinimumSize(new Dimension(1286,1056));
        setMaximumSize(new Dimension(1286,1056));
        setPreferredSize(new Dimension(1286,1056)); // Wymiary okienka
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Możliwość wyłączenia programu przez krzyżyk
        setResizable(false); //Zablokowanie możliwości rozciągania okienka
        setVisible(true);
        createBufferStrategy(2);
        //this.selectionMenu = new SelectionMenu();
        //this.infoMenu = new InfoMenu();
        this.game = new Game(1280,1024);
        controls = new boolean[4];
        timer = new Timer();
        timer.scheduleAtFixedRate(new Loop(),0,1000/60);
        this.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        controls[0] = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        controls[1] = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        controls[2] = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        controls[3] = true;
                        break;


                }
            }

            public void keyReleased(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        controls[0] = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        controls[1] = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        controls[2] = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        controls[3] = false;
                        break;
                }
            }

            public void keyTyped(KeyEvent e) {
            }
        });
        getContentPane().addMouseListener(new MouseE(){ //Obsługa kliknięć myszy

            public void mouseClicked(MouseEvent e)
            {
                game.click(e.getX(), e.getY());

                //Wywołanie funkcji opowiedzialnej za rysowanie
                repaint();
            }
            public void mousePressed(MouseEvent e)
            {

                    game.press(e.getX(), e.getY());

                //Wywołanie funkcji opowiedzialnej za rysowanie
                repaint();
            }
        });

        getContentPane().addMouseMotionListener(new MouseE(){
            public void mouseMoved (MouseEvent e)
            {

                game.move(e.getX(), e.getY());

                repaint();
            }
        });
    }

    public static void main(String[] args)
    {
        Main window = new Main();
        window.repaint();
    }

    public void paint(Graphics g)
    {

        BufferStrategy bstrategy = this.getBufferStrategy();
        Graphics2D g2D = (Graphics2D)bstrategy.getDrawGraphics();
        //Zmiana punktu (0,0)
        g2D.translate(3,32);
        this.game.draw(g2D);
        g2D.dispose();
        bstrategy.show();

    }
}


