package enums;

public enum ThesisTopic {
    MACHINE_LEARNING("Machine Learning"),
    DATA_MINING("Data Mining"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence"),
    COMPUTER_VISION("Computer Vision"),
    NATURAL_LANGUAGE_PROCESSING("Natural Language Processing"),
    ROBOTICS("Robotics"),
    CLOUD_COMPUTING("Cloud Computing"),
    INTERNET_OF_THINGS("Internet of Things"),
    CYBERSECURITY("Cybersecurity"),
    BLOCKCHAIN("Blockchain");

    private final String topic;

    private ThesisTopic(String topic){
        this.topic=topic;
    }

    public String getTopic(){
        return topic;
    }
}
