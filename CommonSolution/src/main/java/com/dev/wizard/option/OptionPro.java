package com.dev.wizard.option;

import lombok.Data;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OptionPro {
    private EnumSet<OptionProEnum> optionProEnumSet;

    public boolean disableUser(){
        return null != optionProEnumSet && optionProEnumSet.contains(OptionProEnum.DISABLE_USER);
    }

    public boolean muteUser(){
        return null != optionProEnumSet && optionProEnumSet.contains(OptionProEnum.MUTE_USER);
    }

    public void removeOption(Set<OptionProEnum> enumSet){
        this.getOptionProEnumSet().removeAll(enumSet);
    }

    public void addOption(Set<OptionProEnum> enumSet){
        this.getOptionProEnumSet().addAll(enumSet);
    }

    public static boolean isSet(int option, int bitIndex){
        int value = 1 << bitIndex;
        return value == (option & value);
    }

    public int toValue(){
        int value = 0;
        Set<OptionProEnum> optionProEnumSet = this.getOptionProEnumSet();
        Iterator<OptionProEnum> optionProEnumIterator = optionProEnumSet.iterator();
        while (optionProEnumIterator.hasNext()){
            int bitIndex = optionProEnumIterator.next().getBitIndex();
            if( bitIndex >= 0 && bitIndex < Integer.SIZE - 1){
                value |= 1 << bitIndex;
            }
        }
        return value;
    }

    public Set<OptionProEnum> buildEnumSet(int value){
        Set<OptionProEnum> set = EnumSet.noneOf(OptionProEnum.class);
        OptionProEnum[] enums = OptionProEnum.class.getEnumConstants();
        return Arrays.stream(enums).filter(e -> isSet(value, e.getBitIndex())).collect(Collectors.toSet());
    }

    public Set<OptionProEnum> combineOptionPro(Set<OptionProEnum> optionFromDB, Set<OptionProEnum> addOption, Set<OptionProEnum> removeOption){
        optionFromDB.addAll(addOption);
        optionFromDB.removeAll(removeOption);
        return optionFromDB;
    }

    public enum OptionProEnum {
        DISABLE_USER(0), MUTE_USER(1);

        private int bitIndex;

        OptionProEnum(int bitIndex) {
            this.bitIndex = bitIndex;
        }

        public int getBitIndex() {
            return bitIndex;
        }
    }
}

