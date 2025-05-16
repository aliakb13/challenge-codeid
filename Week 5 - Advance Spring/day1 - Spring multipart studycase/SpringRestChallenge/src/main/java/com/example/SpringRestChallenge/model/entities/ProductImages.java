package com.example.SpringRestChallenge.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_images", schema = "oe")
public class ProductImages {
  @Id
  @Column(name = "image_id")
  private String imageId;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "file_size")
  private Double fileSize;

  @Column(name = "file_type")
  private String fileType;

  @Column(name = "file_uri")
  private String fileUri;

  @JoinColumn(name = "product_id")
  @ManyToOne
  @JsonBackReference
  private Products products;
}
