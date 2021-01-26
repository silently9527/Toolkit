package cn.silently9527.toolset.model;

public enum TimeUnit {
    Second("秒"),
    Millisecond("毫秒");

    private String label;

    TimeUnit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
