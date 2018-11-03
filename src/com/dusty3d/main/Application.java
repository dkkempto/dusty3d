package com.dusty3d.main;

import com.dusty3d.loader.FileSelectedDispatcher;
import com.dusty3d.scene.RayTracer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class Application extends JFrame {

    private FileSelectedDispatcher fileSelectedDispatcher;

    public Application() {
        fileSelectedDispatcher = new FileSelectedDispatcher();
        initUI();
    }

    private void initUI() {
        Screen screen = new Screen(new RayTracer());

        fileSelectedDispatcher.addListener(screen);

        createMenuBar();

        add(screen);
        setSize(Screen.WIDTH, Screen.HEIGHT);
        setTitle("Dusty 3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit Application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setToolTipText("Open File");
        openMenuItem.addActionListener((ActionEvent event) -> {
            handleOpen();
        });

        file.add(openMenuItem);
        file.add(eMenuItem);

        menuBar.add(file);

        setJMenuBar(menuBar);
    }

    private void handleOpen() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            fileSelectedDispatcher.selectFile(fileChooser.getSelectedFile());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
