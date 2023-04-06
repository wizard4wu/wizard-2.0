package com.dev.wizard;

public class Child extends People {
    private String name = "jerry";

    public Child() {
        playBasketball();
        playFootball();
    }

    public static void main(String[] args) {
        new Child();
    }

    public void playFootball() {
        System.out.println("child_playBasketball: " + name);
    }

    public void playBasketball() {
        System.out.println("child_playFootball:" + name);
    }
}

class People {
    private String name = "Tom";

    public People() {
        playBasketball();
        playFootball();
    }

    public void playFootball() {
        System.out.println("people_playBasketball:" + name);
    }

    public void playBasketball() {
        System.out.println("people_playFootball:" + name);

    }
}
