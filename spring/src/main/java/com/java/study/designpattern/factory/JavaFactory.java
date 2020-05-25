package com.java.study.designpattern.factory;

public class JavaFactory implements ICourceFactory {
    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }
}
