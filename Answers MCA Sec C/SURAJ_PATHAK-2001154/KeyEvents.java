//Name:suraj pathak
//Program 2nd:-

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class KeyEvents extends Applet implements KeyListener
{
    String msg = "";
 
    public void init()
    {
        addKeyListener(this);
    }
 
    public void keyReleased(KeyEvent k)
    {
        showStatus("Key Released");
        repaint();
    }
 
    public void keyTyped(KeyEvent k)
    {
        showStatus("Key Typed");
        repaint();
    }
     public void keyUp(KeyEvent k)
    {
        showStatus("Key UP");
        repaint();
    }
    public void keyDown(KeyEvent k)
    {
        showStatus("Key Down");
        repaint();

    public void keyPressed(KeyEvent k)
    {
        showStatus("Key Pressed");
        repaint();
    }
 
    public void paint(Graphics g)
    {
        g.drawString(msg, 10, 10);
    }
}