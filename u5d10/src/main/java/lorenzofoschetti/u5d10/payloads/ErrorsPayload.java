package lorenzofoschetti.u5d10.payloads;

import java.time.LocalDateTime;

public record ErrorsPayload(String message, LocalDateTime errorTime) {
}
