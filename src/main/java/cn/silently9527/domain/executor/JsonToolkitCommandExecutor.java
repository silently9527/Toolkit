package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.JsonFormatter;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class JsonToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "Json Formatter";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.Json.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JsonFormatter formatter = new JsonFormatter(project);
        JPanel panel = formatter.getPanel();

        JBDimension dimension = new JBDimension(400, 600);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.FileTypes.Json, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }

}
