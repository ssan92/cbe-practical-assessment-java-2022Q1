package com.pichincha.application.enums;



public enum StateEnum {

	ACTIVE("S"),
	INACTIVE("N");

	private String name;

	StateEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
