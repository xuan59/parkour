package com.xy.uitl;

public enum GameEnum {
    MAIN_WIDTH(900, "游戏界面宽度"),
    MAIN_HEIGHT(500, "游戏界面高度"),

    PERSON_WIDTH(100, "人物宽度"),
    PERSON_HEIGHT(100, "人物高度");

    private final Integer value;
    private final String name;
    GameEnum(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
