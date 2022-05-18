package com.dev.wizard.option;

import com.dev.wizard.option.util.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.EnumSet;

@Data
public class OptionProject {

    private Integer value;

    @JsonIgnore
    private EnumSet<OptionProject.OptionProjectEnum> optionProEnumSet;

    public static void main(String[] args) throws JsonProcessingException {
        OptionProject project = new OptionProject();
        project.setValue(6);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(project);
        System.out.println(jsonString);

        OptionProject optionProject = objectMapper.readValue(jsonString, OptionProject.class);
        System.out.println(optionProject.activeUser());
    }

    private EnumSet<OptionProject.OptionProjectEnum> retriveOptionProjectEnumSet() {
        if (null == this.optionProEnumSet) {
            this.optionProEnumSet = EnumUtil.buildEnumSet(this.getValue(), OptionProjectEnum.class);
        }
        return optionProEnumSet;
    }

    public boolean disableUser() {
        return this.containsOption(OptionProjectEnum.DISABLE_USER);
    }

    public boolean muteUser() {
        return this.containsOption(OptionProjectEnum.MUTE_USER);
    }

    public boolean activeUser() {
        return this.containsOption(OptionProjectEnum.ACTIVE_USER);
    }

    private boolean containsOption(OptionProjectEnum optionProjectEnum) {
        return this.retriveOptionProjectEnumSet().contains(optionProjectEnum);
    }

    public enum OptionProjectEnum implements EnumIndex {
        DISABLE_USER(0), MUTE_USER(1), ACTIVE_USER(2);

        private final int bitIndex;

        OptionProjectEnum(int bitIndex) {
            this.bitIndex = bitIndex;
        }

        public int getBitIndex() {
            return bitIndex;
        }
    }
}
