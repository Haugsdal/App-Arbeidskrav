package org.example.Applikasjonsutviklingarbeidskrav.repository;

import org.example.Applikasjonsutviklingarbeidskrav.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    //Select all from activity where the user corresponds to our user email.
}
