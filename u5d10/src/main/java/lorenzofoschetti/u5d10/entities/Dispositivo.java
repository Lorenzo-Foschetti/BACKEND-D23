package lorenzofoschetti.u5d10.entities;

import jakarta.persistence.*;
import lombok.*;
import lorenzofoschetti.u5d10.enums.Type;

import java.util.UUID;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dispositivo {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private Type type;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(Type type) {
        this.type = type;
    }
}
