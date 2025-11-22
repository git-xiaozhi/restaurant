package com.restaurant.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    private final JdbcTemplate jdbc;

    public OrderController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // 接收一个简单的订单对象 { customerName: "", total: 100.0, items: [...] }
    @PostMapping
    public String placeOrder(@RequestBody Map<String,Object> payload) {
        Double total = payload.get("total") == null ? 0.0 : Double.valueOf(payload.get("total").toString());
        String customerName = payload.getOrDefault("customerName","").toString();
        // 将 items 转为 JSON 字符串保存
        try {
            com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
            String itemsJson = om.writeValueAsString(payload.getOrDefault("items","[]"));
            jdbc.update("INSERT INTO orders(customer_name,total,items_json) VALUES (?,?,?)", customerName, total, itemsJson);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}