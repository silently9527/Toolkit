package cn.silently9527.service;

import cn.silently9527.domain.ToolkitCommand;
import com.intellij.openapi.actionSystem.DataContext;

public interface ToolkitCommandService {
    void execute(ToolkitCommand command, DataContext dataContext);
}
