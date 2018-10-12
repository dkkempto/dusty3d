package com.dusty3d.main;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setSize(250, 200);
        setTitle("Dusty 3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
