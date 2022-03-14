package com.game;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MyGame extends JFrame {
    private JLabel heading,clock;
    private JLabel main;
    private JButton[] buttons=new JButton[9];
    private Font font=new Font("",Font.BOLD,40);

    public MyGame() {
        System.out.println("Constructor");
        setTitle("Tic Tac Toe");
        setSize(850,850);
        ImageIcon icon=new ImageIcon("src/main/java/img/icon.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CreateGUI();
        setVisible(true);
    }
    private  void CreateGUI()
    {
        this.getContentPane().setBackground(Color.decode("#2196f3"));
        this.setLayout(new BorderLayout());
        heading=new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.white);
        this.add(heading,BorderLayout.NORTH);
        clock=new JLabel("Clock");
        clock.setFont(font);
        clock.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(clock,BorderLayout.SOUTH);
        clock.setForeground(Color.white);
        Timer();
        PanelSection();
    }
    private void Timer()
    {
        var t=new Thread(()->{
           try {
               while (true) {
                   //..........
                   var datetime=new Date().toLocaleString();
                   clock.setText(datetime);
                   Thread.sleep(1000);
               }
           }catch (InterruptedException e)
           {
               e.printStackTrace();
           }
        });
        t.start();
    }
    private void PanelSection()
    {
        main=new JLabel();
        main.setLayout(new GridLayout(3,3));
        for (int i = 1; i <=9 ; i++) {
            var btn=new JButton(" ");
            btn.setIcon(new ImageIcon("src/main/java/img/zero.png"));
            btn.setBackground(Color.black);
            btn.setFont(font);
            main.add(btn);
            buttons[i-1]=btn;
        }
        this.add(main,BorderLayout.CENTER);
    }
}
