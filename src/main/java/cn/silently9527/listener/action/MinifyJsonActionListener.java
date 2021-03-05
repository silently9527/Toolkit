package cn.silently9527.listener.action;

import cn.silently9527.notification.ToolkitNotifier;
import cn.silently9527.utils.JsonUtils;
import com.intellij.ui.EditorTextField;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MinifyJsonAction
 */
public class MinifyJsonActionListener implements ActionListener {

    private EditorTextField editorTextField;

    public MinifyJsonActionListener() {
    }

    public MinifyJsonActionListener(EditorTextField editorTextField) {
        this.editorTextField = editorTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = editorTextField.getText();
        if (StringUtils.isBlank(text)) {
            return;
        }

        try {
            String minifiedJson = JsonUtils.minifyJson(text);
            editorTextField.setText(minifiedJson);
        } catch (Exception ex) {
            ToolkitNotifier.error("Json minify fail, please check data.");
        }
    }
}
