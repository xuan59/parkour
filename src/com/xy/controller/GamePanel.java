package com.xy.controller;

import com.xy.model.Barrier01;
import com.xy.model.Gold;
import com.xy.model.Person;
import com.xy.model.Pet;
import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lx
 * @date 2020-12-31
 * 游戏主面板， 核心逻辑
 * 1.背景滚动
 * 2.玩家动态效果
 * 3.障碍物出现
 * 4.碰撞
 * 5.暂停、继续、结束
 * */
public class GamePanel extends JPanel implements KeyListener {
    Image background;
    JButton pause, proceed;  //暂停、继续
    Person person; //人物
    Barrier01 barrier01; //障碍物
    Gold gold; //金币
    Pet pet; //宠物
    Gold[] golds = {};
    Barrier01[] barrier01s = {};
    Integer index = 0;
    Integer x = 0;
    JProgressBar jProgressBar;
    boolean isPause = false;
    public GamePanel() {
        person = new Person();
        pause = new JButton();
        proceed = new JButton();
        gold = new Gold();
        pet = new Pet();
        jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true); //显示进度
        jProgressBar.setBackground(Color.WHITE);
        jProgressBar.setForeground(Color.RED);
        jProgressBar.setBounds(0, 0, 600, 15);
        this.add(BorderLayout.SOUTH, jProgressBar);
        try{
            background = ImageIO.read(new File("image/background3.png"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        //绘制背景图片
        x -= 20;
        g.drawImage(background, x, 0, GameEnum.MAIN_WIDTH.getValue(), GameEnum.MAIN_HEIGHT.getValue(), null);
        g.drawImage(background, x + GameEnum.MAIN_WIDTH.getValue(), 0, GameEnum.MAIN_WIDTH.getValue(), GameEnum.MAIN_HEIGHT.getValue(), null);
        if(x < -GameEnum.MAIN_WIDTH.getValue()){
            x = 0;
        }

        //绘制人物
        person.paintPerson(g);
        //绘制宠物
        pet.paintPet(g);
        //绘制障碍物
        for (Gold gold1 : golds) {
            gold1.paintGold(g);
        }
        for (Barrier01 barr: barrier01s) {
            barr.paintBarrier(g);
        }
        g.setColor(Color.ORANGE);
        g.setFont(new Font("宋体", Font.BOLD, 30));
        g.drawString("玩家分数：" + person.getScore() + "分", 100, 50);

    }

    //生成障碍物
    public void enteredAction() {
        index ++;
        if(index % 100 ==0){
            Barrier01 b1 = new Barrier01();
            barrier01s = Arrays.copyOf(barrier01s, barrier01s.length + 1);
            barrier01s[barrier01s.length - 1] = b1;
        }
        if(index % 15 ==0){
            Gold gold = new Gold();
            golds = Arrays.copyOf(golds, golds.length + 1);
            golds[golds.length -1] = gold;
        }
    }

    //移动
    public void stepAction() {
        person.step();
        pet.step();
        for(Gold g : golds){
            g.step();
            if(person.getX() + GameEnum.PERSON_WIDTH.getValue() >= g.getX() && person.getX() <= g.getX() + g.getWIDTH()&&
            person.getY() + + GameEnum.PERSON_HEIGHT.getValue() >= g.getY() && person.getY() <= g.getY() + g.getHEIGHT()){
                person.setScore(person.getScore() + ((g.getIndex() + 1) * 15));
                jProgressBar.setValue(person.getLifeNumber());
            }
            if(g.outOfBounds()){
                g = golds[golds.length - 1];
                golds = Arrays.copyOf(golds , golds.length - 1);
            }
        }
        for(Barrier01 barrier01 : barrier01s){
            barrier01.step();
            if(person.getX() + GameEnum.PERSON_WIDTH.getValue() >= barrier01.getX() && person.getX() <= barrier01.getX() + barrier01.getWIDTH()&&
            person.getY() + + GameEnum.PERSON_HEIGHT.getValue() >= barrier01.getY() && person.getY() <= barrier01.getY() + barrier01.getHEIGHT()){
                person.setLifeNumber(person.getLifeNumber() - 10);
            }
            if(barrier01.outOfBounds()){
                barrier01 = barrier01s[barrier01s.length - 1];
                barrier01s = Arrays.copyOf(barrier01s, barrier01s.length -1);
            }
        }
    }

    public void action() {
        new Thread(){
          public void run() {
              while (!isPause){
                  enteredAction();
                  stepAction();
                  repaint();
                  try{
                      Thread.sleep(60);
                  }catch (Exception e){
                      e.printStackTrace();
                      System.out.println(e.getMessage());
                  }
              }
          }
        }.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //上
        if(e.getKeyCode() == KeyEvent.VK_UP && person.getY() > 10 && person.getY() < GameEnum.MAIN_HEIGHT.getValue() -10){
            person.setY(person.getY() - 25);
            pet.setY(pet.getY() - 25);
        }
        //下
        if(e.getKeyCode() == KeyEvent.VK_DOWN && person.getY() > 10 && person.getY() < GameEnum.MAIN_HEIGHT.getValue() + 10){
            person.setY(person.getY() + 25);
            pet.setY(pet.getY() + 25);
        }
        //左
        if(e.getKeyCode() == KeyEvent.VK_LEFT && person.getX() > 0 && person.getY() < GameEnum.MAIN_WIDTH.getValue()){
            person.setY(person.getX() - 25);
            pet.setY(pet.getX() - 25);
        }
        //右
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && person.getX() > 0 && person.getX() < GameEnum.MAIN_HEIGHT.getValue()){
            person.setY(person.getX() + 25);
            pet.setY(pet.getX() + 25);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
