package cn.silently9527.ui;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.EditorHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.LightVirtualFile;

import javax.swing.*;

public class JsonFormatter {
    private JPanel contentPanel;
    private JComponent editorComponent;
    private JButton formatterButton;
    private JLabel tooltip;

    private Project project;
    /**
     * 编辑器对象
     */
    private Editor editor;

    public JsonFormatter(Project project) {
        this.project = project;
    }

    private void createUIComponents() {
        initialEditor(project);
        this.editorComponent = editor.getComponent();
    }

    private void initialEditor(Project project) {
        EditorFactory editorFactory = EditorFactory.getInstance();
        if (editor != null) {
            editorFactory.releaseEditor(editor);
        }
        Document document = editorFactory.createDocument("");
        // 创建编辑框
        editor = editorFactory.createEditor(document, project);
        EditorSettings editorSettings = editor.getSettings();
        // 关闭虚拟空间
        editorSettings.setVirtualSpace(false);
        // 关闭标记位置（断点位置）
        editorSettings.setLineMarkerAreaShown(false);
        // 关闭缩减指南
        editorSettings.setIndentGuidesShown(false);
        // 显示行号
        editorSettings.setLineNumbersShown(true);
        // 支持代码折叠
        editorSettings.setFoldingOutlineShown(true);
        // 附加行，附加列（提高视野）
        editorSettings.setAdditionalColumnsCount(3);
        editorSettings.setAdditionalLinesCount(3);
        // 不显示换行符号
        editorSettings.setCaretRowShown(false);
        ((EditorEx) editor).setHighlighter(EditorHighlighterFactory.getInstance().createEditorHighlighter(project, new LightVirtualFile("jsonFormatter.json")));
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }


}
