package cn.silently9527.toolset;

import cn.silently9527.component.TextEditor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.JBUI;
import com.wantest.es.sql2dsl.es4sql.SqlToDsl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sql2DslPanel extends JPanel implements ActionListener {

    private TextEditor sqlTextEditor = new TextEditor(8, 20);
    private TextEditor dslTextEditor = new TextEditor(8, 20);
    private JLabel exceptionMessageLabel = new JLabel();
    private JBCheckBox format = new JBCheckBox("格式化DSL");


    public Sql2DslPanel(Project project) {
        super(new BorderLayout(0, 10));
        this.setBorder(JBUI.Borders.empty(10));

        this.add(createSqlArea(), BorderLayout.NORTH);
        this.add(createDslArea(), BorderLayout.CENTER);
        this.add(createConvertButton(), BorderLayout.SOUTH);
    }

    private Component createConvertButton() {
        JButton convertButton = new JButton("转换");
        convertButton.addActionListener(this);

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(format);
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(convertButton);
        horizontalBox.add(Box.createHorizontalStrut(10));
        horizontalBox.add(exceptionMessageLabel);
        return horizontalBox;
    }

    private JComponent createSqlArea() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("输入SQL:"), BorderLayout.NORTH);
        panel.add(this.sqlTextEditor, BorderLayout.CENTER);
        return panel;
    }

    private JComponent createDslArea() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("转换后的DSL:"), BorderLayout.NORTH);
        panel.add(this.dslTextEditor, BorderLayout.CENTER);
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        exceptionMessageLabel.setText("");
        exceptionMessageLabel.setForeground(JBColor.RED);

        String sqlText = this.sqlTextEditor.getTextValue();
        if (StringUtil.isEmpty(sqlText)) {
            exceptionMessageLabel.setText("SQL必填");
            return;
        }
        String dslText;
        try {
            dslText = SqlToDsl.toExactDsl(sqlText);
        } catch (Exception ex) {
            exceptionMessageLabel.setText("转换失败，请检查SQL，异常信息：" + ex.getMessage());
            return;
        }

        if (format.isSelected()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(dslText);
                dslText = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            } catch (Exception ex) {
                exceptionMessageLabel.setText("格式化失败，去掉勾选格式化再试");
                return;
            }
        }

        this.dslTextEditor.setTextValue(dslText);

        exceptionMessageLabel.setForeground(JBColor.GREEN);
        exceptionMessageLabel.setText("转换完成");
    }


}
