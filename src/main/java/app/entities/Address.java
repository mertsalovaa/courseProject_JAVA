package app.entities;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable=false)
    private String Country;

    @Column(nullable=false)
    private String City;

    @Column(nullable=false)
    private String Street;

    @Column(nullable=false)
    private String Home;

    public Address() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }
}
