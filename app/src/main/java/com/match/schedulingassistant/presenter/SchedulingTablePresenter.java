package com.match.schedulingassistant.presenter;

import android.os.Bundle;

import com.bin.david.form.data.column.Column;
import com.match.schedulingassistant.activity.SchedulingTableActivity;
import com.match.schedulingassistant.api.presenter.ISchedulingTablePresenter;
import com.match.schedulingassistant.api.view.ISchedulingTableView;
import com.match.schedulingassistant.scheduling.Scheduling;

public class SchedulingTablePresenter implements ISchedulingTablePresenter {

    private Bundle bundle;
    private Column<String> date;
    private Column<String> checkProject;
    private Column<String> floorOneMember;
    private Column<String> floorTwoMember;
    private Column<String> floorThreeMember;
    private Column<String> floorFourMember;
    private Column<String> floorFiveMember;

    private Scheduling scheduling;

    private ISchedulingTableView iSchedulingTableView;
    private SchedulingTableActivity schedulingTableActivity;

    public SchedulingTablePresenter(Bundle bundle, ISchedulingTableView iSchedulingTableView,
                                    SchedulingTableActivity schedulingTableActivity){
        this.bundle = bundle;
        this.iSchedulingTableView = iSchedulingTableView;
        this.schedulingTableActivity = schedulingTableActivity;
    }

    /**
     * 初始化表格
     */
    @Override
    public void init() {
        this.date = new Column<>("日期", "date");
        this.checkProject = new Column<>("检查项目", "checkProject");
        this.floorOneMember = new Column<>("一楼", "floorOneMember");
        this.floorTwoMember = new Column<>("二楼", "floorTwoMember");
        this.floorThreeMember = new Column<>("三楼", "floorThreeMember");
        this.floorFourMember = new Column<>("四楼", "floorFourMember");
        this.floorFiveMember = new Column<>("五楼", "floorFiveMember");
        this.date.setAutoMerge(true);//字段相同时自动合并单元格

        //获取Scheduling对象
        if(bundle != null){
            this.scheduling = (Scheduling) bundle.getSerializable("scheduling");
        }

    }

    @Override
    public void schedulingDataAnalysis() {

    }
}
