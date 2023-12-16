package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_gen")
    @SequenceGenerator(name = "comment_id_gen", sequenceName = "comment_id_seq", allocationSize = 1)
    private Long id;
    private String text;
    @ManyToOne(fetch = LAZY)
    private Post post;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    private User user;
}
