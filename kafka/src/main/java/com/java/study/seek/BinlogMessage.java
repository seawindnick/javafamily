package com.java.study.seek;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Setter
@Slf4j
public class BinlogMessage {
    /**
     * INSERT/DELETE/UPDATE
     */
    private String type;
    /**
     * 业务数据全链路追踪id，需要回传给检索用于对数据跟踪
     */
    private Long traceId;
    /**
     * 数据变更时间戳
     */
    private Long timestamp;
    /**
     * 变更的表
     */
    private String table;
    /**
     * 变更事件唯一标识#port#logfilename#binlogpostition#epx-receive-time（ 时间戳，ms）#epx-send-time（
     * 时间戳，ms）
     */
    private String id;
    /**
     * 变更的数据库
     */
    private String database;
    /**
     * 数据来源标识,为 kafka的key
     */
    private String data;
    /**
     * 变更的表中的所有字段值，所有值类型为字符串类型
     */
    private Map<String, String> content;
    /**
     * 变更字段信息，key为字段名，before为变更前的值，after为变更后的值
     */
    private Map<String, Map<String, String>> changed;

}
