package br.com.baracho.hm.core.domain.model.hotel.entities;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HotelAddressDomain {
    private UUID id;

    private String postalCode;

    private String street;

    private String complement;

    private String neighborhood;

    private String locale;

    private String uf;

    private HotelDomain hotelDomain;
}
