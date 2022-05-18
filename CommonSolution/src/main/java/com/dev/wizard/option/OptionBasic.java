package com.dev.wizard.option;

import lombok.Data;

@Data
public class OptionBasic {

    private Boolean muteUser;

    private boolean disableUser;

    public int toValue(){
        int value = 0;
        if(disableUser){
            value = set(value, 0);
        }
        if( null != muteUser && muteUser){
            value = set(value, 1);
        }
        return value;
    }

    public OptionBasic buildOption( int value){
        this.disableUser = isSet(value, 0);
        this.muteUser = isSet(value, 1);
        return this;
    }

    public static int set(int option, int bitIndex) {
        int value = 1 << bitIndex;
        return option | value;
    }

    public static int unset(int option, int bitIndex) {
        int value = 1 << bitIndex;
        return option & (~ value);
    }

    public static boolean isSet(int option, int bitIndex){
        int value = 1 << bitIndex;
        return value == (option & value);
    }

    //实际业务应用, 以需要更新的为基础并与来自数据库的结合
    public OptionBasic combineOption(OptionBasic optionFromDB, OptionBasic needSetOption){
        boolean muteUser = optionFromDB.getMuteUser();

        boolean disableUser = optionFromDB.isDisableUser();

        if(disableUser){
            needSetOption.setDisableUser(disableUser);
        }
        if(null == needSetOption.getMuteUser()){
            needSetOption.setMuteUser(muteUser);
        }
        return needSetOption;
    }

}
