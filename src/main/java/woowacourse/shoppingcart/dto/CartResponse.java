package woowacourse.shoppingcart.dto;

import woowacourse.shoppingcart.domain.Cart;
import woowacourse.shoppingcart.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartResponse {

    private List<CartResponseElement> products;

    public CartResponse() {
    }

    public CartResponse(Cart cart) {
        List<Product> products = cart.getProducts();
        List<Long> ids = cart.getIds();
        List<Boolean> checks = cart.getChecks();
        List<Integer> quantities = cart.getQuantities();
        this.products = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            this.products.add(new CartResponseElement(ids.get(i), products.get(i), checks.get(i), quantities.get(i)));
        }
    }

    public List<CartResponseElement> getProducts() {
        return products;
    }
}