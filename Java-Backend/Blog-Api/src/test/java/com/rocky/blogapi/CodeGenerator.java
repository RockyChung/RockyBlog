package com.rocky.blogapi;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        // 1. 資料庫配置
        FastAutoGenerator.create("jdbc:postgresql://ep-cold-breeze-a16jmu1p-pooler.ap-southeast-1.aws.neon.tech:5432/BlogApiDB?sslmode=require&currentSchema=public",
                        "neondb_owner",
                        "npg_QXgfHmO7na2K")

                // 2. 全局配置
                .globalConfig(builder -> {
                    builder.author("Rocky") // 設定作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定輸出目錄
                            .disableOpenDir(); // 生成後不自動打開目錄
                })

                // 3. 包配置
                .packageConfig(builder -> {
                    builder.parent("com.rocky.blogapi") // 設定父包名
                            // 設定 Mapper XML 生成路徑
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"));
                })

                // 4. 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("m_user", "m_blog") // 設定需要生成的表名
                            .addTablePrefix("m_") // 設定過濾表前綴 (生成 User 而不是 MUser)

                            // Entity 策略
                            .entityBuilder()
                            .enableLombok() // 開啟 Lombok
                            .enableTableFieldAnnotation() // 開啟欄位註解

                            // Controller 策略
                            .controllerBuilder()
                            .enableRestStyle(); // 開啟 @RestController
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用 Velocity 引擎
                .execute();
    }
}