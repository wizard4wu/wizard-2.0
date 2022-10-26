package com.dev.wizard.springboot.event.listen;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class CommonSpringEventLister {

    @EventListener
    public void first(FirstType firstType) {
        if (firstType instanceof CommonSpringEventType.DogEvent) {
            CommonSpringEventType.DogEvent dogEvent = (CommonSpringEventType.DogEvent) firstType;
            System.out.println("CommonSpringEventType.DogEvent " + dogEvent.getName());
        }
        if (firstType instanceof CommonSpringEventType.WolfEvent) {
            CommonSpringEventType.WolfEvent wolfEvent = (CommonSpringEventType.WolfEvent) firstType;
            System.out.println("CommonSpringEventType.WolfEvent " + wolfEvent.getName());
        }
    }


    @EventListener
    public void second(SecondType secondType) {
        if (secondType instanceof CommonSpringEventType.TigerEvent) {
            CommonSpringEventType.TigerEvent tigerEvent = (CommonSpringEventType.TigerEvent) secondType;
            System.out.println("CommonSpringEventType.TigerEvent " + tigerEvent.getName());
        }
        if (secondType instanceof CommonSpringEventType.CatEvent) {
            CommonSpringEventType.CatEvent catEvent = (CommonSpringEventType.CatEvent) secondType;
            System.out.println("CommonSpringEventType.CatEvent " + catEvent.getName());
        }
    }

    @EventListener
    public void CatEvent(CommonSpringEventType.CatEvent catEvent) {
        System.out.println("CommonSpringEventType.CatEvent + CatEvent " + catEvent.getName());
    }
}
