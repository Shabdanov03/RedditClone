package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notification-email")
@Entity
public class NotificationEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_id_gen")
    @SequenceGenerator(name = "email_id_gen", sequenceName = "email_id_seq", allocationSize = 1)
    private Long id;
}
