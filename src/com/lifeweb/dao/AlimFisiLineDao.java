/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.enitity.AlimFisiLine;
import java.util.List;

public interface AlimFisiLineDao {

    List<AlimFisiLine> getAlimFisiLineList();

    AlimFisiLine getAlimFisiLine(int id);

    AlimFisiLine setAlimFisiLine(AlimFisiLine alimFisiLine);

    void removeAlimFisiLine(AlimFisiLine alimFisiLine);

    int getAlimFisiLineId(AlimFisiLine alimFisiLine);
}
