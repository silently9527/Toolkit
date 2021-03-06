package cn.silently9527.ui;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.listener.action.IPSearchActionListener;
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

public class IPAndPhoneAddressUI {
    private JPanel panel;
    private JButton search;
    private JTable table;
    private EditorTextField textField;

    private Project project;

    public IPAndPhoneAddressUI(Project project, ToolkitCommand command) {
        this.project = project;
        DefaultTableModel tableModel = new DefaultTableModel();
        this.table.setModel(tableModel);

        if (ToolkitCommand.IP.equals(command)) {
            this.search.addActionListener(new IPSearchActionListener(this.textField, tableModel));
            this.textField.setPlaceholder("input ip address");
        } else {
            this.search.addActionListener(new PhoneAddressSearchActionListener(this.textField, tableModel));
            this.textField.setPlaceholder("input your phone number");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.textField = new LanguageTextField(PlainTextLanguage.INSTANCE, project, "", true);
        this.textField.addSettingsProvider(getEditorSettingsProvider());
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
