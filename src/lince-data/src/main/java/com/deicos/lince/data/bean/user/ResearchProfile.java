package com.deicos.lince.data.bean.user;

import java.util.List;
import java.util.UUID;

/**
 * lince-scientific-desktop
 * com.deicos.lince.data
 * @author berto (alberto.soto@gmail.com)in 29/02/2016.
 * Description:
 */
public class ResearchProfile {

    private UUID key;

    private String researchGroup;

    private String researchName;

    private String researchGroupCode;

    private String researchNameCode;

    private Integer fps;

    private Integer numVideos;

    private List<UserProfile> userProfiles;

    public ResearchProfile() {
        setKey(UUID.randomUUID());
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public Integer getNumVideos() {
        return numVideos;
    }

    public void setNumVideos(Integer numVideos) {
        this.numVideos = numVideos;
    }


    public List<UserProfile> getUserProfiles() {
        //delvemos una lista con los registros del sistema
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        //chequeamos los registros del sistema para cada uno de los usuarios
        this.userProfiles = userProfiles;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public String getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(String researchGroup) {
        this.researchGroup = researchGroup;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getResearchGroupCode() {
        return researchGroupCode;
    }

    public void setResearchGroupCode(String researchGroupCode) {
        this.researchGroupCode = researchGroupCode;
    }

    public String getResearchNameCode() {
        return researchNameCode;
    }

    public void setResearchNameCode(String researchNameCode) {
        this.researchNameCode = researchNameCode;
    }
}
