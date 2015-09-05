package com.uiopenjanela.sdk.list;

import com.uiopenjanela.sdk.util.Media;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class MediaList<T extends Media> extends ListView<T> {

    public MediaList() {
        setCellFactory(SimpleMediaListCell.createDefaultCallback());
    }

    public MediaList(ObservableList<T> items) {
        super(items);
        setCellFactory(SimpleMediaListCell.createDefaultCallback());
    }
}
