package leetCode;//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。
//
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//
// 示例 2：
//
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//
// 提示：
//
//
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 899 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10207_CanFinish {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(canFinish(2,prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return false;
        }

        Map<Integer, CoursesNode> coursesNodeMap = new HashMap<>();
        for (int rowIndex = 0; rowIndex < prerequisites.length; rowIndex++) {
            int[] columnValue = prerequisites[rowIndex];
            int studyCoursesId = columnValue[0];
            int relyCoursesId = columnValue[1];

            CoursesNode studyCourseNode = coursesNodeMap.get(studyCoursesId);
            if (studyCourseNode == null) {
                studyCourseNode = new CoursesNode();
                studyCourseNode.coursesId = studyCoursesId;
                coursesNodeMap.put(studyCoursesId,studyCourseNode);
            }

            CoursesNode relyCourseNode = coursesNodeMap.get(relyCoursesId);
            if (relyCourseNode == null){
                relyCourseNode = new CoursesNode();
                relyCourseNode.coursesId = relyCoursesId;
                coursesNodeMap.put(relyCoursesId,relyCourseNode);
            }

            studyCourseNode.relyCoursesNode = relyCourseNode;
        }


        for (int rowIndex = 0; rowIndex < prerequisites.length ; rowIndex++) {
            int[] columnValue = prerequisites[rowIndex];
            int studyCoursesId = columnValue[0];
            CoursesNode studyCourseNode = coursesNodeMap.get(studyCoursesId);
            Set<CoursesNode> studiedCourseSet = new HashSet<>();
            int count = 0;
            while (!studiedCourseSet.contains(studyCourseNode)){
                studiedCourseSet.add(studyCourseNode);
                count++;
                if (count == numCourses){
                    if (!studiedCourseSet.contains(studyCourseNode.relyCoursesNode)){
                        return true;
                    }
                }
                studyCourseNode = studyCourseNode.relyCoursesNode;
            }
        }
        return false;


    }

    public static class CoursesNode {
        private int coursesId;
        private CoursesNode relyCoursesNode;
    }
}


