package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.Sql2DslUI;
import cn.silently9527.ui.TimestampUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class TimestampToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "Timestamp";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.Timestamp.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new TimestampUI(project).getPanel();

        JBDimension dimension = new JBDimension(550, 300);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.Toolwindows.Documentation, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
