package com.match.schedulingassistant.vo;

import com.match.schedulingassistant.activity.SchedulingTableActivity;

/**
 * @author match
 * javaBean
 */
public class Scheduling {
    //日期
    private String date;
    //检查项目
    private String checkProject;
    //一楼的成员
    private String floorOneMember;
    //二楼的成员
    private String floorTwoMember;
    //三楼的成员
    private String floorThreeMember;
    //四楼的成员
    private String floorFourMember;
    //五楼的成员
    private String floorFiveMember;

    public Scheduling(String date, String checkProject, String floorOneMember, String floorTwoMember,
                      String floorThreeMember, String floorFourMember, String floorFiveMember){
        this.date = date;
        this.checkProject = checkProject;
        this.floorOneMember = floorOneMember;
        this.floorTwoMember = floorTwoMember;
        this.floorThreeMember = floorThreeMember;
        this.floorFourMember = floorFourMember;
        this.floorFiveMember = floorFiveMember;
    }




}
