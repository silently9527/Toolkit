package cn.silently9527.domain.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ToolsetCommandAction extends AnAction {
    private String command;

    public ToolsetCommandAction(String command, String description) {
        this.command = command;

        Presentation presentation = getTemplatePresentation();
        presentation.setText(command, false);
        presentation.setIcon(AllIcons.Nodes.Toolbox);
        presentation.setDescription(description);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        System.out.println(this.command);
    }

    @Nullable
    @Override
    public String getTemplateText() {
        return this.command;
    }

    public String getCommand() {
        return command;
    }
}
