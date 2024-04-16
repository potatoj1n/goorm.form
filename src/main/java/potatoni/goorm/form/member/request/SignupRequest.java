package potatoni.goorm.form.member.request;

import jakarta.validation.constraints.NotNull;

public record SignupRequest (
        @NotNull String loginId,
        @NotNull String name,
        @NotNull String password
){
}
