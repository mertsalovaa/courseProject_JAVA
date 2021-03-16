package app.entities;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable=false)
    private String FirstName;

    @Column(nullable=false)
    private String LastName;

    @Column(nullable = false)
    private Date Birthday;

    @Column(nullable = false)
    private String Phone;

    @Column(nullable=false)
    private String email;

    @Column(nullable = false)
    @Size(min=4)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_id", referencedColumnName = "Id")
    private Address address;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="tblUserRoles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
    private List<Role> roles;

    public User() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}