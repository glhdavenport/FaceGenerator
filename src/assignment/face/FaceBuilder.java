package assignment.face;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FaceBuilder extends JFrame implements ActionListener
{
    private int eyesIndex = 0;
    private int mouthIndex = 0;
    private int noseIndex = 0;
    
    ImageIcon[] eyeImages;
    ImageIcon[] mouthImages;
    ImageIcon[] noseImages;
    
    JCheckBox eyes;
    JCheckBox nose;
    JCheckBox mouth;    
    
    DrawFace face;

    public FaceBuilder()
    {        
        JPanel menu;
        menu = new JPanel(new GridLayout(20,30));
        JLabel label = new JLabel("You Choose: ", JLabel.CENTER);
        eyes = new JCheckBox("Eyes");
        nose = new JCheckBox("Nose");
        mouth = new JCheckBox("Mouth");
        JButton update = new JButton("Update");
       
        face = new DrawFace();
        face.setBackground(Color.YELLOW);
        
        menu.add(label);
        menu.add(eyes);
        menu.add(nose);
        menu.add(mouth);
        menu.add(update);
        
        add(menu, BorderLayout.WEST);
        add(face, BorderLayout.CENTER);
     
        update.addActionListener(this); 
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index;
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        Color randomColor = new Color(red,green,blue);
        
        if (eyes.isSelected())
        {
            eyesIndex++;
            eyesIndex = getIndex(eyesIndex);
            face.currentEye = eyesIndex;
            //System.out.println("Button Eyes Clicked " + eyesIndex + " times");
        }
        
        if (mouth.isSelected())
        {
            mouthIndex++;
            mouthIndex = getIndex(mouthIndex);
            face.currentMouth = mouthIndex;
           // System.out.println("Button Mouth Clicked " + mouthIndex + " times");
        }
        
        if (nose.isSelected())
        {
            noseIndex++;
            noseIndex = getIndex(noseIndex);
            face.currentNose = noseIndex;
           // System.out.println("Button Nose Clicked " + mouthIndex + " times");
        }
        else if (nose.isSelected() == false & mouth.isSelected() == false & eyes.isSelected() == false)
        {
            face.setBackground(randomColor);
        }
        
        // TODO: Better way to do this?
        face.paintComponent(face.getGraphics());
         
    }
    
    private int getIndex(int counter)
    {
        if(counter >= 3)
        {
            return 0;
        }
        
        return counter;
    }
    
    @SuppressWarnings("serial")
    private class DrawFace extends JPanel
    {
        ImageIcon[] eyeImages;
        ImageIcon[] mouthImages;
        ImageIcon[] noseImages;   
        
        public int currentMouth;
        public int currentEye;
        public int currentNose;
        
        public DrawFace()
                
        {
            eyeImages = new ImageIcon[3];
            eyeImages[0] = new ImageIcon(getClass().getResource("eyes1.png"));
            eyeImages[1] = new ImageIcon(getClass().getResource("eyes2.png"));
            eyeImages[2] = new ImageIcon(getClass().getResource("eyes3.png"));

            mouthImages = new ImageIcon[3];
            mouthImages[0] = new ImageIcon(getClass().getResource("mouth1.png"));
            mouthImages[1] = new ImageIcon(getClass().getResource("mouth2.png"));
            mouthImages[2] = new ImageIcon(getClass().getResource("mouth3.png"));

            noseImages = new ImageIcon[3];
            noseImages[0] = new ImageIcon(getClass().getResource("nose1.png"));
            noseImages[1] = new ImageIcon(getClass().getResource("nose2.png"));
            noseImages[2] = new ImageIcon(getClass().getResource("nose3.png"));               
        }
        
        
        
 
        @Override
        protected void paintComponent (Graphics g)
        {
            super.paintComponent(g);
            Color myNewBlue = new Color (63, 72, 204); 
            
            g.setColor(myNewBlue);
            g.fillOval(20, 40, 410, 410);
            
            eyeImages[currentEye].paintIcon(this, g, 112, 80);
            mouthImages[currentMouth].paintIcon(this, g, 95, 285);
            noseImages[currentNose].paintIcon(this, g, 165, 180); 
            

        }          
    }  
}
