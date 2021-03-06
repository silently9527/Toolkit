package cn.silently9527.ui;

import cn.silently9527.listener.action.IPSearchActionListener;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.ui.EditorSettingsProvider;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.LanguageTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IPAddressUI {
    private JPanel panel;
    private JButton search;
    private JTable table;
    private EditorTextField ipTextField;

    private Project project;

    public IPAddressUI(Project project) {
        this.project = project;
        DefaultTableModel tableModel = new DefaultTableModel();
        this.table.setModel(tableModel);

        this.search.addActionListener(new IPSearchActionListener(this.ipTextField, tableModel));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.ipTextField = new LanguageTextField(PlainTextLanguage.INSTANCE, project, "", true);
        this.ipTextField.setPlaceholder("input ip address");
        this.ipTextField.addSettingsProvider(getEditorSettingsProvider());
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
