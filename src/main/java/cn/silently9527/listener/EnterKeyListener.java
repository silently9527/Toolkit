package cn.silently9527.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class EnterKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("enter key:" + e.getKeyChar());
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            enterKeyPressed(e);
        }
    }

    protected abstract void enterKeyPressed(KeyEvent e);

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
