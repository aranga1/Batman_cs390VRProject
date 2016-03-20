import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CatanGameBoard extends JPanel {

	public void baseBoard(Graphics g) {
	}

	private static void makeFrameFullSize(JFrame aFrame){
 		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 		aFrame.setSize(screenSize.width, screenSize.height);
	}

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("DrawPoly");
        makeFrameFullSize(frame);
        //frame.setSize(1000, 1000);
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