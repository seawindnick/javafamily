//package jvm;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * <Description>
// *
// * @author hushiye
// * @since 6/29/21 17:26
// */
//public class TestModel {
//
//
//    private String ClassID;
//    private String CourseID;
//    private String Cmd;
//    private String CloseTime;
//    private String StartTime;
//    private String SID;
//
//    private DataClass data;
//
//    public static class DataClass {
//
//        private EdbEnd edbEnd;
//
//        private Map<String, StageEnd> stageEnd;
//
//        private Map<String, HandsupEnd> handsupEnd;
//
//        private Map<String, AwardEnd> awardEnd;
//        private TimerEnd timerEnd;
//
//        private MuteEndPerson muteEnd;
//
//        private GroupEnd groupEnd;
//
//        private Map<String,InoutEnd> inoutEnd;
//
//        private SmallboardEnd smallboardEnd;
//
//        private SmallboardEnd textboardEnd;
//        private Map<String,AuthorizeEnd> authorizeEnd;
//
//        private DiceEnd diceEnd;
//
//
//
//
//    }
//
//    public static class AnswerEnd{
//
//    }
//
//    public static class DiceEnd{
//        private Integer Count;
//    }
//
//
//
//
//    public static class AuthorizeEnd{
//        private Integer Count;
//        private Integer Total;
//
//    }
//
//    public static class SmallboardEnd{
//        private Integer Count;
//        private Integer Total;
//        private Integer[] Period;
//        private Integer DCount;
//    }
//
//
//    public static class InoutEnd{
//
//        private Integer Total;
//        private Integer Identity;
//        private Details[] Details;
//
//    }
//
//    public static class Details{
//        private String Type;
//        private Integer Device;
//        private Long Time;
//    }
//
//
//    public static class GroupEnd {
//
//        public Grouping Grouping;
//
//
//    }
//
//    public static class Grouping {
//        private Integer Count;
//        private GroupingItem Items;
//
//    }
//
//    public static class GroupingItem {
//        private Integer Duration;
//        public List<Map<String, List<GroupingRole>>> Groups;
//        private Long StartTime;
//    }
//
//
//    public static class GroupingRole {
//        private Integer Role;
//        private String UID;
//    }
//
//
//    public static class MuteEndPerson {
//        private Map<String, MuteEndPersonTotal> Persons;
//
//    }
//
//
//    public static class MuteEndPersonTotal {
//        private Integer Total;
//    }
//
//
//    public static class EdbEnd {
//        private EdbEndFilter[] Files;
//    }
//
//    public static class EdbEndFilter {
//        private String FileKey;
//        private String ActionTime;
//        private String FileSource;
//        private String FileName;
//    }
//
//    public static class StageEnd {
//        private Integer DownCount;
//        private Integer UpTotal;
//        private Integer UpCount;
//        private Integer DownTotal;
//
//    }
//
//    public static class HandsupEnd {
//        private Integer CTime;
//        private Integer Total;
//
//    }
//
//    public static class AwardEnd {
//        private Integer total;
//    }
//
//    public static class TimerEnd {
//        private Integer Count;
//        private Integer Timing_Count;
//    }
//
//
//}
