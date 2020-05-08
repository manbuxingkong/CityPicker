package com.mbxk.citypickerlibrary.adapter;


import com.mbxk.citypickerlibrary.model.City;

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
