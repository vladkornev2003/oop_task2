import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;


public class Java2d_MainPanel extends JPanel{
    //private static BufferedImage img = new BufferedImage();
    private JButton knapp = new JButton("Nytt bilde");
    private JButton knapp2 = new JButton("Nytt bilde2");
    //private static BufferedImage img2 = new BufferedImage();
    //coordinates for image 1
    private int x1 = 0;
    private int y1 = 0;
    //coordinates for image 2
    private int x2 = 50;
    private int y2 = 50;

    public Java2d_MainPanel(){
        add(knapp);
        add(knapp2);
        knapp.addActionListener(new ButtonHandler());
        knapp2.addActionListener(new ButtonHandler2());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void newImage(ActionEvent e){
        if(e.getSource().equals(knapp)){
            //img = new logic.GetBufferedImage().getImage();
            repaint();
        }
        else if(e.getSource().equals(knapp2)){
            //img2 = new logic.GetBufferedImage().getImage2();
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        newPaint(g2d);
    }
    public void newPaint(Graphics2D g2d){
        /*g2d.drawImage(img, x1, y1, null);
        g2d.drawImage(img2, x2, y2,null);*/
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rabbits");
        frame.add(new Java2d_MainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 640);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    class MouseMotionHandler extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {

            x1 = e.getX()-(img.getWidth()/2);
            y1 = e.getY()-(img.getHeight()/2);
            repaint();
        }
    }
    class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            newImage(e);
        }

    }
    class ButtonHandler2 implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            newImage(e);
        }

    }
}

