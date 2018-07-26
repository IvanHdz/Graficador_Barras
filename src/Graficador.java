
/**
 *
 * @author Ivan
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Graficador extends JFrame {

    JButton env;
    JTextField rec;
    JLabel lab1;
    JLabel lab2;
    Color color = Color.BLACK;
    Color color2 = Color.GREEN;
    JButton col;
    JButton col2;
    boolean bandera = true;

    int c = 10;
    int r;
    public int Recibe[] = new int[10];
    public int alturas[] = new int[10];
    public int alturas2[] = new int[10];

    public Graficador() {
        super("Viruz :: Graficador");
        setLayout(null);
        setBounds(200, 100, 465, 550);
        setVisible(true);
        lab1 = new JLabel("Frecuencia(1-50):");
        lab1.setBounds(10, 400, 120, 10);
        add(lab1);

        lab2 = new JLabel("Colores:");
        lab2.setBounds(125, 400, 100, 10);
        add(lab2);

        rec = new JTextField("10");
        env = new JButton("Convertir");
        rec.setBounds(10, 415, 100, 15);

        add(rec);

        env.setBounds(10, 435, 100, 15);
        env.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Integer.parseInt(rec.getText());
            }
        });
        add(env);

        col = new JButton("Color de fondo");
        col.setBounds(125, 415, 150, 15);
        col.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null, "seleccione un color", null);
                System.out.println(color);
            }
        });
        add(col);

        col2 = new JButton("Color de barras");
        col2.setBounds(125, 435, 150, 15);
        col2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color2 = JColorChooser.showDialog(null, "seleccione un color", null);
                System.out.println(color2);
            }
        });
        add(col2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);

        //muñeco
        g.drawOval(400, 415, 40, 40);
        //cuello
        g.drawLine(420, 455, 420, 465);

        //brazos
        g.drawLine(420, 465, 440, 475);
        g.drawLine(440, 475, 460, 465);
        g.drawLine(420, 465, 400, 475);
        g.drawLine(400, 475, 380, 465);

        g.setColor(color);
        g.fillRect(0, 0, 480, 400);
        g.setColor(color2);
        int x2 = r;
        for (int a = 0; a < 60; a++) {

            if (bandera = true) {
                g.setColor(Color.black);
                int m = 430;
                //torso

                g.drawLine(420, 465, m, 495);
                //piernas
                g.drawLine(m, 495, 400, 535);
                g.drawLine(m, 495, 440, 535);

                bandera = false;
                g.setColor(color2);

            } else if (!bandera) {
                g.setColor(Color.BLACK);
                int m = 410;
                //torso
                repaint();
                g.drawLine(420, 465, m, 495);
                //piernas
                g.drawLine(m, 495, 400, 535);
                g.drawLine(m, 495, 440, 535);
            }

            bandera = true;
            g.setColor(color2);

            getValores();
            getAlto();

            for (int x = 0; x < alturas.length; x++) {
                x2 = x2 + 1;
                g.fillRect(x2, alturas2[x], r, alturas[x]);
                x2 = x2 + r;
                repaint();
            }
        }
    }

    //este metodo crea los valores, cuando lo vallas a convertir
    public void getValores() {

        for (int i = 0; i < Recibe.length; i++) {
            Recibe[i] = (int) (Math.random() * 10);
            r = 400 / c;
        }
    }

    public void getAlto() {
        for (int y = 0; y < Recibe.length; y++) {
            int porcent = (int) (Recibe[y] * 100 / 10);
            int alto = (int) (porcent * 400 / 100);
            alturas[y] = alto;
            alturas2[y] = 400 - alto;
        }
    }
}
