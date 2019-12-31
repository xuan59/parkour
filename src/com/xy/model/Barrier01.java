package com.xy.model;

import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Barrier01 {
    private Image image;
    private Image[] images;
    public static final Integer WIDTH = 120;
    public static final Integer HEIGHT = 170;
    private Integer x, y, index, speed;
    public Barrier01() {
        images = new Image[2];
        try{
            BufferedImage bufferedImage = ImageIO.read(new File("image/barrier3.png"));
            images[0] = bufferedImage.getSubimage(0, 0, 124, 175);
            images[1] = bufferedImage.getSubimage(237, 112, 106, 103);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        image = images[0];
        x = GameEnum.MAIN_WIDTH.getValue() + 100;
        y = 260;
        speed = 30;
        index = 0;
    }

    public void step() {
        image = images[index++/5% images.length];
        this.x -= speed;
    }

    public void paintBarrier(Graphics g) {
        g.drawImage(image, x, y, WIDTH, HEIGHT, null);
    }

    public boolean outOfBounds() {
        return this.x < -10;
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

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
