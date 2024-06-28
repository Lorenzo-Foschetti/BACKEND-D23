package lorenzofoschetti.u5d10.payloads;

import java.util.UUID;

public record NewDispositivoPayload(
        String type,
        String state,
        UUID dipendenteId
) {
}
