package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.JsonFormatter;
import cn.silently9527.ui.toolset.JSONPanel;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.ComponentPopupBuilder;
import com.intellij.openapi.ui.popup.IconButton;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;
import java.awt.*;

public class JsonToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "JSON Formatter";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.Json.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);
//        JSONPanel panel = new JSONPanel(project);

        JsonFormatter formatter = new JsonFormatter(project);
        JPanel panel = formatter.getContentPanel();

        JBDimension dimension = new JBDimension(400, 600);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.FileTypes.Json, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }

}
