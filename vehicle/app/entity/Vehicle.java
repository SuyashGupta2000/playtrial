package entity;

public class Vehicle {
    private String id;
    private String userId;
    private String userName;
    private String chassisNumber;
    private String modelId;

    public Vehicle(String id, String userId, String userName, String chassisNumber, String modelId) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.chassisNumber = chassisNumber;
        this.modelId = modelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}

