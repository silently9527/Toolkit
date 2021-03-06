package cn.silently9527.ui;

import cn.silently9527.listener.action.PhoneAddressSearchActionListener;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.LanguageTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PhoneAddressUI {
    private JPanel panel;
    private JButton search;
    private JTable table;
    private EditorTextField phoneTextField;

    private Project project;

    public PhoneAddressUI(Project project) {
        this.project = project;
        DefaultTableModel tableModel = new DefaultTableModel();
        this.table.setModel(tableModel);

        this.search.addActionListener(new PhoneAddressSearchActionListener(this.phoneTextField, tableModel));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.phoneTextField = new LanguageTextField(PlainTextLanguage.INSTANCE, project, "", true);
        this.phoneTextField.setPlaceholder("input your phone number");
        this.phoneTextField.addSettingsProvider(getEditorSettingsProvider());
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

    public JPanel getPanel() {
        return panel;
    }
}
