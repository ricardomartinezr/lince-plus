package com.deicos.lince.math;

import com.deicos.lince.data.CgEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Asoto
 * Date: 03/09/2014 10:47
 * Description:  Data session attribute constants
 * <p/>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SessionDataAttributes implements CgEnum {
    ERROR("error"),
    VIDEO("video"),
    LOCALE("locale"),
    VIDEO_VIEW("video_view"),
    PROFILE("profile"),
    REGISTER("register"),;

    private final String parameterName;

    /**
     * @param newValue
     */
    private SessionDataAttributes(final String newValue) {
        this.parameterName = newValue;
    }

    public String getItemLabel() {
        return parameterName;
    }

    public String getItemValue() {
        return this.toString();
    }

    public static SessionDataAttributes castString(String key) {
        try {
            return SessionDataAttributes.valueOf(key.toUpperCase());
        } catch (Exception e) {
            return ERROR;
        }
    }
}
