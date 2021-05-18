package com.godv.lgd.mybatis;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @program: lgd
 * @description:
 * @author: GodV
 * @create: 2021-05-12 19:18
 **/


@Component
public class MyAutoGenerator {

    public static void main(String[] args) {
        //构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        //配置执行策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String proPath = System.getProperty("user.dir"); //当前项目路径
        gc.setOutputDir(proPath + "/src/main/java"); //设置代码生成路径
        gc.setAuthor("科比门徒");
        gc.setOpen(false); //生成后是否打开文件夹
        gc.setFileOverride(false); //是否覆盖
        gc.setServiceName("%sService"); //去service的 I 前缀
        gc.setIdType(IdType.ID_WORKER); //主键生成策略
        gc.setDateType(DateType.ONLY_DATE); //设置日期类型
        gc.setSwagger2(true); //是否生成Swagger
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/godv?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("dyw5211314");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、配置生成哪些包，这些包放在哪
        PackageConfig pc=new PackageConfig();
        pc.setModuleName("block"); //设置并生成该模块包
        pc.setParent("com.godv.lgd"); //设置模块存放位置
        pc.setEntity("entity"); //设置并生成存放实体类包
        pc.setMapper("mapper");//设置并生成存放mapper接口的包
        pc.setService("service"); //设置并生成service层所在的包
        pc.setController("controller"); //设置并生成controller层所在的包
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy=new StrategyConfig();
        strategy.setInclude("user"); //设置要映射的表名！！！！
        strategy.setNaming(NamingStrategy.underline_to_camel); //表名中下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//表中字段如果有下划线，转驼峰命名
        strategy.setEntityLombokModel(true);//自动生成Lombok
        strategy.setRestControllerStyle(true);//开启 RestFul 风格
        strategy.setControllerMappingHyphenStyle(true);
        //设置逻辑删除，对表中的那个字段
        strategy.setLogicDeleteFieldName("deleted");

        //自动填充 (表中如果有创建时间、修改时间话，可以使用自动填充)
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        //乐观锁配置
        strategy.setVersionFieldName("version");
        mpg.setStrategy(strategy);


        mpg.execute();//执行代码生成操作

    }
}
