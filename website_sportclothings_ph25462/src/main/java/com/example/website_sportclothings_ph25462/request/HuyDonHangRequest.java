package com.example.website_sportclothings_ph25462.request;

import java.util.List;

public class HuyDonHangRequest {
    private List<Long> selectedItems;
    private String lyDo;

    public HuyDonHangRequest() {
    }

    public HuyDonHangRequest(List<Long> selectedItems, String lyDo) {
        this.selectedItems = selectedItems;
        this.lyDo = lyDo;
    }

    public List<Long> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Long> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }
}
