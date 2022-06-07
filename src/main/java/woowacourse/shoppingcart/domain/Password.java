package woowacourse.shoppingcart.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import woowacourse.shoppingcart.exception.InvalidInformationException;

import java.util.Objects;

public class Password {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final String password;

    public Password(String password) {
        validateNotNull(password);
        validateNotEmpty(password);
        validateNotPasswordForm(password);
        validateMinSize(password);
        this.password = password;
    }

    private void validateNotNull(String password) {
        if (password == null) {
            throw new InvalidInformationException("[ERROR] 비밀번호는 null일 수 없습니다.");
        }
    }

    private void validateNotEmpty(String password) {
        if (password.isEmpty()) {
            throw new InvalidInformationException("[ERROR] 비밀번호는 빈 값일 수 없습니다.");
        }
    }

    private void validateNotPasswordForm(String password) {
        if (password.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") || !password.matches("\\S+")) {
            throw new InvalidInformationException("[ERROR] 비밀번호는 한글이나 공백이 들어갈 수 없습니다.");
        }
    }

    private void validateMinSize(String password) {
        if (password.length() < 6) {
            throw new InvalidInformationException("[ERROR] 비밀번호는 최소 6자 이상이어야 합니다.");
        }
    }

    public String generateEncodedPassword() {
        return encoder.encode(password);
    }

    public boolean isSamePassword(Password rawPassword) {
        return encoder.matches(rawPassword.getPassword(), password);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}