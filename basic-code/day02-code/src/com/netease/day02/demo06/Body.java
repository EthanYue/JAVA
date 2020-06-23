package com.netease.day02.demo06;

import javax.swing.plaf.basic.BasicViewportUI;

public class Body {

    String name = "body";

    // member inner class: modifier can be public / protected / (default) / private
    public class Heart {
        String name = "heart";

        public void beat() {
            System.out.println("inner heart beat");
            String name = "local heart";
            System.out.println(name); // local heart
            System.out.println(this.name); // heart
            System.out.println(Body.this.name); // the member var of external class
        }
    }


    public void methodBody() {
        System.out.println("external class method");
        new Heart().beat();
        String name = "methodBody";

        // local inner class: no modifier
        class Blood {
            String name = "blood";
            public void bloodMethod() {
                System.out.println("bloodMethod");
                System.out.println(name); // methodBody   must be final
                System.out.println(this.name);  // blood
                System.out.println(Body.this.name); // the member var of external class

            }
        }
        new Blood().bloodMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
