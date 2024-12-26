package com.demo.struts1.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

public class SpotifyForm extends ActionForm {

    private Long id;
    private String trackName;
    private String artistName;
    private String genre;
    private Integer popularity;
    private String actionType;


    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        String popularityInput = request.getParameter("popularity");

        if (trackName == null || trackName.trim().isEmpty()) {
            errors.add("trackName", new ActionMessage("error.spotify.trackName.required"));
        }
        if (artistName == null || artistName.trim().isEmpty()) {
            errors.add("artistName", new ActionMessage("error.spotify.artistName.required"));
        }
        if (genre == null || genre.trim().isEmpty()) {
            errors.add("genre", new ActionMessage("error.spotify.genre.required"));
        }
        if (popularityInput == null  || popularityInput.trim().isEmpty()) {
            errors.add("popularity", new ActionMessage("error.spotify.popularity.required"));
        } else {
            try {
                popularity = Integer.parseInt(popularityInput);
                if (popularity <= 0) {
                    errors.add("popularity", new ActionMessage("error.spotify.popularity.invalid"));
                }
            } catch (NumberFormatException e) {
                errors.add("popularity", new ActionMessage("error.spotify.popularity.invalid"));
            }
        }

        return errors;
    }

}
