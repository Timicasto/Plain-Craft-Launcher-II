package timicasto.pcl;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGOMDocument;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.dom.svg.SVGDocumentFactory;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.gvt.renderer.ConcreteImageRendererFactory;
import org.apache.batik.gvt.renderer.ImageRenderer;
import org.apache.batik.gvt.renderer.ImageRendererFactory;
import org.apache.batik.util.gui.xmleditor.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.svg.SVGDocument;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
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
    public static final long ANIMATION_LENGTH = 333;

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
        c1.setIcon(new ImageIcon(genCheckBoxIcon(false)));
        main.add(c1);
        c1.addItemListener(e ->  {
            // TODO Animation
            /*c1.setIcon(c1.isSelected() ? new ImageIcon(genCheckBoxIcon(true)) : new ImageIcon(genCheckBoxIcon(false)));
            ((Runnable) () -> {
                long time = System.currentTimeMillis();
                while (time < ANIMATION_LENGTH) {
                    long tempTime = System.currentTimeMillis();
                    if (tempTime != time) {
                        time = tempTime;

                    }
                }
            }).run();*/
        });
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
        JCheckBox c2 = new JCheckBox("Checkbox");
        c2.setBounds(33, 85, 198, 25);
        c2.setIcon(new ImageIcon(genCheckBoxIcon(false)));
        main.add(c2);
        c2.addItemListener(e -> {
            c2.setIcon(c2.isSelected() ? new ImageIcon(genCheckBoxIcon(true)) : new ImageIcon(genCheckBoxIcon(false)));

        });
        c2.addMouseListener(new MouseListener() {
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
                c2.setForeground(new Color(0x2271FF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c2.setForeground(new Color(0));
            }
        });
        JCheckBox c3 = new JCheckBox("Checkbox");
        c3.setBounds(33, 115, 198, 30);
        c3.setIcon(new ImageIcon(genCheckBoxIcon(false)));
        main.add(c3);
        c3.addItemListener(e -> c3.setIcon(c3.isSelected() ? new ImageIcon(genCheckBoxIcon(true)) : new ImageIcon(genCheckBoxIcon(false))));
        c3.addMouseListener(new MouseListener() {
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
                c3.setForeground(new Color(0x2271FF));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                c3.setForeground(new Color(0));
            }
        });
        JButton btnX = new JButton("x");
        btnX.setBounds(580, 40, 60, 60);
        main.add(btnX);
        btnX.addActionListener(e -> System.exit(0));
        JLabel label = new JLabel("大概，只能勾复选框玩......");
        label.setBounds(171, 262, 403, 104);
        label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        main.add(label);
        startup.dispose();
        c1.setBackground(new Color(0xFFFFFF));
        c2.setBackground(new Color(0xFFFFFF));
        c3.setBackground(new Color(0xFFFFFF));
        main.setVisible(true);
        main.getContentPane().setBackground(new Color(0xFFFFFF));
        startup.setVisible(false);
    }

    public static BufferedImage genCheckBoxIcon(boolean isSelected) {
        BufferedImage ret = new BufferedImage(18, 18, BufferedImage.TYPE_INT_ARGB);
        if (!isSelected) {
            Graphics2D g = ret.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(71, 71, 71));
            g.fill(new RoundRectangle2D.Float(0, 0, 18, 18, 4, 4));
            g.setColor(new Color(0xffffff));
            g.fill(new Rectangle2D.Float(2, 2, 14, 14));
            g.dispose();
        } else {
            Graphics2D g = ret.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(0x2271FF));
            g.fill(new RoundRectangle2D.Float(0, 0, 18, 18, 4, 4));
            g.setColor(new Color(0xffffff));
            g.fill(new Rectangle2D.Float(2, 2, 14, 14));
            g.setColor(new Color(0x2271FF));
            g.drawImage(renderCheckBox(), 3, 3, null);
            g.dispose();
        }
        return ret;
    }

    public static BufferedImage renderCheckBox() {
        ImageRendererFactory factory;
        factory = new ConcreteImageRendererFactory();
        ImageRenderer renderer = factory.createStaticImageRenderer();
        GVTBuilder builder = new GVTBuilder();
        BridgeContext ctx = new BridgeContext(new UserAgentAdapter());
        ctx.setDynamicState(BridgeContext.STATIC);
        SVGDocument document = null;
        try {
            document = new SAXSVGDocumentFactory("org.apache.xerces.parsers.SAXParser").createSVGDocument("./PCL/Checkbox.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphicsNode root = builder.build(ctx, document);
        renderer.setTree(root);
        float docWidth = (float)ctx.getDocumentSize().getWidth();
        float docHeight = (float) ctx.getDocumentSize().getHeight();
        float xScale = 12 / docWidth;
        float yScale = 12 / docHeight;
        AffineTransform px = AffineTransform.getScaleInstance(xScale, yScale);
        double tx = -0 + (12 / xScale - docWidth) / 2;
        double ty = -0 + (12 / yScale - docHeight) / 2;
        px.translate(tx, ty);
        renderer.updateOffScreen(12, 12);
        renderer.setTree(root);
        renderer.setTransform(px);
        renderer.repaint(new Rectangle(0, 0, 12, 12));
        return renderer.getOffScreen();
    }
}
