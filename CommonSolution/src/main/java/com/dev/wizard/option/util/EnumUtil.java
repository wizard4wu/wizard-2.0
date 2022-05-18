package com.dev.wizard.option.util;

import com.dev.wizard.option.EnumIndex;
import com.dev.wizard.option.OptionPro;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumUtil<E> {

    public static  <E extends Enum<E> & EnumIndex> int toValue(EnumSet<E> enumSet){
        int value = 0;
        Iterator<E> optionProEnumIterator = enumSet.iterator();
        while (optionProEnumIterator.hasNext()){
            int bitIndex = optionProEnumIterator.next().getBitIndex();
            if( bitIndex >= 0 && bitIndex < Integer.SIZE - 1){
                value |= 1 << bitIndex;
            }
        }
        return value;
    }

    public static <E extends Enum<E> & EnumIndex> EnumSet<E> buildEnumSet(int value, Class<E> enumClass){
        EnumSet<E> enumSet = EnumSet.noneOf(enumClass);
        E[] enums = enumClass.getEnumConstants();
        Arrays.stream(enums).filter(e -> isSet(value, e.getBitIndex())).forEach(enumValue -> enumSet.add(enumValue));
        return enumSet;
    }

    public static boolean isSet(int option, int bitIndex){
        int value = 1 << bitIndex;
        return value == (option & value);
    }
}
