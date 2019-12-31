package com.xy.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @author lx
 * @date 2020-12-28
 * 登录
 * */
public class LoginFrame extends JFrame {
    //标签
    JLabel userNameLabel;
    JLabel userPassLabel;
    //输入框
    JTextField userNameField;
    JPasswordField userPassField;
    //按钮
    JButton login, cancel;

    public LoginFrame(){
        //设置标签字体
        userNameLabel = new JLabel("用户名：");
        userPassLabel = new JLabel("密  码：");
        userNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        userPassLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //布局
        userNameLabel.setBounds(20, 220, 80, 30);
        userPassLabel.setBounds(20, 280, 80, 30);
        this.add(userNameLabel);
        this.add(userPassLabel);
        userNameField = new JTextField();
        userPassField = new JPasswordField();
        userNameField.setBounds(100, 220, 200, 30);
        userPassField.setBounds(100, 280, 200, 30);
        //设置输入框凹陷效果
        userNameField.setBorder(BorderFactory.createLoweredBevelBorder());
        userPassField.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        userNameField.setOpaque(false);
        userPassField.setOpaque(false);
        this.add(userNameField);
        this.add(userPassField);
        //按钮
        login = new JButton("登录");
        cancel = new JButton("退出");
        login.setBounds(45, 350, 100, 36);
        cancel.setBounds(150, 350, 100, 36);
        this.add(login);
        this.add(cancel);
        login.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取输入框内容
                String userName = userNameField.getText();
                String userPass = new String(userPassField.getPassword());
                System.out.println(userName+userPass);
                if("lx".equals(userName) && "123456".equals(userPass)){
                    //跳转到下一个界面
                    JOptionPane.showMessageDialog(null, "欢迎"+userName+"来到天天酷跑");
                    //关闭当前界面
                    dispose();
                }else if(userName == null || userPass == null || userName.isEmpty() || userPass.isEmpty()){
                    JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
                }else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                }

            }
        });
        cancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //关闭当前界面
            }
        });

        LoginPanel loginPanel = new LoginPanel();
        this.add(loginPanel);
        this.setSize(900, 530);
        this.setLocationRelativeTo(null); //居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //设置logo图标
        this.setIconImage(new ImageIcon("image/icon.png").getImage());
        this.setVisible(true);

    }

    class LoginPanel extends JPanel{
        Image background;
        public LoginPanel(){
            try{
                background = ImageIO.read(new File("image/background2.jpg"));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        //绘制
        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(background, 0, 0, 900, 530, null);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

}
