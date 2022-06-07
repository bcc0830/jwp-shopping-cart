package woowacourse.shoppingcart.domain;

import woowacourse.shoppingcart.exception.InvalidInformationException;

public class ProductNameValidationImpl implements NameValidation {

    @Override
    public void validateName(String name) {
        validateNotNull(name);
        validateNotEmpty(name);
        validateNotStartOrEndWithBlank(name);
        validateNotSpecialCharExist(name);
        validateMaxSize(name);
    }

    private void validateNotNull(String username) {
        if (username == null) {
            throw new InvalidInformationException("[ERROR] 상품 이름은 null이 될 수 없습니다.");
        }
    }

    private void validateNotEmpty(String username) {
        if (username.isEmpty()) {
            throw new InvalidInformationException("[ERROR] 상품 이름은 빈 값일 수 없습니다.");
        }
    }

    private void validateNotStartOrEndWithBlank(String username) {
        if (username.length() != username.trim().length()) {
            throw new InvalidInformationException("[ERROR] 상품 이름은 공백으로 시작하거나 끝날 수 없습니다.");
        }
    }

    private void validateNotSpecialCharExist(String username) {
        if (!username.matches("[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣\\s]+")) {
            throw new InvalidInformationException("[ERROR] 상품 이름에는 특수문자가 들어갈 수 없습니다.");
        }
    }

    private void validateMaxSize(String username) {
        if (username.length() > 32) {
            throw new InvalidInformationException("[ERROR] 상품 이름은 최대 32자 이하여야 합니다.");
        }
    }
}