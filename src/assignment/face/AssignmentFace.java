
package assignment.face;

import javax.swing.JFrame;

/**
 *
 * @author Gracie Davenport
 */
public class AssignmentFace
{
    public static void main(String[] args)
    {
        FaceBuilder frame = new FaceBuilder();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
