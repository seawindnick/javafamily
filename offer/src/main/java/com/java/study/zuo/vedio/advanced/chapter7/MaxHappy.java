package com.java.study.zuo.vedio.advanced.chapter7;

import lombok.Data;

import java.util.*;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-24 23:02
 */
public class MaxHappy {

    @Data
    private static class Employee{
        private int value;
        private int index;
        private List<Employee> sub = new ArrayList<>();
    }
    @Data
    public static class Result{
        private int joinValue;
        private int notJoinValue;

        public Result(int joinValue, int notJoinValue) {
            this.joinValue = joinValue;
            this.notJoinValue = notJoinValue;
        }
    }


    public static int maxHappy2(int[][] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int[][]dp = new int[arr.length][2];
        int root = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (i == arr[i][0]){
                root = i;
                break;
            }
        }
        boolean[] visited = new boolean[arr.length];
        process(arr, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);


    }

    private static void process(int[][] arr, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = arr[root][1];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i][0] == root && !visited[i]){
                process(arr,dp,visited,i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }

        }
    }


    public static int maxHappy(int[][] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }


        Map<Integer,Employee> employeeMap = new HashMap<>();
        for (int i = 0; i <  arr.length; i++) {
            employeeMap.put(i,new Employee());
        }

        int bossIndex = -1;

        for (int i = 0; i < arr.length ; i++) {
            int[] relation = arr[i];
            int parentIndex = relation[0];
            int value = relation[1];

            Employee indexEmployee = employeeMap.get(i);
            indexEmployee.setIndex(i);
            indexEmployee.setValue(value);

            if (i == parentIndex){
                bossIndex = i;
            }

            if (i != parentIndex){
                employeeMap.get(parentIndex).getSub().add(indexEmployee);
            }
        }


        Employee boss = employeeMap.get(bossIndex);

        Result result = maxHappy(boss);
        return Math.max(result.joinValue,result.notJoinValue);


    }

    private static Result maxHappy(Employee employee) {
        if (employee.getSub() == null || employee.getSub().isEmpty()){
            return new Result(employee.getValue(),0);
        }

        int joinValue = employee.getValue();
        int notJoinValue = 0;

        for (int i = 0; i < employee.getSub().size(); i++) {
            Employee sub = employee.getSub().get(i);
            Result result = maxHappy(sub);
            notJoinValue = notJoinValue + Math.max(result.joinValue,result.notJoinValue);
            joinValue = joinValue + result.getNotJoinValue();

        }

        return new Result(joinValue,notJoinValue);

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }

}
