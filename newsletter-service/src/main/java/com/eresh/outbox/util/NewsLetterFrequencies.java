package com.eresh.outbox.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 18/August/2021 By Author Eresh, Gorantla
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum NewsLetterFrequencies {
	DAILY(1, "Daily"),
	WEEKLY(2, "Weekly"),
	BI_WEEKLY(3, "BI Weekly"),
	MONTHLY(4, "Monthly"),
	BI_MONTHLY(5, "BI Monthly"),
	ONLY_ONCE(6, "Only Once");

	private Integer id;
	private String frequency;
}