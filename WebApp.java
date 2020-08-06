import java.awt.*;

public class WebApp extends javax.swing.JApplet {
    String greeting;

    public void init() {
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        greeting = "Hello!";
    }

    public void paint(Graphics screen) {
        Graphics2D screen2D = (Graphics2D) screen;
        screen2D.drawString(greeting, 25, 50);
    }
}
