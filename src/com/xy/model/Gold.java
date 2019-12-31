package com.xy.model;

import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * 金币
 * */
public class Gold {
    public static final Integer WIDTH = 60;
    public static final Integer HEIGHT = 60;
    private Image image;
    private Image[] images;
    private Integer x, y, speed;
    private Integer index = 0;
    Random random = new Random();

    public Gold() {
        try{
            images = new Image[6];
            BufferedImage bufferedImage = ImageIO.read(new File("image/barrier3.png"));
            for(int i = 0; i < images.length; i++){
                if(i % 2 != 0){
                    images[i] = bufferedImage.getSubimage(234 + 30, i * 30, WIDTH, HEIGHT);
                }else {
                    images[i] = bufferedImage.getSubimage(234, i * 30, WIDTH, HEIGHT);
                }
            }
            index = random.nextInt(6);
            image = images[index];
            speed = 20;
            x = GameEnum.MAIN_WIDTH.getValue();
            y = 100 + random.nextInt(100);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    //移动方法
    public void step() {
        this.x -= this.speed;
    }

    //绘制人物
    public void paintGold(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    //判断人物是否越界
    public boolean outOfBounds() {
        return this.x + GameEnum.PERSON_WIDTH.getValue() > GameEnum.MAIN_WIDTH.getValue() || this.x < 0;
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
