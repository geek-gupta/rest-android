package org.jbossoutreach.restandroid.model;

/**
 * Created by gaurav on 2/12/17.
 */

public final class GitRepo {

    private String repoTitle;
    private Integer issueCount;
    private Integer prCount;


    public GitRepo(String repoTitle, Integer issueCount, Integer prCount) {
        this.repoTitle = repoTitle;
        this.issueCount = issueCount;
        this.prCount = prCount;
    }

    public String getRepoTitle() {
        return repoTitle;
    }

    public Integer getIssueCount() {
        return issueCount;
    }

    public Integer getPrCount() {
        return prCount;
    }

    @Override
    public String toString() {
        return "GitRepo{ "+"repoTitle = "+repoTitle
                +", issueCount = "+issueCount
                +", prCount = "+prCount+" }";
    }
}
