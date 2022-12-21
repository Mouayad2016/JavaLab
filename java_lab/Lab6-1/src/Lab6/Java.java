package Lab6;

import javax.swing.*;
import java.awt.*;
public class Java {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Du är Kung");
        frame.setContentPane( new minApp().lab6MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}