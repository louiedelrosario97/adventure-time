package com.pluralsight;

public class Scene
{       // Data Members
    private int id;
    private String storyText;
    private String option1Text;
    private int option1NextId;
    private String option2Text;
    private int option2NextId;

    public Scene(int id, String storyText, String option1Text, int option1NextId, String option2Text, int option2NextId)
    {   // Constructors
        this.id = id;
        this.storyText = storyText;
        this.option1Text = option1Text;
        this.option1NextId = option1NextId;
        this.option2Text = option2Text;
        this.option2NextId = option2NextId;
    }
         // Getters
    public int getId() { return id; }
    public String getStoryText() { return storyText; }
    public String getOption1Text() { return option1Text; }
    public int getOption1NextId() { return option1NextId; }
    public String getOption2Text() { return option2Text; }
    public int getOption2NextId() { return option2NextId; }

        // Setters
    public void setId(int id) { this.id = id;}
    public void setStoryText(String storyText) { this.storyText = storyText; }
    public void setOption1Text(String option1Text) { this.option1Text = option1Text; }
    public void setOption1NextId(int option1NextId) { this.option1NextId = option1NextId; }
    public void setOption2Text(String option2Text) { this.option2Text = option2Text; }
    public void setOption2NextId(int option2NextId) { this.option2NextId = option2NextId; }

}


