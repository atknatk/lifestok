package com.lifeweb.dao.controller;

import com.lifeweb.dao.OdemeTurleriLineDao;
import com.lifeweb.dao.pojo.OdemeTurleriLine;
import java.util.List;

public class OdemeTurleriLineController {

    private final OdemeTurleriLineDao odemeTurleriLineDao;

    public OdemeTurleriLineController(OdemeTurleriLineDao odemeTurleriLineDao) {
        this.odemeTurleriLineDao = odemeTurleriLineDao;
    }

 
    public List<OdemeTurleriLine> getOdemeTurleriLine() {
        return odemeTurleriLineDao.getOdemeTurleriLineList();
    }

    public OdemeTurleriLine getOdemeTurleriLine(int id) {
        return odemeTurleriLineDao.getOdemeTurleriLine(id);
    }

    public OdemeTurleriLine editOdemeTurleriLine(OdemeTurleriLine odemeTurleriLine) {
        return odemeTurleriLineDao.editOdemeTurleriLine(odemeTurleriLine);
    }

    public void removeOdemeTurleriLine(OdemeTurleriLine odemeTurleriLine) {
        odemeTurleriLineDao.removeOdemeTurleriLine(odemeTurleriLine);
    }


    public int createOdemeTurleriLine(OdemeTurleriLine odemeTurleriLine) {
        return odemeTurleriLineDao.createOdemeTurleriLine(odemeTurleriLine);
    }
    
}
