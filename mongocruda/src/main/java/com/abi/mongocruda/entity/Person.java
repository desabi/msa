package com.abi.mongocruda.entity;

import com.abi.mongocruda.model.PersonRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "person")
@Data
@NoArgsConstructor // para read all
public class Person {

    @Id
    @Field("_id")
    private ObjectId id;
    private String name;
    private Integer age;
    private Double height;
    private Long phone;

    // para create y update
    // asignar el objeto dto a objeto entity
    public Person(PersonRequest personRequest) {
        this.name = personRequest.getName();
        this.age = personRequest.getAge();
        this.height = personRequest.getHeight();
        this.phone = personRequest.getPhone();
    }
}
