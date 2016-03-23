import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JApplet;
import javax.swing.JPanel;

import java.net.*;
import java.io.*;
import java.util.*;

public class CatanGameBoard extends JPanel implements Runnable { 

    static Dimension screenSize;
    Polygon[] polygons = new Polygon[19];
    ServerSocket server;
    PrintWriter writer = new PrintWriter(System.out);

    public CatanGameBoard ( int port ) throws SocketException {
        if ((port > 1025) && (port < 65535)) {
            this.server = new ServerSocket(port);
            server.setReuseAddress(true);
        } else {
            writer.println("Invalid port number! The port number has to be between 1025 and 65535");
            writer.flush();
        }
    }
    public CatanGameBoard() throws SocketException {
        this.server = new ServerSocket(9999);
        writer.println("Assigned port: " + server.getLocalPort());
        writer.flush();
        server.setReuseAddress(true);

    }

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        polygons[0] = makeHexagon(0, 400 * Math.sin(Math.PI/3));

        for (int i = 0; i < 2; i++) {
            polygons[i + 1] = makeHexagon(-150 + i * 300, 300 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 3] = makeHexagon(-300 + i * 300, 200 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 6] = makeHexagon(-150 + i * 300, 100 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 8] = makeHexagon(-300 + i * 300,0);
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 11] = makeHexagon(-150 + i * 300, -100 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 3; i++) {
            polygons[i + 13] = makeHexagon(-300 + i * 300, -200 * Math.sin(Math.PI/3));
        }

        for (int i = 0; i < 2; i++) {
            polygons[i + 16] = makeHexagon(-150 + i * 300, -300 * Math.sin(Math.PI/3));
        }

        polygons[18] = makeHexagon(0, -400 * Math.sin(Math.PI/3));

        for (int j = 0; j < 19; j++) {
            g.drawPolygon(polygons[j]);
        }
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
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = new Container();
        //panel = frame.getContentPane();
        //contentPane.add(new CatanGameBoard());
        JScrollPane scrollPane = new JScrollPane( new CatanGameBoard()); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        //scrollPane.setHorizontalScrollBar(scrollPane.createHorizontalScrollBar());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        //scrollPane.setVerticalScrollBar(scrollPane.createVerticalScrollBar());
        frame.getContentPane().add("Center", scrollPane); 
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
        frame.show();
    }
}