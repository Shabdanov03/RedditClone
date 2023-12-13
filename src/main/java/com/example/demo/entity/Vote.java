package com.example.demo.entity;

import com.example.demo.enums.VoteType;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "votes")
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vote")
    @SequenceGenerator(name = "vote_id_gen",sequenceName = "vote_id_seq",allocationSize = 1)
    private Long id;
    @Enumerated(STRING)
    private VoteType voteType;
    @ManyToOne(fetch = LAZY)
    private Post post;
    @ManyToOne(fetch = LAZY)
    private User user;

}
