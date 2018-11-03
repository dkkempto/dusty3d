package com.dusty3d.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSelectedDispatcher {
    private List<IFileSelectedListener> listeners = new ArrayList<IFileSelectedListener>();

    public void addListener(IFileSelectedListener listener) {
        listeners.add(listener);
    }

    public void selectFile(File file) {
        for(IFileSelectedListener listener : listeners) {
            listener.fileSelected(file);
        }
    }
}
