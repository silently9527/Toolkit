package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.UrlEncodeUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class UrlEncodeToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "Url Encode";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.URLEncode.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new UrlEncodeUI(project).getPanel();

        JBDimension dimension = new JBDimension(400, 300);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.FileTypes.Html, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
