package edu.umb.cs681.hw16;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Observable {

	protected LinkedList<Observer> observers = new LinkedList<Observer>();
	protected boolean observer_changed = false;

	private AtomicBoolean changed = new AtomicBoolean(false);
	private ReentrantLock locks = new ReentrantLock();

	public void addObserver(Observer o) {
		locks.lock();
		try {
			if (!observers.contains(o)) {
				observers.add(o);
			}
		} finally {
			locks.unlock();
		}
	}

	protected void setChanged() {
		changed.set(true);
	}

	protected boolean hasChanged() {
		return changed.get();
	}

	protected void clearChanged() {
		changed.set(false);
	}

	public void notifyObservers(Object arg) {
		locks.lock();
		try {
			if (hasChanged()) {
				observers.forEach((Observer observers) -> observers.update(this, arg));
				clearChanged();
			}
		} finally {
			locks.unlock();
		}
	}

	public void deleteObserver(Observer o) {
		locks.lock();
		try {
			if (observers.contains(o)) {
				observers.remove(o);
			}
		} finally {
			locks.unlock();
		}
	}

	protected int countObserver() {
		locks.lock();
		try {
			return observers.size();
		} finally {
			locks.unlock();
		}
	}
}