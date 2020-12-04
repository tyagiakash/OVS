package login;

import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {

    private Image img;
    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }
    public ImagePanel(Image img) {
        setPreferredSize(new Dimension(400,300));
        this.img = img;
//        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
//        setPreferredSize(size);
//        setMinimumSize(size);
//        setMaximumSize(size);
//        setSize(size);
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g) {
//        g.drawImage(img, 0, 0, null);
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),null);

    }
}