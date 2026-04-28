package model;

public class Admin {
    private int adminId;
    private String username;
    private String password;

    private static int adminCount = 0;

    public Admin(int adminId, String username, String password) {
        setAdminId(adminId);
        setUsername(username);
        setPassword(password);
        adminCount++;
    }

    public static int getAdminCount() {
        return adminCount;
    }   
    
    public int getAdminId() {
        return adminId;
    }

    private void setAdminId(int adminId) {
    if (adminId > 0) {
        this.adminId = adminId;
    } else {
        this.adminId = 0; // default value
        System.out.println("Invalid admin ID. Set to 0.");
    }
}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            this.username = "defaultUser";
        } else {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            this.password = "defaultPass";
        } else {
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", username=" + username + "]";
    }
}