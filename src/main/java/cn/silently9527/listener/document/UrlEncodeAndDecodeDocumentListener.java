package cn.silently9527.listener.document;

import cn.hutool.core.util.URLUtil;
import cn.silently9527.domain.ToolkitCommand;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.ui.EditorTextField;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class UrlEncodeAndDecodeDocumentListener implements DocumentListener {
    private EditorTextField textField;
    private EditorTextField resultTextField;
    private ToolkitCommand command;

    public UrlEncodeAndDecodeDocumentListener(ToolkitCommand command, EditorTextField textField, EditorTextField resultTextField) {
        this.command = command;
        this.textField = textField;
        this.resultTextField = resultTextField;
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        String text = this.textField.getText();
        if (StringUtils.isBlank(text)) {
            return;
        }
        String result;
        System.out.println(this.command);
        if (ToolkitCommand.URLEncode.equals(command)) {
            System.out.println("1");
            result = URLUtil.encode(text);
        } else {
            System.out.println("2");
            result = URLUtil.decode(text);
        }
        this.resultTextField.setText(result);
    }

}
