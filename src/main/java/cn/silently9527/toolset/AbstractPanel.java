package cn.silently9527.toolset;

import com.intellij.ui.JBColor;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

public class AbstractPanel extends JPanel {
    protected JLabel exceptionMessageLabel = new JLabel();

    public AbstractPanel() {
        super(new BorderLayout(0, 10));
        this.setBorder(JBUI.Borders.empty(10));
    }

    protected void setFailureStyle() {
        exceptionMessageLabel.setText("");
        exceptionMessageLabel.setForeground(JBColor.RED);
    }

    protected void setSuccessStyle(String message) {
        exceptionMessageLabel.setForeground(JBColor.GREEN);
        exceptionMessageLabel.setText(message);
    }
}
