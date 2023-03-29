package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * @Created 28 03 2023 - 11:29 AM
 * @Author Hazeem Hassan
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
public class BeerOrderS16 {

    public BeerOrderS16(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef,
                        CustomerEntityS16 customer, Set<BeerOrderLineS16> beerOrderLineS16s, BeerOrderShipmentS16 beerOrderShipmentS16) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.customerRef = customerRef;
        this.setCustomer(customer);
        this.beerOrderLineS16s = beerOrderLineS16s;
        this.setBeerOrderShipmentS16(beerOrderShipmentS16);
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false )
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    public boolean isNew() {
        return this.id == null;
    }

    private String customerRef;

    @ManyToOne
    private CustomerEntityS16 customer;

    public void setCustomer(CustomerEntityS16 customer) {
        this.customer = customer;
        customer.getBeerOrderS16s().add(this);
    }

    public void setBeerOrderShipmentS16(BeerOrderShipmentS16 beerOrderShipmentS16) {
        this.beerOrderShipment = beerOrderShipmentS16;
        beerOrderShipmentS16.setBeerOrderS16(this);
    }

    @OneToMany(mappedBy = "beerOrder")
    private Set<BeerOrderLineS16> beerOrderLineS16s;

    @OneToOne(cascade = CascadeType.PERSIST)
    private BeerOrderShipmentS16 beerOrderShipment;


}