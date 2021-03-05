package cn.silently9527.ui;

import cn.silently9527.actions.CopyContentAction;
import cn.silently9527.actions.FormatJsonAction;
import cn.silently9527.actions.MinifyJsonAction;
import com.intellij.json.JsonLanguage;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.project.Project;
import com.intellij.ui.LanguageTextField;

import javax.swing.*;

public class JsonFormatter {
    private JPanel panel;
    private LanguageTextField textField;
    private JButton format;
    private JButton copy;
    private JButton minify;

    private Project project;

    /**
     * 编辑器对象
     */
    public JsonFormatter(Project project) {
        this.project = project;
        format.addActionListener(new FormatJsonAction(this.textField));
        copy.addActionListener(new CopyContentAction(this.textField));
        minify.addActionListener(new MinifyJsonAction(this.textField));
    }

    private void createUIComponents() {
        this.textField = new LanguageTextField(JsonLanguage.INSTANCE, project, "", false);
        this.textField.addSettingsProvider(editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setFoldingOutlineShown(true);
            settings.setLineNumbersShown(true);
            settings.setLineMarkerAreaShown(true);
            settings.setIndentGuidesShown(true);
            settings.setWheelFontChangeEnabled(true);
            settings.setTabSize(4);
            settings.setUseTabCharacter(true);
            editor.setHorizontalScrollbarVisible(true);
            editor.setVerticalScrollbarVisible(true);
        });
    }

    //或者主面板
    public JPanel getPanel() {
        return panel;
    }

}
