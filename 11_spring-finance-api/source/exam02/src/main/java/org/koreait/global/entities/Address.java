package org.koreait.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @Column(name = "zoneCode", length = 10)
    private String zoneCode;

    @Column(length = 100)
    private String address;

    @Column(name = "addressSub", length = 100)
    private String addressSub;
}
