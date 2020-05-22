package org.itstep.msk.app.entity;

import org.itstep.msk.app.remote.RemoteController;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "controllers")
public class ControllerWiy {
    @Column(name = "id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "safekey")
    private String safeKey;

    @Column(name = "hostname")
    private String hostname;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false,insertable = false,updatable = false)
//    @Column(name = "owner")
   // @ManyToOne(targetEntity = User.class)
    private User owner;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSafeKey() {
        return safeKey;
    }

    public void setSafeKey(String safeKey) {
        this.safeKey = safeKey;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
