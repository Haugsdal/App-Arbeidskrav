package org.example.mailserver.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="Activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long activityId;

    @Column(nullable=false, name="description")
    private String description;

    @Column(nullable = false, name="duration")
    private int duration;

    @Column(nullable=false, name="accessibility")
    private Boolean accessibility;

    @Column(nullable=false, name="published")
    private LocalDate published;
}