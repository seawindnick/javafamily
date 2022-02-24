package com.java.study;

import com.alibaba.fastjson.JSONArray;

import java.util.HashSet;
import java.util.Set;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/30/21 14:35
 */
public class Compare {

    public static void main(String[] args) {

        String str =

                "   private Long procedureId;\n" +
                        "    private Long customerId;\n" +
                        "    private String customerName;\n" +
                        "    private String customerPhone;\n" +
                        "    private Long agentId;\n" +
                        "    private String agentCode;\n" +
                        "    private String agentPhone;\n" +
                        "    private String agentName;\n" +
                        "    private String businessCode;\n" +
                        "    private String houseCode;\n" +
                        "    private Long managerId;\n" +
                        "    private Byte houseType;\n" +
                        "    private Byte status;\n" +
                        "    private Date appointmentTime;\n" +
                        "    private Date expireDate;\n" +
                        "    private String remark;\n" +
                        "    private String address;\n" +
                        "    private List<ProcedureOpModel> procedureOps;\n" +
                        "    private String houseName;\n" +
                        "    private Date mtime;\n" +
                        "    private Date ctime;\n" +
                        "    private Long channelOperatorUcId;\n" +
                        "    private String cityCode;\n" +
                        "    private Long configId;\n" +
                        "    private List<Long> configIds;\n" +
                        "\n" +
                        "    private Date signApprovedTime;\n" +
                        "\n" +
                        "    private String storeCode;\n" +
                        "\n" +
                        "    private Byte type;";

        Set<String> set1 = getMap(str);

        String str2 = "private Long procedureId;\n" +
                "\n" +
                "    private Long agentId;\n" +
                "\n" +
                "    private String agentCode;\n" +
                "\n" +
                "    private String agentPhone;\n" +
                "\n" +
                "    private String agentName;\n" +
                "\n" +
                "    private Long customerId;\n" +
                "\n" +
                "    private String customerName;\n" +
                "\n" +
                "    private String customerPhone;\n" +
                "\n" +
                "    private String businessCode;\n" +
                "\n" +
                "    private String address;\n" +
                "\n" +
                "    private String houseCode;\n" +
                "\n" +
                "    private Byte houseType;\n" +
                "\n" +
                "    private String houseName;\n" +
                "\n" +
                "    private Long managerId;\n" +
                "\n" +
                "    private Long channelOperatorUcId;\n" +
                "\n" +
                "    private Long configId;\n" +
                "\n" +
                "    private Byte status;\n" +
                "\n" +
                "    private Date appointmentTime;\n" +
                "\n" +
                "    private Date expireDate;\n" +
                "\n" +
                "    private String remark;\n" +
                "\n" +
                "    private Date ctime;\n" +
                "\n" +
                "    private Date mtime;\n" +
                "\n" +
                "    private String cityCode;\n" +
                "\n" +
                "    private Date signApprovedTime;\n" +
                "\n" +
                "    private String storeCode;\n" +
                "\n" +
                "    private Byte type;\n" +
                "\n" +
                "    private Integer flowType";

        Set<String> set2 = getMap(str2);
        for (String o : set1) {
            if (!set2.contains(o)){
                System.out.println(o);
            }
        }

        System.out.println("-----------");

//        System.out.println(JSONArray.toJSONString(set1));
//        System.out.println(JSONArray.toJSONString(set2));
        for (String o : set2) {
            if (!set1.contains(o)){
                System.out.println(o);
            }
        }


    }


    public static Set<String> getMap(String str) {
        String[] array = str.split("private");
        Set set = new HashSet();

        for (String s : array) {
            if (s.contains("*") || s.trim().length() == 0) {
                continue;
            }
            s = s.replace(";", "").trim();
            set.add(s);

        }
        return set;

    }
}
