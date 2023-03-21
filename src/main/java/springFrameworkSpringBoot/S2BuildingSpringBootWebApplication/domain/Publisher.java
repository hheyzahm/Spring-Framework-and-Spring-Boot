package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * @Created 21 03 2023 - 11:38 AM
 * @Author Hazeem Hassan
 */
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publisherID;
    private String publisherName;
    private String publisherAddress;
    private String publisherCity;
    private String publisherState;
    private String publisherZipCode;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
    public Long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Long publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public String getPublisherState() {
        return publisherState;
    }

    public void setPublisherState(String publisherState) {
        this.publisherState = publisherState;
    }

    public String getPublisherZipCode() {
        return publisherZipCode;
    }

    public void setPublisherZipCode(String publisherZipCode) {
        this.publisherZipCode = publisherZipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(publisherID, publisher.publisherID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherID);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Publisher ID=" + publisherID +
                ", Publisher Name='" + publisherName + '\'' +
                ", Publisher Address='" + publisherAddress + '\'' +
                ", Publisher City='" + publisherCity + '\'' +
                ", Publisher State='" + publisherState + '\'' +
                ", Publisher ZipCode='" + publisherZipCode + '\'' +
                '}';
    }
}
