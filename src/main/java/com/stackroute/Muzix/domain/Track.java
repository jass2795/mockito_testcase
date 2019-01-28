package com.stackroute.Muzix.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Tracks")
//@Entity// Creation of table
@Data
@AllArgsConstructor// use of lombok
@NoArgsConstructor//Default Constructor
@Builder

public class Track {
   @Id
    private int id;
    private String name;
    private String comment;



}
