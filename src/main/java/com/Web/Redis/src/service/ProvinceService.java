package com.Web.Redis.src.service;

import com.Web.Redis.src.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();
}
