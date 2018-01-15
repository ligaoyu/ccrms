package com.iproject.ccrms.conference.dao;

import com.iproject.entity.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by ligaoyu on 18/1/10.
 */
public interface ConferenceDao extends JpaRepository<ConferenceEntity, Integer> {


    @Query(value = "select d from ConferenceEntity d where d.startTime between ?1 and ?2 or d.endTime between ?1 and ?2")
    public List<ConferenceEntity> queryByDate(Date beginDate, Date endDate);

}
