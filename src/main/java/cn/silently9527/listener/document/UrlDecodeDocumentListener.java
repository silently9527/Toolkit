package cn.silently9527.listener.document;

import cn.hutool.core.util.URLUtil;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.ui.EditorTextField;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class UrlDecodeDocumentListener implements DocumentListener {
    private EditorTextField urlTextField;
    private EditorTextField resultTextField;

    public UrlDecodeDocumentListener(EditorTextField urlTextField, EditorTextField resultTextField) {
        this.urlTextField = urlTextField;
        this.resultTextField = resultTextField;
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        String text = this.urlTextField.getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        String result = URLUtil.decode(text);
        this.resultTextField.setText(result);
    }

}
