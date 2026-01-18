package com.jothmart.todobackend.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "users")
// public class User implements UserDetails {

public class User  {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false) 
    private Integer id;

   /*  @Column(nullable = false)
    private String firstName;

     @Column(nullable = false)
    private String lastName;

    @Column(unique = true, length = 100, nullable = false)
    private String email; */

 //   @Column(nullable = false)
    private String username;

 //   @Column(nullable = false)
    private String password;

   /*  @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
 */
 // @Override
    public Integer getId() {
        return id;
    }

  //  @Override
    public String getPassword() {
        return password;
    }

  //  @Override
    public String getUsername() {
        return username;
    }


    
}
