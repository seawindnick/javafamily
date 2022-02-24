package com.study;

import static org.junit.Assert.assertTrue;

import com.study.chapter3.FileUtil;
import com.study.chapter3.HashCode;
import com.study.chapter3.RateInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {


    private Set<String> words;

    @Before
    public void before() {
        words = FileUtil.readWordList("/Volumes/work/workspace/study/javafamily/interview/src/test/java/com/study/103976个英语单词库.txt");
    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        List<RateInfo> list = HashCode.collisionRateList(words, 2, 3, 5, 7, 15, 17, 31, 32, 33, 39, 41, 63, 199);
        for (RateInfo rateInfo : list) {
            System.out.println(
                    String.format("乘数=%4d,最小Hash=%11d,最大Hash=%10d,碰撞数量=%6d,碰撞概率=%.4f%%", rateInfo.getMultiplier(), rateInfo.getMinHash(), rateInfo.getMaxHash(), rateInfo.getCollisionCount(), rateInfo.getCollisionRate() * 100));
        }


    }
}
