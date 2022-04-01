package com.pichincha.domains.exceptions;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternalErrorException extends RuntimeException {

}
