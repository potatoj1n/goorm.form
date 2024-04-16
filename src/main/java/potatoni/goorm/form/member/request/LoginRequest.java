package potatoni.goorm.form.member.request;

import jakarta.validation.constraints.NotNull;

public record LoginRequest (
        @NotNull String loginId,
        @NotNull String password
){
}
