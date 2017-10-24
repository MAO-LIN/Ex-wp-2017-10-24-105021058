import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Frame2 extends JFrame {
    private int screenH= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int screenW= Toolkit.getDefaultToolkit().getScreenSize().width;
    private JMenuBar jmb=new JMenuBar();
    private JMenu jmF=new JMenu("File");
    private JMenuItem jmFExit=new JMenuItem("Exit");
    private JMenuItem jmFLoto=new JMenuItem("Loto");
    private JInternalFrame jinFrame=new JInternalFrame();
    private JDesktopPane jdktpane= new JDesktopPane();
    private JPanel jinPanlC=new JPanel(new GridLayout(1,6,5,5));
    private JLabel jlbLoto[]=new JLabel[6];
    private JPanel jinPanlS=new JPanel(new GridLayout(1,2,15,10));
    private JButton jinbtnClose=new JButton("Exit");
    private JButton jinbtnGo=new JButton("Go");
    private Random rdm=new Random(System.currentTimeMillis());

    public Frame2(LoginFrame lfm){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-600/2,screenH/2-450/2,600,450);
        this.setJMenuBar(jmb);
        this.setContentPane(jdktpane);
        jinFrame.setBounds(0,0,300,150);
        jmb.add(jmF);
        jmF.add(jmFExit);
        jmF.add(jmFLoto);
        jmFLoto.setAccelerator(KeyStroke.getKeyStroke('L',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jinFrame.setLayout(new BorderLayout(5,5));
        jinFrame.add(BorderLayout.CENTER,jinPanlC);
        for(int i=0;i<6;i++){
            jlbLoto[i]=new JLabel("null",JLabel.CENTER);
            jinPanlC.add(jlbLoto[i]);
        }
        setLoto();
        jdktpane.add(jinFrame);
        jinFrame.add(BorderLayout.SOUTH,jinPanlS);
        jinPanlS.add(jinbtnClose);

        jinbtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jinFrame.setVisible(false);
            }
        });
        jinPanlS.add(jinbtnGo);

        jmFExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmFExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmFLoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jinFrame.setVisible(true);
            }
        });

    }
    private void setLoto(){
        for(int i=0;i<6;i++){
           jlbLoto[i].setText();
        }
    }
}
