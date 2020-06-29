package com.example.toolbox.bean;

public class MemoBean {
    // 定义记录信息的所有属性
    private String id;
    private String memoContent;
    private String memoTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }

    public String getMemoTime() {
        return memoTime;
    }

    public void setMemoTime(String memoTime) {
        this.memoTime = memoTime;
    }
}
