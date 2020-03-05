package com.deicos.lince.transcoding;

import org.apache.commons.lang3.StringUtils;

/**
 * com.deicos.lince.transcoding.app
 * Class VideoFileType
 * 27/02/2020
 *
 * @author berto (alberto.soto@gmail.com)
 */
public enum MediaFileType {
    MOV, MP4, OGG, WMV, AVI, MPG, JPG, GIF, PNG;

    public String getExtension() {
        return "." + StringUtils.lowerCase(this.toString());

    }
}
