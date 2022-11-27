package pl.sda.hibernate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double wartosc;

    @CreationTimestamp
    private LocalDateTime dataCzasDodania;

    //    RELACJE
    @ManyToOne
    @ToString.Exclude
    private Student uczen; // kolumna student_id
}
