package com.xy.model;

import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * 宠物
 * */
public class Pet {
    private Image image;
    private Image[] images;
    private Integer x, y, index; // x, y, 人物图片切换
    public static final Integer WIDTH = 30;
    public static final Integer HEIGHT = 60;

    public Pet() {
        init();
        x = 20;
        y = 260;
        index = 0;
        image = images[0];
    }

    private void init() {
        try {
            images = new Image[9];
            BufferedImage bufferedImage = ImageIO.read(new File("image/pet1.png"));
            for (int i = 0; i < images.length; i++){
                images[i] = bufferedImage.getSubimage(i * 104, 0, 104, 110);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //下落方法
    public void drop() {
        y += 3;
        if( y >= GameEnum.MAIN_HEIGHT.getValue()){
            y = GameEnum.MAIN_HEIGHT.getValue();
        }
    }

    //移动方法
    public void step() {
        image = images[index++ /2% images.length];
    }

    //绘制人物
    public void paintPet(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    //判断人物是否越界
    public boolean outOfBounds() {
        return this.x + GameEnum.PERSON_WIDTH.getValue() > GameEnum.MAIN_WIDTH.getValue() || this.x < 0;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }
}
