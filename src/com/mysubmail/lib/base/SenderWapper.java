package com.mysubmail.lib.base;

import com.mysubmail.entity.DataStore;

public abstract class SenderWapper {

	protected DataStore requestData = new DataStore();

	public abstract ISender getSender();
}
