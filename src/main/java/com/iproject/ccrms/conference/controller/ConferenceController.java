package com.iproject.ccrms.conference.controller;

import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligaoyu on 18/1/10.
 */
@RestController
@RequestMapping(value = "/conference/")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping(value = "list")
    public Result list(@RequestParam String date){
        return conferenceService.getConferenceListByDate(date);
    }


}
