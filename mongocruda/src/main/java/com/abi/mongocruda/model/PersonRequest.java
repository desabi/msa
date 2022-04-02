package com.abi.mongocruda.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class PersonRequest {

    @NotNull(message = "{person.name.notnull}")
    @NotBlank(message = "{person.name.notblank}")
    private String name;

    @NotNull(message = "{person.age.notnull}")
    @Positive(message = "{person.age.positive}")
    private Integer age;

    @NotNull(message = "{person.height.notnull}")
    @Positive(message = "{person.height.positive}")
    private Double height;

    @NotNull(message = "{person.phone.notnull}")
    private Long phone;

}
