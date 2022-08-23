package com.godv.lgd.demo.mapper;

import com.godv.lgd.demo.model.CitiData;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2022-07-26 18:44
 **/
@Component("citiMapper")
public class CitiMapperImpl implements CitiMapper{

    @Override
    public List<CitiData> doQuery() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/citi?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull")
                .username("root")
                .password("dyw5211314").build();

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        List<CitiData> citiData = jdbcTemplate.query("select * from citi_financial_product", new BeanPropertyRowMapper<>(CitiData.class));
        return citiData;
    }
}
