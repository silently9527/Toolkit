package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import cn.silently9527.ui.IPAddressUI;
import cn.silently9527.ui.PhoneAddressUI;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.util.ui.JBDimension;

import javax.swing.*;

public class PhoneToolkitCommandExecutor extends AbstractToolkitCommandExecutor {
    private static final String POPUP_TITLE = "Phone Address Search";

    @Override
    public boolean support(ToolkitCommand command) {
        return ToolkitCommand.Phone.equals(command);
    }

    @Override
    public void execute(ToolkitCommand command, DataContext dataContext) {
        Project project = getProject(dataContext);

        JPanel panel = new PhoneAddressUI(project).getPanel();

        JBDimension dimension = new JBDimension(400, 250);
        JBPopup popup = createPopup(POPUP_TITLE, dimension, AllIcons.Actions.Search, panel);
        popup.show(getRelativePoint(dataContext, dimension));
    }
}
