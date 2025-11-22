import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MyFrame extends JFrame implements ActionListener{

    private JLabel label;
private JButton refresh;
// list of text files to cycle through*
private String[] eventFiles = { "event1.txt", "event2.txt", "event3.txt", "event4.txt", "event5.txt", "event6.txt", "event7.txt", "event8.txt", "event9.txt", "event10.txt", "event11.txt", "event12.txt", "event13.txt", "event14.txt", "event15.txt" };
//Everything in the Event files are made bymyself and are fictional senerios that were NOT made with ChatGPT or any other AI tool (other that the outo fill feature in Vs)
// tracks which file you're on*
private int currentEvent = 0;
// label for displaying the event text*
private JLabel eventLabel;



    public MyFrame() {

        // Frame setup
        this.setTitle("RBHS Community Events");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(670, 670);

        ImageIcon image = new ImageIcon("logoTwo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x64676E));
        this.setLayout(null); // manual layout


        // Label creation
        label = new JLabel("The Unofficial RBHS Community Post");
        label.setBounds(85, 60, 500, 80); //the positioning for the label
        this.add(label);


        // Label image (scaled)
        ImageIcon Title = new ImageIcon("CommunityPostText.png");
        Image scaledImage = Title.getImage().getScaledInstance(500, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);


        // Label appearance
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); //undo if you want a border
        label.setHorizontalTextPosition(JLabel.CENTER); //Sets text LEFT CENTER OR RIGHT of image
        label.setVerticalTextPosition(JLabel.BOTTOM);       //Sets text TOP CENTER OR BOTTOM of image
        label.setForeground(new Color(0x333333));
        label.setFont(new Font("Impact", Font.PLAIN, 20)); //sets font
        label.setIconTextGap(-13);                         //Sets gap between text and image
        label.setBackground(new Color(0x9EA3AD));
        label.setOpaque(true);                           //display background color
        label.setBorder(border); //undo if you want a border
        label.setVerticalAlignment(JLabel.CENTER);       //Sets vertical position of content within label
        label.setHorizontalAlignment(JLabel.CENTER);     //Sets horizontal position of content within label


        //Button
        refresh = new JButton();
        refresh.setBounds(270, 150, 130, 40);
        refresh.setText("Refresh");
        refresh.setFocusable(false);
        refresh.setFont(new Font("Arial", Font.PLAIN, 16));
        refresh.setBackground(new Color(0xCCCCCC));
        refresh.setForeground(Color.BLACK);
        refresh.addActionListener(this);
        this.add(refresh);
//button fucionality
        //...to be added later
// event display label*
eventLabel = new JLabel();
eventLabel.setBounds(50, 250, 570, 300); // adjust if needed
eventLabel.setForeground(Color.WHITE);
eventLabel.setBackground(new Color(0x9EA3AD));//sets the grey background
eventLabel.setOpaque(true);
eventLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); //for the border
eventLabel.setVerticalAlignment(JLabel.TOP);
eventLabel.setHorizontalAlignment(JLabel.LEFT);
this.add(eventLabel);

// load first event file*
loadEventFromFile(eventFiles[currentEvent]);

        // Finalize frame
        this.setVisible(true);
    }
    @Override
public void actionPerformed(ActionEvent e){
    if(e.getSource() == refresh){
        System.out.println("Refreshed");
        currentEvent = (int)(Math.random() * eventFiles.length); // move to next file
loadEventFromFile(eventFiles[currentEvent]);           // show next event
System.out.println("Loaded: " + eventFiles[currentEvent]);

        }

    }
// loads full text from a .txt file*
private void loadEventFromFile(String fileName) {
    try {
        java.util.Scanner sc = new java.util.Scanner(new java.io.File(fileName));
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append("\n");
        }
        sc.close();

        // JLabel multi-line support
        eventLabel.setText("<html>" + sb.toString().replace("\n", "<br>") + "</html>");

    } catch (Exception ex) {
        eventLabel.setText("Could not load " + fileName);
        }
    }
}
