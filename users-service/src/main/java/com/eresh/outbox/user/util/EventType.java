package com.eresh.outbox.user.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventType {

	INSERT("I"),
	UPDATE("U"),
	DELETE("D"),
	SOFT_DELETE("S");

	private String type;
}