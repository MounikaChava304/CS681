package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {
    private LinkedList<ApfsElement> children;

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }


    public ApfsDirectory(ApfsDirectory parent, String name) {
        super(parent, name, 0, LocalDateTime.now());
        this.children = new LinkedList<>();
    }

    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }

    public void appendChild(ApfsElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDir = new LinkedList<>();
        for (ApfsElement element: this.children) {
            if (element.isDirectory()) {
                subDir.add((ApfsDirectory) element);
            }
        }
        return subDir;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (ApfsElement element: this.children) {
            if (element.isFile()) {
                files.add((ApfsFile) element);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (ApfsElement element : this.children) {
            if (element.isDirectory()) {
                ApfsDirectory subDir = (ApfsDirectory) element;
                totalSize += subDir.getTotalSize();

            } else if (element.isFile()) {
                totalSize += element.getSize();
            }

        }
        return totalSize;
    }
}