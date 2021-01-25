package cn.silently9527;

import cn.silently9527.component.TextLineNumber;
import cn.silently9527.toolset.*;
import com.intellij.openapi.project.Project;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;

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

        TabInfo base64TabInfo = new TabInfo(new Base64Panel(project));
        base64TabInfo.setText("Base64");
        tabs.addTab(base64TabInfo);

        TabInfo jsonTabInfo = new TabInfo(new JSONPanel(project));
        jsonTabInfo.setText("JSON Format");
        tabs.addTab(jsonTabInfo);

        TabInfo ipAddressTabInfo = new TabInfo(new IpAddressPanel(project));
        ipAddressTabInfo.setText("Ip查询");
        tabs.addTab(ipAddressTabInfo);

        TabInfo mobileTabInfo = new TabInfo(new MobilePanel(project));
        mobileTabInfo.setText("手机归属地");
        tabs.addTab(mobileTabInfo);

        TabInfo urlTabInfo = new TabInfo(new URLPanel(project));
        urlTabInfo.setText("URL编解码");
        tabs.addTab(urlTabInfo);

        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(tabs.getComponent(), BorderLayout.CENTER);
    }

    public JPanel getContent() {
        return content;
    }

}
