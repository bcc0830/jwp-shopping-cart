package woowacourse.shoppingcart.dto;

import woowacourse.shoppingcart.validation.PasswordCheck;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePasswordRequest {
    private static final String INVALID_PASSWORD = "[ERROR] 비밀번호는 빈 값일 수 없습니다.";
    private static final String INVALID_PASSWORD_SIZE = "[ERROR] 비밀번호는 최소 6자 이상이어야 합니다.";
    @NotNull(message = INVALID_PASSWORD)
    @PasswordCheck()
    @Size(min = 6, message = INVALID_PASSWORD_SIZE)
    private final String oldPassword;
    @NotNull(message = INVALID_PASSWORD)
    @PasswordCheck()
    @Size(min = 6, message = INVALID_PASSWORD_SIZE)
    private final String newPassword;

    public ChangePasswordRequest(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}