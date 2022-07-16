package com.kaamcube.truelysell.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name="vendor_services")
public class VendorServices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private Long id;

    @Column(name= "vendor_id")
    private Long vendorId;

    @Column(name= "service_title")
    private String serviceTitle;

    @Column(name= "service_amount")
    private String serviceAmount;

    @Column(name= "service_location")
    private String serviceLocation;

    @Column(name= "category")
    private String category;

    @Column(name= "sub_category")
    private String subcategory;

//    @OneToMany
//    @JoinColumn(name = "vendor_service_id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "vendorServices", cascade = CascadeType.ALL)
    private Set<ServiceOffer> serviceOffered = new HashSet<>();;

    public void addService(ServiceOffer serviceOffer){
        serviceOffered.add(serviceOffer);
        serviceOffer.setVendorServices(this);
    }
    public void removeService(ServiceOffer serviceOffer){
        serviceOffered.remove(serviceOffer);
        serviceOffer.setVendorServices(null);
    }

    @Column(name= "descriptions")
    private String descriptions;

    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(
            mappedBy = "vendorServices")
    private BookedServices bookedServices;
}
