package timicasto.pcl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class Main {
    public static long startTime;
    public static final Logger startupLogger = Logger.getLogger("startup");

    public static void main(String[] args) throws IOException {
        startup();
    }

    public static void startup() throws IOException {
        startTime = System.currentTimeMillis();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        File current = new File("./");
        if (!current.canWrite()) {
            startupLogger.severe("PCL2 没有对当前目录的写入权，程序将退出");
            System.exit(4);
        }
        File pcl = new File("./PCL");
        pcl.mkdir();

        FileHandler handler = new FileHandler("./PCL/latest.log");
        handler.setFormatter(new SimpleFormatter());
        startupLogger.addHandler(handler);
        if (!pcl.canWrite()) {
            startupLogger.severe("PCL2 没有对PCL目录的写入权，程序将退出");
        }
        File musics = new File("./PCL/Musics");
        musics.mkdir();
        File pictures = new File("./PCL/Pictures");
        pictures.mkdir();
        File temp = new File("./PCL/Temp");
        temp.mkdir();
        if (!temp.canWrite()) {
            startupLogger.severe("PCL2 没有对缓存目录的写入权，程序将退出");
            System.exit(4);
        }
        File download = new File("./PCL/Temp/Download");
        download.mkdir();
        File caches = new File("./PCL/Temp/Caches");
        caches.mkdir();
        String txt = "Plain Craft Launcher II\u3000";
        JFrame startup = new JFrame();
        startup.setSize(192, 192);
        startup.setUndecorated(true);
        Image image = ImageIO.read(new File("./PCL/Pictures/icon.png")).getScaledInstance(192, 192, Image.SCALE_AREA_AVERAGING);
        BufferedImage icon = new BufferedImage(192, 192, BufferedImage.TYPE_INT_ARGB);
        Graphics g = icon.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        JLabel ico = new JLabel();
        ico.setIcon(new ImageIcon(icon));
        ico.setBounds(0, 0, 192, 192);
        startup.add(ico);
        startup.setBackground(new Color(255, 255, 255, 0));
        startup.setLocationRelativeTo(null);
        startup.setVisible(true);
        startupLogger.info("Application Version: Dev 0.0.0");
        JFrame main = new JFrame("Plain Craft Launcher II");
        main.setUndecorated(true);
        main.setSize(850, 500);
        main.setLocationRelativeTo(null);
        main.setLayout(null);
        JCheckBox c1 = new JCheckBox("Checkbox");
        c1.setBounds(33, 55, 210, 30);
        main.add(c1);
        c1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                c1.setForeground(new Color(0x2271FF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c1.setForeground(new Color(0));
            }
        });
        JCheckBox c2 = new JCheckBox();
        c2.setBounds(33, 85, 198, 25);
        main.add(c2);
        JCheckBox c3 = new JCheckBox();
        c3.setBounds(33, 115, 198, 30);
        main.add(c3);
        JButton btnX = new JButton("x");
        btnX.setBounds(580, 40, 60, 60);
        main.add(btnX);
        btnX.addActionListener(e -> System.exit(0));
        JLabel label = new JLabel("大概，只能勾复选框玩......");
        label.setBounds(171, 262, 403, 104);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        main.add(label);
        startup.dispose();
        main.setVisible(true);
        startup.setVisible(false);
    }
}
