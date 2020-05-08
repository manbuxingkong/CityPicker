package com.mbxk.citypickerlibrary.adapter;


import com.mbxk.citypickerlibrary.model.City;

public interface OnPickListener {
    void onPick(int position, City data);
    void onLocate();
    void onCancel();
}
