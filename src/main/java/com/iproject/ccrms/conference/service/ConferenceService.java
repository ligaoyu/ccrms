package com.iproject.ccrms.conference.service;

import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.DateUtil;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.conference.dao.ConferenceDao;
import com.iproject.entity.ConferenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ligaoyu on 18/1/10.
 */
@Service
public class ConferenceService {

    @Autowired
    private ConferenceDao conferenceDao;

    /**
     * 根据给定的日期查询当前月的课程信息
     * @param strDate
     */
    public Result getConferenceListByDate(String strDate){
        Date date = null;

        if(strDate == null){
            date = DateUtil.getNowDate();
        }else{
            date = DateUtil.getDateFormat(strDate);
        }

        Date beginDate = DateUtil.getFirstDayOfMonth(date);
        Date endDate = DateUtil.getLastDayOfMonth(date);

        List<ConferenceEntity> list = conferenceDao.queryByDate(beginDate,endDate);

        return ResultUtil.success(list);
    }

}
