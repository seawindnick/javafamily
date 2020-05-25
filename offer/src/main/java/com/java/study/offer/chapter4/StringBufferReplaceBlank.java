package com.java.study.offer.chapter4;

import com.alibaba.fastjson.JSONArray;

import java.util.Objects;

public class StringBufferReplaceBlank {


    public static void main(String[] args) {

//        System.out.println(replaceBlankUseArray("we are"));
        Character[] characters = new Character[18];
        String str = "B CAA";
        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }

        Character[] tempChar = endToStartRepalce(characters);

        System.out.println(JSONArray.toJSONString(tempChar));

    }


    private static Character[] endToStartRepalce(Character[] targetCharacters) {
        if (Objects.isNull(targetCharacters) || targetCharacters.length == 0) {
            return null;
        }
        int originStrLength = 0;

        //统计空格数量
        int blankCount = 0;
        for (Character targetCharacter : targetCharacters) {
            if (Objects.isNull(targetCharacter)) {
                break;
            }
            originStrLength++;
            if (Objects.equals(targetCharacter, ' ')) {
                blankCount++;
            }
        }

        int targetLength = originStrLength + 2 * blankCount;
        //说明无空格
        if (targetLength == originStrLength) {
            return targetCharacters;
        }

        int targetEndIndex = targetLength - 1;

        for (int index = originStrLength - 1; index >= 0 && index < targetEndIndex; index--) {
            Character character = targetCharacters[index];
            if (!Objects.equals(character, ' ')) {
                targetCharacters[targetEndIndex] = character;
            } else {
                targetCharacters[targetEndIndex] = '0';
                targetCharacters[--targetEndIndex] = '2';
                targetCharacters[--targetEndIndex] = '%';
            }
            targetEndIndex--;

        }
        return targetCharacters;
    }


    private static Character[] replaceArrayBlank(Character[] targetCharacters) {
        if (Objects.isNull(targetCharacters) || targetCharacters.length == 0) {
            return null;
        }
        int originStrLength = 0;

        //统计空格数量
        int blankCount = 0;
        for (Character targetCharacter : targetCharacters) {
            if (Objects.isNull(targetCharacter)) {
                break;
            }
            originStrLength++;
            if (Objects.equals(targetCharacter, ' ')) {
                blankCount++;
            }
        }

        int targetLength = originStrLength + 2 * blankCount;
        //说明无空格
        if (targetLength == originStrLength) {
            return targetCharacters;
        }

        //原始数组不能进行完成替换
        if (targetLength > targetCharacters.length) {
            return null;
        }

        //已经处理的空格数量
        int handleCount = 0;
        for (int index = 0; index < targetLength; index++) {

            //如果已经处理的空格数量与统计的空格数量一致，已经不需要进行处理
            if (handleCount == blankCount) {
                break;
            }

            Character character = targetCharacters[index];
            if (Objects.isNull(character)) {
                break;
            }

            if (!Objects.equals(character, ' ')) {
                continue;
            }

            //不为空字符最后位置
            int originEndIndex = originStrLength + handleCount * 2 - 1;

            //向后移动两位
            for (int i = originEndIndex; i > index; i--) {
                targetCharacters[i + 2] = targetCharacters[i];
            }

            targetCharacters[index] = '%';
            targetCharacters[++index] = '2';
            targetCharacters[++index] = '0';

            handleCount++;
        }
        return targetCharacters;
    }


    private static String replaceBlankUseArray(String originStr) {
        if (Objects.isNull(originStr) || originStr.length() == 0) {
            return null;
        }

        int originLength = originStr.length();
        int blankCount = 0;
        for (int index = 0; index < originLength; index++) {
            Character indexCharacter = originStr.charAt(index);
            if (Objects.equals(indexCharacter, ' ')) {
                blankCount++;
            }
        }

        int newLength = originLength + blankCount * 2;
        char[] newStrArray = new char[newLength];
        int newStrStartIndex = 0;
        for (int index = 0; index < originLength; index++) {
            char indexCharacter = originStr.charAt(index);
            if (indexCharacter != ' ') {
                newStrArray[newStrStartIndex] = indexCharacter;
            } else {
                newStrArray[newStrStartIndex] = '%';
                newStrArray[++newStrStartIndex] = '2';
                newStrArray[++newStrStartIndex] = '0';
            }
            //新数组复制完之后，指向下一个需要处理的位置
            newStrStartIndex++;
        }
        return new String(newStrArray);
    }


    private static String replaceBlank(String originStr) {
        if (Objects.isNull(originStr) || originStr.length() == 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int length = originStr.length();
        for (int index = 0; index < length; index++) {
            Character character = originStr.charAt(index);
            if (!Objects.equals(character, ' ')) {
                builder.append(character);

            } else {
                builder.append("%").append("20");
            }
        }
        return builder.toString();
    }
}
