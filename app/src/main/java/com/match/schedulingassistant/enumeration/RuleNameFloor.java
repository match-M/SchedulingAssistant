package com.match.schedulingassistant.enumeration;

import com.match.schedulingassistant.R;

public enum RuleNameFloor {


    MORNING_FLOOR(R.id.morning_floor_btn, "MORNING_FLOOR"),
    AFTERNOON_FLOOR(R.id.afternoon_floor_btn, "AFTERNOON_FLOOR"),
    NIGHT_FLOOR(R.id.night_floor_btn, "NIGHT_FLOOR"),
    NIGHT_4_FLOOR(R.id.night_4_floor_btn, "NIGHT_4_FLOOR");
    private int id;
    private String ruleName;

    RuleNameFloor(int id, String ruleName) {
        this.id = id;
        this.ruleName = ruleName;
    }

    public static String getRuleName(int id){
        String ruleName = null;
        for (RuleNameFloor ruleNameFloor : RuleNameFloor.values()) {
            if (ruleNameFloor.id == id) {
                ruleName = ruleNameFloor.ruleName;
                break;
            }
        }
        return ruleName;
    }
}
