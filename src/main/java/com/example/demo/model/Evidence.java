package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
private DamageClaim claim;

private String fileUrl;
private String evidenceType;
private LocalDateTime uploadedAt;

public Evidence() {
}

@PrePersist
public void onUpload() {
if (uploadedAt == null) {
uploadedAt = LocalDateTime.now();
}
}

// getters and setters
public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public DamageClaim getClaim() {
return claim;
}

public void setClaim(DamageClaim claim) {
this.claim = claim;
}

public String getFileUrl() {
return fileUrl;
}

public void setFileUrl(String fileUrl) {
this.fileUrl = fileUrl;
}

public String getEvidenceType() {
return evidenceType;
}

public void setEvidenceType(String evidenceType) {
this.evidenceType = evidenceType;
}

public LocalDateTime getUploadedAt() {
return uploadedAt;
}
}