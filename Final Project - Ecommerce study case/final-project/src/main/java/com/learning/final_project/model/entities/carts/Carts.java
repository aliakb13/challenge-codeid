package com.learning.final_project.model.entities.carts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learning.final_project.model.entities.BaseEntity;
import com.learning.final_project.model.entities.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "oe")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carts extends BaseEntity{
  @Id
  @Column(name = "cart_id")
  private String id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<CartItems> items;
}
