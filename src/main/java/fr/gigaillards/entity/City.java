package fr.gigaillards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;

@Entity
@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
public class City {
    private Long id;

    @NotBlank(message = "Department code cannot be blank")
    private String departmentCode;

    @NotBlank(message = "Zip Code cannot be blank")
    private String zipCode;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private Float lat;

    private Float lon;

    @Id
    @SequenceGenerator(name = "citySeq", sequenceName = "city_id_seq")
    @GeneratedValue(generator = "citySeq")
    public Long getId() {
        return id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }
}
