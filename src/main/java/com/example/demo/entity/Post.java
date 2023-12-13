package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "posts")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_id_gen")
    @SequenceGenerator(name = "post_id_gen",sequenceName = "post_id_seq",allocationSize = 1)
    private Long id;
    private String postName;
    private String url;
    @Lob
    private String description;
    private Integer voteCount;
    private Instant createdDate;

}


