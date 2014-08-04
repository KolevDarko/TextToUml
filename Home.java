import net.sourceforge.plantuml.SourceStringReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * Created by darko on 27.6.14.
 */
public class Home {
       /**
         * Create the GUI and show it.  For thread safety,
         * this method should be invoked from the
         * event-dispatching thread.
         */
        private static void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("Text to UML");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Add the ubiquitous "Hello World" label.
            JLabel label = new JLabel("Insert text here:");
            JTextArea textArea = new JTextArea(5,20);
            frame.getContentPane().add(label);
            frame.getContentPane().add(textArea);


            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });

            System.out.println("zdravo");

            ByteArrayOutputStream png = new ByteArrayOutputStream();

            Actor a1,a2,a3;
            Action ac1,ac2;

            a1 = new Actor("Darko","Darko");
            a2 = new Actor("Dragana","Dragana");
            a3 = new Actor("Turlitava","Rucek");

            ac1 = new Action("Action1", "S");
            ac2 = new Action("Action2", "G");

            ac1.setLabel1("action label");
            ac2.setLabel2("result label");

            Case c1 = new Case(a1,a2,ac1);
            Case c2 = new Case(a2,a3,ac2);

            UseCaseDiagram diagram = new UseCaseDiagram();
            diagram.cases.add(c1);
            diagram.cases.add(c2);
            diagram.cases.add(c2);
            diagram.cases.add(c2);


            String source = diagram.toString();

            System.out.println(source);

            /*String source = "@startuml \n";
            source += ":Main Admin: as Admin \n";
            source += "(Main App) as (App) \n";
            source += "User -> (App) \n";
            source += "(App) -> Admin \n";
            source += "@enduml\n";
*/


            SourceStringReader reader = new SourceStringReader(source);
            try {
// Write the first image to "png"
                String desc = reader.generateImage(png);
// Return a null string if no generation
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Error in writing to png");
            }

            byte[] data = png.toByteArray();
            ByteArrayInputStream input = new ByteArrayInputStream(data);

            try {
                BufferedImage image = ImageIO.read(input);
                ImageIO.write(image,"png",new File("diagram.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

