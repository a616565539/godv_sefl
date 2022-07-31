package com.godv.demo.mapper;

import com.godv.demo.model.CitiData;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-07-31 21:49
 **/

public class CitiMapperImpl implements CitiMapper{

    @Override
    public List<CitiData> doQuery() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/godv?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull")
                .username("root")
                .password("dyw5211314").build();

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        List<CitiData> citiData = jdbcTemplate.queryForList("select * from citi_financial_product", CitiData.class);
        return citiData;
    }
}
