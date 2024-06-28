package lorenzofoschetti.u5d10.payloads;

import lorenzofoschetti.u5d10.enums.State;
import lorenzofoschetti.u5d10.enums.Type;

import java.util.UUID;

public record NewDispositivoPayload(
        Type type,
        State state,
        UUID dipendenteId
) {
}
