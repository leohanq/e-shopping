package com.eshopping.user.model.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "customer")
@Data
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
