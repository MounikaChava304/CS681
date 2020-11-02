package edu.umb.cs681.hw09.FSFoundation;

import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
	protected String name;
	protected int size;
	protected ReentrantLock lock = new ReentrantLock();

	public FSElement(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public int getSize() {
		lock.lock();
		try {
			return this.size;
		} finally {
			lock.unlock();
		}
	}

	public void setSize(int size) {
		lock.lock();
		try {
			this.size = size;
		} finally {
			lock.unlock();
		}
	}

	public String getName() {
		lock.lock();
		try {
			return name;
		} finally {
			lock.unlock();
		}
	}

	public void setName(String name) {
		lock.lock();
		try {
			this.name = name;
		} finally {
			lock.unlock();
		}
	}

	public abstract boolean isDirectory();

	public abstract boolean isFile();
}