package com.learning.final_project.model.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "person")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  private String password;

  @Column(name = "user_handphone")
  private String handphone;

  @Column(name = "created_on")
  private Instant createdOn;
}
