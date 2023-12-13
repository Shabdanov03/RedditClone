package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "subreddits")
@Entity
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "subreddit_id_gen")
    @SequenceGenerator(name = "subreddit_id_gen",sequenceName = "subreddit_id_seq")
    private Long id;
    private String name;
    private String description;
    private Instant createdDate;
    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    @ManyToOne(fetch = LAZY)
    private User user;
}
