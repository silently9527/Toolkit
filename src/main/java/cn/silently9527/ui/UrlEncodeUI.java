package cn.silently9527.ui;

import cn.silently9527.listener.action.CopyContentActionListener;
import cn.silently9527.listener.document.UrlEncodeDocumentListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorTextField;

import javax.swing.*;

public class UrlEncodeUI {
    private JPanel panel;
    private EditorTextField urlTextField;
    private JButton copy;
    private EditorTextField resultTextField;

    private Project project;

    public UrlEncodeUI(Project project) {
        this.project = project;
        copy.addActionListener(new CopyContentActionListener(this.resultTextField));
    }

    private void createUIComponents() {
        this.urlTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, false, false);
        this.urlTextField.addSettingsProvider(editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setUseSoftWraps(true);
            settings.setLineNumbersShown(true);
        });

        this.resultTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, true, false);
        this.resultTextField.addSettingsProvider(editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setUseSoftWraps(true);
            settings.setLineNumbersShown(true);
        });

        this.urlTextField.addDocumentListener(new UrlEncodeDocumentListener(urlTextField, resultTextField));
    }

    public JPanel getPanel() {
        return this.panel;
    }
}
