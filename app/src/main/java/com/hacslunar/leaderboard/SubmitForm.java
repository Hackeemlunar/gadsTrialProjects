package com.hacslunar.leaderboard;

import com.google.gson.annotations.SerializedName;

public class SubmitForm {
    @SerializedName("entry.1877115667")
    private String firstName;
    @SerializedName("entry.2006916086")
    private String lastName;
    @SerializedName("entry.1824927963")
    private String emailAddress;
    @SerializedName("entry.284483984")
    private String gitHubLink;

    public SubmitForm(String firstName, String lastName, String emailAddress, String gitHubLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.gitHubLink = gitHubLink;
    }

    public SubmitForm() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }
}
