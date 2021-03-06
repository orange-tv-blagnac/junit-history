package com.francetelecom.orangetv.junithistory.server.model;

/**
 * Encapuse un DbTestMessage
 * 
 * @author ndmz2720
 *
 */
public class LazyTestMessage extends DbTestMessage implements ILazy {

	private static final long serialVersionUID = 1L;

	private boolean lazy = true;

	// --------------------- constructor
	public LazyTestMessage(int id) {
		super.setId(id);
	}

	// ---------------------- implementing IDbEntry
	@Override
	public boolean isLazy() {
		return lazy;
	}

	// ---------------------- implementing ILazy

	@Override
	public void setLazy(boolean lazy) {
		this.lazy = lazy;
	}

	// ---------------------- overriding DtTestMessage

	// TODO mettre les autres
	// ----------------------- accessor

}
