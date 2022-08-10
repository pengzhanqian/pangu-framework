package com.pangu.framework;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.pangu.framework.utils.PanguStrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 */
public class MybatisPlusGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (PanguStrUtil.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        //得到当前项目的路径
        String projectPath = MybatisPlusGenerator.class.getResource("/").getPath().replaceAll("/target/(test-)?classes/", "");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //设置统一设置生成的文件输出的根目录  我们这里不进行配置 因为不同的文件会出现再不同的服务中
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("mybatis plus generator");
        //设置生成代码后是否打开文件
        gc.setOpen(false);
        //设置是否覆盖源文件
        gc.setFileOverride(true);
        //设置是否开启activeRecord模式                          默认关闭
        gc.setActiveRecord(false);
        //设置是否开启XML中的Mybatis的二级缓存                   默认关闭
        gc.setEnableCache(false);
        //设置是否配置XML中的ResultMap                          默认关闭
        gc.setBaseResultMap(false);
        //设置是否配置XML的基础字段 baseColumnList              默认关闭
        gc.setBaseColumnList(false);
        //设置是否开启Swagger2的注解放在Controller中的方法上     默认关闭
        gc.setSwagger2(false);
        /**
         *     设置主键策略
         *     {@link com.baomidou.mybatisplus.annotation.IdType}
         *     本次选择不处理 业务注入
         */
        gc.setIdType(IdType.NONE);
        //设置生成的代码中的注释的日期格式
        gc.setDateType(DateType.ONLY_DATE);
        //设置MapperName xmlMapperName serviceName serviceImplName controllerName
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        //将全局配置加入生成器
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://10.10.8.15:3306/mdc_live?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("ufhUhsd7ysdGH");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        //pc.setParent("com.muducloud.phoenix.job.autodb");
//        pc.setModuleName("issue");
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.crgecent.entity.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.crgecent.admin.BaseController");
        //        String tables = scanner("表名：");
        strategy.setInclude("mdc_publish_realtime_transcode");
//        strategy.setInclude("mc_dict_channel");
        //        strategy.setSuperEntityColumns("id");
        //        strategy.setSuperEntityColumns("create_time");
        //        strategy.setSuperEntityColumns("update_time");
        //        strategy.setSuperEntityColumns("status");
        strategy.setControllerMappingHyphenStyle(true);

        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix("mdc_");
        mpg.setStrategy(strategy);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
