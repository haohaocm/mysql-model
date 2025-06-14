package org.example.mysqlmodel.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

@Data
@TableName("data_types_demo")
public class DataTypesDemo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Byte tinyIntVal;
    private Short smallIntVal;
    private Integer mediumIntVal;
    private Integer intVal;
    private Long bigIntVal;

    private Float floatVal;
    private Double doubleVal;
    private BigDecimal decimalVal;

    private String charVal;
    private String varcharVal;
    private String textVal;
    private String longtextVal;

    private LocalDate dateVal;
    private LocalTime timeVal;
    private LocalDateTime datetimeVal;
    private Timestamp timestampVal;
    private Year yearVal;

    private Boolean booleanVal;
    private String enumVal;
    private String setVal;

    private byte[] blobVal;
}

