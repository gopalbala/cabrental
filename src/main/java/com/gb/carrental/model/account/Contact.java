package com.gb.carrental.model.account;

import com.gb.carrental.model.common.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private String phone;
    private String email;
    private Address address;
}
