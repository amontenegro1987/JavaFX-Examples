package com.uiopenjanela.sdk.container;

import com.uiopenjanela.sdk.toolbar.BaseToolbar;


public class ContainerToolbar extends BaseToolbar {

    public ContainerToolbar() {
        getStyleClass().add("container-toolbar");
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        double titleTextPrefWidth = titleText.prefWidth(-1);
        double titleTextPrefHeight = titleText.prefHeight(-1);
        titleText.resize(titleTextPrefWidth, titleTextPrefHeight);
        titleText.relocate(getPadding().getLeft(), getPadding().getTop() + (getHeight() - getPadding().getTop() - titleTextPrefHeight) / 2);
    }
}
