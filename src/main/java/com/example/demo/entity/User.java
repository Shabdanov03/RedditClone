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
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen",sequenceName = "user_id_seq",allocationSize = 1)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Instant createdDate;
    private boolean enabled;


}
