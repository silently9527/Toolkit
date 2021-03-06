package cn.silently9527.ui;

import cn.hutool.core.date.DateTime;
import cn.silently9527.listener.action.CopyContentActionListener;
import cn.silently9527.listener.document.DateDocumentListener;
import cn.silently9527.listener.document.TimestampDocumentListener;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.LanguageTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TimestampUI {
    private JPanel panel;
    private JButton localTimeCopy;
    private JButton localDateCopy;
    private JButton secondCopy;
    private JButton millisCopy;
    private JButton utcCopy;
    private EditorTextField textField;
    private EditorTextField localTimeTextField;
    private EditorTextField localDateTextField;
    private EditorTextField secondTextField;
    private EditorTextField millisTextField;
    private EditorTextField utcTimeTextField;

    private Project project;

    public TimestampUI(Project project) {
        this.project = project;
        this.localTimeCopy.addActionListener(new CopyContentActionListener(localTimeTextField));
        this.localDateCopy.addActionListener(new CopyContentActionListener(localDateTextField));
        this.secondCopy.addActionListener(new CopyContentActionListener(secondTextField));
        this.millisCopy.addActionListener(new CopyContentActionListener(millisTextField));
        this.utcCopy.addActionListener(new CopyContentActionListener(utcTimeTextField));

        this.textField.addDocumentListener(new TimestampDocumentListener(this.textField, this.localTimeTextField,
                this.localDateTextField, this.secondTextField, this.millisTextField, this.utcTimeTextField));

        this.textField.setText(String.valueOf(DateTime.now().getTime()));
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.textField = new LanguageTextField(PlainTextLanguage.INSTANCE, project, "", true);
        this.textField.setPlaceholder("input timestamp");
        this.textField.addSettingsProvider(getEditorSettingsProvider());

        this.localTimeTextField = createPlainTextEditor();
        this.localTimeTextField.addSettingsProvider(getEditorSettingsProvider());

        this.localDateTextField = createPlainTextEditor();
        this.localDateTextField.addSettingsProvider(getEditorSettingsProvider());

        this.secondTextField = createPlainTextEditor();
        this.secondTextField.addSettingsProvider(getEditorSettingsProvider());

        this.millisTextField = createPlainTextEditor();
        this.millisTextField.addSettingsProvider(getEditorSettingsProvider());

        this.utcTimeTextField = createPlainTextEditor();
        this.utcTimeTextField.addSettingsProvider(getEditorSettingsProvider());
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
            editor.setHorizontalScrollbarVisible(true);
        };
    }
}
