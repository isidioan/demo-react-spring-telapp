package com.iioannou.taap.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ioannou
 */
public class CallD implements Serializable {
    @JsonIgnore
    private Long id;
    @JsonProperty("called_party_id")
    private Long contactedCallerId;
    @JsonProperty("caller_id")
    private Long callerId;
    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    @JsonProperty("duration_in_seconds")
    private Double duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactedCallerId() {
        return contactedCallerId;
    }

    public void setContactedCallerId(Long contactedCallerId) {
        this.contactedCallerId = contactedCallerId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Long getCallerId() {
        return callerId;
    }

    public void setCallerId(Long callerId) {
        this.callerId = callerId;
    }
}
