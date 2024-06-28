package lorenzofoschetti.u5d10.payloads;

import jakarta.validation.constraints.NotEmpty;

public record NewDipendentePayload(
        @NotEmpty(message = "Il nome è obbligatorio!")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio!")
        String surname,
        @NotEmpty(message = "Lo username è obbligatorio!")
        String username,
        @NotEmpty(message = "L'email è obbligatoria!")
        String email
) {
}
