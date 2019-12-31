package com.xy.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author lx
 * @date 2020-12-29
 * 加载中
 * */
public class WindowFrame extends JFrame implements Runnable {
    JLabel background;
    JProgressBar jProgressBar; //进度条

    public WindowFrame() {
        background = new JLabel(new ImageIcon("image/load.jpg"));
        this.add(BorderLayout.NORTH, background);
        jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true); //显示进度
        jProgressBar.setBackground(Color.WHITE);
        jProgressBar.setForeground(Color.CYAN);
        jProgressBar.setSize(460, 15);
        this.add(BorderLayout.SOUTH, jProgressBar);
        this.setSize(460, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon("image/icon.png").getImage());
        this.setVisible(true);
    }

    public void start(){
        WindowFrame windowFrame = new WindowFrame();
        Thread thread = new Thread(windowFrame);
        thread.start();
        dispose();
    }

    @Override
    public void run() {
        int [] values = {0, 1, 3, 10, 23, 32, 40, 45, 48, 52, 58, 65, 70, 75, 80, 85, 90, 95, 99, 99, 99, 100};
        for (int tem: values) {
            jProgressBar.setValue(tem);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        if(jProgressBar.getValue() == 100){
            new GameFrame();
            dispose();
        }
    }
}
