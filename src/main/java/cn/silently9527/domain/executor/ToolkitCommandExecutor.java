package cn.silently9527.domain.executor;

import cn.silently9527.domain.ToolkitCommand;
import com.intellij.openapi.actionSystem.DataContext;

public interface ToolkitCommandExecutor {
    boolean support(ToolkitCommand command);

    void execute(ToolkitCommand command, DataContext dataContext);
}
