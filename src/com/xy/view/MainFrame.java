package com.xy.view;

import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
/**
 * @author lx
 * @date 2020-12-29
 * 主界面
 * */
public class MainFrame  extends JFrame implements MouseListener {
    JButton start, help, exit;
    JPanel mainPanel;
    public MainFrame() {
        /*start = new JLabel(new ImageIcon("image/start.png"));
        help = new JLabel(new ImageIcon("image/help.png"));
        exit = new JLabel(new ImageIcon("image/exit.png"));*/
        start = new JButton("开始游戏");
        help = new JButton("帮助");
        exit = new JButton("退出");
        start.setBounds(350, 320, 150, 40);
        start.setEnabled(false); //按钮为灰色
        start.addMouseListener(this);
        help.setBounds(350, 370, 150, 40);
        help.setEnabled(false); //按钮为灰色
        help.addMouseListener(this);
        exit.setBounds(350, 420, 150, 40);
        exit.setEnabled(false); //按钮为灰色
        exit.addMouseListener(this);
        this.add(start);
        this.add(help);
        this.add(exit);
        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        this.setSize(GameEnum.MAIN_WIDTH.getValue(), GameEnum.MAIN_HEIGHT.getValue());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon("image/icon.png").getImage());
        this.setVisible(true);
    }

    class MainPanel extends JPanel{
        Image background;
        public MainPanel() {
            try{
                background = ImageIO.read(new File("image/background2.jpg"));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(background, 0, 0, GameEnum.MAIN_WIDTH.getValue(), GameEnum.MAIN_HEIGHT.getValue(), null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //鼠标点击
        if(e.getSource().equals(start)){
            WindowFrame windowFrame = new WindowFrame();
            windowFrame.start();
        }else if(e.getSource().equals(help)){
            JOptionPane.showMessageDialog(null, "帮助");
        }else if(e.getSource().equals(exit)){
            dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //鼠标移进
        if(e.getSource().equals(start)){
            start.setEnabled(true);
        }else if(e.getSource().equals(help)){
            help.setEnabled(true);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //鼠标移出
        if(e.getSource().equals(start)){
            start.setEnabled(false);
        }else if(e.getSource().equals(help)){
            help.setEnabled(false);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
