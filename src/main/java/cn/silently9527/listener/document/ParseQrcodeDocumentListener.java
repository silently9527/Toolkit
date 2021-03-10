package cn.silently9527.listener.document;

import cn.silently9527.notification.ToolkitNotifier;
import cn.silently9527.utils.QRCodeUtils;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.ui.EditorTextField;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ParseQrcodeDocumentListener implements DocumentListener {
    private EditorTextField pathTextField;
    private EditorTextField resultTextField;

    public ParseQrcodeDocumentListener(EditorTextField pathTextField, EditorTextField resultTextField) {
        this.pathTextField = pathTextField;
        this.resultTextField = resultTextField;
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        String text = this.pathTextField.getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        try {
            this.resultTextField.setText(QRCodeUtils.decode(text));
        } catch (Exception ignored) {
            ToolkitNotifier.error("解析二维码图片失败");
        }
    }


}
