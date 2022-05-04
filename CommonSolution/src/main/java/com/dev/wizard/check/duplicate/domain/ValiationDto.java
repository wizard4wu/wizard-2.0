package com.dev.wizard.check.duplicate.domain;


import com.dev.wizard.check.duplicate.NotDuplicatedElement;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ValiationDto {

    @Size(max = 10)
    private String name;

    @Valid
    @NotDuplicatedElement(message = "不可以重复")
    private List<StudentDto> studentDtos;

    @NotDuplicatedElement(message = "不可以重复")
    private List<String> questions;


    @Data
    public static class StudentDto {

        @NonNull
        private String name;

        @NotDuplicatedElement(message = "test message")
        private List<Question> questions;

    }

    @Data
    public static class Question {
        private String title;
    }
}
