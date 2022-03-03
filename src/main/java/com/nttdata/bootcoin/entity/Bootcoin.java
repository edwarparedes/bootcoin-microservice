package com.nttdata.bootcoin.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Bootcoin {
    @Id
    private String id;
    private String typeDocument;
    private String numberDocument;
    private String phoneNumber;
    private String email;
    private Double coin;
}
