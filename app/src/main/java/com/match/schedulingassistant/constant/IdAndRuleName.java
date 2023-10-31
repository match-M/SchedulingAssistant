package com.match.schedulingassistant.constant;

import com.match.schedulingassistant.R;
import java.util.HashMap;

public class IdAndRuleName {
    public final static HashMap<Integer, String> idAndRuleName = new HashMap<>();

    static {

        idAndRuleName.put(R.id.morning_days_btn, RuleName.MORNING_DAYS);
        idAndRuleName.put(R.id.afternoon_days_btn, RuleName.AFTERNOON_DAYS);
        idAndRuleName.put(R.id.night_days_btn, RuleName.NIGHT_DAYS);
        idAndRuleName.put(R.id.night_4_days_btn, RuleName.NIGHT_4_DAYS);

        idAndRuleName.put(R.id.morning_people_btn, RuleName.MORNING_PEOPLE);
        idAndRuleName.put(R.id.afternoon_people_btn, RuleName.AFTERNOON_PEOPLE);
        idAndRuleName.put(R.id.night_people_btn, RuleName.NIGHT_PEOPLE);
        idAndRuleName.put(R.id.night_4_people_btn, RuleName.NIGHT_4_PEOPLE);

        idAndRuleName.put(R.id.morning_floor_btn, RuleName.MORNING_FLOOR);
        idAndRuleName.put(R.id.afternoon_floor_btn, RuleName.AFTERNOON_FLOOR);
        idAndRuleName.put(R.id.night_floor_btn, RuleName.NIGHT_FLOOR);
        idAndRuleName.put(R.id.night_4_floor_btn, RuleName.NIGHT_4_FLOOR);

        idAndRuleName.put(R.id.morning_start_position_btn, RuleName.MORNING_START_POSITION);
        idAndRuleName.put(R.id.afternoon_start_position_btn, RuleName.AFTERNOON_START_POSITION);
        idAndRuleName.put(R.id.night_start_position_btn, RuleName.NIGHT_START_POSITION);
        idAndRuleName.put(R.id.night_4_start_position_btn, RuleName.NIGHT_4_START_POSITION);

        idAndRuleName.put(R.id.not_more_than_btn, RuleName.NOT_MORE_THAN);

    }

    /**
     * 通过id获取RuleName
     * @param buttonId 控件id
     * @return 返回RuleName
     */
    public static String getRuleName(int buttonId){
        return idAndRuleName.get(buttonId);
    }

    /**
     * 获取控件id
     * @param ruleName 规则名字
     * @return 控件id, 404代表找不到这个id
     */
    public static Integer getButtonId(String ruleName){
        int result = 404;

        //判断这个是值是否存在与集合中
        if(!idAndRuleName.containsValue(ruleName)) return result;

        for(Integer key : idAndRuleName.keySet()){
            String value = idAndRuleName.get(key);
            if(value.equals(ruleName)){
                result = key;
                break;
            }
        }

        return result;
    }



}
