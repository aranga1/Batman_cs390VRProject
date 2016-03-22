import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JPanel;

public class CatanGameBoard extends JPanel { 
    static Dimension screenSize;
    Polygon[] polygons = new Polygon[19];

	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.translate( screenSize.width/2, screenSize.height/2);
        /*
        Polygon p1 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p1.addPoint((int) (screenSize.width/2 + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p1);
        polygons[0] = p1;

        Polygon p2 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p2.addPoint((int) ((screenSize.width/2 + 150) + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 + 100*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p2);
        polygons[1] = p2;

        Polygon p3 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p3.addPoint((int) ((screenSize.width/2 - 150) + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 - 100*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p3);
        polygons[2] = p3;

        Polygon p4 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p4.addPoint((int) ((screenSize.width/2 - 150) + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 + 100*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p4);
        polygons[3] = p4;

        Polygon p5 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p5.addPoint((int) ((screenSize.width/2 + 150) + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 - 100*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p5);
        polygons[4] = p5;

        Polygon p6 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p6.addPoint((int) (screenSize.width/2 + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 + 200*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p6);
        polygons[5] = p6;

        Polygon p7 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p7.addPoint((int) (screenSize.width/2 + 100 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2 - 200*Math.sin(Math.PI / 3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }
        g.drawPolygon(p7);
        polygons[6] = p7;

        Polygon p8 = new Polygon();
        for (int i = 0; i < 6; i++)
            p8.addPoint((int) ((screenSize.width/2 + 300) + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (screenSize.height/2 + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p8);
        polygons[7] = p8;

        Polygon p9 = new Polygon();
        for (int i = 0; i < 6; i++)
            p9.addPoint((int) ((screenSize.width/2 - 150) - 150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) (screenSize.height/2 + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p9);
        polygons[8] = p9;

        Polygon p10 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p10.addPoint((int) (screenSize.width/2 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 - 4 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }

        g.drawPolygon(p10);
        polygons[9] = p10;

        Polygon p11 = new Polygon();
        for (int i = 0; i < 6; i++) {
            p11.addPoint((int) (screenSize.width/2 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + 4 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));
        }

        g.drawPolygon(p11);
        polygons[10] = p11;

        Polygon p12 = new Polygon();
        for (int i = 0; i < 6; i++)
            p12.addPoint((int) (screenSize.width/2 + 300 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + 2 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p12);
        polygons[11] = p12;

        Polygon p13 = new Polygon();
        for (int i = 0; i < 6; i++)
            p13.addPoint((int) (screenSize.width/2 + 300 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 - 2 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p13);
        polygons[12] = p13;

        Polygon p14 = new Polygon();
        for (int i = 0; i < 6; i++)
            p14.addPoint((int) ((screenSize.width/2 - 150) - 150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + 2 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p14);
        polygons[13] = p14;

        Polygon p15 = new Polygon();
        for (int i = 0; i < 6; i++)
            p15.addPoint((int) ((screenSize.width/2 - 150) - 150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 - 2 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p15);
        polygons[14] = p15;

        Polygon p16 = new Polygon();
        for (int i = 0; i < 6; i++)
            p16.addPoint((int) (screenSize.width/2 + 150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + 3 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p16);
        polygons[15] = p16;

        Polygon p17 = new Polygon();
        for (int i = 0; i < 6; i++)
            p17.addPoint((int) (screenSize.width/2 + 150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 - 3 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p17);
        polygons[16] = p17;

        Polygon p18 = new Polygon();
        for (int i = 0; i < 6; i++)
            p18.addPoint((int) (screenSize.width/2 -150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + 3 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p18);
        polygons[17] = p18;

        Polygon p19 = new Polygon();
        for (int i = 0; i < 6; i++)
            p19.addPoint((int) (screenSize.width/2 -150 + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 - 3 * 50 * Math.sqrt(3)) + 100 * Math.sin(i * 2 * Math.PI / 6)));

        g.drawPolygon(p19);
        polygons[18] = p19;
        */

        polygons[0] = makeHexagon(0, 200 * Math.sin(Math.PI/3));
        g.drawPolygon(polygons[0]);
	}

    public static Polygon makeHexagon(double x, double y) {
        Polygon p = new Polygon();
        for (int i = 0; i < 6; i++)
            p.addPoint((int) (screenSize.width/2 + x + 100 * Math.cos(i * 2 * Math.PI / 6)),
                    (int) ((screenSize.height/2 + y + 100 * Math.sin(i * 2 * Math.PI / 6))));
        return p;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel();
        frame.setTitle("Catan");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = new Container();
        //panel = frame.getContentPane();
        //contentPane.add(new CatanGameBoard());
        JScrollPane scrollPane = new JScrollPane(new CatanGameBoard()); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        frame.getContentPane().add(scrollPane);        
        frame.show();
    }


}