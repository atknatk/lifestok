/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.OdemeTurleriLine;
import java.util.List;

public interface OdemeTurleriLineDao  {
    int createOdemeTurleriLine(OdemeTurleriLine line);

    List<OdemeTurleriLine> getOdemeTurleriLineList();

    OdemeTurleriLine getOdemeTurleriLine(int id);

    
    OdemeTurleriLine editOdemeTurleriLine(OdemeTurleriLine urunler);

    void removeOdemeTurleriLine(OdemeTurleriLine urunler);
}
