package com.sapl.util;

import java.util.HashSet;

public class AutoGrowHashSet<T> extends HashSet<T>{
	/**
	 * This is my development :-)
	 */
	private static final long serialVersionUID = 5441L;
	private Class<T> growingClass;
	public AutoGrowHashSet(Class<T> classType){
		super();
	}



	public Object get(int index) throws InstantiationException, IllegalAccessException{
		int backingListSize = this.size();
		T element = null;
		if (index < backingListSize) {
			element = (T)this.get(index);
			if (element == null) {
				element = growingClass.newInstance();
				this.add(element);
			}
		} else {
			for (int x = backingListSize; x < index; x++)
				this.add(null);

			element = growingClass.newInstance();
			this.add(element);
		}
		return element;
	}

}
