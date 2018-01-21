package com.iproject.ccrms.token.model;

import lombok.Data;

/**
 * Created by ligaoyu on 18/1/17.
 *
 */
@Data
public class TokenModel {

    private Integer userId;

    private String token;

    public TokenModel(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

}
