package com.xy.view;

import com.xy.controller.GamePanel;
import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author lx
 * @date 2020-12-31
 * 游戏主界面
 * */
public class GameFrame extends JFrame {
    public GameFrame(){
        try {
            GamePanel gamePanel = new GamePanel();
            gamePanel.action();
            this.addKeyListener(gamePanel);
            this.add(gamePanel);
            this.setSize(GameEnum.MAIN_WIDTH.getValue(), GameEnum.MAIN_HEIGHT.getValue());
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setIconImage(new ImageIcon("image/icon.png").getImage());
            this.setUndecorated(true);
            this.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
