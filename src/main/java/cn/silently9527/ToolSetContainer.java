package cn.silently9527;

import cn.silently9527.component.TextLineNumber;
import cn.silently9527.toolset.Sql2DslPanel;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

public class ToolSetContainer {
    private Project project;

    private JPanel content;

    public ToolSetContainer(Project project) {
        this.project = project;
        init();
    }

    private void init() {
        JBTabsImpl tabs = new JBTabsImpl(project);

        TabInfo Sql2DslTabInfo = new TabInfo(new Sql2DslPanel(project));
        Sql2DslTabInfo.setText("Sql2Dsl");
        tabs.addTab(Sql2DslTabInfo);

        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabs.getComponent(), BorderLayout.CENTER);
    }

    public JPanel getContent() {
        return content;
    }

}
