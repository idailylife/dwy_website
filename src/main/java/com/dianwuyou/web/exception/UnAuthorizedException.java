package com.dianwuyou.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hebowei on 16/7/4.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnAuthorizedException extends RuntimeException {
}
