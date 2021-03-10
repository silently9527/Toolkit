package cn.silently9527.ui;

import cn.silently9527.listener.action.CopyContentActionListener;
import cn.silently9527.listener.action.OpenFileActionListener;
import cn.silently9527.listener.document.ParseQrcodeDocumentListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class QrcodeDecodeUI {
    private JPanel panel;
    private JButton browse;
    private JButton copy;
    private EditorTextField pathTextField;
    private EditorTextField resultTextField;

    private Project project;

    public QrcodeDecodeUI(Project project) {
        this.project = project;

        this.copy.addActionListener(new CopyContentActionListener(this.resultTextField));
        this.browse.addActionListener(new OpenFileActionListener(project, this.pathTextField));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.pathTextField = createPlainTextEditor();
        this.pathTextField.addSettingsProvider(getEditorSettingsProvider());

        this.resultTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, true, false);
        this.resultTextField.addSettingsProvider(getEditorSettingsProvider());

        this.pathTextField.addDocumentListener(new ParseQrcodeDocumentListener(this.pathTextField, this.resultTextField));
    }

    @NotNull
    private EditorTextField createPlainTextEditor() {
        return new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, true, true);
    }

    @NotNull
    private EditorSettingsProvider getEditorSettingsProvider() {
        return editor -> {
            EditorSettings settings = editor.getSettings();
            settings.setIndentGuidesShown(true);
            settings.setWheelFontChangeEnabled(true);
        };
    }

    public JPanel getPanel() {
        return panel;
    }

}
