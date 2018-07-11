package com.mtty.igood.service;

import com.mtty.igood.dao.RsNavbarMapper;
import com.mtty.igood.model.RsNavbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desp
 * @Date 2018/4/13
 * @Author mtty
 */
@Service
public class NavBarService {
    @Autowired
    private RsNavbarMapper navbarDao;

    public List<RsNavbar> getAll(){
        return navbarDao.queryAll();
    }

}
