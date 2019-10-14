package com.code.refactoring.demo.demo01.重构后;

/**
 * <Description>
 *
 * @author wangxi
 */
public interface DTOConvert<S, T> {
    T convert(S s);
}
