package com.londonappbrewery.destini;

public class StoryWithAnswers {

    private Integer storyTextId;
    private Integer storyAnswer1Id;
    private Integer storyAnswer2Id;

    public StoryWithAnswers(Integer storyTextId, Integer storyAnswer1Id, Integer storyAnswer2Id) {
        this.storyTextId = storyTextId;
        this.storyAnswer1Id = storyAnswer1Id;
        this.storyAnswer2Id = storyAnswer2Id;
    }

    public Integer getStoryTextId() {
        return storyTextId;
    }

    public void setStoryTextId(Integer storyTextId) {
        this.storyTextId = storyTextId;
    }

    public Integer getStoryAnswer1Id() {
        return storyAnswer1Id;
    }

    public void setStoryAnswer1Id(Integer storyAnswer1Id) {
        this.storyAnswer1Id = storyAnswer1Id;
    }

    public Integer getStoryAnswer2Id() {
        return storyAnswer2Id;
    }

    public void setStoryAnswer2Id(Integer storyAnswer2Id) {
        this.storyAnswer2Id = storyAnswer2Id;
    }
}

