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
@Table(name = "verification_tokens")
@Entity
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "token_id_gen")
    @SequenceGenerator(name = "token_id_gen",sequenceName = "token_id_seq",allocationSize = 1)
    private Long id;
    private String token;
    @OneToOne(fetch = LAZY)
    private User user;
    private Instant expiryDate;
}
