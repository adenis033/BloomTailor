package com.bloomtailor.controller;

import com.bloomtailor.model.CartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/place")
    public String placeOrder(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            return "redirect:/cart";
        }

        double total = cart.stream().mapToDouble(CartItem::getSubtotal).sum();

        // simulate storing order (later we can use DB if needed)
        session.removeAttribute("cart"); // clear the cart
        model.addAttribute("orderTotal", total);
        return "order-success";
    }
}
