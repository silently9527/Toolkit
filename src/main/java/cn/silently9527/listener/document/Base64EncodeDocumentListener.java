package cn.silently9527.listener.document;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.ui.EditorTextField;
import com.intellij.util.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class Base64EncodeDocumentListener implements DocumentListener {
    private EditorTextField urlTextField;
    private EditorTextField resultTextField;

    public Base64EncodeDocumentListener(EditorTextField urlTextField, EditorTextField resultTextField) {
        this.urlTextField = urlTextField;
        this.resultTextField = resultTextField;
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        String text = this.urlTextField.getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        String result = Base64.encode(text.getBytes(StandardCharsets.UTF_8));
        this.resultTextField.setText(result);
    }

}