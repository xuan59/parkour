package com.xy.model;

import com.xy.uitl.GameEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Person {

    private Image image;
    private Image[] images;
    private Integer x, y, index, score, distance, lifeNumber; // x, y, 人物图片切换, 分数, 距离

    public Person() {
        init();
        x = 90;
        y = 260;
        index = 0;
        score = 0;
        distance = 0;
        lifeNumber = 100;
        image = images[0];
    }

    private void init() {
        images = new Image[12];
        for (int i = 0; i < images.length; i++){
            try {
                images[i] = ImageIO.read(new File("image/person" + (i+1) + ".png"));
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    //下落方法
    public void drop() {
        y += 5;
        if( y >= GameEnum.MAIN_HEIGHT.getValue()){
            y = GameEnum.MAIN_HEIGHT.getValue();
        }
    }

    //移动方法
    public void step() {
        image = images[index++ /3% images.length];
    }

    //绘制人物
    public void paintPerson(Graphics g) {
        g.drawImage(image, x, y, GameEnum.PERSON_WIDTH.getValue(), GameEnum.PERSON_WIDTH.getValue(), null);
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getLifeNumber() {
        return lifeNumber;
    }

    public void setLifeNumber(Integer lifeNumber) {
        this.lifeNumber = lifeNumber;
    }
}
