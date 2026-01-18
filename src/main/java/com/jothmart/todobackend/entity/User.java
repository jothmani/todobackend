package com.jothmart.todobackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "users")
// public class User implements UserDetails {

public class User  {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", sequenceName = "users_SEQ", allocationSize = 1)
    @Column(nullable = false) 
    private Integer user_id;

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
    /* public Integer getUser_id() {
        return user_id;
    } */




  //  @Override
    public String getPassword() {
        return password;
    }

  //  @Override
    public String getUsername() {
        return username;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}
