package lorenzofoschetti.u5d10.entities;

import jakarta.persistence.*;
import lombok.*;
import lorenzofoschetti.u5d10.enums.State;
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
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(State state, Type type) {
        this.state = state;
        this.type = type;
    }
}
