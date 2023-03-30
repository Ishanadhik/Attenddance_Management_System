package model;

public class attendance {
    int id;
    int classId;
    int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public attendance(int id, int classId, int userId) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
    }
}
