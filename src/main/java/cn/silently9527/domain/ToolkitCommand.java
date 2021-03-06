package cn.silently9527.domain;

import cn.silently9527.domain.executor.Base64EncodeAndDecodeToolkitCommandExecutor;
import cn.silently9527.domain.executor.DateTimestampToolkitCommandExecutor;
import cn.silently9527.domain.executor.DigestToolkitCommandExecutor;
import cn.silently9527.domain.executor.IPAndPhoneToolkitCommandExecutor;
import cn.silently9527.domain.executor.JsonToolkitCommandExecutor;
import cn.silently9527.domain.executor.QrcodeEncodeToolkitCommandExecutor;
import cn.silently9527.domain.executor.RegularToolkitCommandExecutor;
import cn.silently9527.domain.executor.Sql2DslToolkitCommandExecutor;
import cn.silently9527.domain.executor.ToolkitCommandExecutor;
import cn.silently9527.domain.executor.URLEncodeAndDecodeToolkitCommandExecutor;
import cn.silently9527.domain.executor.UuidToolkitCommandExecutor;

public enum ToolkitCommand {
    Date("date", "日期转时间戳", DateTimestampToolkitCommandExecutor.class),
    Timestamp("timestamp", "时间戳转日期", DateTimestampToolkitCommandExecutor.class),
    Json("json", "JSON格式化", JsonToolkitCommandExecutor.class),
    Sql2dsl("sql2dsl", "SQL转elasticSearch语句", Sql2DslToolkitCommandExecutor.class),
    URLEncode("url encode", "URL编码", URLEncodeAndDecodeToolkitCommandExecutor.class),
    URLDecode("url decode", "URL解码", URLEncodeAndDecodeToolkitCommandExecutor.class),
    Base64Encode("base64 encode", "base64编码", Base64EncodeAndDecodeToolkitCommandExecutor.class),
    Base64Decode("base64 decode", "base64解码", Base64EncodeAndDecodeToolkitCommandExecutor.class),
    Phone("phone", "手机号归属地", IPAndPhoneToolkitCommandExecutor.class),
    IP("ip", "IP归属地", IPAndPhoneToolkitCommandExecutor.class),
    MD5("md5", "MD5加密", DigestToolkitCommandExecutor.class),
    SHA1("sha1", "SHA1加密", DigestToolkitCommandExecutor.class),
    SHA224("sha224", "SHA224加密", DigestToolkitCommandExecutor.class),
    SHA256("sha256", "SHA256加密", DigestToolkitCommandExecutor.class),
    SHA384("sha384", "SHA384加密", DigestToolkitCommandExecutor.class),
    SHA512("sha512", "SHA512加密", DigestToolkitCommandExecutor.class),
    UUID("uuid", "UUID随机值", UuidToolkitCommandExecutor.class),
    Regular("regular", "正则表达式", RegularToolkitCommandExecutor.class),
    QRCodeEncode("qrcode encode", "生成二维码", QrcodeEncodeToolkitCommandExecutor.class);

    private String command;
    private String description;
    private Class<? extends ToolkitCommandExecutor> executor;

    ToolkitCommand(String command, String description, Class<? extends ToolkitCommandExecutor> executor) {
        this.command = command;
        this.description = description;
        this.executor = executor;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends ToolkitCommandExecutor> getExecutor() {
        return executor;
    }
}
