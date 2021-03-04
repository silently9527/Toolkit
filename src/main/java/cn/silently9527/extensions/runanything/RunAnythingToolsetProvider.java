package cn.silently9527.extensions.runanything;

import cn.silently9527.domain.actions.ToolsetCommandAction;
import com.google.common.cache.Cache;
import com.intellij.icons.AllIcons;
import com.intellij.ide.IdeBundle;
import com.intellij.ide.actions.runAnything.activity.RunAnythingAnActionProvider;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.util.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

public class RunAnythingToolsetProvider extends RunAnythingAnActionProvider<AnAction> {



    @Override
    public @NotNull Collection<AnAction> getValues(@NotNull DataContext dataContext, @NotNull String pattern) {
        return Arrays.asList(new ToolsetCommandAction("nat", "nat"), new ToolsetCommandAction("date", "date"));
    }

    @Override
    public @NotNull String getCommand(@NotNull AnAction value) {
        return this.getHelpCommand() + " " + ObjectUtils.notNull(value.getTemplatePresentation().getText(),
                IdeBundle.message("run.anything.actions.undefined"));
    }

    @Override
    public @Nullable String getHelpGroupTitle() {
        return "Toolset";
    }

    @NotNull
    @Override
    public String getHelpCommand() {
        return "toolset";
    }

    @NotNull
    @Override
    public String getHelpCommandPlaceholder() {
        return "toolset <command name>";
    }

    @Override
    @Nullable
    public Icon getHelpIcon() {
        return AllIcons.Nodes.Toolbox;
    }

    @NotNull
    @Override
    public String getCompletionGroupTitle() {
        return "Toolset"; //过滤界面中的名称
    }

//    @Override
//    public @Nullable String getAdText() {
//        return "fwfwefwef";
//    }
}
