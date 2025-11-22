package com.restaurant.repository;

import com.restaurant.model.Dish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepository {
    private final JdbcTemplate jdbc;
    private final RowMapper<Dish> mapper = (rs, rowNum) -> {
        Dish d = new Dish();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setDescription(rs.getString("description"));
        d.setPrice(rs.getDouble("price"));
        d.setImageUrl(rs.getString("image_url"));
        d.setAvailable(rs.getInt("available"));
        return d;
    };

    public DishRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Dish> findAll() {
        return jdbc.query("SELECT * FROM dishes", mapper);
    }

    public Dish findById(int id) {
        return jdbc.queryForObject("SELECT * FROM dishes WHERE id = ?", new Object[]{id}, mapper);
    }

    public int save(Dish d) {
        return jdbc.update("INSERT INTO dishes(name,description,price,image_url,available) VALUES (?,?,?,?,?)",
                d.getName(), d.getDescription(), d.getPrice(), d.getImageUrl(), d.getAvailable());
    }

    public int update(Dish d) {
        return jdbc.update("UPDATE dishes SET name=?,description=?,price=?,image_url=?,available=? WHERE id=?",
                d.getName(), d.getDescription(), d.getPrice(), d.getImageUrl(), d.getAvailable(), d.getId());
    }

    public int delete(int id) {
        return jdbc.update("DELETE FROM dishes WHERE id=?", id);
    }
}