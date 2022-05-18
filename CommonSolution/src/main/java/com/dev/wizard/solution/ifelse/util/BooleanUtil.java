package com.dev.wizard.solution.ifelse.util;

import com.dev.wizard.solution.ifelse.function.BooleanFunction;
import com.dev.wizard.solution.ifelse.methodenum.GenderEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;


public class BooleanUtil<T> {

    public static BooleanFunction isAnyMatch(Boolean... booleans) {
        boolean result = Arrays.stream(booleans).filter(Objects::nonNull).anyMatch(Boolean::booleanValue);
        return getBooleanFunction(result);
    }

    public static BooleanFunction isAllMatch(Boolean... booleans){
        boolean result = Arrays.stream(booleans).filter(Objects::nonNull).allMatch(Boolean::booleanValue);
        return getBooleanFunction(result);
    }

    public static BooleanFunction isAllMatch(BooleanSupplier... booleanSuppliers){
        boolean result = Arrays.stream(booleanSuppliers).filter(Objects::nonNull).map(BooleanSupplier::getAsBoolean).allMatch(Boolean::booleanValue);
        return getBooleanFunction(result);
    }

    public static BooleanFunction isAnyMatch(BooleanSupplier... booleanSuppliers) {
        boolean result = Arrays.stream(booleanSuppliers).filter(Objects::nonNull).map(BooleanSupplier::getAsBoolean).anyMatch(Boolean::booleanValue);
        return getBooleanFunction(result);
    }

    private static BooleanFunction getBooleanFunction(boolean result){
        return (ifFunction, elseFunction) -> result ? ifFunction.get() : Optional.ofNullable(elseFunction).map(Supplier::get).orElse(null);
    }

    public static void main(String[] args) {


       String result =  (String)BooleanUtil.isAnyMatch( () -> StringUtils.equals("hh","hhe")).handleCondition(
                () -> "if function",
              null
        );

        System.out.println(result);

    }


    public GenderEnum getGender(int genderValue){
        if(genderValue == GenderEnum.FEMALE.getValue()){
            return GenderEnum.FEMALE;
        }else {
            return GenderEnum.MALE;
        }
    }

    public GenderEnum getGenderAfterChange(int genderValue){
        return genderValue == GenderEnum.FEMALE.getValue()? GenderEnum.FEMALE:GenderEnum.MALE;
    }

    public void test(){
        int genderValue = 0;
        GenderEnum genderEnum = null;
        if(genderValue == GenderEnum.FEMALE.getValue()){
            genderEnum = GenderEnum.FEMALE;
        }else {
            genderEnum = GenderEnum.MALE;
        }
/******************************************************************************************************************/
        genderEnum = genderValue == GenderEnum.FEMALE.getValue() ? GenderEnum.FEMALE: GenderEnum.MALE;
    }

}

