package com.wywang.webstore.rowmapper;

import com.wywang.webstore.constant.ProductCategory;
import com.wywang.webstore.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        String categorystr = resultSet.getString("category");
        ProductCategory category = ProductCategory.valueOf(categorystr);
        product.setCategory(category);

        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setImageUrl(resultSet.getString("image_url"));
        return product;
    }
}
