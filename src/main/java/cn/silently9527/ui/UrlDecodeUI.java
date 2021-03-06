package cn.silently9527.ui;

import cn.silently9527.listener.action.CopyContentActionListener;
import cn.silently9527.listener.document.UrlDecodeDocumentListener;
import cn.silently9527.listener.document.UrlEncodeDocumentListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class UrlDecodeUI {
    private JPanel panel;
    private EditorTextField urlTextField;
    private EditorTextField resultTextField;
    private JButton copy;

    private Project project;

    public UrlDecodeUI(Project project) {
        this.project = project;
        copy.addActionListener(new CopyContentActionListener(this.resultTextField));
    }


    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.urlTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, false, false);
        this.urlTextField.addSettingsProvider(getEditorSettingsProvider());

        this.resultTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, true, false);
        this.resultTextField.addSettingsProvider(getEditorSettingsProvider());

        this.urlTextField.addDocumentListener(new UrlDecodeDocumentListener(urlTextField, resultTextField));
    }

    @NotNull
    private EditorSettingsProvider getEditorSettingsProvider() {
        return editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setUseSoftWraps(true);
            settings.setLineNumbersShown(true);
        };
    }
}
