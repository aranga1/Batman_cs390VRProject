import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatanGameBoard extends JPanel { 
    static Dimension screenSize;  

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Polygon p1 = new Polygon();

        for (int i = 0; i < 6; i++) {
            p1.addPoint((int) (screenSize.width/2 + 50 * Math.cos(i * 2 * Math.PI / 6)),
          (int) ((screenSize.height/2- 20) + 50 * Math.sin(i * 2 * Math.PI / 6)));
        }

    g.drawPolygon(p1);


	}


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Catan");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();
        contentPane.add(new CatanGameBoard());


        frame.show();
    }


}