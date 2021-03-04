package cn.silently9527.domain;

public enum ToolsetCommand {
    Date("date", "日期转时间戳"),
    Timestamp("timestamp", "时间戳转日期"),
    Json("json", "JSON格式化"),
    Sql2dsl("sql2dsl", "SQL转elasticSearch语句"),
    URLEncode("url encode", "URL编码"),
    URLDecode("url decode", "URL解码"),
    UUID("uuid", "UUID随机唯一值"),
    MD5("md5", "md5加密"),
    Base64Encode("base64 encode", "base64编码"),
    Base64Decode("base64 decode", "base64解码"),
    Phone("phone", "手机号归属地"),
    Regular("regular", "正则表达式"),
    QRcodeEncode("qrcode encode", "生成二维码"),
    IP("ip", "IP归属地");

    private String command;
    private String description;

    ToolsetCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

}
