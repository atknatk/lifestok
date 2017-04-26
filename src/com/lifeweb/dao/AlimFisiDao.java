package com.lifeweb.dao;

import com.lifeweb.enitity.AlimFisi;
import java.util.List;

public interface AlimFisiDao {

    List<AlimFisi> getAlimFisiList();

    AlimFisi getAlimFisi(int id);

    AlimFisi setAlimFisi(AlimFisi alimFisi);

    void removeAlimFisi(AlimFisi alimFisi);

    int getAlimFisiId(AlimFisi alimFisi);
}
