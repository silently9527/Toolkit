package cn.silently9527.toolset;

import cn.silently9527.toolset.model.TimeUnit;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UI;

import javax.swing.*;
import java.awt.*;

public class TimestampPanel extends AbstractPanel {
    private JBTextField timeStampTextField1 = new JBTextField();
    private JBTextField timeStampTextField2 = new JBTextField();

    private ComboBox<TimeUnit> timeUnitBox1 = new ComboBox<>(TimeUnit.values());
    private ComboBox<TimeUnit> timeUnitBox2 = new ComboBox<>(TimeUnit.values());

    private JBTextField dateTextField1 = new JBTextField();
    private JBTextField dateTextField2 = new JBTextField();

    public TimestampPanel(Project project) {
        super();

        this.add(createTimestampToDate(), BorderLayout.NORTH);
    }


    private JComponent createTimestampToDate() {
        JButton convertButton = new JButton("转换");
//        convertButton.addActionListener(queryMobileButtonListener());

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};  //设置了总共有4列
        gridBagLayout.rowHeights = new int[]{0};  //设置了总共有2行
        gridBagLayout.columnWeights = new double[]{0.1, 0.3, 0.1, 0.1, 0.1, 0.3};  //设置了列的宽度为容器宽度
        gridBagLayout.rowWeights = new double[]{1.0};  //第一行的高度占了容器的2份，第二行的高度占了容器的8份
        JPanel jPanel = new JPanel(gridBagLayout);

        GridBagConstraints gbc0 = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(new JBLabel("时间戳："), gbc0);

        GridBagConstraints gbc1 = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(timeStampTextField1, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(timeUnitBox1, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(convertButton, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints(4, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(new JBLabel("日期："), gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints(5, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, JBUI.emptyInsets(), 0, 0);
        jPanel.add(dateTextField1, gbc5);

        return jPanel;
    }


}
