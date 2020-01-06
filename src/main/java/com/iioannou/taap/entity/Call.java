package com.iioannou.taap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author ioannou
 */
@Entity
@Table(name = "CALLS")
public class Call {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "caller_id")
    private Caller caller;

    @Column(name = "called_party_id")
    private Long contactedCallerId;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Column(name = "duration_in_seconds")
    private Double duration;

    public Call() {
        super();
        setDateTime(LocalDateTime.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
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

}
