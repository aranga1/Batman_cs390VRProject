
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;


public class CatanServer  {
	
	ServerSocket server;
    PrintWriter writer = new PrintWriter(System.out);
    private static BufferedImage bi;
    Polygon[] polygons = new Polygon[19];


    public CatanServer ( int port ) throws SocketException, IOException {
        if ((port > 1025) && (port < 65535)) {
            this.server = new ServerSocket(port);
            server.setReuseAddress(true);
        } else {
            writer.println("Invalid port number! The port number has to be between 1025 and 65535");
            writer.flush();
        }
    }
    public CatanServer() throws SocketException, IOException {
        this.server = new ServerSocket(9999);
        writer.println("Assigned port: " + server.getLocalPort());
        writer.flush();
        server.setReuseAddress(true);

    }
    private static void loadImage() throws IOException{
        bi = ImageIO.read(new File("unnamedjpg"));
    }
    public static void startFrame() {
    	JFrame frame = new JFrame("Welcome");
        	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	JButton button = new JButton("Start Game");
        	//button.setSize(680, 10);
			ImageIcon imageIcon = new ImageIcon("unnamed.jpg");
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(680, 400,  java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			JLabel label = new JLabel(imageIcon);
        	// Define ActionListener
        	ActionListener actionListener = new ActionListener() {
         		public void actionPerformed(ActionEvent actionEvent) {
            		System.out.println("Game Started.");
            		frame.setVisible(false);
            		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            		catanBoard();

            	} 
            };
        	// Attach listeners
        	button.addActionListener(actionListener);
        	frame.setLayout(new GridBagLayout());
        	GridBagConstraints c = new GridBagConstraints();

        	//frame.setVgap(20);
        	//BorderLayout.setVgap(20);
        	c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 0;
        	frame.add(label, c);
        	c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridwidth = 3;
			c.gridx = 1;
			c.gridy = 1;
        	frame.add(button, c);
 			frame.pack();
            frame.setLocationRelativeTo(null);
        	frame.setSize(screenSize.width, screenSize.height);
        	frame.setVisible(true);

    }
    
    public static void catanBoard() {
		JFrame frame = new JFrame();
		//JPanel panel = new JPanel();
        frame.setTitle("Catan");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*CatanBoard board = new CatanBoard();
        Container contentPane = frame.getContentPane();
        contentPane.add(board);
        frame.add(contentPane);*/
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
        //CatanBoard board = new CatanBoard();

    }
    public static void main(String[] args) {
    	Runnable runner = new Runnable() {
      	public void run() {
      		startFrame();
        	
		} };
   		EventQueue.invokeLater(runner);	
    }
    
}