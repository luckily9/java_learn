package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address) && Objects.equals(home, that.home) && Objects.equals(mobile, that.mobile) && Objects.equals(email, that.email) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(work, that.work) && Objects.equals(allPhones, that.allPhones) && Objects.equals(allEmails, that.allEmails) && Objects.equals(photo, that.photo) && Objects.equals(groups, that.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, home, mobile, email, email2, email3, work, allPhones, allEmails, photo, groups);
  }

  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstname;
  @Expose
  @Column(name ="lastname")
  private String lastname;
  @Expose
  @Type(type="text")
  @Column(name ="address")
  private String address;
  @Expose
  @Column(name ="home")
  @Type(type="text")
  private String home;
  @Expose
  @Column(name ="mobile")
  @Type(type="text")
  private String mobile;
  @Expose
  @Column(name ="email")
  @Type(type="text")
  private String email;
  @Expose
  @Column(name ="email2")
  @Type(type="text")
  private String email2;
  @Expose
  @Column(name ="email3")
  @Type(type="text")
  private String email3;
  @Expose
  @Column(name ="work")
  @Type(type="text")
  private String work;


  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column(name ="photo")
  @Type(type="text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }





  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }



  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }



  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }



  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }


  public Groups getGroups() {
    return new Groups(groups);
  }

  public int getId() {return id;}

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return  work;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail() {
    return email;
  }


  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }
}
