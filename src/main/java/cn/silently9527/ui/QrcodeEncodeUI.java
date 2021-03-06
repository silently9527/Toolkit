package cn.silently9527.ui;

import cn.silently9527.listener.action.DownloadQrcodeActionListener;
import cn.silently9527.listener.action.GenerateQrcodeActionListener;
import cn.silently9527.listener.action.OpenFileActionListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class QrcodeEncodeUI {
    private JPanel panel;
    private JButton brower;
    private JButton generate;
    private JButton download;
    private JLabel imageLabel;
    private EditorTextField contentTextField;
    private EditorTextField logoTextField;

    private Project project;

    public QrcodeEncodeUI(Project project) {
        this.project = project;
        this.brower.addActionListener(new OpenFileActionListener(project, logoTextField));
        this.generate.addActionListener(new GenerateQrcodeActionListener(contentTextField, logoTextField, imageLabel));
        this.download.addActionListener(new DownloadQrcodeActionListener(project, imageLabel));

        this.contentTextField.setText(" ");
        this.generate.doClick();
        this.contentTextField.setText("");
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.contentTextField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.PLAIN_TEXT, false, false);
        this.contentTextField.addSettingsProvider(getEditorSettingsProvider());

        this.logoTextField = createPlainTextEditor();
        this.logoTextField.addSettingsProvider(getEditorSettingsProvider());
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

}
