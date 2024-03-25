package Lesson6.Lesson6.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_table")
@Data
public class MyTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String taskDescription;
    @Column(nullable = false)
    private String taskContent;
    @Column
    private LocalDateTime taskDateOfCreation = new Timestamp(System.currentTimeMillis()).toLocalDateTime();


}
