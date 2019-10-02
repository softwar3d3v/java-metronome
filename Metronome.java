import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.*;

import javax.swing.border.TitledBorder;
public class Metronome extends JFrame {
    public static void main(String[] args) {
        Runnable app = new Runnable() {
            public void run() {
                Metronome t = new Metronome();
                t.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(app);
    }
    public Metronome() {
        super("Metronome App");
        // code that uses the look of the OS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e) {
            System.err.println(e);
        }
        // create the slider
        final JSlider sBPM = new JSlider(JSlider.VERTICAL, 20, 200, 120);
        // various settings for the Slider
        sBPM.setPaintLabels(true);
        sBPM.setPaintTicks(true);
        sBPM.setMajorTickSpacing(20);
        sBPM.setMinorTickSpacing(10);
        java.util.Hashtable labelSlider = new java.util.Hashtable();
        // Settings for tempo inside of the slider
        labelSlider.put(new Integer(200), new JLabel(" 200 Prestissimo"));
        labelSlider.put(new Integer(180), new JLabel(" 180 Presto"));
        labelSlider.put(new Integer(160), new JLabel(" 160"));
        labelSlider.put(new Integer(140), new JLabel(" 140"));
        labelSlider.put(new Integer(130), new JLabel(" 130 Allegro"));
        labelSlider.put(new Integer(120), new JLabel(" 120"));
        labelSlider.put(new Integer(100), new JLabel(" 100 Moderato"));
        labelSlider.put(new Integer(90), new JLabel(" 90 Andante"));
        labelSlider.put(new Integer(80), new JLabel(" 80"));
        labelSlider.put(new Integer(70), new JLabel(" 70 Adagio"));
        labelSlider.put(new Integer(60), new JLabel(" 60"));
        labelSlider.put(new Integer(50), new JLabel(" 50 Lento"));
        labelSlider.put(new Integer(40), new JLabel(" 40"));
        labelSlider.put(new Integer(20), new JLabel(" 20"));
        // more settings for the slider
        sBPM.setLabelTable(labelSlider);
        sBPM.setPaintLabels(true);
        sBPM.setPreferredSize(new Dimension(150, 400));
        sBPM.setBorder(new TitledBorder("Beats per minute (BPM)"));
        // creating of the slider and settings
        final JSlider sDuration = new JSlider(JSlider.VERTICAL, 0, 120, 5);
        sDuration.setPaintLabels(true);
        sDuration.setPaintTicks(true);
        sDuration.setMajorTickSpacing(20);
        sDuration.setMinorTickSpacing(10);
        sDuration.setPreferredSize(new Dimension(70, 400));
        sDuration.setBorder(new TitledBorder("Seconds"));
        JPanel pMain = new JPanel(new BorderLayout());
        pMain.add(sBPM, BorderLayout.EAST);
        pMain.add(sDuration, BorderLayout.CENTER);
        JButton bBeats = new JButton("Listen to Beats");
        // Activation listener that signals to the generateBeats constructor with params(bpm, duration)
        bBeats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                generateBeats(sBPM.getValue(), sDuration.getValue());
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(bBeats, BorderLayout.WEST);
        pMain.add(panel, BorderLayout.NORTH);
        pMain.setBorder(new javax.swing.border.EmptyBorder(5, 3, 5, 3));
        getContentPane().add(pMain);
        pack();
        setLocation(0, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void generateBeats(double bpm, int duration) {
        System.out.println("Hello!");
    }
}