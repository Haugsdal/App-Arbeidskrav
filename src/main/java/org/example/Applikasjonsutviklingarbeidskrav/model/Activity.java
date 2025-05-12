package org.example.Applikasjonsutviklingarbeidskrav.model;

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
    @Column (nullable=false, name="activity_id")
    private int activityId;

    @Column(nullable=false, name="description")
    private String description;

    @Column(nullable = false, name="duration")
    private int duration;

    @Column(nullable=false, name="accessibility")
    private String accessibility;

    @Column(nullable=false, name="published")
    private LocalDate published;

    @ManyToOne
    @JoinColumn(name="publisher")
    private User user;
}