package com.dev.wizard.springboot.event.listen;

import lombok.Data;

public class CommonSpringEventType {
    @Data
    public static class DogEvent extends FirstType{
        private String name;
        public DogEvent(Object source, String name) {
            super(source);
            this.name = name;
        }
    }
    @Data
    public static class WolfEvent extends FirstType{
        private String name;
        public WolfEvent(Object source, String name) {
            super(source);
            this.name = name;
        }
    }
    @Data
    public static class TigerEvent extends SecondType{
        private String name;
        public TigerEvent(Object source, String name) {
            super(source);
            this.name = name;
        }
    }

    @Data
    public static class CatEvent extends SecondType{
        private String name;
        public CatEvent(Object source, String name) {
            super(source);
            this.name = name;
        }
    }

}
