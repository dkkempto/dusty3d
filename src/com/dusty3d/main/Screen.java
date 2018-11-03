package com.dusty3d.main;

import com.dusty3d.loader.IFileSelectedListener;
import com.dusty3d.loader.ILoader;
import com.dusty3d.loader.LoaderFactory;
import com.dusty3d.scene.IEntity;
import com.dusty3d.scene.IRenderer;
import com.dusty3d.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.io.File;

public class Screen extends JPanel implements Runnable, IFileSelectedListener {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private boolean isRunning = true;
    private Thread thread;

    private static final long NANOS_PER_SECOND = 1_000_000_000L;
    private static final long NANOS_PER_MILLISECOND = 1_000_000L;
    private static final long OPTIMAL_TICKS = 50L;
    private static final long NANOS_PER_TICK = NANOS_PER_SECOND / OPTIMAL_TICKS;

    private BufferedImage bi;
    private IRenderer renderer;

    private Scene scene;

    public Screen(IRenderer renderer) {
        this.renderer = renderer;
        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        scene = new Scene();
        thread = new Thread(this);
        thread.start();

        setFocusable(true);
        addKeyListener(scene);
    }

    @Override
    public void run() {
        long nextTick = System.nanoTime();
        long nextSecond = nextTick;

        final long rateLimit = NANOS_PER_SECOND / 200;

        while(isRunning) {

            long loopStart = System.nanoTime();

            render();

            final long now = System.nanoTime();

            if(now - nextTick >= 0) {
                update();

                do {
                    nextTick += NANOS_PER_TICK;
                } while (now - nextTick >= 0);
            }

            if (now - nextSecond >= 0) {
                updatePerSecond();
                nextSecond += NANOS_PER_SECOND;
            }

            final long delayms = ((loopStart + rateLimit) - System.nanoTime()) / NANOS_PER_MILLISECOND;
            if(delayms > 0) {
                try {
                    Thread.sleep(delayms);
                } catch (InterruptedException ie) {
                    //Don't really know what to do if this happens
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImageToScreen(g);
        clear(g);
    }

    private void clear(Graphics g) {
        Graphics g2 = bi.getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,bi.getWidth(),bi.getHeight());
    }

    private void drawImageToScreen(Graphics g) {
        g.drawImage(bi, 0, 0, null);
    }

    private void render() {
        if(renderer == null) return;
        if(scene == null) return;

        renderer.render(bi, scene);
        repaint();
    }

    private void update() {
        scene.update();
    }

    private void updatePerSecond() {
        //TODO: If there's any features that need to be updated less often, add them here
    }

    @Override
    public void fileSelected(File file) {
        ILoader loader = LoaderFactory.GetLoader(file);
        List<IEntity> res = loader.load();
        scene.setEntities(res);
    }
}
