package cn.silently9527.utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

/**
 * SystemUtils
 *
 * @author zhangjiaxing created on 2020-04-14
 */
public class SystemUtils {

    private SystemUtils() {}

    public static void copyToClipboard(String content) {
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(new StringSelection(content), null);
    }
}